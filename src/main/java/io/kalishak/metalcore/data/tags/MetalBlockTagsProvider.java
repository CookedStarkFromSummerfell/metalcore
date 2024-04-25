package io.kalishak.metalcore.data.tags;

import io.kalishak.metalcore.tags.MetalBlockTags;
import io.kalishak.metalcore.world.level.block.MetalcoreBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
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
        addNeoForgeTags(pProvider);

        tag(MetalBlockTags.ALUMINUM_ORES)
                .add(MetalcoreBlocks.ALUMINUM_ORE.get())
                .add(MetalcoreBlocks.DEEPSLATE_ALUMINUM_ORE.get());
        tag(MetalBlockTags.STORAGE_BLOCKS_ALUMINUM)
                .add(MetalcoreBlocks.ALUMINUM_BLOCK.get());
        tag(MetalBlockTags.STORAGE_BLOCKS_RAW_ALUMINUM)
                .add(MetalcoreBlocks.RAW_ALUMINUM_BLOCK.get());
    }

    private void addNeoForgeTags(HolderLookup.Provider pProvider) {
        tag(Tags.Blocks.ORES)
                .addTag(MetalBlockTags.ALUMINUM_ORES)
                .addTag(MetalBlockTags.TIN_ORES)
                .addTag(MetalBlockTags.SILVER_ORES)
                .addTag(MetalBlockTags.LEAD_ORES);

        tag(Tags.Blocks.STORAGE_BLOCKS)
                .addTag(MetalBlockTags.STORAGE_BLOCKS_ALUMINUM)
                .addTag(MetalBlockTags.STORAGE_BLOCKS_RAW_ALUMINUM)
                .addTag(MetalBlockTags.STORAGE_BLOCKS_TIN)
                .addTag(MetalBlockTags.STORAGE_BLOCKS_RAW_TIN)
                .addTag(MetalBlockTags.STORAGE_BLOCKS_LEAD)
                .addTag(MetalBlockTags.STORAGE_BLOCKS_RAW_LEAD)
                .addTag(MetalBlockTags.STORAGE_BLOCKS_SILVER)
                .addTag(MetalBlockTags.STORAGE_BLOCKS_RAW_SILVER);

        tag(Tags.Blocks.ORES_IN_GROUND_DEEPSLATE)
                .add(MetalcoreBlocks.DEEPSLATE_ALUMINUM_ORE.get());

        tag(Tags.Blocks.ORES_IN_GROUND_STONE)
                .add(MetalcoreBlocks.ALUMINUM_ORE.get());

        tag(Tags.Blocks.ORE_RATES_DENSE)
                .add(MetalcoreBlocks.ALUMINUM_ORE.get());

        tag(Tags.Blocks.ORE_RATES_SINGULAR)
                .add(MetalcoreBlocks.DEEPSLATE_ALUMINUM_ORE.get());
    }
}
