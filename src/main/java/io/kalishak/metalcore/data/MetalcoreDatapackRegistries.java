package io.kalishak.metalcore.data;

import io.kalishak.metalcore.api.alloy.AlloyMaterial;
import io.kalishak.metalcore.api.alloy.MetalMaterial;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.registries.DataPackRegistryEvent;

public class MetalcoreDatapackRegistries {
    @SubscribeEvent
    public static void registerDatapackRegistries(final DataPackRegistryEvent.NewRegistry event) {
        event.dataPackRegistry(MetalMaterial.REGISTRY_KEY, MetalMaterial.DIRECT_CODEC);
        event.dataPackRegistry(AlloyMaterial.REGISTRY_KEY, AlloyMaterial.CODEC);
    }
}
