package io.kalishak.metalcore.data.tags;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

public class MetalTagsProvider {
    private static CompletableFuture<TagsProvider.TagLookup<Block>> blockTags = null;

    public static void init(DataGenerator dataGenerator, String modId) {

    }
}
