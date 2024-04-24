package io.kalishak.metalcore.data.tags;

import io.kalishak.metalcore.tags.MetalItemTags;
import io.kalishak.metalcore.world.item.MetalcoreItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class MetalItemTagsProvider extends ItemTagsProvider {
    MetalItemTagsProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries, CompletableFuture<TagLookup<Block>> blockTags, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, registries, blockTags, modId, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        addNeoForgeTags(pProvider);

        tag(MetalItemTags.ALUMINUM_ORES)
                .add(MetalcoreItems.ALUMINUM_ORE.get())
                .add(MetalcoreItems.DEEPSLATE_ALUMINUM_ORE.get());

        tag(MetalItemTags.STORAGE_BLOCKS_ALUMINUM)
                .add(MetalcoreItems.ALUMINUM_BLOCK.get());

        tag(MetalItemTags.RAW_BLOCKS_ALUMINUM)
                .add(MetalcoreItems.RAW_ALUMINUM_BLOCK.get());
    }

    private void addNeoForgeTags(HolderLookup.Provider pProvider) {
        tag(Tags.Items.ORES)
                .addTag(MetalItemTags.ALUMINUM_ORES)
                .addTag(MetalItemTags.TIN_ORES)
                .addTag(MetalItemTags.LEAD_ORES)
                .addTag(MetalItemTags.SILVER_ORES);

        tag(Tags.Items.RAW_BLOCKS)
                .addTag(MetalItemTags.RAW_BLOCKS_ALUMINUM)
                .addTag(MetalItemTags.RAW_BLOCKS_TIN)
                .addTag(MetalItemTags.RAW_BLOCKS_LEAD)
                .addTag(MetalItemTags.RAW_BLOCKS_SILVER);

        tag(Tags.Items.RAW_MATERIALS)
                .addTag(MetalItemTags.RAW_MATERIALS_ALUMINUM)
                .addTag(MetalItemTags.RAW_MATERIALS_TIN)
                .addTag(MetalItemTags.RAW_MATERIALS_LEAD)
                .addTag(MetalItemTags.RAW_MATERIALS_SILVER);
    }
}
