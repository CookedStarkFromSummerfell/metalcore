package io.kalishak.metalcore.world.level.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageEffects;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class CopperSpikesBlock extends Block implements SimpleWaterloggedBlock {
    public static final IntegerProperty PARTS = IntegerProperty.create("parts", 1, 4);
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    private static final VoxelShape ONE_SPIKE_SHAPE = Block.box(3.0, 0.0, 3.0, 12.0, 7.0, 12.0);
    private static final VoxelShape SPIKES_SHAPE = Block.box(1.0, 0.0, 1.0, 15.0, 7.0, 15.0);

    public CopperSpikesBlock(BlockBehaviour.Properties properties) {
        super(properties);
        registerDefaultState(getStateDefinition().any().setValue(PARTS, 1).setValue(WATERLOGGED, false));
    }

    protected boolean isPoisonous(BlockState state) {
        return false;
    }

    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        if (!pEntity.isSteppingCarefully()) {
            dealDamage(pState, pEntity, 1.0F);
        }

        super.stepOn(pLevel, pPos, pState, pEntity);
    }

    @Override
    public void fallOn(Level pLevel, BlockState pState, BlockPos pPos, Entity pEntity, float pFallDistance) {
        dealDamage(pState, pEntity, pFallDistance);

        super.fallOn(pLevel, pState, pPos, pEntity, pFallDistance);
    }

    protected void dealDamage(BlockState blockState, Entity entity, float fallDamage) {
        boolean flag = isPoisonous(blockState);
        int amount = blockState.getBlock() instanceof WeatheringCopper weatheringCopper ? weatheringCopper.getAge().ordinal() * 2 : 1;

        if (!blockState.getValue(WATERLOGGED) && !entity.isInvulnerable()) {
            entity.hurt(entity.level().damageSources().generic(), 3.0F + fallDamage * 0.25F);

            if (flag && entity instanceof LivingEntity livingEntity) {
                livingEntity.addEffect(new MobEffectInstance(MobEffects.POISON, 4, amount));
            }
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(PARTS, WATERLOGGED);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        BlockState blockState = pContext.getLevel().getBlockState(pContext.getClickedPos());
        return blockState.is(this)
                ? blockState.setValue(PARTS, Math.min(4, blockState.getValue(PARTS) + 1))
                : super.getStateForPlacement(pContext);
    }

    @Override
    protected VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return pState.getValue(PARTS) > 0 ? SPIKES_SHAPE : ONE_SPIKE_SHAPE;
    }
}
