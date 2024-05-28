package io.kalishak.metalcore.world.level.block.sign;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.kalishak.metalcore.api.block.WeatheringCopperHolder;
import io.kalishak.metalcore.api.block.state.properties.MetalType;

public class WeatheringCopperWallSignBlock extends CopperWallSignBlock implements WeatheringCopperHolder {
    public static final MapCodec<WeatheringCopperWallSignBlock> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
            MetalType.CODEC.fieldOf("metal_type").forGetter(WeatheringCopperWallSignBlock::getType),
            WeatherState.CODEC.fieldOf("weather_state").forGetter(WeatheringCopperWallSignBlock::getAge),
            propertiesCodec()
    ).apply(instance, WeatheringCopperWallSignBlock::new));
    private final WeatheringCopperHolder.WeatherState weatherState;

    public WeatheringCopperWallSignBlock(MetalType type, WeatheringCopperHolder.WeatherState weatherState, Properties properties) {
        super(type, properties);
        this.weatherState = weatherState;
    }

    @Override
    protected MapCodec<WeatheringCopperWallSignBlock> codec() {
        return CODEC;
    }

    @Override
    public WeatherState getAge() {
        return this.weatherState;
    }
}
