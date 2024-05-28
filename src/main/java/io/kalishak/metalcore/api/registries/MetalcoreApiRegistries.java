package io.kalishak.metalcore.api.registries;

import io.kalishak.metalcore.api.block.state.properties.MetalType;
import io.kalishak.metalcore.api.foundry.alloy.Alloy;
import io.kalishak.metalcore.api.foundry.alloy.Metal;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

public final class MetalcoreApiRegistries {
    public static final ResourceKey<Registry<Alloy>> ALLOY_KEY = ResourceKey.createRegistryKey(new ResourceLocation("alloy"));
    public static final ResourceKey<Registry<Metal>> METAL_KEY = ResourceKey.createRegistryKey(new ResourceLocation("metal"));
    public static final ResourceKey<Registry<MetalType>> METAL_BLOCK_TYPE_KEY = ResourceKey.createRegistryKey(new ResourceLocation("metal_block_type"));
}
