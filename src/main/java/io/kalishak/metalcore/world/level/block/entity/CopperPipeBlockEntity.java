package io.kalishak.metalcore.world.level.block.entity;

import io.kalishak.metalcore.api.block.PipeBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockState;

public class CopperPipeBlockEntity extends PipeBlockEntity {
    public CopperPipeBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(MetalcoreBlockEntityType.COPPER_PIPE.get(), pPos, pBlockState);
    }

    public static void serverTick(Level pLevel, BlockPos pPos, BlockState pState, CopperPipeBlockEntity pipe) {
        if (pipe.getBlockState().getBlock() instanceof WeatheringCopper weatheringCopper) {
            if (weatheringCopper.getNext(pState).isPresent()) {
                weatheringCopper.changeOverTime(pState, (ServerLevel) pLevel, pPos, pLevel.random);
            }
        }
    }
}
