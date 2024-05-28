package io.kalishak.metalcore.world.level.block.fan;

import com.mojang.serialization.MapCodec;
import io.kalishak.metalcore.api.block.ToolActionStateModifable;
import io.kalishak.metalcore.world.level.block.entity.CopperFanBlockEntity;
import io.kalishak.metalcore.world.level.block.entity.MetalcoreBlockEntityType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.common.ToolAction;
import org.jetbrains.annotations.Nullable;

public class CopperFanBlock extends BaseEntityBlock implements ToolActionStateModifable {
    public static final DirectionProperty FACING = BlockStateProperties.FACING;
    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;

    public CopperFanBlock(BlockBehaviour.Properties properties) {
        super(properties);

        registerDefaultState(getStateDefinition().any().setValue(FACING, Direction.NORTH).setValue(POWERED, false));
    }

    public static Position getDispensePosition(BlockState blockState, Vec3 center) {
        return getDispensePosition(blockState, center, 0.7D, Vec3.ZERO);
    }

    public static Position getDispensePosition(BlockState blockState, Vec3 center, double speed, Vec3 position) {
        Direction direction = blockState.getValue(FACING);
        return center
                .add(
                        speed * (double)direction.getStepX() + position.x(),
                        speed * (double)direction.getStepY() + position.y(),
                        speed * (double)direction.getStepZ() + position.z()
                );
    }

    @Override
    protected MapCodec<? extends CopperFanBlock> codec() {
        return simpleCodec(CopperFanBlock::new);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return defaultBlockState().setValue(FACING, pContext.getNearestLookingDirection().getOpposite());
    }

    @Override
    protected void neighborChanged(BlockState pState, Level pLevel, BlockPos pPos, Block pNeighborBlock, BlockPos pNeighborPos, boolean pMovedByPiston) {
        boolean flag = pLevel.hasNeighborSignal(pPos);

        if (flag != pState.getValue(POWERED)) {
            rotateFan(pLevel, pPos, pState.getValue(FACING), flag);
            pLevel.setBlock(pPos, pState.setValue(POWERED, flag), 3);
        }
    }

    protected boolean rotateFan(Level level, BlockPos pos, Direction facing, boolean powered) {
        BlockEntity blockEntity = level.getBlockEntity(pos);

        if (!level.isClientSide && blockEntity instanceof CopperFanBlockEntity copperFan) {
            copperFan.setRotating(facing, powered);
            level.gameEvent(null, GameEvent.BLOCK_CHANGE, pos);
            return true;
        }

        return false;
    }

    @Override
    protected RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new CopperFanBlockEntity(pPos, pState);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING, POWERED);
    }

    @Override
    public BlockState rotate(BlockState pState, Rotation pRotation) {
        return pState.setValue(FACING, pRotation.rotate(pState.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        return createTickerHelper(pBlockEntityType, MetalcoreBlockEntityType.COPPER_FAN.get(), CopperFanBlockEntity::serverTick);
    }

    @Override
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        if (pState.getValue(POWERED)) {
            double x = (double) pPos.getX() + 0.5D;
            double y = (double) pPos.getY();
            double z = (double) pPos.getZ() + 0.5D;

            Direction direction = pState.getValue(FACING);
            Direction.Axis axis = direction.getAxis();
            double d = 0.52D;
            double offSet = pRandom.nextDouble() * 0.6D - 0.3D;
            double xOffSet = axis == Direction.Axis.X ? (double) direction.getStepX() * d : offSet;
            double yOffSet = axis == Direction.Axis.Y ? (double) direction.getStepY() * d : offSet;
            double zOffSet = axis == Direction.Axis.Z ? (double) direction.getStepY() * d : offSet;

            double xSpeed, ySpeed, zSpeed;
            switch (axis) {
                case X -> {
                    xSpeed = 5.0E-5;
                    ySpeed = pRandom.nextFloat() / 2.0F;
                    zSpeed = pRandom.nextFloat() / 2.0F;
                }

                case Y -> {
                    xSpeed = pRandom.nextFloat() / 2.0F;
                    ySpeed = 5.0E-5;
                    zSpeed = pRandom.nextFloat() / 2.0F;
                }

                case Z -> {
                    xSpeed = pRandom.nextFloat() / 2.0F;
                    ySpeed = pRandom.nextFloat() / 2.0F;
                    zSpeed = 5.0E-5;
                }

                default -> {
                    xSpeed = 0.0D;
                    ySpeed = 0.0D;
                    zSpeed = 0.0D;
                }
            }

            pLevel.addParticle(ParticleTypes.CLOUD, x + xOffSet, y + yOffSet, z + zOffSet, xSpeed, ySpeed, zSpeed);
        }
    }

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate) {
        return applyToolAction(state, context, toolAction);
    }

    @Override
    protected boolean hasAnalogOutputSignal(BlockState pState) {
        return true;
    }

    @Override
    protected int getAnalogOutputSignal(BlockState pState, Level pLevel, BlockPos pPos) {
        return AbstractContainerMenu.getRedstoneSignalFromBlockEntity(pLevel.getBlockEntity(pPos));
    }
}
