package io.kalishak.metalcore.api.datamaps;

import com.mojang.serialization.Codec;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.datamaps.DataMapType;

public class MetalcoreApiDatamaps {
    private static final Codec<ResourceKeyDataMap<Block>> WAXED_CODEC = ResourceKeyDataMap.codec(Registries.BLOCK, "waxed");
    private static final Codec<ResourceKeyDataMap<Block>> UNWAXED_CODEC = ResourceKeyDataMap.codec(Registries.BLOCK, "unwaxed");
    private static final Codec<ResourceKeyDataMap<Block>> STRIPPED_CODEC = ResourceKeyDataMap.codec(Registries.BLOCK, "stripped");
    private static final Codec<ResourceKeyDataMap<Block>> UNSTRIPPED_CODEC = ResourceKeyDataMap.codec(Registries.BLOCK, "unstripped");

    public static final DataMapType<Item, WeatheringItemDataMap> WEATHERING_ITEM = DataMapType
            .builder(new ResourceLocation("c:weathering_item"), Registries.ITEM, WeatheringItemDataMap.CODEC)
            .synced(WeatheringItemDataMap.CODEC, true)
            .build();

    public static final DataMapType<Block, WeatheringCopperDataMap> WEATHERING_COPPER = DataMapType
            .builder(new ResourceLocation("c:weathering_copper"), Registries.BLOCK, WeatheringCopperDataMap.CODEC)
            .synced(WeatheringCopperDataMap.CODEC, true)
            .build();
    public static final DataMapType<Block, ResourceKeyDataMap<Block>> WAXABLES = DataMapType
            .builder(new ResourceLocation("c:waxed"), Registries.BLOCK, WAXED_CODEC)
            .synced(WAXED_CODEC, true)
            .build();
    public static final DataMapType<Block, ResourceKeyDataMap<Block>> UNWAXED = DataMapType
            .builder(new ResourceLocation("c:unwaxed"), Registries.BLOCK, UNWAXED_CODEC)
            .synced(UNWAXED_CODEC, true)
            .build();
    public static final DataMapType<Block, ResourceKeyDataMap<Block>> STRIPPABLE = DataMapType
            .builder(new ResourceLocation("c:stripped"), Registries.BLOCK, STRIPPED_CODEC)
            .synced(STRIPPED_CODEC, true)
            .build();
    public static final DataMapType<Block, ResourceKeyDataMap<Block>> UNSTRIPPED = DataMapType
            .builder(new ResourceLocation("c:unstripped"), Registries.BLOCK, UNSTRIPPED_CODEC)
            .synced(UNSTRIPPED_CODEC, true)
            .build();
}
