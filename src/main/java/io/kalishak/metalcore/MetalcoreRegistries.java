package io.kalishak.metalcore;

import io.kalishak.metalcore.api.block.state.properties.MetalType;
import io.kalishak.metalcore.api.foundry.TierMaterial;
import io.kalishak.metalcore.api.registries.MetalcoreApiRegistries;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.registries.NewRegistryEvent;
import net.neoforged.neoforge.registries.RegistryBuilder;

public final class MetalcoreRegistries {
    private static void init() {}

    public static final Registry<Tier> TIER_MATERIALS = new RegistryBuilder<>(TierMaterial.REGISTRY_KEY)
            .sync(true)
            .create();
    public static final Registry<MetalType> METAL_TYPES = new RegistryBuilder<>(MetalcoreApiRegistries.METAL_BLOCK_TYPE_KEY)
            .sync(true)
            .defaultKey(new ResourceLocation("copper"))
            .create();

    @SubscribeEvent
    public static void registerRegistries(final NewRegistryEvent event) {
        event.register(TIER_MATERIALS);
        event.register(METAL_TYPES);
    }

    static {
        init();
    }
}
