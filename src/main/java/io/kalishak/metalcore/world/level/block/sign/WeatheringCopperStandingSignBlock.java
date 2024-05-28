package io.kalishak.metalcore.world.level.block.sign;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.kalishak.metalcore.api.block.WeatheringCopperHolder;
import io.kalishak.metalcore.api.block.state.properties.MetalType;

public class WeatheringCopperStandingSignBlock extends CopperStandingSignBlock implements WeatheringCopperHolder {
    public static final MapCodec<WeatheringCopperStandingSignBlock> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
            MetalType.CODEC.fieldOf("metal_type").forGetter(WeatheringCopperStandingSignBlock::getType),
            WeatheringCopperHolder.WeatherState.CODEC.fieldOf("weathering_state").forGetter(WeatheringCopperStandingSignBlock::getAge),
            propertiesCodec()
    ).apply(instance, WeatheringCopperStandingSignBlock::new));

    private final WeatheringCopperHolder.WeatherState weatherState;

    public WeatheringCopperStandingSignBlock(MetalType type, WeatheringCopperHolder.WeatherState weatherState, Properties properties) {
        super(type, properties);
        this.weatherState = weatherState;
    }

    @Override
    protected MapCodec<WeatheringCopperStandingSignBlock> codec() {
        return CODEC;
    }

    @Override
    public WeatheringCopperHolder.WeatherState getAge() {
        return this.weatherState;
    }
}
