package io.kalishak.metalcore.api.registries;

import io.kalishak.metalcore.api.tier.TierMaterial;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.neoforged.neoforge.registries.DeferredRegister;

public class DeferredRegistries<T> extends DeferredRegister<T> {
    protected DeferredRegistries(ResourceKey<? extends Registry<T>> registryKey, String namespace) {
        super(registryKey, namespace);
    }
    
    public static DeferredRegistries.Tiers createTiers(String modId) {
        return new Tiers(modId);
    }
    
    public static class Tiers extends DeferredRegistries<TierMaterial> {
        protected Tiers(String modId) {
            super(TierMaterial.REGISTRY_KEY, modId);
        }
    }
}
