package io.kalishak.metalcore.world.level.block.sign.hanging;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.kalishak.metalcore.api.block.WeatheringCopperHolder;
import io.kalishak.metalcore.api.block.state.properties.MetalType;

public class WeatheringCopperWallHangingSignBlock extends CopperWallHangingSignBlock implements WeatheringCopperHolder {
    public static final MapCodec<WeatheringCopperWallHangingSignBlock> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
            MetalType.CODEC.fieldOf("metal_type").forGetter(WeatheringCopperWallHangingSignBlock::getType),
            WeatherState.CODEC.fieldOf("weathering_state").forGetter(WeatheringCopperWallHangingSignBlock::getAge),
            propertiesCodec()
    ).apply(instance, WeatheringCopperWallHangingSignBlock::new));

    private final WeatherState weatherState;

    public WeatheringCopperWallHangingSignBlock(MetalType type, WeatheringCopperHolder.WeatherState weatherState, Properties properties) {
        super(type, properties);
        this.weatherState = weatherState;
    }

    @Override
    protected MapCodec<WeatheringCopperWallHangingSignBlock> codec() {
        return CODEC;
    }

    @Override
    public WeatherState getAge() {
        return this.weatherState;
    }
}
