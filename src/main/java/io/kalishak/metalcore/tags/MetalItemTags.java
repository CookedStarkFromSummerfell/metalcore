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
    public static final TagKey<Item> SILICON_ORES = commonTag("ores/silicon");
    public static final TagKey<Item> SILVER_ORES = commonTag("ores/silver");

    public static final TagKey<Item> STORAGE_BLOCKS_ALUMINUM = commonTag("storage_blocks/aluminum");
    public static final TagKey<Item> STORAGE_BLOCKS_RAW_ALUMINUM = commonTag("storage_blocks/raw_aluminum");
    public static final TagKey<Item> STORAGE_BLOCKS_TIN = commonTag("storage_blocks/tin");
    public static final TagKey<Item> STORAGE_BLOCKS_RAW_TIN = commonTag("storage_blocks/raw_tin");
    public static final TagKey<Item> STORAGE_BLOCKS_LEAD = commonTag("storage_blocks/lead");
    public static final TagKey<Item> STORAGE_BLOCKS_RAW_LEAD = commonTag("storage_blocks/raw_lead");
    public static final TagKey<Item> STORAGE_BLOCKS_RAW_SILICON = commonTag("storage_blocks/raw_silicon");
    public static final TagKey<Item> STORAGE_BLOCKS_SILVER = commonTag("storage_blocks/silver");
    public static final TagKey<Item> STORAGE_BLOCKS_RAW_SILVER = commonTag("storage_blocks/raw_silver");

    public static final TagKey<Item> RAW_BLOCKS_ALUMINUM = commonTag("raw_blocks/aluminum");
    public static final TagKey<Item> RAW_BLOCKS_TIN = commonTag("raw_blocks/tin");
    public static final TagKey<Item> RAW_BLOCKS_LEAD = commonTag("raw_blocks/lead");
    public static final TagKey<Item> RAW_BLOCKS_SILICON = commonTag("raw_blocks/silicon");
    public static final TagKey<Item> RAW_BLOCKS_SILVER = commonTag("raw_blocks/silver");

    public static final TagKey<Item> RAW_MATERIALS_ALUMINUM = commonTag("raw_materials/aluminum");
    public static final TagKey<Item> RAW_MATERIALS_TIN = commonTag("raw_materials/tin");
    public static final TagKey<Item> RAW_MATERIALS_LEAD = commonTag("raw_materials/lead");
    public static final TagKey<Item> RAW_MATERIALS_SILICON = commonTag("raw_materials/silicon");
    public static final TagKey<Item> RAW_MATERIALS_SILVER = commonTag("raw_materials/silver");

    public static final TagKey<Item> INGOTS_ALUMINUM = commonTag("ingots/aluminum");
    public static final TagKey<Item> INGOTS_BRONZE = commonTag("ingots/bronze");
    public static final TagKey<Item> INGOTS_TIN = commonTag("ingots/tin");
    public static final TagKey<Item> INGOTS_LEAD = commonTag("ingots/lead");
    public static final TagKey<Item> INGOTS_SILVER = commonTag("ingots/silver");
    public static final TagKey<Item> INGOTS_STEEL = commonTag("ingots/steel");

    public static final TagKey<Item> DUSTS_ALUMINUM = commonTag("dusts/aluminum");
    public static final TagKey<Item> DUSTS_BRONZE = commonTag("dusts/bronze");
    public static final TagKey<Item> DUSTS_COPPER = commonTag("dusts/copper");
    public static final TagKey<Item> DUSTS_DIAMOND = commonTag("dusts/diamond");
    public static final TagKey<Item> DUSTS_EMERALD = commonTag("dusts/emerald");
    public static final TagKey<Item> DUSTS_GOLD = commonTag("dusts/gold");
    public static final TagKey<Item> DUSTS_IRON = commonTag("dusts/iron");
    public static final TagKey<Item> DUSTS_LAPIS_LAZULI = commonTag("dusts/lapis_lazuli");
    public static final TagKey<Item> DUSTS_LEAD = commonTag("dusts/lead");
    public static final TagKey<Item> DUSTS_SILICON = commonTag("dusts/silicon");
    public static final TagKey<Item> DUSTS_SILVER = commonTag("dusts/silver");
    public static final TagKey<Item> DUSTS_STEEL = commonTag("dusts/steel");
    public static final TagKey<Item> DUSTS_TIN = commonTag("dusts/tin");

    public static final TagKey<Item> METALS = modTag("metals");
    public static final TagKey<Item> METAL_ALUMINUM = modTag("metals/aluminum");
    public static final TagKey<Item> METAL_COPPER = modTag("metals/copper");
    public static final TagKey<Item> METAL_GOLD = modTag("metals/gold");
    public static final TagKey<Item> METAL_IRON = modTag("metals/iron");
    public static final TagKey<Item> METAL_LEAD = modTag("metals/lead");
    public static final TagKey<Item> METAL_NETHERITE = modTag("metals/netherite");
    public static final TagKey<Item> METAL_SILVER = modTag("metals/silver");
    public static final TagKey<Item> METAL_TIN = modTag("metals/tin");

    public static final TagKey<Item> ALLOYS = modTag("alloys");
    public static final TagKey<Item> ALLOY_BRONZE = modTag("alloys/bronze");
    public static final TagKey<Item> ALLOY_STEEL = modTag("alloys/steel");

    private static TagKey<Item> commonTag(String tagName) {
        return ItemTags.create(new ResourceLocation("c", tagName));
    }

    private static TagKey<Item> modTag(String tagName) {
        return ItemTags.create(new ResourceLocation(Metalcore.MODID, tagName));
    }
}
