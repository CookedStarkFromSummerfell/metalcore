package io.kalishak.metalcore.world.level.block.sign;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.kalishak.metalcore.api.block.state.properties.MetalType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.RotationSegment;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;

public class CopperStandingSignBlock extends CopperSignBlock {
    public static final IntegerProperty ROTATION = BlockStateProperties.ROTATION_16;
    public static final MapCodec<CopperStandingSignBlock> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
            MetalType.CODEC.fieldOf("metal_type").forGetter(CopperSignBlock::getType),
            propertiesCodec()
    ).apply(instance, CopperStandingSignBlock::new));

    public CopperStandingSignBlock(MetalType type, BlockBehaviour.Properties properties) {
        super(type, properties);
        registerDefaultState(this.stateDefinition.any().setValue(ROTATION, 0).setValue(WATERLOGGED, false));
    }

    @Override
    protected MapCodec<? extends CopperStandingSignBlock> codec() {
        return CODEC;
    }

    @Override
    protected boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        return level.getBlockState(pos.below()).isSolid();
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext cxt) {
        FluidState fluidstate = cxt.getLevel().getFluidState(cxt.getClickedPos());
        return this.defaultBlockState()
                .setValue(ROTATION, RotationSegment.convertToSegment(cxt.getRotation() + 180.0F))
                .setValue(WATERLOGGED, fluidstate.getType() == Fluids.WATER);
    }

    @Override
    protected BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor level, BlockPos currentPos, BlockPos facingPos) {
        return facing == Direction.DOWN && !this.canSurvive(state, level, currentPos)
                ? Blocks.AIR.defaultBlockState()
                : super.updateShape(state, facing, facingState, level, currentPos, facingPos);
    }

    @Override
    public float getYRotationDegrees(BlockState state) {
        return RotationSegment.convertToDegrees(state.getValue(ROTATION));
    }

    @Override
    protected BlockState rotate(BlockState state, Rotation rot) {
        return state.setValue(ROTATION, rot.rotate(state.getValue(ROTATION), 16));
    }

    @Override
    protected BlockState mirror(BlockState state, Mirror mirror) {
        return state.setValue(ROTATION, mirror.mirror(state.getValue(ROTATION), 16));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(ROTATION, WATERLOGGED);
    }
}
