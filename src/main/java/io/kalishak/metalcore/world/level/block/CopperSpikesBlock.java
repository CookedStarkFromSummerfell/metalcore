package io.kalishak.metalcore.world.level.block;

import io.kalishak.metalcore.api.block.ToolActionStateModifable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.common.ToolAction;
import org.jetbrains.annotations.Nullable;

public class CopperSpikesBlock extends Block implements SimpleWaterloggedBlock, ToolActionStateModifable {
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

    protected boolean penetrateArmor(ItemStack itemStack) {
        if (!itemStack.isEmpty()) {
            ArmorItem item = ((ArmorItem) itemStack.getItem());
            Holder<ArmorMaterial> armorMaterial = item.getMaterial();

            return armorMaterial == ArmorMaterials.LEATHER || armorMaterial == ArmorMaterials.CHAIN;
        }

        return true;
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
        int amount = blockState.getBlock() instanceof WeatheringCopper weatheringCopper ? weatheringCopper.getAge().ordinal() * 2 : 1;

        if (entity instanceof LivingEntity livingEntity) {
            if (!blockState.getValue(WATERLOGGED) && !entity.isInvulnerable() && penetrateArmor(livingEntity.getItemBySlot(EquipmentSlot.FEET))) {
                entity.hurt(entity.level().damageSources().generic(), 3.0F + fallDamage * 0.25F);

                if (isPoisonous(blockState)) {
                    livingEntity.addEffect(new MobEffectInstance(MobEffects.POISON, 4, amount));
                }
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
        Level level = pContext.getLevel();
        BlockPos pos = pContext.getClickedPos();
        BlockState blockState = level.getBlockState(pos);

        if (blockState.is(this) && blockState.getValue(PARTS) < 4) {
            return blockState
                    .setValue(PARTS, blockState.getValue(PARTS) + 1)
                    .setValue(WATERLOGGED, false);
        } else {
            FluidState fluidState = level.getFluidState(pos);

            return defaultBlockState()
                    .setValue(PARTS, 1)
                    .setValue(WATERLOGGED, fluidState.getType() == Fluids.WATER);
        }
    }

    @Override
    protected VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return pState.getValue(PARTS) > 0 ? SPIKES_SHAPE : ONE_SPIKE_SHAPE;
    }

    @Override
    protected FluidState getFluidState(BlockState pState) {
        return pState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(pState);
    }

    @Override
    protected BlockState updateShape(BlockState pState, Direction pDirection, BlockState pNeighborState, LevelAccessor pLevel, BlockPos pPos, BlockPos pNeighborPos) {
        if (pState.getValue(WATERLOGGED)) {
            pLevel.scheduleTick(pPos, Fluids.WATER, Fluids.WATER.getTickDelay(pLevel));
        }

        return super.updateShape(pState, pDirection, pNeighborState, pLevel, pPos, pNeighborPos);
    }

    @Override
    protected boolean isPathfindable(BlockState blockState, PathComputationType pathType) {
        return pathType == PathComputationType.WATER && blockState.getFluidState().is(FluidTags.WATER);
    }

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate) {
        return applyToolAction(state, context, toolAction);
    }
}
