package io.kalishak.metalcore.api.datamaps;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;

import java.util.Optional;

public record WeatheringItemDataMap(Optional<ResourceKey<Item>> previousWeatheringItem, Optional<ResourceKey<Item>> nextWeatheringItem) {
    public static final Codec<WeatheringItemDataMap> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            ResourceKey.codec(Registries.ITEM).optionalFieldOf("previous_weathering_item").forGetter(WeatheringItemDataMap::previousWeatheringItem),
            ResourceKey.codec(Registries.ITEM).optionalFieldOf("next_weathering_item").forGetter(WeatheringItemDataMap::nextWeatheringItem)
    ).apply(instance, WeatheringItemDataMap::new));

    public static WeatheringItemDataMap of( ItemLike previousWeatheringItem, ItemLike nextWeatheringItem) {
        return new WeatheringItemDataMap(
                Optional.of(keyFromItem(previousWeatheringItem)),
                Optional.of(keyFromItem(nextWeatheringItem))
        );
    }

    public static WeatheringItemDataMap withPrevious( ItemLike previousWeatheringItem) {
        return new WeatheringItemDataMap(
                Optional.of(keyFromItem(previousWeatheringItem)),
                Optional.empty()
        );
    }

    public static WeatheringItemDataMap withNext( ItemLike nextWeatheringItem) {
        return new WeatheringItemDataMap(
                Optional.empty(),
                Optional.of(keyFromItem(nextWeatheringItem))
        );
    }

    private static ResourceKey<Item> keyFromItem( ItemLike item) {
        return ResourceKey.create(Registries.ITEM, BuiltInRegistries.ITEM.getKey(item.asItem()));
    }
}
