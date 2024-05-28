package io.kalishak.metalcore.world.level.block.sign.hanging;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.kalishak.metalcore.api.block.WeatheringCopperHolder;
import io.kalishak.metalcore.api.block.state.properties.MetalType;

public class WeatheringCopperCeilingHangingSignBlock extends CopperCeilingHangingSignBlock implements WeatheringCopperHolder {
    public static final MapCodec<WeatheringCopperCeilingHangingSignBlock> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
            MetalType.CODEC.fieldOf("metal_type").forGetter(WeatheringCopperCeilingHangingSignBlock::getType),
            WeatherState.CODEC.fieldOf("weathering_state").forGetter(WeatheringCopperCeilingHangingSignBlock::getAge),
            propertiesCodec()
    ).apply(instance, WeatheringCopperCeilingHangingSignBlock::new));

    private final WeatherState weatherState;

    public WeatheringCopperCeilingHangingSignBlock(MetalType type, WeatheringCopperHolder.WeatherState weatherState, Properties properties) {
        super(type, properties);
        this.weatherState = weatherState;
    }

    @Override
    protected MapCodec<WeatheringCopperCeilingHangingSignBlock> codec() {
        return CODEC;
    }

    @Override
    public WeatherState getAge() {
        return this.weatherState;
    }
}
