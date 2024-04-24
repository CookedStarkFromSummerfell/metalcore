package io.kalishak.metalcore.data.tags;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class MetalTagsProvider {
    public static  void init(GatherDataEvent event, String modId, BiConsumer<Boolean, DataProvider> consumer) {
        BlockTagsProvider blockTagsProvider = new MetalBlockTagsProvider(
                event.getGenerator().getPackOutput(),
                event.getLookupProvider(),
                modId,
                event.getExistingFileHelper());
        consumer.accept(event.includeServer(), blockTagsProvider);
        consumer.accept(event.includeServer(), new MetalItemTagsProvider(
                event.getGenerator().getPackOutput(),
                event.getLookupProvider(),
                blockTagsProvider.contentsGetter(),
                modId,
                event.getExistingFileHelper()));
        consumer.accept(event.includeServer(), new MetalFluidTagsProvider(
                event.getGenerator().getPackOutput(),
                event.getLookupProvider(),
                modId,
                event.getExistingFileHelper()));
    }
}
