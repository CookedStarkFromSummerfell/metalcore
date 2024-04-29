package io.kalishak.metalcore.data.tags;

import net.minecraft.data.DataProvider;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.function.BiConsumer;

public interface MetalTagsProvider {
    static void init(GatherDataEvent event, String modId, BiConsumer<Boolean, DataProvider> consumer) {
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
