package io.kalishak.metalcore.data.placements;

import io.kalishak.metalcore.Metalcore;
import io.kalishak.metalcore.data.features.MetalcoreOreFeatures;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class MetalcoreOrePlacements {
    public static final ResourceKey<PlacedFeature> ORE_ALUMINUM_UPPER = createKey("ore_aluminum_upper");
    public static final ResourceKey<PlacedFeature> ORE_ALUMINUM_MIDDLE = createKey("ore_aluminum_middle");
    public static final ResourceKey<PlacedFeature> ORE_ALUMINUM_SMALL = createKey("ore_aluminum_small");
    public static final ResourceKey<PlacedFeature> ORE_LEAD = createKey("ore_lead");
    public static final ResourceKey<PlacedFeature> ORE_LEAD_SMALL = createKey("ore_lead_small");
    public static final ResourceKey<PlacedFeature> ORE_SILICON = createKey("ore_silicon");
    public static final ResourceKey<PlacedFeature> ORE_SILVER = createKey("ore_silver");
    public static final ResourceKey<PlacedFeature> END_ORE_SILVER = createKey("end_ore_silver");
    public static final ResourceKey<PlacedFeature> ORE_TIN = createKey("ore_tin");
    public static final ResourceKey<PlacedFeature> ORE_TIN_SMALL = createKey("ore_tin_small");

    public static void bootstrap(BootstrapContext<PlacedFeature> ctx) {
        var holderGetter = ctx.lookup(Registries.CONFIGURED_FEATURE);
        var aluminum = holderGetter.getOrThrow(MetalcoreOreFeatures.ORE_ALUMINUM);
        var aluminumSmall = holderGetter.getOrThrow(MetalcoreOreFeatures.ORE_ALUMINUM_SMALL);
        var lead = holderGetter.getOrThrow(MetalcoreOreFeatures.ORE_LEAD);
        var leadSmall = holderGetter.getOrThrow(MetalcoreOreFeatures.ORE_LEAD_SMALL);
        var silicon = holderGetter.getOrThrow(MetalcoreOreFeatures.ORE_SILICON);
        var silver = holderGetter.getOrThrow(MetalcoreOreFeatures.ORE_SILVER);
        var endSilver = holderGetter.getOrThrow(MetalcoreOreFeatures.END_ORE_SILVER);
        var tin = holderGetter.getOrThrow(MetalcoreOreFeatures.ORE_TIN);
        var tinSmall = holderGetter.getOrThrow(MetalcoreOreFeatures.ORE_ALUMINUM_SMALL);

        PlacementUtils.register(
                ctx,
                ORE_ALUMINUM_UPPER,
                aluminum,
                commonOrePlacement(60, HeightRangePlacement.triangle(VerticalAnchor.absolute(80), VerticalAnchor.absolute(384)))
        );
        PlacementUtils.register(
                ctx,
                ORE_ALUMINUM_MIDDLE,
                aluminum,
                commonOrePlacement(20, HeightRangePlacement.triangle(VerticalAnchor.absolute(-24), VerticalAnchor.absolute(56)))
        );
        PlacementUtils.register(
                ctx,
                ORE_ALUMINUM_SMALL,
                aluminumSmall,
                commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(72)))
        );
        PlacementUtils.register(
                ctx,
                ORE_LEAD,
                lead,
                commonOrePlacement(20, HeightRangePlacement.uniform(VerticalAnchor.absolute(50), VerticalAnchor.absolute(89)))
        );
        PlacementUtils.register(
                ctx,
                ORE_LEAD_SMALL,
                leadSmall,
                commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(33)))
        );
        PlacementUtils.register(
                ctx,
                ORE_SILICON,
                silicon,
                commonOrePlacement(40, HeightRangePlacement.triangle(VerticalAnchor.absolute(75), VerticalAnchor.absolute(384)))
        );
        PlacementUtils.register(
                ctx,
                ORE_SILVER,
                silver,
                commonOrePlacement(15, HeightRangePlacement.triangle(VerticalAnchor.absolute(-12), VerticalAnchor.absolute(60)))
        );
        PlacementUtils.register(
                ctx,
                END_ORE_SILVER,
                endSilver,
                commonOrePlacement(10, PlacementUtils.RANGE_4_4)
        );
        PlacementUtils.register(
                ctx,
                ORE_TIN,
                tin,
                commonOrePlacement(60, HeightRangePlacement.uniform(VerticalAnchor.absolute(80), VerticalAnchor.absolute(384)))
        );
        PlacementUtils.register(
                ctx,
                ORE_TIN_SMALL,
                tinSmall,
                commonOrePlacement(15, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(80)))
        );
    }

    private static ResourceKey<PlacedFeature> createKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Metalcore.MODID, name));
    }

    private static List<PlacementModifier> commonOrePlacement(int pCount, PlacementModifier pHeightRange) {
        return List.of(CountPlacement.of(pCount), InSquarePlacement.spread(), pHeightRange, BiomeFilter.biome());
    }
}
