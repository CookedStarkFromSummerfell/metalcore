package io.kalishak.metalcore.world.level.block.sign.hanging;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.kalishak.metalcore.api.block.state.properties.MetalType;
import io.kalishak.metalcore.world.level.block.entity.CopperSignBlockEntity;
import io.kalishak.metalcore.world.level.block.entity.HangingCopperSignBlockEntity;
import io.kalishak.metalcore.world.level.block.entity.MetalcoreBlockEntityType;
import io.kalishak.metalcore.world.level.block.sign.CopperSignBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.RotationSegment;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.Map;
import java.util.Optional;

public class CopperCeilingHangingSignBlock extends CopperSignBlock {
    public static final MapCodec<CopperCeilingHangingSignBlock> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
            MetalType.CODEC.fieldOf("metal_type").forGetter(CopperCeilingHangingSignBlock::getType),
            propertiesCodec()
    ).apply(instance, CopperCeilingHangingSignBlock::new));
    public static final IntegerProperty ROTATION = BlockStateProperties.ROTATION_16;
    public static final BooleanProperty ATTACHED = BlockStateProperties.ATTACHED;
    protected static final float AABB_OFFSET = 5.0F;
    protected static final VoxelShape SHAPE = Block.box(3.0, 0.0, 3.0, 13.0, 16.0, 13.0);
    private static final Map<Integer, VoxelShape> AABBS = Maps.newHashMap(
            ImmutableMap.of(
                    0,
                    Block.box(1.0, 0.0, 7.0, 15.0, 10.0, 9.0),
                    4,
                    Block.box(7.0, 0.0, 1.0, 9.0, 10.0, 15.0),
                    8,
                    Block.box(1.0, 0.0, 7.0, 15.0, 10.0, 9.0),
                    12,
                    Block.box(7.0, 0.0, 1.0, 9.0, 10.0, 15.0)
            )
    );

    public CopperCeilingHangingSignBlock(MetalType type, BlockBehaviour.Properties properties) {
        super(type, properties);
        registerDefaultState(this.stateDefinition
                .any()
                .setValue(ROTATION, 0)
                .setValue(ATTACHED, false)
                .setValue(WATERLOGGED, false)
        );
    }

    @Override
    protected MapCodec<? extends CopperCeilingHangingSignBlock> codec() {
        return CODEC;
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        if (level.getBlockEntity(pos) instanceof SignBlockEntity signblockentity && shouldTryToChainAnotherHangingSign(player, result, signblockentity, stack)) {
            return ItemInteractionResult.SKIP_DEFAULT_BLOCK_INTERACTION;
        }

        return super.useItemOn(stack, state, level, pos, player, hand, result);
    }

    private boolean shouldTryToChainAnotherHangingSign(Player player, BlockHitResult result, SignBlockEntity sign, ItemStack stack) {
        return !sign.canExecuteClickCommands(sign.isFacingFrontText(player), player)
                && stack.getItem() instanceof HangingSignItem
                && result.getDirection().equals(Direction.DOWN);
    }

    @Override
    protected boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        return level.getBlockState(pos.above()).isFaceSturdy(level, pos.above(), Direction.DOWN, SupportType.CENTER);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext cxt) {
        Level level = cxt.getLevel();
        FluidState fluidState = level.getFluidState(cxt.getClickedPos());
        BlockPos blockPos = cxt.getClickedPos().above();
        BlockState blockState = level.getBlockState(blockPos);
        boolean flag = blockState.is(BlockTags.ALL_HANGING_SIGNS);
        Direction direction = Direction.fromYRot(cxt.getRotation());
        boolean flag1 = !Block.isFaceFull(blockState.getCollisionShape(level, blockPos), Direction.DOWN) || cxt.isSecondaryUseActive();

        if (flag && !cxt.isSecondaryUseActive()) {
            if (blockState.hasProperty(WallHangingSignBlock.FACING)) {
                Direction direction1 = blockState.getValue(WallHangingSignBlock.FACING);

                if (direction1.getAxis().test(direction)) {
                    flag1 = false;
                }
            } else if (blockState.hasProperty(ROTATION)) {
                Optional<Direction> optional = RotationSegment.convertToDirection(blockState.getValue(ROTATION));

                if (optional.isPresent() && optional.get().getAxis().test(direction)) {
                    flag1 = false;
                }
            }
        }

        int i = !flag1 ? RotationSegment.convertToSegment(direction.getOpposite()) : RotationSegment.convertToSegment(cxt.getRotation() + 180.0F);

        return this.defaultBlockState()
                .setValue(ATTACHED, flag1)
                .setValue(ROTATION, i)
                .setValue(WATERLOGGED, fluidState.getType() == Fluids.WATER);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext cxt) {
        VoxelShape voxelshape = AABBS.get(state.getValue(ROTATION));
        return voxelshape == null ? SHAPE : voxelshape;
    }

    @Override
    protected VoxelShape getBlockSupportShape(BlockState state, BlockGetter level, BlockPos pos) {
        return this.getShape(state, level, pos, CollisionContext.empty());
    }

    @Override
    protected BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor level, BlockPos currentPos, BlockPos facingPos) {
        return facing == Direction.UP && !this.canSurvive(state, level, currentPos)
                ? Blocks.AIR.defaultBlockState()
                : super.updateShape(state, facing, facingState, level, currentPos, facingPos);
    }

    @Override
    public float getYRotationDegrees(BlockState state) {
        return RotationSegment.convertToDegrees(state.getValue(ROTATION));
    }

    @Override
    protected BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(ROTATION, rotation.rotate(state.getValue(ROTATION), 16));
    }

    @Override
    protected BlockState mirror(BlockState state, Mirror mirror) {
        return state.setValue(ROTATION, mirror.mirror(state.getValue(ROTATION), 16));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(ROTATION, ATTACHED, WATERLOGGED);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new HangingCopperSignBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        return createTickerHelper(blockEntityType, MetalcoreBlockEntityType.HANGING_COPPER_SIGN.get(), CopperSignBlockEntity::tick);
    }
}
