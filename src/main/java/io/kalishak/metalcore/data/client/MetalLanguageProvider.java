package io.kalishak.metalcore.data.client;

import io.kalishak.metalcore.tags.MetalBlockTags;
import io.kalishak.metalcore.tags.MetalItemTags;
import io.kalishak.metalcore.world.item.MetalcoreItems;
import io.kalishak.metalcore.world.level.block.MetalcoreBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class MetalLanguageProvider extends LanguageProvider {
    public MetalLanguageProvider(PackOutput output, String modid, String locale) {
        super(output, modid, locale);
    }

    @Override
    protected void addTranslations() {
        add("itemGroup.metalcore.items", "Metalcore: Items");
        add("itemGroup.metalcore.blocks", "Metalcore: Decoration Blocks");

        addBlock(MetalcoreBlocks.ALUMINUM_ORE, "Aluminum Ore");
        addBlock(MetalcoreBlocks.DEEPSLATE_ALUMINUM_ORE, "Deepslate Aluminum Ore");
        addBlock(MetalcoreBlocks.LEAD_ORE, "Lead Ore");
        addBlock(MetalcoreBlocks.DEEPSLATE_LEAD_ORE, "Deepslate Lead Ore");
        addBlock(MetalcoreBlocks.SILICON_ORE, "Silicon Ore");
        addBlock(MetalcoreBlocks.DEEPSLATE_SILICON_ORE, "Deepslate Silicon Ore");
        addBlock(MetalcoreBlocks.SILVER_ORE, "Silver Ore");
        addBlock(MetalcoreBlocks.DEEPSLATE_SILVER_ORE, "Deepslate Silver Ore");
        addBlock(MetalcoreBlocks.END_SILVER_ORE, "End Silver Ore");
        addBlock(MetalcoreBlocks.TIN_ORE, "Tin Ore");
        addBlock(MetalcoreBlocks.DEEPSLATE_TIN_ORE, "Deepslate Tin Ore");
        addBlock(MetalcoreBlocks.RAW_ALUMINUM_BLOCK, "Raw Aluminum Block");
        addBlock(MetalcoreBlocks.ALUMINUM_BLOCK, "Aluminum Block");
        addBlock(MetalcoreBlocks.RAW_LEAD_BLOCK, "Raw Lead Block");
        addBlock(MetalcoreBlocks.LEAD_BLOCK, "Lead Block");
        addBlock(MetalcoreBlocks.RAW_WAXED_LEAD_BLOCK, "Raw Waxed Lead Block");
        addBlock(MetalcoreBlocks.WAXED_LEAD_BLOCK, "Waxed Lead Block");
        addBlock(MetalcoreBlocks.RAW_SILICON_BLOCK,  "Raw Silicon Block");
        addBlock(MetalcoreBlocks.RAW_SILVER_BLOCK, "Raw Silver Block");
        addBlock(MetalcoreBlocks.SILVER_BLOCK, "Silver Block");
        addBlock(MetalcoreBlocks.RAW_TIN_BLOCK,  "Raw Tin Block");
        addBlock(MetalcoreBlocks.TIN_BLOCK, "Tin Block");
        addBlock(MetalcoreBlocks.COPPER_PIPE, "Copper Pipe");
        addBlock(MetalcoreBlocks.EXPOSED_COPPER_PIPE, "Exposed Copper Pipe");
        addBlock(MetalcoreBlocks.WEATHERED_COPPER_PIPE, "Weather Copper Pipe");
        addBlock(MetalcoreBlocks.OXIDIZED_COPPER_PIPE,  "Oxidized Copper Pipe");
        addBlock(MetalcoreBlocks.WAXED_COPPER_PIPE, "Waxed Copper Pipe");
        addBlock(MetalcoreBlocks.WAXED_EXPOSED_COPPER_PIPE, "Waxed Exposed Copper Pipe");
        addBlock(MetalcoreBlocks.WAXED_WEATHERED_COPPER_PIPE, "Waxed Weather Copper Pipe");
        addBlock(MetalcoreBlocks.WAXED_OXIDIZED_COPPER_PIPE,  "Waxed Oxidized Copper Pipe");
        addBlock(MetalcoreBlocks.COPPER_BELL,  "Copper Bell");
        addBlock(MetalcoreBlocks.EXPOSED_COPPER_BELL, "Exposed Copper Bell");
        addBlock(MetalcoreBlocks.WEATHERED_COPPER_BELL,  "Weather Copper Bell");
        addBlock(MetalcoreBlocks.OXIDIZED_COPPER_BELL,  "Oxidized Copper Bell");
        addBlock(MetalcoreBlocks.WAXED_COPPER_BELL,  "Waxed Copper Bell");
        addBlock(MetalcoreBlocks.WAXED_EXPOSED_COPPER_BELL, "Waxed Exposed Copper Bell");
        addBlock(MetalcoreBlocks.WAXED_WEATHERED_COPPER_BELL,  "Waxed Weather Copper Bell");
        addBlock(MetalcoreBlocks.WAXED_OXIDIZED_COPPER_BELL,  "Waxed Oxidized Copper Bell");
        addBlock(MetalcoreBlocks.COPPER_SPIKES, "Copper Spikes");
        addBlock(MetalcoreBlocks.EXPOSED_COPPER_SPIKES, "Exposed Copper Spikes");
        addBlock(MetalcoreBlocks.WEATHERED_COPPER_SPIKES, "Weather Copper Spikes");
        addBlock(MetalcoreBlocks.OXIDIZED_COPPER_SPIKES, "Oxidized Copper Spikes");
        addBlock(MetalcoreBlocks.WAXED_COPPER_SPIKES, "Waxed Copper Spikes");
        addBlock(MetalcoreBlocks.WAXED_EXPOSED_COPPER_SPIKES, "Waxed Exposed Copper Spikes");
        addBlock(MetalcoreBlocks.WAXED_WEATHERED_COPPER_SPIKES, "Waxed Weather Copper Spikes");
        addBlock(MetalcoreBlocks.WAXED_OXIDIZED_COPPER_SPIKES, "Waxed Oxidized Copper Spikes");
        addBlock(MetalcoreBlocks.COPPER_FAN, "Copper Fan");
        addBlock(MetalcoreBlocks.EXPOSED_COPPER_FAN, "Exposed Copper Fan");
        addBlock(MetalcoreBlocks.WEATHERED_COPPER_FAN, "Weathered Copper Fan");
        addBlock(MetalcoreBlocks.OXIDIZED_COPPER_FAN, "Oxidized Copper Fan");
        addBlock(MetalcoreBlocks.WAXED_COPPER_FAN, "Waxed Copper Fan");
        addBlock(MetalcoreBlocks.WAXED_EXPOSED_COPPER_FAN, "Waxed Exposed Copper Fan");
        addBlock(MetalcoreBlocks.WAXED_WEATHERED_COPPER_FAN, "Waxed Weathered Copper Fan");
        addBlock(MetalcoreBlocks.WAXED_OXIDIZED_COPPER_FAN, "Waxed Oxidized Copper Fan");

        addItem(MetalcoreItems.RAW_ALUMINUM, "Raw Aluminum");
        addItem(MetalcoreItems.ALUMINUM_INGOT, "Aluminum Ingot");
        addItem(MetalcoreItems.ALUMINUM_DUST, "Aluminum Dust");
        addItem(MetalcoreItems.RAW_LEAD, "Raw Lead");
        addItem(MetalcoreItems.LEAD_INGOT, "Lead Ingot");
        addItem(MetalcoreItems.LEAD_DUST, "Lead Dust");
        addItem(MetalcoreItems.COPPER_DUST , "Copper Dust");
        addItem(MetalcoreItems.DIAMOND_DUST , "Diamond Dust");
        addItem(MetalcoreItems.EMERALD_DUST , "Emerald Dust");
        addItem(MetalcoreItems.GOLD_DUST , "Gold Dust");
        addItem(MetalcoreItems.IRON_DUST , "Iron Dust");
        addItem(MetalcoreItems.LAPIS_LAZULI_DUST , "Lapis Lazuli Dust");
        addItem(MetalcoreItems.RAW_SILICON, "Raw Silicon");
        addItem(MetalcoreItems.SILICON_DUST, "Silicon Dust");
        addItem(MetalcoreItems.RAW_SILVER, "Raw Silver");
        addItem(MetalcoreItems.SILVER_INGOT, "Silver Ingot");
        addItem(MetalcoreItems.SILVER_DUST, "Silver Dust");
        addItem(MetalcoreItems.RAW_TIN, "Raw Tin");
        addItem(MetalcoreItems.TIN_INGOT, "Tin Ingot");
        addItem(MetalcoreItems.TIN_DUST, "Tin Dust");
        addItem(MetalcoreItems.STEEL_INGOT, "Steel Ingot");
        addItem(MetalcoreItems.STEEL_DUST, "Steel Dust");
        addItem(MetalcoreItems.STEEL_AXE,  "Steel Axe");
        addItem(MetalcoreItems.STEEL_HOE,  "Steel Hoe");
        addItem(MetalcoreItems.STEEL_PICKAXE,  "Steel Pickaxe");
        addItem(MetalcoreItems.STEEL_SHOVEL, "Steel Shovel");
        addItem(MetalcoreItems.STEEL_SWORD, "Steel Sword");
        addItem(MetalcoreItems.STEEL_HELMET, "Steel Helmet");
        addItem(MetalcoreItems.STEEL_CHESTPLATE,  "Steel Chestplate");
        addItem(MetalcoreItems.STEEL_LEGGINGS,  "Steel Leggings");
        addItem(MetalcoreItems.STEEL_BOOTS, "Steel Boots");
        addItem(MetalcoreItems.COPPER_SHIELD, "Copper Shield");

        add(MetalBlockTags.METALS, "Metals");
        add(MetalBlockTags.METAL_ALUMINUM, "Aluminum Metals");
        add(MetalBlockTags.METAL_COPPER, "Copper Metals");
        add(MetalBlockTags.METAL_GOLD, "Gold Metals");
        add(MetalBlockTags.METAL_IRON, "Iron Metals");
        add(MetalBlockTags.METAL_LEAD, "Lead Metals");
        add(MetalBlockTags.METAL_NETHERITE, "Netherite Metals");
        add(MetalBlockTags.METAL_SILVER, "Silver Metals");
        add(MetalBlockTags.METAL_TIN, "Tin Metals");
        add(MetalBlockTags.ALLOYS, "Alloys");
        add(MetalBlockTags.ALLOY_BRONZE,  "Bronze Alloys");
        add(MetalBlockTags.ALLOY_STEEL, "Steel Alloys");

        add(MetalItemTags.METALS, "Metals");
        add(MetalItemTags.METAL_ALUMINUM, "Aluminum Metals");
        add(MetalItemTags.METAL_COPPER, "Copper Metals");
        add(MetalItemTags.METAL_GOLD, "Gold Metals");
        add(MetalItemTags.METAL_IRON, "Iron Metals");
        add(MetalItemTags.METAL_LEAD, "Lead Metals");
        add(MetalItemTags.METAL_NETHERITE, "Netherite Metals");
        add(MetalItemTags.METAL_SILVER, "Silver Metals");
        add(MetalItemTags.METAL_TIN, "Tin Metals");
        add(MetalItemTags.ALLOYS, "Alloys");
        add(MetalItemTags.ALLOY_BRONZE,  "Bronze Alloys");
        add(MetalItemTags.ALLOY_STEEL, "Steel Alloys");
        add(MetalItemTags.WEATHERING_ITEM, "Weathering Items");
    }
}
