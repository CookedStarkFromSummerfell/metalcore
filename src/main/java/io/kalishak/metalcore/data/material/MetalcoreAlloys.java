package io.kalishak.metalcore.data.material;

import com.google.common.collect.ImmutableList;
import io.kalishak.metalcore.Metalcore;
import io.kalishak.metalcore.api.alloy.AlloyCompound;
import io.kalishak.metalcore.api.alloy.AlloyMaterial;
import io.kalishak.metalcore.api.alloy.MetalData;
import io.kalishak.metalcore.api.alloy.MetalMaterial;
import io.kalishak.metalcore.tags.MetalBlockTags;
import io.kalishak.metalcore.tags.MetalFluidTags;
import io.kalishak.metalcore.tags.MetalItemTags;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

public class MetalcoreAlloys {
    public static final ResourceKey<AlloyMaterial> BRONZE = create("bronze");
    public static final ResourceKey<AlloyMaterial> STEEL = create("steel");

    public static void bootstrap(BootstrapContext<AlloyMaterial> cxt) {
        var lookupProvider = cxt.lookup(MetalMaterial.REGISTRY_KEY);

        Holder<MetalMaterial> carbon = lookupProvider.getOrThrow(MetalcoreMetals.CARBON);
        Holder<MetalMaterial> copper = lookupProvider.getOrThrow(MetalcoreMetals.COPPER);
        Holder<MetalMaterial> iron = lookupProvider.getOrThrow(MetalcoreMetals.IRON);
        Holder<MetalMaterial> tin = lookupProvider.getOrThrow(MetalcoreMetals.TIN);

        cxt.register(BRONZE, new AlloyMaterial(
                new MetalData(940.0F, 8.0F, 110),
                MetalBlockTags.ALLOY_BRONZE,
                MetalItemTags.ALLOY_BRONZE,
                MetalFluidTags.MOLTEN_BRONZE,
                new ImmutableList.Builder<AlloyCompound>()
                        .add(new AlloyCompound(85.0, copper))
                        .add(new AlloyCompound(15.0, tin))
                        .build(),
                false,
                false)
        );
        cxt.register(STEEL, new AlloyMaterial(
                new MetalData(1370.0F, 7.5F, 130),
                MetalBlockTags.ALLOY_STEEL,
                MetalItemTags.ALLOY_STEEL,
                MetalFluidTags.MOLTEN_STEEL,
                new ImmutableList.Builder<AlloyCompound>()
                        .add(new AlloyCompound(97.7, iron))
                        .add(new AlloyCompound(2.3, carbon))
                        .build(),
                false,
                false)
        );
    }

    private static ResourceKey<AlloyMaterial> create(String name) {
        return ResourceKey.create(AlloyMaterial.REGISTRY_KEY, new ResourceLocation(Metalcore.MODID, name));
    }
}
