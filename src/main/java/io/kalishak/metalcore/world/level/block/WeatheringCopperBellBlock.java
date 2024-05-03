package io.kalishak.metalcore.world.level.block;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.kalishak.metalcore.api.block.WeatheringCopperHolder;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.properties.BellAttachType;

public class WeatheringCopperBellBlock extends CopperBellBlock implements WeatheringCopperHolder {
    public static final MapCodec<WeatheringCopperBellBlock> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
            WeatherState.CODEC.fieldOf("weathering_state").forGetter(WeatheringCopperBellBlock::getAge),
            propertiesCodec()
    ).apply(instance, WeatheringCopperBellBlock::new));
    private final WeatherState weatherState;

    public WeatheringCopperBellBlock(WeatherState weatherState, Properties properties) {
        super(properties);
        this.weatherState = weatherState;

        registerDefaultState(getStateDefinition().any()
                .setValue(FACING, Direction.NORTH)
                .setValue(ATTACHMENT, BellAttachType.FLOOR)
                .setValue(POWERED, false)
                .setValue(WATERLOGGED, false)
        );
    }

    @Override
    protected MapCodec<? extends WeatheringCopperBellBlock> codec() {
        return CODEC;
    }

    @Override
    public float getChanceModifier() {
        float modifier = WeatheringCopperHolder.super.getChanceModifier();

        //if (waterlogged) { modifier *= 2.0F; }

        return modifier;
    }

    @Override
    public WeatherState getAge() {
        return this.weatherState;
    }
}
