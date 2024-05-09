package io.kalishak.metalcore.world.level.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ColorParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import org.apache.commons.lang3.mutable.MutableInt;

import java.util.List;

public class CopperBellBlockEntity extends BlockEntity {
    private static final int DURATION = 50;
    private static final int GLOW_DURATION = 60;
    private static final int MIN_TICKS_BETWEEN_SEARCHES = 60;
    private static final int MAX_RESONATION_TICKS = 40;
    private static final int TICKS_BEFORE_RESONATION = 5;
    private static final int SEARCH_RADIUS = 48;
    private static final int HEAR_BELL_RADIUS = 32;
    private static final int HIGHLIGHT_RAIDERS_RADIUS = 48;
    private long lastRingTimestamp;
    public int ticks;
    public boolean shaking;
    public Direction clickDirection;
    private List<LivingEntity> nearbyEntities;
    private boolean resonating;
    private int resonationTicks;

    public CopperBellBlockEntity(BlockPos pos, BlockState state) {
        super(MetalcoreBlockEntityType.COPPER_BELL.get(), pos, state);
    }

    @Override
    public boolean triggerEvent(int pId, int pType) {
        if (pId == 1) {
            updateEntities();
            this.resonationTicks = 0;
            this.clickDirection = Direction.from3DDataValue(pType);
            this.ticks = 0;
            this.shaking = true;
            return true;
        } else {
            return super.triggerEvent(pId, pType);
        }
    }

    private static void tick(Level level, BlockPos pos, BlockState state, CopperBellBlockEntity bell, ResonationEndAction resonationEndAction) {
        if (bell.shaking) {
            bell.ticks++;
        }

        if (bell.ticks >= 50) {
            bell.shaking = false;
            bell.ticks = 0;
        }

        if (bell.ticks >= 5 && bell.resonationTicks == 0 && areRaidersNearby(pos, bell.nearbyEntities)) {
            bell.resonating = true;
            level.playSound(null, pos, SoundEvents.BELL_RESONATE, SoundSource.BLOCKS, 1.0F, 1.0F);
        }

        if (bell.resonating) {
            if (bell.resonationTicks < 40) {
                bell.resonationTicks++;
            } else {
                resonationEndAction.run(level, pos, bell.nearbyEntities);
                bell.resonating = false;
            }
        }
    }

    public static void clientTick(Level pLevel, BlockPos pPos, BlockState pState, CopperBellBlockEntity pBlockEntity) {
        tick(pLevel, pPos, pState, pBlockEntity, CopperBellBlockEntity::showBellParticles);
    }

    public static void serverTick(Level pLevel, BlockPos pPos, BlockState pState, CopperBellBlockEntity pBlockEntity) {
        tick(pLevel, pPos, pState, pBlockEntity, CopperBellBlockEntity::makeRaidersGlow);

        if (pBlockEntity.getBlockState().getBlock() instanceof WeatheringCopper weatheringCopper && pLevel instanceof ServerLevel) {
            weatheringCopper.changeOverTime(pState, (ServerLevel) pLevel, pPos, pLevel.random);
        }
    }

    public void onHit(Direction pDirection) {
        BlockPos blockpos = this.getBlockPos();
        this.clickDirection = pDirection;
        if (this.shaking) {
            this.ticks = 0;
        } else {
            this.shaking = true;
        }

        this.level.blockEvent(blockpos, this.getBlockState().getBlock(), 1, pDirection.get3DDataValue());
    }

    private static boolean areRaidersNearby(BlockPos pPos, List<LivingEntity> pRaiders) {
        for (LivingEntity livingentity : pRaiders) {
            if (livingentity.isAlive()
                    && !livingentity.isRemoved()
                    && pPos.closerToCenterThan(livingentity.position(), 32.0)
                    && livingentity.getType().is(EntityTypeTags.RAIDERS)) {
                return true;
            }
        }

        return false;
    }

    private static void makeRaidersGlow(Level level, BlockPos pos, List<LivingEntity> nearbyEntities) {
        nearbyEntities.stream().filter(entity -> isRaiderWithinRange(pos, entity)).forEach(CopperBellBlockEntity::glow);
    }

    private static void showBellParticles(Level level, BlockPos pos, List<LivingEntity> nearbyEntities) {
        MutableInt mutableint = new MutableInt(16700985);
        int i = (int) nearbyEntities.stream().filter(entity -> pos.closerToCenterThan(entity.position(), 48.0)).count();
        nearbyEntities.stream()
                .filter(entity -> isRaiderWithinRange(pos, entity))
                .forEach(entity -> {
                    float f = 1.0F;
                    double d0 = Math.sqrt(
                            (entity.getX() - (double) pos.getX()) * (entity.getX() - (double) pos.getX())
                                    + (entity.getZ() - (double) pos.getZ()) * (entity.getZ() - (double) pos.getZ())
                    );
                    double d1 = (double) ((float) pos.getX() + 0.5F) + 1.0 / d0 * (entity.getX() - (double) pos.getX());
                    double d2 = (double) ((float) pos.getZ() + 0.5F) + 1.0 / d0 * (entity.getZ() - (double) pos.getZ());
                    int j = Mth.clamp((i - 21) / -2, 3, 15);

                    for (int k = 0; k < j; k++) {
                        int l = mutableint.addAndGet(5);
                        level.addParticle(
                                ColorParticleOption.create(ParticleTypes.ENTITY_EFFECT, l), d1, (double) ((float) pos.getY() + 0.5F), d2, 0.0, 0.0, 0.0
                        );
                    }
                });
    }

    private void updateEntities() {
        BlockPos blockpos = this.getBlockPos();
        if (this.level.getGameTime() > this.lastRingTimestamp + 60L || this.nearbyEntities == null) {
            this.lastRingTimestamp = this.level.getGameTime();
            AABB aabb = new AABB(blockpos).inflate(48.0);
            this.nearbyEntities = this.level.getEntitiesOfClass(LivingEntity.class, aabb);
        }

        if (!this.level.isClientSide) {
            for (LivingEntity livingentity : this.nearbyEntities) {
                if (livingentity.isAlive() && !livingentity.isRemoved() && blockpos.closerToCenterThan(livingentity.position(), 32.0)) {
                    livingentity.getBrain().setMemory(MemoryModuleType.HEARD_BELL_TIME, this.level.getGameTime());
                }
            }
        }
    }

    private static boolean isRaiderWithinRange(BlockPos pPos, LivingEntity pRaider) {
        return pRaider.isAlive()
                && !pRaider.isRemoved()
                && pPos.closerToCenterThan(pRaider.position(), 48.0)
                && pRaider.getType().is(EntityTypeTags.RAIDERS);
    }

    private static void glow(LivingEntity entity) {
        entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 60));
    }

    @FunctionalInterface
    interface ResonationEndAction {
        void run(Level pLevel, BlockPos pPos, List<LivingEntity> pRaiders);
    }
}
