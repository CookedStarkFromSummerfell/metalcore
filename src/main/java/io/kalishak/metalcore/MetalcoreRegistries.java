package io.kalishak.metalcore;

import io.kalishak.metalcore.api.tier.TierMaterial;
import net.minecraft.core.Registry;
import net.neoforged.neoforge.registries.RegistryBuilder;

public final class MetalcoreRegistries {
    public static final Registry<TierMaterial> TIER_MATERIALS = new RegistryBuilder<>(TierMaterial.REGISTRY_KEY).sync(true).create();
}
