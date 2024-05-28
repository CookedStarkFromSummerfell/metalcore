package io.kalishak.metalcore.data;

import io.kalishak.metalcore.api.datamaps.MetalcoreApiDatamaps;
import io.kalishak.metalcore.api.datamaps.ResourceKeyDataMap;
import io.kalishak.metalcore.api.datamaps.WeatheringCopperDataMap;
import io.kalishak.metalcore.api.datamaps.WeatheringItemDataMap;
import io.kalishak.metalcore.world.item.MetalcoreItems;
import io.kalishak.metalcore.world.level.block.MetalcoreBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.data.DataMapProvider;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class MetalcoreDataMapProvider extends DataMapProvider {
    public MetalcoreDataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void gather() {
        builder(MetalcoreApiDatamaps.WEATHERING_COPPER)
                .add(MetalcoreBlocks.COPPER_PIPE, WeatheringCopperDataMap.onlyNext(MetalcoreBlocks.EXPOSED_COPPER_PIPE), false)
                .add(MetalcoreBlocks.EXPOSED_COPPER_PIPE, WeatheringCopperDataMap.of(MetalcoreBlocks.COPPER_PIPE, MetalcoreBlocks.WEATHERED_COPPER_PIPE), false)
                .add(MetalcoreBlocks.WEATHERED_COPPER_PIPE, WeatheringCopperDataMap.of(MetalcoreBlocks.EXPOSED_COPPER_PIPE, MetalcoreBlocks.OXIDIZED_COPPER_PIPE), false)
                .add(MetalcoreBlocks.OXIDIZED_COPPER_PIPE, WeatheringCopperDataMap.onlyPrevious(MetalcoreBlocks.WEATHERED_COPPER_PIPE), false)

                .add(MetalcoreBlocks.COPPER_BELL, WeatheringCopperDataMap.onlyNext(MetalcoreBlocks.EXPOSED_COPPER_BELL), false)
                .add(MetalcoreBlocks.EXPOSED_COPPER_BELL, WeatheringCopperDataMap.of(MetalcoreBlocks.COPPER_BELL, MetalcoreBlocks.WEATHERED_COPPER_BELL), false)
                .add(MetalcoreBlocks.WEATHERED_COPPER_BELL, WeatheringCopperDataMap.of(MetalcoreBlocks.EXPOSED_COPPER_BELL, MetalcoreBlocks.OXIDIZED_COPPER_BELL), false)
                .add(MetalcoreBlocks.OXIDIZED_COPPER_BELL, WeatheringCopperDataMap.onlyPrevious(MetalcoreBlocks.WEATHERED_COPPER_BELL), false)

                .add(MetalcoreBlocks.COPPER_FAN, WeatheringCopperDataMap.onlyNext(MetalcoreBlocks.EXPOSED_COPPER_FAN), false)
                .add(MetalcoreBlocks.EXPOSED_COPPER_FAN, WeatheringCopperDataMap.of(MetalcoreBlocks.COPPER_FAN, MetalcoreBlocks.WEATHERED_COPPER_FAN), false)
                .add(MetalcoreBlocks.WEATHERED_COPPER_FAN, WeatheringCopperDataMap.of(MetalcoreBlocks.EXPOSED_COPPER_FAN, MetalcoreBlocks.OXIDIZED_COPPER_FAN), false)
                .add(MetalcoreBlocks.OXIDIZED_COPPER_FAN, WeatheringCopperDataMap.onlyPrevious(MetalcoreBlocks.WEATHERED_COPPER_FAN), false)

                .add(MetalcoreBlocks.COPPER_SPIKES, WeatheringCopperDataMap.onlyNext(MetalcoreBlocks.EXPOSED_COPPER_SPIKES), false)
                .add(MetalcoreBlocks.EXPOSED_COPPER_SPIKES, WeatheringCopperDataMap.of(MetalcoreBlocks.COPPER_SPIKES, MetalcoreBlocks.WEATHERED_COPPER_SPIKES), false)
                .add(MetalcoreBlocks.WEATHERED_COPPER_SPIKES, WeatheringCopperDataMap.of(MetalcoreBlocks.EXPOSED_COPPER_SPIKES, MetalcoreBlocks.OXIDIZED_COPPER_SPIKES), false)
                .add(MetalcoreBlocks.OXIDIZED_COPPER_SPIKES, WeatheringCopperDataMap.onlyPrevious(MetalcoreBlocks.WEATHERED_COPPER_SPIKES), false);

        builder(MetalcoreApiDatamaps.WAXABLES)
                .add(MetalcoreBlocks.COPPER_PIPE, ResourceKeyDataMap.of(MetalcoreBlocks.WAXED_COPPER_PIPE), false)
                .add(MetalcoreBlocks.EXPOSED_COPPER_PIPE, ResourceKeyDataMap.of(MetalcoreBlocks.WAXED_EXPOSED_COPPER_PIPE), false)
                .add(MetalcoreBlocks.WEATHERED_COPPER_PIPE, ResourceKeyDataMap.of(MetalcoreBlocks.WAXED_WEATHERED_COPPER_PIPE), false)
                .add(MetalcoreBlocks.OXIDIZED_COPPER_PIPE, ResourceKeyDataMap.of(MetalcoreBlocks.WAXED_OXIDIZED_COPPER_PIPE), false)

                .add(MetalcoreBlocks.COPPER_BELL, ResourceKeyDataMap.of(MetalcoreBlocks.WAXED_COPPER_BELL), false)
                .add(MetalcoreBlocks.EXPOSED_COPPER_BELL, ResourceKeyDataMap.of(MetalcoreBlocks.WAXED_EXPOSED_COPPER_BELL), false)
                .add(MetalcoreBlocks.WEATHERED_COPPER_BELL, ResourceKeyDataMap.of(MetalcoreBlocks.WAXED_WEATHERED_COPPER_BELL), false)
                .add(MetalcoreBlocks.OXIDIZED_COPPER_BELL, ResourceKeyDataMap.of(MetalcoreBlocks.WAXED_OXIDIZED_COPPER_BELL), false)

                .add(MetalcoreBlocks.COPPER_SPIKES, ResourceKeyDataMap.of(MetalcoreBlocks.WAXED_COPPER_SPIKES), false)
                .add(MetalcoreBlocks.EXPOSED_COPPER_SPIKES, ResourceKeyDataMap.of(MetalcoreBlocks.WAXED_EXPOSED_COPPER_SPIKES), false)
                .add(MetalcoreBlocks.WEATHERED_COPPER_SPIKES, ResourceKeyDataMap.of(MetalcoreBlocks.WAXED_WEATHERED_COPPER_SPIKES), false)
                .add(MetalcoreBlocks.OXIDIZED_COPPER_SPIKES, ResourceKeyDataMap.of(MetalcoreBlocks.WAXED_OXIDIZED_COPPER_SPIKES), false)

                .add(MetalcoreBlocks.COPPER_FAN, ResourceKeyDataMap.of(MetalcoreBlocks.WAXED_COPPER_FAN), false)
                .add(MetalcoreBlocks.EXPOSED_COPPER_FAN, ResourceKeyDataMap.of(MetalcoreBlocks.WAXED_EXPOSED_COPPER_FAN), false)
                .add(MetalcoreBlocks.WEATHERED_COPPER_FAN, ResourceKeyDataMap.of(MetalcoreBlocks.WAXED_WEATHERED_COPPER_FAN), false)
                .add(MetalcoreBlocks.OXIDIZED_COPPER_FAN, ResourceKeyDataMap.of(MetalcoreBlocks.WAXED_OXIDIZED_COPPER_FAN), false);

        builder(MetalcoreApiDatamaps.UNWAXED)
                .add(MetalcoreBlocks.WAXED_COPPER_PIPE, ResourceKeyDataMap.of(MetalcoreBlocks.COPPER_PIPE), false)
                .add(MetalcoreBlocks.WAXED_EXPOSED_COPPER_PIPE, ResourceKeyDataMap.of(MetalcoreBlocks.EXPOSED_COPPER_PIPE), false)
                .add(MetalcoreBlocks.WAXED_WEATHERED_COPPER_PIPE, ResourceKeyDataMap.of(MetalcoreBlocks.WEATHERED_COPPER_PIPE), false)
                .add(MetalcoreBlocks.WAXED_OXIDIZED_COPPER_PIPE, ResourceKeyDataMap.of(MetalcoreBlocks.OXIDIZED_COPPER_PIPE), false)

                .add(MetalcoreBlocks.WAXED_COPPER_BELL, ResourceKeyDataMap.of(MetalcoreBlocks.COPPER_BELL), false)
                .add(MetalcoreBlocks.WAXED_EXPOSED_COPPER_BELL, ResourceKeyDataMap.of(MetalcoreBlocks.EXPOSED_COPPER_BELL), false)
                .add(MetalcoreBlocks.WAXED_WEATHERED_COPPER_BELL, ResourceKeyDataMap.of(MetalcoreBlocks.WEATHERED_COPPER_BELL), false)
                .add(MetalcoreBlocks.WAXED_OXIDIZED_COPPER_BELL, ResourceKeyDataMap.of(MetalcoreBlocks.OXIDIZED_COPPER_BELL), false)

                .add(MetalcoreBlocks.WAXED_COPPER_SPIKES, ResourceKeyDataMap.of(MetalcoreBlocks.COPPER_SPIKES), false)
                .add(MetalcoreBlocks.WAXED_EXPOSED_COPPER_SPIKES, ResourceKeyDataMap.of(MetalcoreBlocks.EXPOSED_COPPER_SPIKES), false)
                .add(MetalcoreBlocks.WAXED_WEATHERED_COPPER_SPIKES, ResourceKeyDataMap.of(MetalcoreBlocks.WEATHERED_COPPER_SPIKES), false)
                .add(MetalcoreBlocks.WAXED_OXIDIZED_COPPER_SPIKES, ResourceKeyDataMap.of(MetalcoreBlocks.OXIDIZED_COPPER_SPIKES), false)

                .add(MetalcoreBlocks.WAXED_COPPER_FAN, ResourceKeyDataMap.of(MetalcoreBlocks.COPPER_FAN), false)
                .add(MetalcoreBlocks.WAXED_EXPOSED_COPPER_FAN, ResourceKeyDataMap.of(MetalcoreBlocks.EXPOSED_COPPER_FAN), false)
                .add(MetalcoreBlocks.WAXED_WEATHERED_COPPER_FAN, ResourceKeyDataMap.of(MetalcoreBlocks.WEATHERED_COPPER_FAN), false)
                .add(MetalcoreBlocks.WAXED_OXIDIZED_COPPER_FAN, ResourceKeyDataMap.of(MetalcoreBlocks.OXIDIZED_COPPER_FAN), false);

        builder(MetalcoreApiDatamaps.WEATHERING_ITEM)
                .add(getId(Items.COPPER_INGOT), WeatheringItemDataMap.withNext(MetalcoreItems.EXPOSED_COPPER_INGOT), false)
                .add(MetalcoreItems.EXPOSED_COPPER_INGOT, WeatheringItemDataMap.of(Items.COPPER_INGOT, MetalcoreItems.WEATHERED_COPPER_INGOT), false)
                .add(MetalcoreItems.WEATHERED_COPPER_INGOT, WeatheringItemDataMap.of(MetalcoreItems.EXPOSED_COPPER_INGOT, MetalcoreItems.OXIDIZED_COPPER_INGOT), false)
                .add(MetalcoreItems.OXIDIZED_COPPER_INGOT, WeatheringItemDataMap.withPrevious(MetalcoreItems.WEATHERED_COPPER_INGOT), false);
    }

    private ResourceLocation getId(@NotNull Item item) {
        return BuiltInRegistries.ITEM.getKey(item);
    }
}
