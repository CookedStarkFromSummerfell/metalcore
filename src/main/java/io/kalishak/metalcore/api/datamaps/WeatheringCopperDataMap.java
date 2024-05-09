package io.kalishak.metalcore.api.datamaps;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;

import java.util.Optional;

public record WeatheringCopperDataMap(Optional<ResourceKey<Block>> previousWeatheringBlock, Optional<ResourceKey<Block>> nextWeatheringBlock) {
    public static final Codec<WeatheringCopperDataMap> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            ResourceKey.codec(Registries.BLOCK).optionalFieldOf("previous_weathering_block").forGetter(WeatheringCopperDataMap::previousWeatheringBlock),
            ResourceKey.codec(Registries.BLOCK).optionalFieldOf("next_weathering_block").forGetter(WeatheringCopperDataMap::nextWeatheringBlock)
    ).apply(instance, WeatheringCopperDataMap::new));

    public static WeatheringCopperDataMap of(Holder<Block> previousWeatheringBlock, Holder<Block> nextWeatheringBlock) {
        return new WeatheringCopperDataMap(
                previousWeatheringBlock.unwrapKey(),
                nextWeatheringBlock.unwrapKey()
        );
    }

    public static WeatheringCopperDataMap onlyPrevious(Holder<Block> previousWeatheringBlock) {
        return new WeatheringCopperDataMap(
                previousWeatheringBlock.unwrapKey(),
                Optional.empty()
        );
    }

    public static WeatheringCopperDataMap onlyNext(Holder<Block> nextWeatheringBlock) {
        return new WeatheringCopperDataMap(
                Optional.empty(),
                nextWeatheringBlock.unwrapKey()
        );
    }
}
