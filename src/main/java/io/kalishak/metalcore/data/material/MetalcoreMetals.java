package io.kalishak.metalcore.data.material;

import io.kalishak.metalcore.Metalcore;
import io.kalishak.metalcore.api.foundry.alloy.Metal;
import io.kalishak.metalcore.api.registries.MetalcoreApiRegistries;
import io.kalishak.metalcore.tags.MetalBlockTags;
import io.kalishak.metalcore.tags.MetalFluidTags;
import io.kalishak.metalcore.tags.MetalItemTags;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.Tags;

import java.util.Optional;

public class MetalcoreMetals {
    public static final ResourceKey<Metal> GOLD = createVanilla("gold");
    public static final ResourceKey<Metal> COPPER = createVanilla("copper");
    public static final ResourceKey<Metal> IRON = createVanilla("iron");
    public static final ResourceKey<Metal> NETHERITE = createVanilla("netherite");

    public static final ResourceKey<Metal> ALUMINUM = create("aluminum");
    public static final ResourceKey<Metal> CARBON = create("carbon");
    public static final ResourceKey<Metal> LEAD = create("lead");
    public static final ResourceKey<Metal> SILVER = create("silver");
    public static final ResourceKey<Metal> TIN = create("tin");

    public static final ResourceKey<Metal> BRONZE = create("bronze");
    public static final ResourceKey<Metal> STEEL = create("steel");

    public static void bootstrap(BootstrapContext<Metal> cxt) {
        cxt.register(GOLD, Metal.of(
                0xF2E41F,
                0x918809,
                1337.0F,
                19.3F,
                9.0F,
                118,
                false,
                MetalItemTags.METAL_GOLD,
                MetalBlockTags.METAL_GOLD,
                MetalFluidTags.MOLTEN_GOLD)
        );
        cxt.register(COPPER, Metal.of(
                0xE07C1D,
                0xAD6826,
                1357.0F,
                8.9F,
                4.5F,
                120,
                true,
                MetalItemTags.METAL_COPPER,
                MetalBlockTags.METAL_COPPER,
                MetalFluidTags.MOLTEN_COPPER)
        );
        cxt.register(IRON, Metal.of(
                0xD1D0CF,
                0x9C9691,
                1808.0F,
                7.8F,
                9.1F,
                109,
                true,
                MetalItemTags.METAL_IRON,
                MetalBlockTags.METAL_IRON,
                MetalFluidTags.MOLTEN_IRON)
        );
        cxt.register(NETHERITE, Metal.of(
                0x261A0F,
                0x1A130D,
                1448.0F,
                21.3F,
                13.F,
                93,
                false,
                MetalItemTags.METAL_NETHERITE,
                MetalBlockTags.METAL_NETHERITE,
                MetalFluidTags.MOLTEN_NETHERITE)
        );

        cxt.register(ALUMINUM, Metal.of(
                0xD9D2CC,
                0xB3ACA6,
                933.0F,
                2.7F,
                1.0F,
                45,
                false,
                MetalItemTags.METAL_ALUMINUM,
                MetalBlockTags.METAL_ALUMINUM,
                MetalFluidTags.MOLTEN_ALUMINUM)
        );
        cxt.register(CARBON, new Metal(
                0x262626,
                0x1C1A1A,
                3555.0F,
                2.9F,
                0.9F,
                355,
                false,
                Optional.of(Tags.Items.STORAGE_BLOCKS_COAL),
                Optional.of(Tags.Blocks.STORAGE_BLOCKS_COAL),
                Optional.empty())
        );
        cxt.register(LEAD, Metal.of(
                0x856DED,
                0x5C45BF,
                600.0F,
                11.3F,
                5.3F,
                28,
                true,
                MetalItemTags.METAL_LEAD,
                MetalBlockTags.METAL_LEAD,
                MetalFluidTags.MOLTEN_LEAD)
        );
        cxt.register(SILVER, Metal.of(
                0xA8B2E0,
                0x939ABA,
                1234.0F,
                10.4F,
                8.4F,
                74,
                false,
                MetalItemTags.METAL_SILVER,
                MetalBlockTags.METAL_SILVER,
                MetalFluidTags.MOLTEN_SILVER)
        );
        cxt.register(TIN, Metal.of(
                0xAFBBF0,
                0x7681B5,
                504.0F,
                7.2F,
                5.3F,
                19,
                false,
                MetalItemTags.METAL_TIN,
                MetalBlockTags.METAL_TIN,
                MetalFluidTags.MOLTEN_TIN)
        );

        cxt.register(BRONZE, Metal.of(
                0x754208,
                0x613E16,
                940.0F,
                8.0F,
                6.0F,
                110,
                false,
                MetalItemTags.ALLOY_BRONZE,
                MetalBlockTags.ALLOY_BRONZE,
                MetalFluidTags.MOLTEN_BRONZE)
        );
        cxt.register(STEEL, Metal.of(
                0x474542,
                0x706C66,
                1370.0F,
                7.5F,
                8.8F,
                130,
                false,
                MetalItemTags.ALLOY_STEEL,
                MetalBlockTags.ALLOY_STEEL,
                MetalFluidTags.MOLTEN_STEEL)
        );
    }

    private static ResourceKey<Metal> createVanilla(String name) {
        return ResourceKey.create(MetalcoreApiRegistries.METAL_KEY, new ResourceLocation(name));
    }

    private static ResourceKey<Metal> create(String name) {
        return createVanilla(Metalcore.MODID + ":" + name);
    }
}
