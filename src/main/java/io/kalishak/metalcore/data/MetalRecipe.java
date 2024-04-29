package io.kalishak.metalcore.data;

import io.kalishak.metalcore.tags.MetalItemTags;
import io.kalishak.metalcore.world.item.MetalcoreItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MetalRecipe extends RecipeProvider {
    public MetalRecipe(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
        super(packOutput, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        blastingRecipes(pRecipeOutput);
        craftingRecipes(pRecipeOutput);
        smeltingRecipes(pRecipeOutput);
    }

    private void craftingRecipes(RecipeOutput recipeOutput) {
        packedMetal(
                recipeOutput,
                MetalItemTags.INGOTS_ALUMINUM,
                MetalcoreItems.ALUMINUM_INGOT,
                MetalItemTags.STORAGE_BLOCKS_ALUMINUM,
                MetalcoreItems.ALUMINUM_BLOCK
        );
        packedMetal(
                recipeOutput,
                MetalItemTags.RAW_MATERIALS_ALUMINUM,
                MetalcoreItems.RAW_ALUMINUM,
                MetalItemTags.STORAGE_BLOCKS_RAW_LEAD,
                MetalcoreItems.RAW_ALUMINUM_BLOCK
        );

        packedMetal(
                recipeOutput,
                MetalItemTags.INGOTS_LEAD,
                MetalcoreItems.LEAD_INGOT,
                MetalItemTags.STORAGE_BLOCKS_LEAD,
                MetalcoreItems.LEAD_BLOCK
        );
        packedMetal(
                recipeOutput,
                MetalItemTags.RAW_MATERIALS_LEAD,
                MetalcoreItems.RAW_LEAD,
                MetalItemTags.STORAGE_BLOCKS_RAW_LEAD,
                MetalcoreItems.RAW_LEAD_BLOCK
        );

        packedMetal(
                recipeOutput,
                MetalItemTags.RAW_MATERIALS_SILICON,
                MetalcoreItems.RAW_SILICON,
                MetalItemTags.STORAGE_BLOCKS_RAW_SILICON,
                MetalcoreItems.RAW_SILICON_BLOCK
        );

        packedMetal(
                recipeOutput,
                MetalItemTags.INGOTS_SILVER,
                MetalcoreItems.SILVER_INGOT,
                MetalItemTags.STORAGE_BLOCKS_SILVER,
                MetalcoreItems.SILVER_BLOCK
        );
        packedMetal(
                recipeOutput,
                MetalItemTags.RAW_MATERIALS_SILVER,
                MetalcoreItems.RAW_SILVER,
                MetalItemTags.STORAGE_BLOCKS_RAW_SILVER,
                MetalcoreItems.RAW_SILVER_BLOCK
        );

        packedMetal(
                recipeOutput,
                MetalItemTags.INGOTS_TIN,
                MetalcoreItems.TIN_INGOT,
                MetalItemTags.STORAGE_BLOCKS_TIN,
                MetalcoreItems.TIN_BLOCK
        );
        packedMetal(
                recipeOutput,
                MetalItemTags.RAW_MATERIALS_TIN,
                MetalcoreItems.RAW_TIN,
                MetalItemTags.STORAGE_BLOCKS_RAW_TIN,
                MetalcoreItems.RAW_TIN_BLOCK
        );
    }

    private void smeltingRecipes(RecipeOutput recipeOutput) {
        oreSmelting(
                recipeOutput,
                List.of(MetalcoreItems.ALUMINUM_ORE, MetalcoreItems.DEEPSLATE_ALUMINUM_ORE, MetalcoreItems.RAW_ALUMINUM),
                RecipeCategory.MISC,
                MetalcoreItems.ALUMINUM_INGOT,
                0.4F,
                200,
                "aluminum"
        );

        oreSmelting(
                recipeOutput,
                List.of(MetalcoreItems.LEAD_ORE, MetalcoreItems.DEEPSLATE_LEAD_ORE, MetalcoreItems.RAW_LEAD),
                RecipeCategory.MISC,
                MetalcoreItems.LEAD_INGOT,
                0.4F,
                200,
                "lead"
        );

        oreSmelting(
                recipeOutput,
                List.of(MetalcoreItems.SILICON_ORE, MetalcoreItems.DEEPSLATE_SILICON_ORE),
                RecipeCategory.MISC,
                MetalcoreItems.RAW_SILICON,
                0.3F,
                200,
                "silicon"
        );

        oreSmelting(
                recipeOutput,
                List.of(MetalcoreItems.SILVER_ORE, MetalcoreItems.DEEPSLATE_SILVER_ORE, MetalcoreItems.RAW_SILVER),
                RecipeCategory.MISC,
                MetalcoreItems.SILVER_INGOT,
                0.4F,
                200,
                "silver"
        );

        oreSmelting(
                recipeOutput,
                List.of(MetalcoreItems.TIN_ORE, MetalcoreItems.DEEPSLATE_TIN_ORE, MetalcoreItems.RAW_TIN),
                RecipeCategory.MISC,
                MetalcoreItems.TIN_INGOT,
                0.4F,
                200,
                "tin"
        );
    }

    private void blastingRecipes(RecipeOutput recipeOutput) {
        oreBlasting(
                recipeOutput,
                List.of(MetalcoreItems.ALUMINUM_ORE, MetalcoreItems.DEEPSLATE_ALUMINUM_ORE, MetalcoreItems.RAW_ALUMINUM),
                RecipeCategory.MISC,
                MetalcoreItems.ALUMINUM_INGOT,
                0.2F,
                100,
                "aluminum"
        );

        oreBlasting(
                recipeOutput,
                List.of(MetalcoreItems.LEAD_ORE, MetalcoreItems.DEEPSLATE_LEAD_ORE, MetalcoreItems.RAW_LEAD),
                RecipeCategory.MISC,
                MetalcoreItems.LEAD_INGOT,
                0.2F,
                100,
                "lead"
        );

        oreBlasting(
                recipeOutput,
                List.of(MetalcoreItems.SILICON_ORE, MetalcoreItems.DEEPSLATE_SILICON_ORE),
                RecipeCategory.MISC,
                MetalcoreItems.RAW_SILICON,
                0.1F,
                100,
                "silicon"
        );

        oreBlasting(
                recipeOutput,
                List.of(MetalcoreItems.SILVER_ORE, MetalcoreItems.DEEPSLATE_SILVER_ORE, MetalcoreItems.END_SILVER_ORE, MetalcoreItems.RAW_SILVER),
                RecipeCategory.MISC,
                MetalcoreItems.SILVER_INGOT,
                0.2F,
                100,
                "silver"
        );

        oreBlasting(
                recipeOutput,
                List.of(MetalcoreItems.TIN_ORE, MetalcoreItems.DEEPSLATE_TIN_ORE, MetalcoreItems.RAW_TIN),
                RecipeCategory.MISC,
                MetalcoreItems.TIN_INGOT,
                0.2F,
                100,
                "tin"
        );
    }

    private static void packedMetal(RecipeOutput recipeOutput, TagKey<Item> unpacked, ItemLike unpackedDefault, TagKey<Item> packed, ItemLike packedDefault) {
        packedMetal(
                recipeOutput,
                Ingredient.of(unpacked),
                unpackedDefault,
                Ingredient.of(packed),
                packedDefault,
                getSimpleRecipeName(packedDefault),
                getSimpleRecipeName(unpackedDefault)
        );
    }

    static void packedMetal(RecipeOutput pRecipeOutput, Ingredient pUnpacked, ItemLike unpackedDefaultItem, Ingredient pPacked, ItemLike packedDefaultItem, String pPackedName, String pUnpackedName) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, unpackedDefaultItem, 9)
                .requires(pPacked)
                .unlockedBy(getHasName(packedDefaultItem), has(packedDefaultItem))
                .save(pRecipeOutput, new ResourceLocation(pUnpackedName));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, packedDefaultItem)
                .define('#', pUnpacked)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .unlockedBy(getHasName(unpackedDefaultItem), has(unpackedDefaultItem))
                .save(pRecipeOutput, new ResourceLocation(pPackedName));
    }
}
