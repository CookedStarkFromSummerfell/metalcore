package io.kalishak.metalcore.data.tags;

import io.kalishak.metalcore.tags.MetalBlockTags;
import io.kalishak.metalcore.world.level.block.MetalcoreBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class MetalBlockTagsProvider extends BlockTagsProvider {
    MetalBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, modId, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        addVanillaTags();
        addNeoForgeTags();

        tag(MetalBlockTags.ALUMINUM_ORES)
                .add(MetalcoreBlocks.ALUMINUM_ORE.get())
                .add(MetalcoreBlocks.DEEPSLATE_ALUMINUM_ORE.get());
        tag(MetalBlockTags.LEAD_ORES)
                .add(MetalcoreBlocks.LEAD_ORE.get())
                .add(MetalcoreBlocks.DEEPSLATE_LEAD_ORE.get());
        tag(MetalBlockTags.SILICON_ORES)
                .add(MetalcoreBlocks.SILICON_ORE.get())
                .add(MetalcoreBlocks.DEEPSLATE_SILICON_ORE.get());
        tag(MetalBlockTags.SILVER_ORES)
                .add(MetalcoreBlocks.SILVER_ORE.get())
                .add(MetalcoreBlocks.DEEPSLATE_SILVER_ORE.get())
                .add(MetalcoreBlocks.END_SILVER_ORE.get());
        tag(MetalBlockTags.TIN_ORES)
                .add(MetalcoreBlocks.TIN_ORE.get())
                .add(MetalcoreBlocks.DEEPSLATE_TIN_ORE.get());

        tag(MetalBlockTags.STORAGE_BLOCKS_ALUMINUM)
                .add(MetalcoreBlocks.ALUMINUM_BLOCK.get());
        tag(MetalBlockTags.STORAGE_BLOCKS_LEAD)
                .add(MetalcoreBlocks.LEAD_BLOCK.get());
        tag(MetalBlockTags.STORAGE_BLOCKS_SILVER)
                .add(MetalcoreBlocks.SILVER_BLOCK.get());
        tag(MetalBlockTags.STORAGE_BLOCKS_TIN)
                .add(MetalcoreBlocks.TIN_BLOCK.get());

        tag(MetalBlockTags.STORAGE_BLOCKS_RAW_ALUMINUM)
                .add(MetalcoreBlocks.RAW_ALUMINUM_BLOCK.get());
        tag(MetalBlockTags.STORAGE_BLOCKS_RAW_LEAD)
                .add(MetalcoreBlocks.RAW_LEAD_BLOCK.get());
        tag(MetalBlockTags.STORAGE_BLOCKS_RAW_SILICON)
                .add(MetalcoreBlocks.RAW_SILICON_BLOCK.get());
        tag(MetalBlockTags.STORAGE_BLOCKS_RAW_SILVER)
                .add(MetalcoreBlocks.RAW_SILVER_BLOCK.get());
        tag(MetalBlockTags.STORAGE_BLOCKS_RAW_TIN)
                .add(MetalcoreBlocks.RAW_TIN_BLOCK.get());

        tag(MetalBlockTags.METALS)
                .addTag(MetalBlockTags.METAL_ALUMINUM)
                //.addTag(MetalBlockTags.METAL_BRONZE)
                .addTag(MetalBlockTags.METAL_COPPER)
                .addTag(MetalBlockTags.METAL_GOLD)
                .addTag(MetalBlockTags.METAL_IRON)
                .addTag(MetalBlockTags.METAL_LEAD)
                .addTag(MetalBlockTags.METAL_NETHERITE)
                .addTag(MetalBlockTags.METAL_SILVER)
                //.addTag(MetalBlockTags.METAL_STEEL)
                .addTag(MetalBlockTags.METAL_TIN);

        tag(MetalBlockTags.METAL_ALUMINUM)
                .add(MetalcoreBlocks.ALUMINUM_ORE.get())
                .add(MetalcoreBlocks.DEEPSLATE_ALUMINUM_ORE.get())
                .add(MetalcoreBlocks.ALUMINUM_BLOCK.get())
                .add(MetalcoreBlocks.RAW_ALUMINUM_BLOCK.get());
        tag(MetalBlockTags.METAL_COPPER)
                .add(Blocks.COPPER_ORE)
                .add(Blocks.DEEPSLATE_COPPER_ORE)
                .add(Blocks.COPPER_BLOCK)
                .add(Blocks.RAW_COPPER_BLOCK);
        tag(MetalBlockTags.METAL_GOLD)
                .add(Blocks.GOLD_ORE)
                .add(Blocks.DEEPSLATE_GOLD_ORE)
                .add(Blocks.NETHER_GOLD_ORE)
                .add(Blocks.GOLD_BLOCK)
                .add(Blocks.RAW_GOLD_BLOCK);
        tag(MetalBlockTags.METAL_IRON)
                .add(Blocks.IRON_ORE)
                .add(Blocks.DEEPSLATE_IRON_ORE)
                .add(Blocks.IRON_BLOCK)
                .add(Blocks.RAW_IRON_BLOCK);
        tag(MetalBlockTags.METAL_LEAD)
                .add(MetalcoreBlocks.LEAD_ORE.get())
                .add(MetalcoreBlocks.DEEPSLATE_LEAD_ORE.get())
                .add(MetalcoreBlocks.LEAD_BLOCK.get())
                .add(MetalcoreBlocks.RAW_LEAD_BLOCK.get());
        tag(MetalBlockTags.METAL_NETHERITE)
                .add(Blocks.ANCIENT_DEBRIS)
                .add(Blocks.NETHERITE_BLOCK);
        //.add(MetalcoreItems.NETHERITE_DUST.get());
        tag(MetalBlockTags.METAL_SILVER)
                .add(MetalcoreBlocks.SILVER_ORE.get())
                .add(MetalcoreBlocks.DEEPSLATE_SILVER_ORE.get())
                .add(MetalcoreBlocks.SILVER_BLOCK.get())
                .add(MetalcoreBlocks.RAW_SILVER_BLOCK.get());
        tag(MetalBlockTags.METAL_TIN)
                .add(MetalcoreBlocks.TIN_ORE.get())
                .add(MetalcoreBlocks.DEEPSLATE_TIN_ORE.get())
                .add(MetalcoreBlocks.TIN_BLOCK.get())
                .add(MetalcoreBlocks.RAW_TIN_BLOCK.get());
    }

    private void addVanillaTags() {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(MetalcoreBlocks.ALUMINUM_ORE.get())
                .add(MetalcoreBlocks.DEEPSLATE_ALUMINUM_ORE.get())
                .add(MetalcoreBlocks.LEAD_ORE.get())
                .add(MetalcoreBlocks.DEEPSLATE_LEAD_ORE.get())
                .add(MetalcoreBlocks.SILICON_ORE.get())
                .add(MetalcoreBlocks.DEEPSLATE_SILICON_ORE.get())
                .add(MetalcoreBlocks.SILVER_ORE.get())
                .add(MetalcoreBlocks.DEEPSLATE_SILVER_ORE.get())
                .add(MetalcoreBlocks.END_SILVER_ORE.get())
                .add(MetalcoreBlocks.TIN_ORE.get())
                .add(MetalcoreBlocks.DEEPSLATE_TIN_ORE.get())
                .add(MetalcoreBlocks.RAW_ALUMINUM_BLOCK.get())
                .add(MetalcoreBlocks.ALUMINUM_BLOCK.get())
                .add(MetalcoreBlocks.RAW_LEAD_BLOCK.get())
                .add(MetalcoreBlocks.LEAD_BLOCK.get())
                .add(MetalcoreBlocks.RAW_WAXED_LEAD_BLOCK.get())
                .add(MetalcoreBlocks.WAXED_LEAD_BLOCK.get())
                .add(MetalcoreBlocks.RAW_SILICON_BLOCK.get())
                .add(MetalcoreBlocks.RAW_SILVER_BLOCK.get())
                .add(MetalcoreBlocks.SILVER_BLOCK.get())
                .add(MetalcoreBlocks.RAW_TIN_BLOCK.get())
                .add(MetalcoreBlocks.TIN_BLOCK.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
            .add(MetalcoreBlocks.SILICON_ORE.get())
                .add(MetalcoreBlocks.ALUMINUM_ORE.get())
                .add(MetalcoreBlocks.DEEPSLATE_ALUMINUM_ORE.get())
                .add(MetalcoreBlocks.DEEPSLATE_SILICON_ORE.get())
                .add(MetalcoreBlocks.SILVER_ORE.get())
                .add(MetalcoreBlocks.DEEPSLATE_SILVER_ORE.get())
                .add(MetalcoreBlocks.END_SILVER_ORE.get())
                .add(MetalcoreBlocks.RAW_ALUMINUM_BLOCK.get())
                .add(MetalcoreBlocks.ALUMINUM_BLOCK.get())
                .add(MetalcoreBlocks.RAW_SILICON_BLOCK.get())
                .add(MetalcoreBlocks.RAW_SILVER_BLOCK.get())
                .add(MetalcoreBlocks.SILVER_BLOCK.get());

        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(MetalcoreBlocks.LEAD_ORE.get())
                .add(MetalcoreBlocks.DEEPSLATE_LEAD_ORE.get())
                .add(MetalcoreBlocks.TIN_ORE.get())
                .add(MetalcoreBlocks.DEEPSLATE_TIN_ORE.get())
                .add(MetalcoreBlocks.RAW_LEAD_BLOCK.get())
                .add(MetalcoreBlocks.LEAD_BLOCK.get())
                .add(MetalcoreBlocks.RAW_WAXED_LEAD_BLOCK.get())
                .add(MetalcoreBlocks.WAXED_LEAD_BLOCK.get())
                .add(MetalcoreBlocks.RAW_TIN_BLOCK.get())
                .add(MetalcoreBlocks.TIN_BLOCK.get());
    }

    private void addNeoForgeTags() {
        tag(Tags.Blocks.ORES)
                .addTag(MetalBlockTags.ALUMINUM_ORES)
                .addTag(MetalBlockTags.LEAD_ORES)
                .addTag(MetalBlockTags.SILICON_ORES)
                .addTag(MetalBlockTags.SILVER_ORES)
                .addTag(MetalBlockTags.TIN_ORES);

        tag(Tags.Blocks.STORAGE_BLOCKS)
                .addTag(MetalBlockTags.STORAGE_BLOCKS_ALUMINUM)
                .addTag(MetalBlockTags.STORAGE_BLOCKS_RAW_ALUMINUM)
                .addTag(MetalBlockTags.STORAGE_BLOCKS_LEAD)
                .addTag(MetalBlockTags.STORAGE_BLOCKS_RAW_LEAD)
                .addTag(MetalBlockTags.STORAGE_BLOCKS_SILVER)
                .addTag(MetalBlockTags.STORAGE_BLOCKS_RAW_SILVER)
                .addTag(MetalBlockTags.STORAGE_BLOCKS_RAW_SILICON)
                .addTag(MetalBlockTags.STORAGE_BLOCKS_TIN)
                .addTag(MetalBlockTags.STORAGE_BLOCKS_RAW_TIN);

        tag(Tags.Blocks.ORES_IN_GROUND_DEEPSLATE)
                .add(MetalcoreBlocks.DEEPSLATE_ALUMINUM_ORE.get())
                .add(MetalcoreBlocks.DEEPSLATE_LEAD_ORE.get())
                .add(MetalcoreBlocks.DEEPSLATE_SILICON_ORE.get())
                .add(MetalcoreBlocks.DEEPSLATE_SILVER_ORE.get())
                .add(MetalcoreBlocks.DEEPSLATE_TIN_ORE.get());

        tag(Tags.Blocks.ORES_IN_GROUND_STONE)
                .add(MetalcoreBlocks.ALUMINUM_ORE.get())
                .add(MetalcoreBlocks.LEAD_ORE.get())
                .add(MetalcoreBlocks.SILICON_ORE.get())
                .add(MetalcoreBlocks.SILVER_ORE.get())
                .add(MetalcoreBlocks.TIN_ORE.get());

        tag(Tags.Blocks.ORE_RATES_DENSE)
                .add(MetalcoreBlocks.ALUMINUM_ORE.get())
                .add(MetalcoreBlocks.LEAD_ORE.get())
                .add(MetalcoreBlocks.TIN_ORE.get());

        tag(Tags.Blocks.ORE_RATES_SPARSE)
                .add(MetalcoreBlocks.SILVER_ORE.get());

        tag(Tags.Blocks.ORE_RATES_SINGULAR)
                .add(MetalcoreBlocks.DEEPSLATE_ALUMINUM_ORE.get())
                .add(MetalcoreBlocks.DEEPSLATE_LEAD_ORE.get())
                .add(MetalcoreBlocks.DEEPSLATE_SILICON_ORE.get())
                .add(MetalcoreBlocks.DEEPSLATE_SILVER_ORE.get())
                .add(MetalcoreBlocks.DEEPSLATE_TIN_ORE.get())
                .add(MetalcoreBlocks.SILICON_ORE.get());
    }
}
