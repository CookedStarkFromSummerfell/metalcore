package io.kalishak.metalcore.data.client;

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
    }
}
