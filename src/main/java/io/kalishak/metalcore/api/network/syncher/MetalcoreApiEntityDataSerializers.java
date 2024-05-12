package io.kalishak.metalcore.api.network.syncher;

import com.google.common.base.Suppliers;
import io.kalishak.metalcore.api.block.WeatheringCopperHolder;
import net.minecraft.network.syncher.EntityDataSerializer;

import java.util.function.Supplier;

public final class MetalcoreApiEntityDataSerializers {
    public static final Supplier<EntityDataSerializer<WeatheringCopperHolder.WeatherState>> WEATHERING_STATE = Suppliers.memoize(() -> EntityDataSerializer.forValueType(WeatheringCopperHolder.WeatherState.STREAM_CODEC));
}
