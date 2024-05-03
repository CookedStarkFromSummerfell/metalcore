package io.kalishak.metalcore.world.level.block;

import io.kalishak.metalcore.api.block.WeatheringCopperHolder;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockState;

public class WeatheringCopperSpikesBlock extends CopperSpikesBlock implements WeatheringCopperHolder {
    private final WeatheringCopper.WeatherState weatherState;

    public WeatheringCopperSpikesBlock(WeatherState weatherState, Properties properties) {
        super(properties);
        this.weatherState = weatherState;

        registerDefaultState(getStateDefinition().any().setValue(PARTS, 1).setValue(WATERLOGGED, false));
    }

    @Override
    public WeatherState getAge() {
        return this.weatherState;
    }

    protected boolean isPoisonous(BlockState state) {
        return state.getValue(WATERLOGGED) && getAge() != WeatherState.UNAFFECTED && getAge() != WeatherState.EXPOSED;
    }

    @Override
    protected void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        changeOverTime(pState, pLevel, pPos, pRandom);
    }

    @Override
    protected boolean isRandomlyTicking(BlockState state) {
        return getNext(state).isPresent();
    }
}
