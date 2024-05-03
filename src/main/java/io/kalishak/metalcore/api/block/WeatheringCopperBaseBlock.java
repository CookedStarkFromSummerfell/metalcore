package io.kalishak.metalcore.api.block;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockState;

public class WeatheringCopperBaseBlock extends Block implements WeatheringCopperHolder {
    public static final MapCodec<WeatheringCopperBaseBlock> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
            WeatherState.CODEC.fieldOf("weather_state").forGetter(WeatheringCopperBaseBlock::getAge),
            propertiesCodec()
    ).apply(instance, WeatheringCopperBaseBlock::new));
    protected WeatheringCopper.WeatherState weatherState;

    public WeatheringCopperBaseBlock(WeatheringCopper.WeatherState weatherState, Properties properties) {
        super(properties);
        this.weatherState = weatherState;
    }

    @Override
    protected MapCodec<? extends WeatheringCopperBaseBlock> codec() {
        return CODEC;
    }

    @Override
    public WeatherState getAge() {
        return this.weatherState;
    }

    @Override
    protected void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        changeOverTime(pState, pLevel, pPos, pRandom);
    }
}
