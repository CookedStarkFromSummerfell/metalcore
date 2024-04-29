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
    public static final TagKey<Block> SILICON_ORES = commonTag("ores/silicon");
    public static final TagKey<Block> SILVER_ORES = commonTag("ores/silver");

    public static final TagKey<Block> STORAGE_BLOCKS_ALUMINUM = commonTag("storage_blocks/aluminum");
    public static final TagKey<Block> STORAGE_BLOCKS_RAW_ALUMINUM = commonTag("storage_blocks/raw_aluminum");
    public static final TagKey<Block> STORAGE_BLOCKS_TIN = commonTag("storage_blocks/tin");
    public static final TagKey<Block> STORAGE_BLOCKS_RAW_TIN = commonTag("storage_blocks/raw_tin");
    public static final TagKey<Block> STORAGE_BLOCKS_LEAD = commonTag("storage_blocks/lead");
    public static final TagKey<Block> STORAGE_BLOCKS_RAW_LEAD = commonTag("storage_blocks/raw_lead");
    public static final TagKey<Block> STORAGE_BLOCKS_RAW_SILICON = commonTag("storage_blocks/raw_silicon");
    public static final TagKey<Block> STORAGE_BLOCKS_SILVER = commonTag("storage_blocks/silver");
    public static final TagKey<Block> STORAGE_BLOCKS_RAW_SILVER = commonTag("storage_blocks/raw_silver");

    public static final TagKey<Block> METALS = modTag("metals");
    public static final TagKey<Block> METAL_ALUMINUM = modTag("metals/aluminum");
    public static final TagKey<Block> METAL_COPPER = modTag("metals/copper");
    public static final TagKey<Block> METAL_GOLD = modTag("metals/gold");
    public static final TagKey<Block> METAL_IRON = modTag("metals/iron");
    public static final TagKey<Block> METAL_LEAD = modTag("metals/lead");
    public static final TagKey<Block> METAL_NETHERITE = modTag("metals/netherite");
    public static final TagKey<Block> METAL_SILVER = modTag("metals/silver");
    public static final TagKey<Block> METAL_TIN = modTag("metals/tin");

    public static final TagKey<Block> ALLOY_BRONZE = modTag("metals/bronze");
    public static final TagKey<Block> ALLOY_STEEL = modTag("metals/steel");

    private static TagKey<Block> commonTag(String tagName) {
        return BlockTags.create(new ResourceLocation("c", tagName));
    }

    private static TagKey<Block> modTag(String tagName) {
        return BlockTags.create(new ResourceLocation(Metalcore.MODID, tagName));
    }
}
