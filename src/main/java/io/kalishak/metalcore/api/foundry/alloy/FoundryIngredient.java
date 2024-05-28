package io.kalishak.metalcore.api.foundry.alloy;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;

public record FoundryIngredient(Holder<Metal> ingredient, int amount) {
    public static final Codec<FoundryIngredient> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Metal.CODEC.fieldOf("ingredient").forGetter(FoundryIngredient::ingredient),
            Codec.INT.fieldOf("amount").forGetter(FoundryIngredient::amount)
    ).apply(instance, FoundryIngredient::new));
}
