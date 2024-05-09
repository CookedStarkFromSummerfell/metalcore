package io.kalishak.metalcore.world.level.block.entity;

import io.kalishak.metalcore.api.block.WeatheringCopperHolder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class CopperFanBlockEntity extends BlockEntity {
    public int ticks;
    public boolean isPowered;
    public Direction windDirection;

    public CopperFanBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(MetalcoreBlockEntityType.COPPER_FAN.get(), pPos, pBlockState);
    }

    public static void serverTick(Level pLevel, BlockPos pPos, BlockState pState, CopperFanBlockEntity copperFan) {
        if (copperFan.isPowered) {
            copperFan.ticks++;
        }

        if (copperFan.ticks >= 200) {
            copperFan.ticks = 0;
        }

        if (copperFan.ticks % 7 == 2) {
            pLevel.playSound(null, pPos, SoundEvents.WIND_CHARGE_THROW, SoundSource.BLOCKS, 1.0F, 1.0F);
            copperFan.rotateFan();
        }

        if (copperFan.getBlockState().getBlock() instanceof WeatheringCopper weatheringCopper && pLevel instanceof ServerLevel) {
            weatheringCopper.changeOverTime(pState, (ServerLevel) pLevel, pPos, pLevel.random);
        }
    }

    private void rotateFan() {
        if (this.isPowered) {
            Direction.Axis axis = windDirection.getAxis();
            double x = 1.1D;
            double y = 1.1D;
            double z = 1.1D;
            double range = getFanRange(getWeatherState());

            switch (axis) {
                case X -> {
                    x = range;
                    y = 0.0D;
                    z = 0.0D;
                }
                case Y -> {
                    x = 0.0D;
                    y = range;
                    z = 0.0D;
                }
                case Z -> {
                    x = 0.0D;
                    y = 0.0D;
                    z = range;
                }
            }

            var aboveFanBox = new AABB(1.0D, 1.0D, 1.0D, 1.0D + x, 1.0D + y, 1.0D + z);
            var entities = this.level.getEntities((Entity) null, aboveFanBox, Entity::isNoGravity);

            if (!entities.isEmpty()) {
                for (Entity entity : entities) {
                    if (!entity.isInFluidType() && !entity.isInvulnerable()) {
                        entity.setDeltaMovement(new Vec3(x, y, z));
                    }
                }
            }
        }
    }

    @Override
    public boolean triggerEvent(int pId, int pType) {
        if (pId == 1) {
            this.ticks = 0;
            this.windDirection = Direction.from3DDataValue(pType);
            return true;
        }

        return super.triggerEvent(pId, pType);
    }

    public void setRotating(Direction windDirection, boolean powered) {
        this.windDirection = windDirection;
        this.isPowered = powered;
    }

    private WeatheringCopperHolder.WeatherState getWeatherState() {
        Block block = getBlockState().getBlock();

        if (block instanceof WeatheringCopperHolder copperHolder) {
            return copperHolder.getAge();
        }

        return WeatheringCopperHolder.WeatherState.UNAFFECTED;
    }

    private float getFanRange(WeatheringCopperHolder.WeatherState state) {
        return state == WeatheringCopperHolder.WeatherState.OXIDIZED ? 0.0F : 9.0F / ((float) state.ordinal() + 1.0F);
    }
}
