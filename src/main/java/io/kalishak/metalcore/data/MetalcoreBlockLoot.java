package io.kalishak.metalcore.data;

import io.kalishak.metalcore.Metalcore;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;

import java.util.Map;
import java.util.Set;

public class MetalcoreBlockLoot extends BlockLootSubProvider {
    protected MetalcoreBlockLoot() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BuiltInRegistries.BLOCK.entrySet()
                .stream()
                .filter(entry -> entry.getKey().location().getNamespace().equals(Metalcore.MODID))
                .map(Map.Entry::getValue)
                .toList();
    }
}
