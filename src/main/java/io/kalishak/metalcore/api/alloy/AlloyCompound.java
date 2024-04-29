package io.kalishak.metalcore.api.alloy;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;

public record AlloyCompound(double amount, Holder<MetalMaterial> metal) {
    public static final Codec<AlloyCompound> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.DOUBLE.fieldOf("amount").forGetter(AlloyCompound::amount),
            MetalMaterial.CODEC.fieldOf("metal").forGetter(AlloyCompound::metal)
    ).apply(instance, AlloyCompound::new));
}
