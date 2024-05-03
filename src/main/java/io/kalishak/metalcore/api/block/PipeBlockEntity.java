package io.kalishak.metalcore.api.block;

import io.kalishak.metalcore.world.level.block.entity.MetalcoreBlockEntityType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class PipeBlockEntity extends BlockEntity {
    public PipeBlockEntity(BlockEntityType<? extends PipeBlockEntity> blockEntityType, BlockPos pPos, BlockState pBlockState) {
        super(blockEntityType, pPos, pBlockState);
    }

    public PipeBlockEntity(BlockPos pPos, BlockState pBlockState) {
        this(MetalcoreBlockEntityType.PIPE.get(), pPos, pBlockState);
    }
}
