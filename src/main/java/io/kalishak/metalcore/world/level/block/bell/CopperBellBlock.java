package io.kalishak.metalcore.world.level.block.bell;

import com.mojang.serialization.MapCodec;
import io.kalishak.metalcore.api.block.ToolActionStateModifable;
import io.kalishak.metalcore.world.level.block.entity.MetalcoreBlockEntityType;
import io.kalishak.metalcore.world.level.block.entity.CopperBellBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.common.ToolAction;
import org.jetbrains.annotations.Nullable;

import java.util.function.BiConsumer;

public class CopperBellBlock extends BaseEntityBlock implements SimpleWaterloggedBlock, ToolActionStateModifable {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final EnumProperty<BellAttachType> ATTACHMENT = BlockStateProperties.BELL_ATTACHMENT;
    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    private static final VoxelShape NORTH_SOUTH_FLOOR_SHAPE = Block.box(0.0, 0.0, 4.0, 16.0, 16.0, 12.0);
    private static final VoxelShape EAST_WEST_FLOOR_SHAPE = Block.box(4.0, 0.0, 0.0, 12.0, 16.0, 16.0);
    private static final VoxelShape BELL_TOP_SHAPE = Block.box(5.0, 6.0, 5.0, 11.0, 13.0, 11.0);
    private static final VoxelShape BELL_BOTTOM_SHAPE = Block.box(4.0, 4.0, 4.0, 12.0, 6.0, 12.0);
    private static final VoxelShape BELL_SHAPE = Shapes.or(BELL_BOTTOM_SHAPE, BELL_TOP_SHAPE);
    private static final VoxelShape NORTH_SOUTH_BETWEEN = Shapes.or(BELL_SHAPE, Block.box(7.0, 13.0, 0.0, 9.0, 15.0, 16.0));
    private static final VoxelShape EAST_WEST_BETWEEN = Shapes.or(BELL_SHAPE, Block.box(0.0, 13.0, 7.0, 16.0, 15.0, 9.0));
    private static final VoxelShape TO_WEST = Shapes.or(BELL_SHAPE, Block.box(0.0, 13.0, 7.0, 13.0, 15.0, 9.0));
    private static final VoxelShape TO_EAST = Shapes.or(BELL_SHAPE, Block.box(3.0, 13.0, 7.0, 16.0, 15.0, 9.0));
    private static final VoxelShape TO_NORTH = Shapes.or(BELL_SHAPE, Block.box(7.0, 13.0, 0.0, 9.0, 15.0, 13.0));
    private static final VoxelShape TO_SOUTH = Shapes.or(BELL_SHAPE, Block.box(7.0, 13.0, 3.0, 9.0, 15.0, 16.0));
    private static final VoxelShape CEILING_SHAPE = Shapes.or(BELL_SHAPE, Block.box(7.0, 13.0, 7.0, 9.0, 16.0, 9.0));
    public static final int EVENT_BELL_RING = 1;

    public CopperBellBlock(Properties properties) {
        super(properties);

        registerDefaultState(getStateDefinition().any()
                .setValue(FACING, Direction.NORTH)
                .setValue(ATTACHMENT, BellAttachType.FLOOR)
                .setValue(POWERED, false)
                .setValue(WATERLOGGED, false)
        );
    }

    @Override
    protected MapCodec<? extends CopperBellBlock> codec() {
        return simpleCodec(CopperBellBlock::new);
    }

    @Override
    protected FluidState getFluidState(BlockState pState) {
        return pState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(pState);
    }

    @Override
    protected void neighborChanged(BlockState pState, Level pLevel, BlockPos pPos, Block pNeighborBlock, BlockPos pNeighborPos, boolean pMovedByPiston) {
        boolean flag = pLevel.hasNeighborSignal(pPos);

        if (flag != pState.getValue(POWERED)) {
            if (flag) {
                attemptToRing(pLevel, pPos, null);
            }

            pLevel.setBlock(pPos, pState.setValue(POWERED, flag), 3);
        }
    }

    @Override
    protected void onProjectileHit(Level pLevel, BlockState pState, BlockHitResult pHit, Projectile pProjectile) {
        Entity entity = pProjectile.getOwner();
        Player player = entity instanceof Player ? (Player) entity : null;

        onHit(pLevel, pState, pHit, player, true);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, BlockHitResult pHit) {
        return onHit(pLevel, pState, pHit, pPlayer, true) ? InteractionResult.sidedSuccess(pLevel.isClientSide) : InteractionResult.PASS;
    }

    public boolean onHit(Level pLevel, BlockState pState, BlockHitResult pHit, @Nullable Player pPlayer, boolean pCanRingBell) {
        Direction direction = pHit.getDirection();
        BlockPos blockPos = pHit.getBlockPos();
        boolean flag = !pCanRingBell || isProperHit(pState, direction, pHit.getLocation().y - (double) blockPos.getY());

        if (flag) {
            boolean flag1 = attemptToRing(pPlayer, pLevel, blockPos, direction);
            if (flag1 && pPlayer != null) {
                pPlayer.awardStat(Stats.BELL_RING);
            }
        }

        return flag;
    }

    private boolean isProperHit(BlockState pState, Direction pDirection, double pDistanceY) {
        if (pDirection.getAxis() != Direction.Axis.Y && !(pDistanceY > 0.8124F)) {
            Direction direction = pState.getValue(FACING);
            BellAttachType bellAttachType = pState.getValue(ATTACHMENT);

            return switch (bellAttachType) {
                case FLOOR -> direction.getAxis() == pDirection.getAxis();
                case SINGLE_WALL, DOUBLE_WALL -> direction.getAxis() != pDirection.getAxis();
                case CEILING -> true;
            };
        }

        return false;
    }

    public boolean attemptToRing(Level pLevel, BlockPos pPos, @Nullable Direction pDirection) {
        return attemptToRing(null, pLevel, pPos, pDirection);
    }

    public boolean attemptToRing(@Nullable Entity pEntity, Level pLevel, BlockPos pPos, @Nullable Direction pDirection) {
        BlockEntity blockEntity = pLevel.getBlockEntity(pPos);

        if (!pLevel.isClientSide && blockEntity instanceof CopperBellBlockEntity bell) {
            if (pDirection == null) {
                pDirection = pLevel.getBlockState(pPos).getValue(FACING);
            }

            bell.onHit(pDirection);
            pLevel.playSound(null, pPos, SoundEvents.BELL_BLOCK, SoundSource.BLOCKS, 2.0F, 1.0F);
            pLevel.gameEvent(pEntity, GameEvent.BLOCK_CHANGE, pPos);
            return true;
        }

        return false;
    }

    private VoxelShape getVoxelShape(BlockState pState) {
        Direction direction = pState.getValue(FACING);
        BellAttachType bellAttachType = pState.getValue(ATTACHMENT);

        if (bellAttachType == BellAttachType.FLOOR) {
            return direction != Direction.NORTH && direction != Direction.SOUTH ? EAST_WEST_FLOOR_SHAPE : NORTH_SOUTH_FLOOR_SHAPE;
        } else if (bellAttachType == BellAttachType.CEILING) {
            return CEILING_SHAPE;
        } else if (bellAttachType == BellAttachType.DOUBLE_WALL) {
            return direction != Direction.NORTH && direction != Direction.SOUTH ? EAST_WEST_BETWEEN : NORTH_SOUTH_BETWEEN;
        } else if (direction == Direction.NORTH) {
            return TO_NORTH;
        } else if (direction == Direction.SOUTH) {
            return TO_SOUTH;
        } else {
            return direction == Direction.EAST ? TO_EAST : TO_WEST;
        }
    }

    @Override
    protected VoxelShape getCollisionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return getVoxelShape(pState);
    }

    @Override
    protected VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return getVoxelShape(pState);
    }

    @Override
    protected RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        Direction direction = pContext.getClickedFace();
        BlockPos blockpos = pContext.getClickedPos();
        Level level = pContext.getLevel();
        Direction.Axis axis = direction.getAxis();

        if (axis == Direction.Axis.Y) {
            BlockState state = defaultBlockState()
                    .setValue(ATTACHMENT, direction == Direction.DOWN ? BellAttachType.CEILING : BellAttachType.FLOOR)
                    .setValue(FACING, pContext.getHorizontalDirection());

            if (state.canSurvive(level, blockpos)) {
                return state;
            }
        } else {
            boolean flag = axis == Direction.Axis.X
                    && level.getBlockState(blockpos.west()).isFaceSturdy(level, blockpos.west(), Direction.EAST)
                    && level.getBlockState(blockpos.east()).isFaceSturdy(level, blockpos.east(), Direction.WEST)
                    || axis == Direction.Axis.Z
                    && level.getBlockState(blockpos.north()).isFaceSturdy(level, blockpos.north(), Direction.SOUTH)
                    && level.getBlockState(blockpos.south()).isFaceSturdy(level, blockpos.south(), Direction.NORTH);
            BlockState state = defaultBlockState()
                    .setValue(ATTACHMENT, flag ? BellAttachType.DOUBLE_WALL : BellAttachType.SINGLE_WALL)
                    .setValue(FACING, direction.getOpposite());

            if (state.canSurvive(level, blockpos)) {
                return state;
            }

            boolean flag1 = level.getBlockState(blockpos.below()).isFaceSturdy(level, blockpos.below(), Direction.UP);
            state = state.setValue(ATTACHMENT, flag1 ? BellAttachType.FLOOR : BellAttachType.CEILING);

            if (state.canSurvive(level, pContext.getClickedPos())) {
                return state;
            }
        }

        return null;
    }

    @Override
    protected void onExplosionHit(BlockState pState, Level pLevel, BlockPos pPos, Explosion pExplosion, BiConsumer<ItemStack, BlockPos> pDropConsumer) {
        if (pExplosion.getBlockInteraction() == Explosion.BlockInteraction.TRIGGER_BLOCK && !pLevel.isClientSide) {
            attemptToRing(pLevel, pPos, null);
        }

        super.onExplosionHit(pState, pLevel, pPos, pExplosion, pDropConsumer);
    }

    @Override
    protected BlockState updateShape(BlockState pState, Direction pFacing, BlockState pFacingState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pFacingPos) {
        BellAttachType bellattachtype = pState.getValue(ATTACHMENT);
        Direction direction = getConnectedDirection(pState).getOpposite();
        
        if (direction == pFacing && !pState.canSurvive(pLevel, pCurrentPos) && bellattachtype != BellAttachType.DOUBLE_WALL) {
            return Blocks.AIR.defaultBlockState();
        } else {
            if (pFacing.getAxis() == pState.getValue(FACING).getAxis()) {
                if (bellattachtype == BellAttachType.DOUBLE_WALL && !pFacingState.isFaceSturdy(pLevel, pFacingPos, pFacing)) {
                    return pState.setValue(ATTACHMENT, BellAttachType.SINGLE_WALL).setValue(FACING, pFacing.getOpposite());
                }

                if (bellattachtype == BellAttachType.SINGLE_WALL
                        && direction.getOpposite() == pFacing
                        && pFacingState.isFaceSturdy(pLevel, pFacingPos, pState.getValue(FACING))) {
                    return pState.setValue(ATTACHMENT, BellAttachType.DOUBLE_WALL);
                }
            }

            return super.updateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);
        }
    }

    @Override
    protected boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        Direction direction = getConnectedDirection(pState).getOpposite();

        return direction == Direction.UP
                ? Block.canSupportCenter(pLevel, pPos.above(), Direction.DOWN)
                : FaceAttachedHorizontalDirectionalBlock.canAttach(pLevel, pPos, direction);
    }

    private static Direction getConnectedDirection(BlockState pState) {
        return switch (pState.getValue(ATTACHMENT)) {
            case FLOOR -> Direction.UP;
            case CEILING -> Direction.DOWN;
            default -> pState.getValue(FACING).getOpposite();
        };
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(ATTACHMENT, FACING, POWERED, WATERLOGGED);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new CopperBellBlockEntity(pPos, pState);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        return createTickerHelper(pBlockEntityType, MetalcoreBlockEntityType.COPPER_BELL.get(), pLevel.isClientSide ? CopperBellBlockEntity::clientTick : CopperBellBlockEntity::serverTick);
    }

    @Override
    protected boolean isPathfindable(BlockState p_60475_, PathComputationType p_60478_) {
        return false;
    }

    @Override
    public BlockState rotate(BlockState pState, Rotation pRotation) {
        return pState.setValue(FACING, pRotation.rotate(pState.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
    }

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate) {
        return applyToolAction(state, context, toolAction);
    }
}
