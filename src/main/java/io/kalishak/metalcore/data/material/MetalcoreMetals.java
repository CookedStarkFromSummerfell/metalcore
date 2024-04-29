package io.kalishak.metalcore.data.material;

import io.kalishak.metalcore.Metalcore;
import io.kalishak.metalcore.api.alloy.MetalData;
import io.kalishak.metalcore.api.alloy.MetalMaterial;
import io.kalishak.metalcore.tags.MetalBlockTags;
import io.kalishak.metalcore.tags.MetalFluidTags;
import io.kalishak.metalcore.tags.MetalItemTags;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.Tags;

public class MetalcoreMetals {
    public static final ResourceKey<MetalMaterial> GOLD = createVanilla("gold");
    public static final ResourceKey<MetalMaterial> COPPER = createVanilla("copper");
    public static final ResourceKey<MetalMaterial> IRON = createVanilla("iron");
    public static final ResourceKey<MetalMaterial> NETHERITE = createVanilla("netherite");

    public static final ResourceKey<MetalMaterial> ALUMINUM = create("aluminum");
    public static final ResourceKey<MetalMaterial> CARBON = create("carbon");
    public static final ResourceKey<MetalMaterial> LEAD = create("lead");
    public static final ResourceKey<MetalMaterial> SILVER = create("silver");
    public static final ResourceKey<MetalMaterial> TIN = create("tin");

    public static void bootstrap(BootstrapContext<MetalMaterial> cxt) {
        cxt.register(GOLD, new MetalMaterial(
                new MetalData(1337.0F, 19.3F, 118),
                MetalBlockTags.METAL_GOLD,
                MetalItemTags.METAL_GOLD,
                MetalFluidTags.MOLTEN_GOLD,
                false,
                false)
        );
        cxt.register(COPPER, new MetalMaterial(
                new MetalData(1357.0F, 8.9F, 120),
                MetalBlockTags.METAL_COPPER,
                MetalItemTags.METAL_COPPER,
                MetalFluidTags.MOLTEN_COPPER,
                false,
                true)
        );
        cxt.register(IRON, new MetalMaterial(
                new MetalData(1808.0F, 7.8F, 109),
                MetalBlockTags.METAL_IRON,
                MetalItemTags.METAL_IRON,
                MetalFluidTags.MOLTEN_IRON,
                false,
                false)
        );
        cxt.register(NETHERITE, new MetalMaterial(
                new MetalData(1448.0F, 21.3F, 93),
                MetalBlockTags.METAL_NETHERITE,
                MetalItemTags.METAL_NETHERITE,
                MetalFluidTags.MOLTEN_NETHERITE,
                false,
                false)
        );

        cxt.register(ALUMINUM, new MetalMaterial(
                new MetalData(933.0F, 2.7F, 45),
                MetalBlockTags.METAL_ALUMINUM,
                MetalItemTags.METAL_ALUMINUM,
                MetalFluidTags.MOLTEN_ALUMINUM,
                false,
                false)
        );
        cxt.register(CARBON, new MetalMaterial(
                new MetalData(3555.0F, 2.9F, 355),
                Tags.Blocks.STORAGE_BLOCKS_COAL,
                Tags.Items.STORAGE_BLOCKS_COAL,
                Tags.Fluids.HIDDEN_FROM_RECIPE_VIEWERS,
                false,
                false)
        );
        cxt.register(LEAD, new MetalMaterial(
                new MetalData(600.0F, 11.3F, 28),
                MetalBlockTags.METAL_LEAD,
                MetalItemTags.METAL_LEAD,
                MetalFluidTags.MOLTEN_LEAD,
                true,
                true)
        );
        cxt.register(SILVER, new MetalMaterial(
                new MetalData(1234.0F, 10.4F, 74),
                MetalBlockTags.METAL_SILVER,
                MetalItemTags.METAL_SILVER,
                MetalFluidTags.MOLTEN_SILVER,
                false,
                false)
        );
        cxt.register(TIN, new MetalMaterial(
                new MetalData(504.0F, 7.2F, 19),
                MetalBlockTags.METAL_TIN,
                MetalItemTags.METAL_TIN,
                MetalFluidTags.MOLTEN_TIN,
                false,
                false)
        );
    }

    private static ResourceKey<MetalMaterial> createVanilla(String name) {
        return ResourceKey.create(MetalMaterial.REGISTRY_KEY, new ResourceLocation(name));
    }

    private static ResourceKey<MetalMaterial> create(String name) {
        return createVanilla(Metalcore.MODID + ":" + name);
    }
}
