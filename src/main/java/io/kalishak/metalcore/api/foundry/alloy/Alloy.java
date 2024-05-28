package io.kalishak.metalcore.api.foundry.alloy;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.kalishak.metalcore.api.registries.MetalcoreApiRegistries;
import net.minecraft.core.Holder;
import net.minecraft.core.NonNullList;
import net.minecraft.resources.RegistryFileCodec;

import java.util.Arrays;

public record Alloy(Holder<Metal> metal, NonNullList<FoundryIngredient> ingredients) {
    public static final Codec<Alloy> DIRECT_CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Metal.CODEC.fieldOf("metal").forGetter(Alloy::metal),
            NonNullList.codecOf(FoundryIngredient.CODEC).fieldOf("ingredients").forGetter(Alloy::ingredients)
    ).apply(instance, Alloy::new));
    public static final Codec<Holder<Alloy>> CODEC = RegistryFileCodec.create(MetalcoreApiRegistries.ALLOY_KEY, DIRECT_CODEC);

    public static Alloy of(Holder<Metal> metal, FoundryIngredient... ingredients) {
        return new Alloy(metal, NonNullList.copyOf(Arrays.asList(ingredients)));
    }
}
