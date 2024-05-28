package io.kalishak.metalcore.api.foundry.alloy;

import io.kalishak.metalcore.api.registries.MetalcoreApiRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;

public class MetalTags {
    public static final TagKey<Metal> COPPER = createShared("copper");
    public static final TagKey<Metal> GOLD = createShared("gold");
    public static final TagKey<Metal> IRON = createShared("iron");
    public static final TagKey<Metal> NETHERITE = createShared("netherite");

    public static TagKey<Metal> createShared(String name) {
        return TagKey.create(MetalcoreApiRegistries.METAL_KEY, new ResourceLocation("c", name));
    }
}
