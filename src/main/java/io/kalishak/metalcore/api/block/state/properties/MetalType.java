package io.kalishak.metalcore.api.block.state.properties;

import com.mojang.serialization.Codec;
import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.BlockSetType;

import java.util.Map;
import java.util.stream.Stream;

public record MetalType(String name, BlockSetType setType, SoundType soundType, SoundType hangingSignSoundType) {
    private static final Map<String, MetalType> TYPES = new Object2ObjectArrayMap<>();
    public static final Codec<MetalType> CODEC = Codec.stringResolver(MetalType::name, TYPES::get);

    public static MetalType register(MetalType metalBlockType) {
        TYPES.put(metalBlockType.name(), metalBlockType);
        return metalBlockType;
    }

    public static Stream<MetalType> values() {
        return TYPES.values().stream();
    }
}
