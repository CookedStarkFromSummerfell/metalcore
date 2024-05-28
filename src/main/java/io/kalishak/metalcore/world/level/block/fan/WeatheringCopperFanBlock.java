package io.kalishak.metalcore.world.level.block.fan;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.kalishak.metalcore.api.block.WeatheringCopperHolder;
import net.minecraft.core.Direction;

public class WeatheringCopperFanBlock extends CopperFanBlock implements WeatheringCopperHolder {
    public static final MapCodec<WeatheringCopperFanBlock> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
            WeatherState.CODEC.fieldOf("weathering_state").forGetter(WeatheringCopperFanBlock::getAge),
            propertiesCodec()
    ).apply(instance, WeatheringCopperFanBlock::new));

    private final WeatherState weatherState;

    public WeatheringCopperFanBlock(WeatherState weatherState, Properties properties) {
        super(properties);
        this.weatherState = weatherState;

        registerDefaultState(getStateDefinition().any().setValue(FACING, Direction.NORTH).setValue(POWERED, false));
    }

    @Override
    protected MapCodec<WeatheringCopperFanBlock> codec() {
        return CODEC;
    }

    @Override
    public WeatherState getAge() {
        return this.weatherState;
    }
}
