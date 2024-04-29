package io.kalishak.metalcore.data.features;

import io.kalishak.metalcore.Metalcore;
import io.kalishak.metalcore.world.level.block.MetalcoreBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class MetalcoreOreFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_ALUMINUM = createKey("ore_aluminum");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_ALUMINUM_SMALL = createKey("ore_aluminum_small");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_LEAD = createKey("ore_lead");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_LEAD_SMALL = createKey("ore_lead_small");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_SILICON = createKey("ore_silicon");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_SILVER = createKey("ore_silver");
    public static final ResourceKey<ConfiguredFeature<?, ?>> END_ORE_SILVER = createKey("end_ore_silver");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_TIN = createKey("ore_tin");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_TIN_SMALL = createKey("ore_tin_small");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> ctx) {
        RuleTest isStone = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest isDeepslate = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest isEndstone = new BlockMatchTest(Blocks.END_STONE);

        List<OreConfiguration.TargetBlockState> aluminum = List.of(
                OreConfiguration.target(isStone, MetalcoreBlocks.ALUMINUM_ORE.get().defaultBlockState()),
                OreConfiguration.target(isDeepslate, MetalcoreBlocks.DEEPSLATE_ALUMINUM_ORE.get().defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> lead = List.of(
                OreConfiguration.target(isStone, MetalcoreBlocks.LEAD_ORE.get().defaultBlockState()),
                OreConfiguration.target(isDeepslate, MetalcoreBlocks.DEEPSLATE_LEAD_ORE.get().defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> silicon = List.of(
                OreConfiguration.target(isStone, MetalcoreBlocks.SILICON_ORE.get().defaultBlockState()),
                OreConfiguration.target(isDeepslate, MetalcoreBlocks.DEEPSLATE_SILICON_ORE.get().defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> silver = List.of(
                OreConfiguration.target(isStone, MetalcoreBlocks.SILVER_ORE.get().defaultBlockState()),
                OreConfiguration.target(isDeepslate, MetalcoreBlocks.DEEPSLATE_SILVER_ORE.get().defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> tin = List.of(
                OreConfiguration.target(isStone, MetalcoreBlocks.TIN_ORE.get().defaultBlockState()),
                OreConfiguration.target(isDeepslate, MetalcoreBlocks.DEEPSLATE_TIN_ORE.get().defaultBlockState())
        );

        FeatureUtils.register(ctx, ORE_ALUMINUM, Feature.ORE, new OreConfiguration(aluminum, 6));
        FeatureUtils.register(ctx, ORE_ALUMINUM_SMALL, Feature.ORE, new OreConfiguration(aluminum, 3));
        FeatureUtils.register(ctx, ORE_LEAD, Feature.ORE, new OreConfiguration(lead, 4));
        FeatureUtils.register(ctx, ORE_LEAD_SMALL, Feature.ORE, new OreConfiguration(lead, 2));
        FeatureUtils.register(ctx, ORE_SILICON, Feature.ORE, new OreConfiguration(silicon, 4));
        FeatureUtils.register(ctx, ORE_SILVER, Feature.ORE, new OreConfiguration(silver, 2));
        FeatureUtils.register(ctx, END_ORE_SILVER, Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(isEndstone, MetalcoreBlocks.END_SILVER_ORE.get().defaultBlockState())), 1));
        FeatureUtils.register(ctx, ORE_TIN, Feature.ORE, new OreConfiguration(tin, 8));
        FeatureUtils.register(ctx, ORE_TIN_SMALL, Feature.ORE, new OreConfiguration(tin, 4));
    }

    static ResourceKey<ConfiguredFeature<?, ?>> createKey(String pName) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(Metalcore.MODID, pName));
    }
}
