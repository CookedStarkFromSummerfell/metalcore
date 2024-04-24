package io.kalishak.metalcore.tags;

import io.kalishak.metalcore.Metalcore;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class MetalItemTags {
    public static final TagKey<Item> ALUMINUM_ORES = commonTag("ores/aluminum");
    public static final TagKey<Item> TIN_ORES = commonTag("ores/tin");
    public static final TagKey<Item> LEAD_ORES = commonTag("ores/lead");
    public static final TagKey<Item> SILVER_ORES = commonTag("ores/silver");

    public static final TagKey<Item> STORAGE_BLOCKS_ALUMINUM = commonTag("storage_blocks/aluminum");
    public static final TagKey<Item> STORAGE_BLOCKS_RAW_ALUMINUM = commonTag("storage_blocks/raw_aluminum");
    public static final TagKey<Item> STORAGE_BLOCKS_TIN = commonTag("storage_blocks/tin");
    public static final TagKey<Item> STORAGE_BLOCKS_RAW_TIN = commonTag("storage_blocks/raw_tin");
    public static final TagKey<Item> STORAGE_BLOCKS_LEAD = commonTag("storage_blocks/lead");
    public static final TagKey<Item> STORAGE_BLOCKS_RAW_LEAD = commonTag("storage_blocks/raw_lead");
    public static final TagKey<Item> STORAGE_BLOCKS_SILVER = commonTag("storage_blocks/silver");
    public static final TagKey<Item> STORAGE_BLOCKS_RAW_SILVER = commonTag("storage_blocks/raw_silver");

    public static final TagKey<Item> RAW_BLOCKS_ALUMINUM = commonTag("raw_blocks/aluminum");
    public static final TagKey<Item> RAW_BLOCKS_TIN = commonTag("raw_blocks/tin");
    public static final TagKey<Item> RAW_BLOCKS_LEAD = commonTag("raw_blocks/lead");
    public static final TagKey<Item> RAW_BLOCKS_SILVER = commonTag("raw_blocks/silver");

    public static final TagKey<Item> RAW_MATERIALS_ALUMINUM = commonTag("raw_materials/aluminum");
    public static final TagKey<Item> RAW_MATERIALS_TIN = commonTag("raw_materials/tin");
    public static final TagKey<Item> RAW_MATERIALS_LEAD = commonTag("raw_materials/lead");
    public static final TagKey<Item> RAW_MATERIALS_SILVER = commonTag("raw_materials/silver");

    private static TagKey<Item> commonTag(String tagName) {
        return ItemTags.create(new ResourceLocation("c", tagName));
    }

    private static TagKey<Item> modTag(String tagName) {
        return ItemTags.create(new ResourceLocation(Metalcore.MODID, tagName));
    }
}
