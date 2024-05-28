package io.kalishak.metalcore.data.client;

import io.kalishak.metalcore.api.block.WeatheringCopperHolder;
import io.kalishak.metalcore.tags.MetalBlockTags;
import io.kalishak.metalcore.tags.MetalFluidTags;
import io.kalishak.metalcore.tags.MetalItemTags;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class CommonLanguageProvider extends LanguageProvider {
    public CommonLanguageProvider(PackOutput output) {
        super(output, "c", "en_us");
    }

    @Override
    protected void addTranslations() {
        addWeatheringState();

        add(MetalBlockTags.ALUMINUM_ORES, "Aluminum Ores");
        add(MetalBlockTags.TIN_ORES, "Tin Ores");
        add(MetalBlockTags.LEAD_ORES, "Lead Ores");
        add(MetalBlockTags.SILICON_ORES, "Silicon Ores");
        add(MetalBlockTags.SILVER_ORES, "Silver Ores");
        add(MetalBlockTags.STORAGE_BLOCKS_ALUMINUM, "Aluminum Storage Blocks");
        add(MetalBlockTags.STORAGE_BLOCKS_RAW_ALUMINUM, "Raw Aluminum Storage Blocks");
        add(MetalBlockTags.STORAGE_BLOCKS_TIN, "Tin Storage Blocks");
        add(MetalBlockTags.STORAGE_BLOCKS_RAW_TIN, "Raw Tin Storage Blocks");
        add(MetalBlockTags.STORAGE_BLOCKS_LEAD, "Lead Storage Blocks");
        add(MetalBlockTags.STORAGE_BLOCKS_RAW_LEAD, "Raw Lead Storage Blocks");
        add(MetalBlockTags.STORAGE_BLOCKS_RAW_SILICON, "Raw Silicon Storage Blocks");
        add(MetalBlockTags.STORAGE_BLOCKS_SILVER, "Silver Storage Blocks");
        add(MetalBlockTags.STORAGE_BLOCKS_RAW_SILVER, "Raw Silver Storage Blocks");

        add(MetalFluidTags.MOLTEN_ALUMINUM, "Molten Aluminum");
        add(MetalFluidTags.MOLTEN_BRONZE, "Molten Bronze");
        add(MetalFluidTags.MOLTEN_COPPER, "Molten Copper");
        add(MetalFluidTags.MOLTEN_GOLD, "Molten Gold");
        add(MetalFluidTags.MOLTEN_IRON, "Molten Iron");
        add(MetalFluidTags.MOLTEN_LEAD, "Molten Lead");
        add(MetalFluidTags.MOLTEN_NETHERITE, "Molten Netherite");
        add(MetalFluidTags.MOLTEN_STEEL, "Molten Steel");
        add(MetalFluidTags.MOLTEN_SILVER, "Molten Silver");
        add(MetalFluidTags.MOLTEN_TIN, "Molten Tin");

        add(MetalItemTags.ALUMINUM_ORES, "Aluminum Ores");
        add(MetalItemTags.TIN_ORES, "Tin Ores");
        add(MetalItemTags.LEAD_ORES, "Lead Ores");
        add(MetalItemTags.SILICON_ORES, "Silicon Ores");
        add(MetalItemTags.SILVER_ORES, "Silver Ores");
        add(MetalItemTags.STORAGE_BLOCKS_ALUMINUM, "Aluminum Storage Blocks");
        add(MetalItemTags.STORAGE_BLOCKS_RAW_ALUMINUM, "Raw Aluminum Storage Blocks");
        add(MetalItemTags.STORAGE_BLOCKS_TIN, "Tin Storage Blocks");
        add(MetalItemTags.STORAGE_BLOCKS_RAW_TIN, "Raw Tin Storage Blocks");
        add(MetalItemTags.STORAGE_BLOCKS_LEAD, "Lead Storage Blocks");
        add(MetalItemTags.STORAGE_BLOCKS_RAW_LEAD, "Raw Lead Storage Blocks");
        add(MetalItemTags.STORAGE_BLOCKS_RAW_SILICON, "Raw Silicon Storage Blocks");
        add(MetalItemTags.STORAGE_BLOCKS_SILVER, "Silver Storage Blocks");
        add(MetalItemTags.STORAGE_BLOCKS_RAW_SILVER, "Raw Silver Storage Blocks");
        add(MetalItemTags.RAW_BLOCKS_ALUMINUM, "Raw Aluminum Blocks");
        add(MetalItemTags.RAW_BLOCKS_TIN, "Raw Tin Blocks");
        add(MetalItemTags.RAW_BLOCKS_LEAD, "Raw Lead Blocks");
        add(MetalItemTags.RAW_BLOCKS_SILICON, "Raw Silicon Blocks");
        add(MetalItemTags.RAW_BLOCKS_SILVER, "Raw Silver Blocks");
        add(MetalItemTags.RAW_MATERIALS_ALUMINUM, "Raw Aluminum Materials");
        add(MetalItemTags.RAW_MATERIALS_LEAD, "Raw Lead Materials");
        add(MetalItemTags.RAW_MATERIALS_TIN, "Raw Tin Materials");
        add(MetalItemTags.RAW_MATERIALS_SILICON, "Raw Materials Silicon Materials");
        add(MetalItemTags.RAW_MATERIALS_SILVER, "Raw Silver Materials");
        add(MetalItemTags.INGOTS_ALUMINUM, "Aluminum Ingots");
        add(MetalItemTags.INGOTS_BRONZE, "Bronze Ingots");
        add(MetalItemTags.INGOTS_TIN, "Tin Ingots");
        add(MetalItemTags.INGOTS_LEAD, "Lead Ingots");
        add(MetalItemTags.INGOTS_SILVER, "Silver Ingots");
        add(MetalItemTags.INGOTS_STEEL, "Steel Ingots");
        add(MetalItemTags.DUSTS_ALUMINUM, "Aluminum Dusts");
        add(MetalItemTags.DUSTS_BRONZE, "Bronze Dusts");
        add(MetalItemTags.DUSTS_COPPER, "Copper Dusts");
        add(MetalItemTags.DUSTS_DIAMOND, "Diamond Dusts");
        add(MetalItemTags.DUSTS_GOLD, "Gold Dusts");
        add(MetalItemTags.DUSTS_IRON, "Iron Dusts");
        add(MetalItemTags.DUSTS_LAPIS_LAZULI, "Lapis Lazuli Dusts");
        add(MetalItemTags.DUSTS_LEAD, "Lead Dusts");
        add(MetalItemTags.DUSTS_SILICON, "Silicon Dusts");
        add(MetalItemTags.DUSTS_SILVER, "Silver Dusts");
        add(MetalItemTags.DUSTS_STEEL, "Steel Dusts");
        add(MetalItemTags.DUSTS_TIN, "Tin Dusts");
    }

    private void addWeatheringState() {
        for (var state : WeatheringCopperHolder.WeatherState.values()) {
            String stateName = state.getSerializedName();
            String key = "item.metalcore.weathering_state." + stateName;
            String value = stateName.substring(0, 1).toUpperCase() + stateName.substring(1);

            add(key, value);
        }
    }
}
