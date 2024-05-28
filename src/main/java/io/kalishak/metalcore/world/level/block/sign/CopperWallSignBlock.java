package io.kalishak.metalcore.world.level.block.sign;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.kalishak.metalcore.api.block.state.properties.MetalType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.Map;

public class CopperWallSignBlock extends CopperSignBlock {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final MapCodec<CopperWallSignBlock> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
            MetalType.CODEC.fieldOf("metal_type").forGetter(CopperSignBlock::getType),
            propertiesCodec()
    ).apply(instance, CopperWallSignBlock::new));
    protected static final float AABB_THICKNESS = 2.0F;
    protected static final float AABB_BOTTOM = 4.5F;
    protected static final float AABB_TOP = 12.5F;
    private static final Map<Direction, VoxelShape> AABBS = Maps.newEnumMap(
            ImmutableMap.of(
                    Direction.NORTH,
                    Block.box(0.0, AABB_BOTTOM, 14.0, 16.0, AABB_TOP, 16.0),
                    Direction.SOUTH,
                    Block.box(0.0, AABB_BOTTOM, 0.0, 16.0, AABB_TOP, AABB_THICKNESS),
                    Direction.EAST,
                    Block.box(0.0, AABB_BOTTOM, 0.0, AABB_THICKNESS, AABB_TOP, 16.0),
                    Direction.WEST,
                    Block.box(14.0, AABB_BOTTOM, 0.0, 16.0, AABB_TOP, 16.0)
            )
    );

    public CopperWallSignBlock(MetalType type, Block.Properties properties) {
        super(type, properties);
        registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, false));
    }

    @Override
    protected MapCodec<? extends CopperWallSignBlock> codec() {
        return CODEC;
    }

    @Override
    public String getDescriptionId() {
        return this.asItem().getDescriptionId();
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext cxt) {
        return AABBS.get(state.getValue(FACING));
    }

    @Override
    protected boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        return level.getBlockState(pos.relative(state.getValue(FACING).getOpposite())).isSolid();
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext cxt) {
        BlockState blockstate = this.defaultBlockState();
        FluidState fluidstate = cxt.getLevel().getFluidState(cxt.getClickedPos());
        LevelReader levelreader = cxt.getLevel();
        BlockPos blockpos = cxt.getClickedPos();
        Direction[] adirection = cxt.getNearestLookingDirections();

        for (Direction direction : adirection) {
            if (direction.getAxis().isHorizontal()) {

                Direction direction1 = direction.getOpposite();
                blockstate = blockstate.setValue(FACING, direction1);

                if (blockstate.canSurvive(levelreader, blockpos)) {
                    return blockstate.setValue(WATERLOGGED, fluidstate.getType() == Fluids.WATER);
                }
            }
        }

        return null;
    }

    @Override
    protected BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor level, BlockPos currentPos, BlockPos facingPos) {
        return facing.getOpposite() == state.getValue(FACING) && !state.canSurvive(level, currentPos)
                ? Blocks.AIR.defaultBlockState()
                : super.updateShape(state, facing, facingState, level, currentPos, facingPos);
    }

    @Override
    public float getYRotationDegrees(BlockState state) {
        return state.getValue(FACING).toYRot();
    }

    @Override
    public Vec3 getSignHitboxCenterPosition(BlockState state) {
        VoxelShape voxelshape = AABBS.get(state.getValue(FACING));
        return voxelshape.bounds().getCenter();
    }

    @Override
    protected BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @Override
    protected BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED);
    }
}
