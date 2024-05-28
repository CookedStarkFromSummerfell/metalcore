package io.kalishak.metalcore.data;

import io.kalishak.metalcore.api.foundry.alloy.Alloy;
import io.kalishak.metalcore.api.foundry.alloy.Metal;
import io.kalishak.metalcore.api.registries.MetalcoreApiRegistries;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.registries.DataPackRegistryEvent;

public class MetalcoreDatapackRegistries {
    @SubscribeEvent
    public static void registerDatapackRegistries(final DataPackRegistryEvent.NewRegistry event) {
        event.dataPackRegistry(MetalcoreApiRegistries.METAL_KEY, Metal.DIRECT_CODEC);
        event.dataPackRegistry(MetalcoreApiRegistries.ALLOY_KEY, Alloy.DIRECT_CODEC);
    }
}
