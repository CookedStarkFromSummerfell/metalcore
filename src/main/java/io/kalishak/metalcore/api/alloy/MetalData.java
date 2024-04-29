package io.kalishak.metalcore.api.alloy;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

public record MetalData(float meltingTemperature, float density, int hardeningTime) {
    public static final Codec<MetalData> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.FLOAT.fieldOf("melting_temperature").forGetter(MetalData::meltingTemperature),
            Codec.FLOAT.fieldOf("density").forGetter(MetalData::density),
            Codec.INT.fieldOf("hardening_time").forGetter(MetalData::hardeningTime)
    ).apply(instance, MetalData::new));
}
