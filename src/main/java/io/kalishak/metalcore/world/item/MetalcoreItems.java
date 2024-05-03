package io.kalishak.metalcore.world.item;

import io.kalishak.metalcore.Metalcore;
import io.kalishak.metalcore.world.level.block.MetalcoreBlocks;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class MetalcoreItems {
    private static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Metalcore.MODID);

    public static final DeferredItem<BlockItem> ALUMINUM_ORE = ITEMS.registerSimpleBlockItem(MetalcoreBlocks.ALUMINUM_ORE);
    public static final DeferredItem<BlockItem> DEEPSLATE_ALUMINUM_ORE = ITEMS.registerSimpleBlockItem(MetalcoreBlocks.DEEPSLATE_ALUMINUM_ORE);
    public static final DeferredItem<BlockItem> LEAD_ORE = ITEMS.registerSimpleBlockItem(MetalcoreBlocks.LEAD_ORE);
    public static final DeferredItem<BlockItem> DEEPSLATE_LEAD_ORE = ITEMS.registerSimpleBlockItem(MetalcoreBlocks.DEEPSLATE_LEAD_ORE);
    public static final DeferredItem<BlockItem> SILICON_ORE = ITEMS.registerSimpleBlockItem(MetalcoreBlocks.SILICON_ORE);
    public static final DeferredItem<BlockItem> DEEPSLATE_SILICON_ORE = ITEMS.registerSimpleBlockItem(MetalcoreBlocks.DEEPSLATE_SILICON_ORE);
    public static final DeferredItem<BlockItem> SILVER_ORE = ITEMS.registerSimpleBlockItem(MetalcoreBlocks.SILVER_ORE);
    public static final DeferredItem<BlockItem> DEEPSLATE_SILVER_ORE = ITEMS.registerSimpleBlockItem(MetalcoreBlocks.DEEPSLATE_SILVER_ORE);
    public static final DeferredItem<BlockItem> END_SILVER_ORE = ITEMS.registerSimpleBlockItem(MetalcoreBlocks.END_SILVER_ORE);
    public static final DeferredItem<BlockItem> TIN_ORE = ITEMS.registerSimpleBlockItem(MetalcoreBlocks.TIN_ORE);
    public static final DeferredItem<BlockItem> DEEPSLATE_TIN_ORE = ITEMS.registerSimpleBlockItem(MetalcoreBlocks.DEEPSLATE_TIN_ORE);
    public static final DeferredItem<BlockItem> RAW_ALUMINUM_BLOCK = ITEMS.registerSimpleBlockItem(MetalcoreBlocks.RAW_ALUMINUM_BLOCK);
    public static final DeferredItem<BlockItem> ALUMINUM_BLOCK = ITEMS.registerSimpleBlockItem(MetalcoreBlocks.ALUMINUM_BLOCK);
    public static final DeferredItem<BlockItem> RAW_LEAD_BLOCK = ITEMS.registerSimpleBlockItem(MetalcoreBlocks.RAW_LEAD_BLOCK);
    public static final DeferredItem<BlockItem> LEAD_BLOCK = ITEMS.registerSimpleBlockItem(MetalcoreBlocks.LEAD_BLOCK);
    public static final DeferredItem<BlockItem> RAW_WAXED_LEAD_BLOCK = ITEMS.registerSimpleBlockItem(MetalcoreBlocks.RAW_WAXED_LEAD_BLOCK);
    public static final DeferredItem<BlockItem> WAXED_LEAD_BLOCK = ITEMS.registerSimpleBlockItem(MetalcoreBlocks.WAXED_LEAD_BLOCK);
    public static final DeferredItem<BlockItem> RAW_SILICON_BLOCK = ITEMS.registerSimpleBlockItem(MetalcoreBlocks.RAW_SILICON_BLOCK);
    public static final DeferredItem<BlockItem> RAW_SILVER_BLOCK = ITEMS.registerSimpleBlockItem(MetalcoreBlocks.RAW_SILVER_BLOCK);
    public static final DeferredItem<BlockItem> SILVER_BLOCK = ITEMS.registerSimpleBlockItem(MetalcoreBlocks.SILVER_BLOCK);
    public static final DeferredItem<BlockItem> RAW_TIN_BLOCK = ITEMS.registerSimpleBlockItem(MetalcoreBlocks.RAW_TIN_BLOCK);
    public static final DeferredItem<BlockItem> TIN_BLOCK = ITEMS.registerSimpleBlockItem(MetalcoreBlocks.TIN_BLOCK);
    public static final DeferredItem<WeatheringCopperPipeBlockItem> COPPER_PIPE = ITEMS.register("copper_pipe", () -> new WeatheringCopperPipeBlockItem(MetalcoreBlocks.COPPER_PIPE, new Item.Properties()));
    public static final DeferredItem<BlockItem> COPPER_BELL = ITEMS.registerSimpleBlockItem(MetalcoreBlocks.COPPER_BELL);
    public static final DeferredItem<BlockItem> EXPOSED_COPPER_BELL = ITEMS.registerSimpleBlockItem(MetalcoreBlocks.EXPOSED_COPPER_BELL);
    public static final DeferredItem<BlockItem> WEATHERED_COPPER_BELL = ITEMS.registerSimpleBlockItem(MetalcoreBlocks.WEATHERED_COPPER_BELL);
    public static final DeferredItem<BlockItem> OXIDIZED_COPPER_BELL = ITEMS.registerSimpleBlockItem(MetalcoreBlocks.OXIDIZED_COPPER_BELL);

    public static final DeferredItem<Item> RAW_ALUMINUM = ITEMS.registerSimpleItem("raw_aluminum");
    public static final DeferredItem<Item> ALUMINUM_INGOT = ITEMS.registerSimpleItem("aluminum_ingot");
    public static final DeferredItem<Item> ALUMINUM_DUST = ITEMS.registerSimpleItem("aluminum_dust");
    public static final DeferredItem<Item> RAW_LEAD = ITEMS.registerSimpleItem("raw_lead");
    public static final DeferredItem<Item> LEAD_INGOT = ITEMS.registerSimpleItem("lead_ingot");
    public static final DeferredItem<Item> LEAD_DUST = ITEMS.registerSimpleItem("lead_dust");
    public static final DeferredItem<Item> RAW_SILICON = ITEMS.registerSimpleItem("raw_silicon");
    public static final DeferredItem<Item> SILICON_DUST = ITEMS.registerSimpleItem("silicon_dust");
    public static final DeferredItem<Item> RAW_SILVER = ITEMS.registerSimpleItem("raw_silver");
    public static final DeferredItem<Item> SILVER_INGOT = ITEMS.registerSimpleItem("silver_ingot");
    public static final DeferredItem<Item> SILVER_DUST = ITEMS.registerSimpleItem("silver_dust");
    public static final DeferredItem<Item> RAW_TIN = ITEMS.registerSimpleItem("raw_tin");
    public static final DeferredItem<Item> TIN_INGOT = ITEMS.registerSimpleItem("tin_ingot");
    public static final DeferredItem<Item> TIN_DUST = ITEMS.registerSimpleItem("tin_dust");
    public static final DeferredItem<Item> STEEL_INGOT = ITEMS.registerSimpleItem("steel_ingot");
    public static final DeferredItem<Item> STEEL_DUST = ITEMS.registerSimpleItem("steel_dust");
    public static final DeferredItem<Item> COPPER_DUST = ITEMS.registerSimpleItem("copper_dust");
    public static final DeferredItem<Item> DIAMOND_DUST = ITEMS.registerSimpleItem("diamond_dust");
    public static final DeferredItem<Item> EMERALD_DUST = ITEMS.registerSimpleItem("emerald_dust");
    public static final DeferredItem<Item> GOLD_DUST = ITEMS.registerSimpleItem("gold_dust");
    public static final DeferredItem<Item> IRON_DUST = ITEMS.registerSimpleItem("iron_dust");
    public static final DeferredItem<Item> LAPIS_LAZULI_DUST = ITEMS.registerSimpleItem("lapis_lazuli_dust");

    public static final DeferredItem<AxeItem> STEEL_AXE = ITEMS.register("steel_axe", () -> new AxeItem(MetalcoreTiers.STEEL, new Item.Properties().attributes(AxeItem.createAttributes(MetalcoreTiers.STEEL, 6.0F, -3.1F))));
    public static final DeferredItem<HoeItem> STEEL_HOE = ITEMS.register("steel_hoe", () -> new HoeItem(MetalcoreTiers.STEEL, new Item.Properties().attributes(HoeItem.createAttributes(MetalcoreTiers.STEEL, -2.0F, -1.0F))));
    public static final DeferredItem<PickaxeItem> STEEL_PICKAXE = ITEMS.register("steel_pickaxe", () -> new PickaxeItem(MetalcoreTiers.STEEL, new Item.Properties().attributes(PickaxeItem.createAttributes(MetalcoreTiers.STEEL, 1.0F, -2.8F))));
    public static final DeferredItem<ShovelItem> STEEL_SHOVEL = ITEMS.register("steel_shovel", () -> new ShovelItem(MetalcoreTiers.STEEL, new Item.Properties().attributes(ShovelItem.createAttributes(MetalcoreTiers.STEEL, 1.5F, -3.0F))));
    public static final DeferredItem<SwordItem> STEEL_SWORD = ITEMS.register("steel_sword", () -> new SwordItem(MetalcoreTiers.STEEL, new Item.Properties().attributes(SwordItem.createAttributes(MetalcoreTiers.STEEL, 3, -2.4F))));
    public static final DeferredItem<WeatheringCopperShieldItem> COPPER_SHIELD = ITEMS.register("copper_shield", () -> new WeatheringCopperShieldItem(new Item.Properties().durability(384)));

    public static final DeferredItem<ArmorItem> STEEL_HELMET = ITEMS.register("steel_helmet", () -> new ArmorItem(MetalcoreArmorMaterials.STEEL, ArmorItem.Type.HELMET, new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(23))));
    public static final DeferredItem<ArmorItem> STEEL_CHESTPLATE = ITEMS.register("steel_chestplate", () -> new ArmorItem(MetalcoreArmorMaterials.STEEL, ArmorItem.Type.CHESTPLATE, new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(23))));
    public static final DeferredItem<ArmorItem> STEEL_LEGGINGS = ITEMS.register("steel_leggings", () -> new ArmorItem(MetalcoreArmorMaterials.STEEL, ArmorItem.Type.LEGGINGS, new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(23))));
    public static final DeferredItem<ArmorItem> STEEL_BOOTS = ITEMS.register("steel_boots", () -> new ArmorItem(MetalcoreArmorMaterials.STEEL, ArmorItem.Type.BOOTS, new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(23))));

    public static void init(IEventBus bus) {
        ITEMS.register(bus);
    }

    @SubscribeEvent
    public static void appendItems(final BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == MetalcoreCreativeModeTabs.METALCORE_ITEMS.getKey()) {
            ITEMS.getEntries().stream().map(DeferredHolder::get).forEach(event::accept);
        }
    }
}
