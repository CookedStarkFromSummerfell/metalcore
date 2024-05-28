package io.kalishak.metalcore.data.material;

import com.google.common.collect.ImmutableList;
import io.kalishak.metalcore.Metalcore;
import io.kalishak.metalcore.api.foundry.alloy.*;
import io.kalishak.metalcore.api.registries.MetalcoreApiGameRules;
import io.kalishak.metalcore.api.registries.MetalcoreApiRegistries;
import io.kalishak.metalcore.tags.MetalBlockTags;
import io.kalishak.metalcore.tags.MetalFluidTags;
import io.kalishak.metalcore.tags.MetalItemTags;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

public class MetalcoreAlloys {
    public static final ResourceKey<Alloy> BRONZE = create("bronze");
    public static final ResourceKey<Alloy> STEEL = create("steel");

    public static void bootstrap(BootstrapContext<Alloy> cxt) {
        var lookupProvider = cxt.lookup(MetalcoreApiRegistries.METAL_KEY);

        Holder<Metal> bronze = lookupProvider.getOrThrow(MetalcoreMetals.BRONZE);
        Holder<Metal> steel = lookupProvider.getOrThrow(MetalcoreMetals.STEEL);

        Holder<Metal> carbon = lookupProvider.getOrThrow(MetalcoreMetals.CARBON);
        Holder<Metal> copper = lookupProvider.getOrThrow(MetalcoreMetals.COPPER);
        Holder<Metal> iron = lookupProvider.getOrThrow(MetalcoreMetals.IRON);
        Holder<Metal> tin = lookupProvider.getOrThrow(MetalcoreMetals.TIN);

        cxt.register(BRONZE, Alloy.of(
                bronze,
                new FoundryIngredient(copper, 3),
                new FoundryIngredient(tin, 1))
        );
        cxt.register(STEEL, Alloy.of(
                steel,
                new FoundryIngredient(iron, 8),
                new FoundryIngredient(carbon, 1))
        );
    }

    private static ResourceKey<Alloy> create(String name) {
        return ResourceKey.create(MetalcoreApiRegistries.ALLOY_KEY, new ResourceLocation(Metalcore.MODID, name));
    }
}
