package io.kalishak.metalcore.data.tags;

import io.kalishak.metalcore.Metalcore;
import io.kalishak.metalcore.tags.MetalItemTags;
import io.kalishak.metalcore.world.item.MetalcoreItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class MetalItemTagsProvider extends ItemTagsProvider {
    MetalItemTagsProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries, CompletableFuture<TagLookup<Block>> blockTags, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, registries, blockTags, modId, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        addNeoForgeTags();
        addVanillaTags();

        tag(MetalItemTags.ALUMINUM_ORES)
                .add(MetalcoreItems.ALUMINUM_ORE.get())
                .add(MetalcoreItems.DEEPSLATE_ALUMINUM_ORE.get());
        tag(MetalItemTags.LEAD_ORES)
                .add(MetalcoreItems.LEAD_ORE.get())
                .add(MetalcoreItems.DEEPSLATE_LEAD_ORE.get());
        tag(MetalItemTags.SILICON_ORES)
                .add(MetalcoreItems.SILICON_ORE.get())
                .add(MetalcoreItems.DEEPSLATE_SILICON_ORE.get());
        tag(MetalItemTags.SILVER_ORES)
                .add(MetalcoreItems.SILVER_ORE.get())
                .add(MetalcoreItems.DEEPSLATE_SILVER_ORE.get())
                .add(MetalcoreItems.END_SILVER_ORE.get());
        tag(MetalItemTags.TIN_ORES)
                .add(MetalcoreItems.TIN_ORE.get())
                .add(MetalcoreItems.DEEPSLATE_TIN_ORE.get());

        tag(MetalItemTags.STORAGE_BLOCKS_ALUMINUM)
                .add(MetalcoreItems.ALUMINUM_BLOCK.get());
        tag(MetalItemTags.STORAGE_BLOCKS_LEAD)
                .add(MetalcoreItems.LEAD_BLOCK.get());
        tag(MetalItemTags.STORAGE_BLOCKS_SILVER)
                .add(MetalcoreItems.SILVER_BLOCK.get());
        tag(MetalItemTags.STORAGE_BLOCKS_TIN)
                .add(MetalcoreItems.TIN_BLOCK.get());

        tag(MetalItemTags.STORAGE_BLOCKS_RAW_ALUMINUM)
                .add(MetalcoreItems.RAW_ALUMINUM_BLOCK.get());
        tag(MetalItemTags.STORAGE_BLOCKS_RAW_LEAD)
                .add(MetalcoreItems.RAW_LEAD_BLOCK.get());
        tag(MetalItemTags.STORAGE_BLOCKS_RAW_SILICON)
                .add(MetalcoreItems.RAW_SILICON_BLOCK.get());
        tag(MetalItemTags.STORAGE_BLOCKS_RAW_SILVER)
                .add(MetalcoreItems.RAW_SILVER_BLOCK.get());
        tag(MetalItemTags.STORAGE_BLOCKS_RAW_TIN)
                .add(MetalcoreItems.RAW_TIN_BLOCK.get());

        tag(MetalItemTags.RAW_BLOCKS_ALUMINUM)
                .add(MetalcoreItems.RAW_ALUMINUM_BLOCK.get());
        tag(MetalItemTags.RAW_BLOCKS_LEAD)
                .add(MetalcoreItems.RAW_LEAD_BLOCK.get());
        tag(MetalItemTags.RAW_BLOCKS_SILICON)
                .add(MetalcoreItems.RAW_SILICON_BLOCK.get());
        tag(MetalItemTags.RAW_BLOCKS_SILVER)
                .add(MetalcoreItems.RAW_SILVER_BLOCK.get());
        tag(MetalItemTags.RAW_BLOCKS_TIN)
                .add(MetalcoreItems.RAW_TIN_BLOCK.get());

        tag(MetalItemTags.INGOTS_ALUMINUM)
                .add(MetalcoreItems.ALUMINUM_INGOT.get());
        tag(MetalItemTags.INGOTS_LEAD)
                .add(MetalcoreItems.LEAD_INGOT.get());
        tag(MetalItemTags.INGOTS_SILVER)
                .add(MetalcoreItems.SILVER_INGOT.get());
        tag(MetalItemTags.INGOTS_STEEL)
                .add(MetalcoreItems.STEEL_INGOT.get());
        tag(MetalItemTags.INGOTS_TIN)
                .add(MetalcoreItems.TIN_INGOT.get());

        tag(MetalItemTags.DUSTS_COPPER)
                .add(MetalcoreItems.COPPER_DUST.get());

        tag(MetalItemTags.DUSTS_DIAMOND)
            .add(MetalcoreItems.DIAMOND_DUST.get());

        tag(MetalItemTags.DUSTS_EMERALD)
                .add(MetalcoreItems.EMERALD_DUST.get());

        tag(MetalItemTags.DUSTS_GOLD)
                .add(MetalcoreItems.GOLD_DUST.get());

        tag(MetalItemTags.DUSTS_IRON)
                .add(MetalcoreItems.IRON_DUST.get());

        tag(MetalItemTags.DUSTS_LAPIS_LAZULI)
                .add(MetalcoreItems.LAPIS_LAZULI_DUST.get());

        tag(MetalItemTags.RAW_MATERIALS_ALUMINUM)
                .add(MetalcoreItems.RAW_ALUMINUM.get());
        tag(MetalItemTags.RAW_MATERIALS_LEAD)
                .add(MetalcoreItems.RAW_LEAD.get());
        tag(MetalItemTags.RAW_MATERIALS_SILICON)
                .add(MetalcoreItems.RAW_SILICON.get());
        tag(MetalItemTags.RAW_MATERIALS_SILVER)
                .add(MetalcoreItems.RAW_SILVER.get());
        tag(MetalItemTags.RAW_MATERIALS_TIN)
            .add(MetalcoreItems.RAW_TIN.get());

        tag(MetalItemTags.DUSTS_ALUMINUM)
                .add(MetalcoreItems.ALUMINUM_DUST.get());
        tag(MetalItemTags.DUSTS_LEAD)
                .add(MetalcoreItems.LEAD_DUST.get());
        tag(MetalItemTags.DUSTS_SILICON)
                .add(MetalcoreItems.SILICON_DUST.get());
        tag(MetalItemTags.DUSTS_SILVER)
                .add(MetalcoreItems.SILVER_DUST.get());
        tag(MetalItemTags.DUSTS_STEEL)
                .add(MetalcoreItems.STEEL_DUST.get());
        tag(MetalItemTags.DUSTS_TIN)
                .add(MetalcoreItems.TIN_DUST.get());

        tag(MetalItemTags.METALS)
                .addTag(MetalItemTags.METAL_ALUMINUM)
                .addTag(MetalItemTags.METAL_COPPER)
                .addTag(MetalItemTags.METAL_GOLD)
                .addTag(MetalItemTags.METAL_IRON)
                .addTag(MetalItemTags.METAL_LEAD)
                .addTag(MetalItemTags.METAL_NETHERITE)
                .addTag(MetalItemTags.METAL_SILVER)
                .addTag(MetalItemTags.METAL_TIN);

        tag(MetalItemTags.METAL_ALUMINUM)
                .add(MetalcoreItems.ALUMINUM_ORE.get())
                .add(MetalcoreItems.DEEPSLATE_ALUMINUM_ORE.get())
                .add(MetalcoreItems.ALUMINUM_BLOCK.get())
                .add(MetalcoreItems.RAW_ALUMINUM_BLOCK.get())
                .add(MetalcoreItems.RAW_ALUMINUM.get())
                .add(MetalcoreItems.ALUMINUM_INGOT.get())
                .add(MetalcoreItems.ALUMINUM_DUST.get());
        tag(MetalItemTags.METAL_COPPER)
                .add(Items.COPPER_ORE)
                .add(Items.DEEPSLATE_COPPER_ORE)
                .add(Items.COPPER_BLOCK)
                .add(Items.RAW_COPPER_BLOCK)
                .add(Items.RAW_COPPER)
                .add(Items.COPPER_INGOT)
                .add(MetalcoreItems.COPPER_DUST.get());
        tag(MetalItemTags.METAL_GOLD)
                .add(Items.GOLD_ORE)
                .add(Items.DEEPSLATE_GOLD_ORE)
                .add(Items.NETHER_GOLD_ORE)
                .add(Items.GOLD_BLOCK)
                .add(Items.RAW_GOLD_BLOCK)
                .add(Items.RAW_GOLD)
                .add(Items.GOLD_INGOT)
                .add(MetalcoreItems.GOLD_DUST.get());
        tag(MetalItemTags.METAL_IRON)
                .add(Items.IRON_ORE)
                .add(Items.DEEPSLATE_IRON_ORE)
                .add(Items.IRON_BLOCK)
                .add(Items.RAW_IRON_BLOCK)
                .add(Items.RAW_IRON)
                .add(Items.IRON_INGOT)
                .add(MetalcoreItems.IRON_DUST.get());
        tag(MetalItemTags.METAL_LEAD)
                .add(MetalcoreItems.LEAD_ORE.get())
                .add(MetalcoreItems.DEEPSLATE_LEAD_ORE.get())
                .add(MetalcoreItems.LEAD_BLOCK.get())
                .add(MetalcoreItems.RAW_LEAD_BLOCK.get())
                .add(MetalcoreItems.RAW_LEAD.get())
                .add(MetalcoreItems.LEAD_INGOT.get())
                .add(MetalcoreItems.LEAD_DUST.get());
        tag(MetalItemTags.METAL_NETHERITE)
                .add(Items.ANCIENT_DEBRIS)
                .add(Items.NETHERITE_BLOCK)
                .add(Items.NETHERITE_SCRAP)
                .add(Items.NETHERITE_INGOT);
                //.add(MetalcoreItems.NETHERITE_DUST.get());
        tag(MetalItemTags.METAL_SILVER)
                .add(MetalcoreItems.SILVER_ORE.get())
                .add(MetalcoreItems.DEEPSLATE_SILVER_ORE.get())
                .add(MetalcoreItems.SILVER_BLOCK.get())
                .add(MetalcoreItems.RAW_SILVER_BLOCK.get())
                .add(MetalcoreItems.RAW_SILVER.get())
                .add(MetalcoreItems.SILVER_INGOT.get())
                .add(MetalcoreItems.SILVER_DUST.get());
        tag(MetalItemTags.METAL_TIN)
                .add(MetalcoreItems.TIN_ORE.get())
                .add(MetalcoreItems.DEEPSLATE_TIN_ORE.get())
                .add(MetalcoreItems.TIN_BLOCK.get())
                .add(MetalcoreItems.RAW_TIN_BLOCK.get())
                .add(MetalcoreItems.RAW_TIN.get())
                .add(MetalcoreItems.TIN_INGOT.get())
                .add(MetalcoreItems.TIN_DUST.get());

        tag(MetalItemTags.ALLOYS)
                //.addTag(MetalItemTags.METAL_BRONZE)
                .addTag(MetalItemTags.ALLOY_STEEL);

        tag(MetalItemTags.ALLOY_STEEL)
                .add(MetalcoreItems.STEEL_INGOT.get())
                .add(MetalcoreItems.STEEL_DUST.get());
    }

    private void addVanillaTags() {
        tag(ItemTags.AXES)
                .add(MetalcoreItems.STEEL_AXE.get());
        tag(ItemTags.HOES)
                .add(MetalcoreItems.STEEL_HOE.get());
        tag(ItemTags.PICKAXES)
                .add(MetalcoreItems.STEEL_PICKAXE.get());
        tag(ItemTags.SHOVELS)
                .add(MetalcoreItems.STEEL_SHOVEL.get());
        tag(ItemTags.SWORDS)
                .add(MetalcoreItems.STEEL_SWORD.get());

        tag(ItemTags.HEAD_ARMOR)
                .add(MetalcoreItems.STEEL_HELMET.get());
        tag(ItemTags.CHEST_ARMOR)
                .add(MetalcoreItems.STEEL_CHESTPLATE.get());
        tag(ItemTags.LEG_ARMOR)
                .add(MetalcoreItems.STEEL_LEGGINGS.get());
        tag(ItemTags.FOOT_ARMOR)
                .add(MetalcoreItems.STEEL_BOOTS.get());

        tag(ItemTags.CLUSTER_MAX_HARVESTABLES)
                .add(MetalcoreItems.STEEL_PICKAXE.get());
    }

    private void addNeoForgeTags() {
        tag(Tags.Items.ORES)
                .addTag(MetalItemTags.ALUMINUM_ORES)
                .addTag(MetalItemTags.LEAD_ORES)
                .addTag(MetalItemTags.SILICON_ORES)
                .addTag(MetalItemTags.SILVER_ORES)
                .addTag(MetalItemTags.TIN_ORES);

        tag(Tags.Items.RAW_BLOCKS)
                .addTag(MetalItemTags.RAW_BLOCKS_ALUMINUM)
                .addTag(MetalItemTags.RAW_BLOCKS_LEAD)
                .addTag(MetalItemTags.RAW_BLOCKS_SILICON)
                .addTag(MetalItemTags.RAW_BLOCKS_SILVER)
                .addTag(MetalItemTags.RAW_BLOCKS_TIN);

        tag(Tags.Items.STORAGE_BLOCKS)
                .addTag(MetalItemTags.STORAGE_BLOCKS_ALUMINUM)
                .addTag(MetalItemTags.STORAGE_BLOCKS_RAW_ALUMINUM)
                .addTag(MetalItemTags.STORAGE_BLOCKS_LEAD)
                .addTag(MetalItemTags.STORAGE_BLOCKS_RAW_LEAD)
                .addTag(MetalItemTags.STORAGE_BLOCKS_RAW_SILICON)
                .addTag(MetalItemTags.STORAGE_BLOCKS_SILVER)
                .addTag(MetalItemTags.STORAGE_BLOCKS_RAW_SILVER)
                .addTag(MetalItemTags.STORAGE_BLOCKS_TIN)
                .addTag(MetalItemTags.STORAGE_BLOCKS_RAW_TIN);

        tag(Tags.Items.ORE_RATES_DENSE)
                .add(MetalcoreItems.ALUMINUM_ORE.get())
                .add(MetalcoreItems.LEAD_ORE.get())
                .add(MetalcoreItems.TIN_ORE.get());

        tag(Tags.Items.ORE_RATES_SPARSE)
                .add(MetalcoreItems.SILVER_ORE.get());

        tag(Tags.Items.ORE_RATES_SINGULAR)
                .add(MetalcoreItems.DEEPSLATE_ALUMINUM_ORE.get())
                .add(MetalcoreItems.DEEPSLATE_LEAD_ORE.get())
                .add(MetalcoreItems.DEEPSLATE_SILICON_ORE.get())
                .add(MetalcoreItems.DEEPSLATE_SILVER_ORE.get())
                .add(MetalcoreItems.DEEPSLATE_TIN_ORE.get())
                .add(MetalcoreItems.SILICON_ORE.get());

        tag(Tags.Items.RAW_MATERIALS)
                .addTag(MetalItemTags.RAW_MATERIALS_ALUMINUM)
                .addTag(MetalItemTags.RAW_MATERIALS_LEAD)
                .addTag(MetalItemTags.RAW_MATERIALS_SILICON)
                .addTag(MetalItemTags.RAW_MATERIALS_SILVER)
                .addTag(MetalItemTags.RAW_MATERIALS_TIN);

        tag(Tags.Items.INGOTS)
                .addTag(MetalItemTags.INGOTS_ALUMINUM)
                .addTag(MetalItemTags.INGOTS_LEAD)
                .addTag(MetalItemTags.INGOTS_SILVER)
                .addTag(MetalItemTags.INGOTS_STEEL)
                .addTag(MetalItemTags.INGOTS_TIN);

        tag(Tags.Items.DUSTS)
                .addTag(MetalItemTags.DUSTS_ALUMINUM)
                .addTag(MetalItemTags.DUSTS_COPPER)
                .addTag(MetalItemTags.DUSTS_DIAMOND)
                .addTag(MetalItemTags.DUSTS_EMERALD)
                .addTag(MetalItemTags.DUSTS_GOLD)
                .addTag(MetalItemTags.DUSTS_IRON)
                .addTag(MetalItemTags.DUSTS_LAPIS_LAZULI)
                .addTag(MetalItemTags.DUSTS_LEAD)
                .addTag(MetalItemTags.DUSTS_SILICON)
                .addTag(MetalItemTags.DUSTS_SILVER)
                .addTag(MetalItemTags.DUSTS_STEEL)
                .addTag(MetalItemTags.DUSTS_TIN);
    }
}
