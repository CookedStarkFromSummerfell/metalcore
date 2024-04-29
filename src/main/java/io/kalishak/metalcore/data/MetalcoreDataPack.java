package io.kalishak.metalcore.data;

import io.kalishak.metalcore.api.alloy.AlloyMaterial;
import io.kalishak.metalcore.api.alloy.MetalMaterial;
import io.kalishak.metalcore.data.features.MetalcoreOreFeatures;
import io.kalishak.metalcore.data.material.MetalcoreAlloys;
import io.kalishak.metalcore.data.material.MetalcoreMetals;
import io.kalishak.metalcore.data.placements.MetalcoreOrePlacements;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class MetalcoreDataPack extends DatapackBuiltinEntriesProvider {
    private static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, MetalcoreOreFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, MetalcoreOrePlacements::bootstrap)
            .add(MetalMaterial.REGISTRY_KEY, MetalcoreMetals::bootstrap)
            .add(AlloyMaterial.REGISTRY_KEY, MetalcoreAlloys::bootstrap);

    public MetalcoreDataPack(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, String modId) {
        super(output, registries, BUILDER, Set.of(modId));
    }
}
