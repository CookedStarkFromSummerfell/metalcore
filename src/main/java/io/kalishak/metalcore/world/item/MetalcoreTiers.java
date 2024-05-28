package io.kalishak.metalcore.world.item;

import io.kalishak.metalcore.Metalcore;
import io.kalishak.metalcore.api.foundry.TierMaterial;
import io.kalishak.metalcore.tags.MetalItemTags;
import net.minecraft.core.Holder;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.SimpleTier;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class MetalcoreTiers {
    /*public static final DeferredRegister<Tier> TIERS = DeferredRegister.create(TierMaterial.REGISTRY_KEY, Metalcore.MODID);

    public static final Holder<Tier> STEEL = TIERS.register("steel", () -> new TierMaterial(
            320, 5.0F, 3.0F, BlockTags.INCORRECT_FOR_IRON_TOOL, 9, () -> Ingredient.of(MetalItemTags.INGOTS_STEEL))
    );
    public static final Holder<Tier> COPPER = TIERS.register("copper", () -> new TierMaterial(
            216, 4.0F, 1.5F, BlockTags.INCORRECT_FOR_STONE_TOOL, 11, () -> Ingredient.of(Tags.Items.INGOTS_COPPER))
    );*/
    public static final Tier STEEL = new SimpleTier(
            BlockTags.INCORRECT_FOR_IRON_TOOL,320, 5.0F, 3.0F, 9, () -> Ingredient.of(MetalItemTags.INGOTS_STEEL)
    );
    public static final Tier COPPER = new SimpleTier(
            BlockTags.INCORRECT_FOR_STONE_TOOL, 216, 4.0F, 1.5F, 11, () -> Ingredient.of(Tags.Items.INGOTS_COPPER)
    );

    public static void init(IEventBus bus) {
        //TIERS.register(bus);
    }
}
