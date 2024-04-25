package io.kalishak.metalcore.data;

import io.kalishak.metalcore.Metalcore;
import io.kalishak.metalcore.data.client.MetalBlockStatesProvider;
import io.kalishak.metalcore.data.client.MetalItemModelsProvider;
import io.kalishak.metalcore.data.client.MetalLanguageProvider;
import io.kalishak.metalcore.data.tags.MetalTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MetalcoreDataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator dataGenerator = event.getGenerator();
        PackOutput packOutput = dataGenerator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> registries = event.getLookupProvider();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();

        MetalTagsProvider.init(event, Metalcore.MODID, dataGenerator::addProvider);
        dataGenerator.addProvider(event.includeServer(), new LootTableProvider(packOutput, BuiltInLootTables.all(), List.of(new LootTableProvider.SubProviderEntry(MetalcoreBlockLoot::new, LootContextParamSets.BLOCK)), registries));

        dataGenerator.addProvider(event.includeClient(), new MetalLanguageProvider(packOutput, Metalcore.MODID, "en_us"));
        dataGenerator.addProvider(event.includeClient(), new MetalBlockStatesProvider(packOutput, Metalcore.MODID, fileHelper));
        dataGenerator.addProvider(event.includeClient(), new MetalItemModelsProvider(packOutput, Metalcore.MODID, fileHelper));
    }
}
