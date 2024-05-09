package io.kalishak.metalcore.api.datamaps;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;

public record ResourceKeyDataMap<T>(ResourceKey<T> key) {
    public static <A> Codec<ResourceKeyDataMap<A>> codec(ResourceKey<? extends Registry<A>> key, String fieldName) {
        return RecordCodecBuilder.create(instance -> instance.group(
                ResourceKey.codec(key).fieldOf(fieldName).forGetter(ResourceKeyDataMap::key)
        ).apply(instance, ResourceKeyDataMap::new));
    }

    public static <T> ResourceKeyDataMap<T> of(Holder<T> holder) {
        return new ResourceKeyDataMap<>(holder.unwrapKey().orElseThrow());
    }
}
