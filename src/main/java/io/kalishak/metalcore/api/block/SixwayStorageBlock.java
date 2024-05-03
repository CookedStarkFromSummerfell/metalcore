package io.kalishak.metalcore.api.block;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.kalishak.metalcore.api.block.state.properties.PipeConnection;
import io.kalishak.metalcore.api.block.state.properties.PipeProperty;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

public abstract class SixwayStorageBlock<E extends BlockEntity> extends BaseEntityBlock implements Pipe, SimpleWaterloggedBlock {
    public static final PipeProperty CONNECTED_NORTH = PipeProperty.CONNECTED_NORTH;
    public static final PipeProperty CONNECTED_EAST = PipeProperty.CONNECTED_EAST;
    public static final PipeProperty CONNECTED_SOUTH = PipeProperty.CONNECTED_SOUTH;
    public static final PipeProperty CONNECTED_WEST = PipeProperty.CONNECTED_WEST;
    public static final PipeProperty CONNECTED_UP = PipeProperty.CONNECTED_UP;
    public static final PipeProperty CONNECTED_DOWN = PipeProperty.CONNECTED_DOWN;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    protected final Map<Direction, PipeProperty> FACING_TO_CONNECTION = Util.make(new HashMap<>(), map -> {
       map.put(Direction.NORTH, CONNECTED_NORTH);
       map.put(Direction.EAST, CONNECTED_EAST);
       map.put(Direction.SOUTH, CONNECTED_SOUTH);
       map.put(Direction.WEST, CONNECTED_WEST);
       map.put(Direction.UP, CONNECTED_UP);
       map.put(Direction.DOWN, CONNECTED_DOWN);
    });

    protected final Type type;
    protected final double size;

    public SixwayStorageBlock(Type type, double size, Properties properties) {
        super(properties);
        this.type = type;
        this.size = size;

        registerDefaultState(getStateDefinition().any()
                .setValue(CONNECTED_NORTH, PipeConnection.NONE)
                .setValue(CONNECTED_EAST, PipeConnection.NONE)
                .setValue(CONNECTED_SOUTH, PipeConnection.NONE)
                .setValue(CONNECTED_WEST, PipeConnection.NONE)
                .setValue(CONNECTED_UP, PipeConnection.NONE)
                .setValue(CONNECTED_DOWN, PipeConnection.NONE)
                .setValue(WATERLOGGED, false)
        );
    }

    public Type getType() {
        return this.type;
    }

    public double getSize() {
        return this.size;
    }

    @Override
    protected RenderShape getRenderShape(BlockState pState) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return null;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(CONNECTED_NORTH, CONNECTED_EAST, CONNECTED_SOUTH, CONNECTED_WEST, CONNECTED_UP, CONNECTED_DOWN, WATERLOGGED);
    }
}
