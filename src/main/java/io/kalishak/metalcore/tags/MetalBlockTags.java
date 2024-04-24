package io.kalishak.metalcore.tags;

import io.kalishak.metalcore.Metalcore;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class MetalBlockTags {
    public static final TagKey<Block> ALUMINUM_ORES = commonTag("ores/aluminum");
    public static final TagKey<Block> TIN_ORES = commonTag("ores/tin");
    public static final TagKey<Block> LEAD_ORES = commonTag("ores/lead");
    public static final TagKey<Block> SILVER_ORES = commonTag("ores/silver");

    public static final TagKey<Block> STORAGE_BLOCKS_ALUMINUM = commonTag("storage_blocks/aluminum");
    public static final TagKey<Block> STORAGE_BLOCKS_RAW_ALUMINUM = commonTag("storage_blocks/raw_aluminum");
    public static final TagKey<Block> STORAGE_BLOCKS_TIN = commonTag("storage_blocks/tin");
    public static final TagKey<Block> STORAGE_BLOCKS_RAW_TIN = commonTag("storage_blocks/raw_tin");
    public static final TagKey<Block> STORAGE_BLOCKS_LEAD = commonTag("storage_blocks/lead");
    public static final TagKey<Block> STORAGE_BLOCKS_RAW_LEAD = commonTag("storage_blocks/raw_lead");
    public static final TagKey<Block> STORAGE_BLOCKS_SILVER = commonTag("storage_blocks/silver");
    public static final TagKey<Block> STORAGE_BLOCKS_RAW_SILVER = commonTag("storage_blocks/raw_silver");

    private static TagKey<Block> commonTag(String tagName) {
        return BlockTags.create(new ResourceLocation("c", tagName));
    }

    private static TagKey<Block> modTag(String tagName) {
        return BlockTags.create(new ResourceLocation(Metalcore.MODID, tagName));
    }
}
