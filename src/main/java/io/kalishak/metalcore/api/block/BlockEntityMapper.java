package io.kalishak.metalcore.api.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public interface BlockEntityMapper<E extends BlockEntity> {
    BlockEntityFactory<E> getBlockEntity();

    interface BlockEntityFactory<E extends BlockEntity> {
        E create(BlockPos pos, BlockState state);
    }
}
