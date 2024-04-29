package io.kalishak.metalcore.world.item;

import io.kalishak.metalcore.api.tier.TierMaterial;
import io.kalishak.metalcore.tags.MetalItemTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.bus.api.IEventBus;

public final class MetalcoreTiers {
    public static final TierMaterial STEEL = new TierMaterial(320, 5.0F, 3.0F, BlockTags.INCORRECT_FOR_IRON_TOOL, 9, Ingredient.of(MetalItemTags.INGOTS_STEEL));
    /*public static final DeferredRegister<TierMaterial> TIERS = DeferredRegister.create(TierMaterial.REGISTRY_KEY, Metalcore.MODID);

    public static final DeferredHolder<TierMaterial, TierMaterial> WOOD = TIERS.register("wood", () -> TierMaterial
            .ofVanilla(Tiers.WOOD));
    public static final DeferredHolder<TierMaterial, TierMaterial> STONE = TIERS.register("stone", () -> TierMaterial
            .ofVanilla(Tiers.STONE));
    public static final DeferredHolder<TierMaterial, TierMaterial> IRON = TIERS.register("iron", () -> TierMaterial
            .ofVanilla(Tiers.IRON));
    public static final DeferredHolder<TierMaterial, TierMaterial> DIAMOND = TIERS.register("diamond", () -> TierMaterial
            .ofVanilla(Tiers.DIAMOND));
    public static final DeferredHolder<TierMaterial, TierMaterial> GOLD = TIERS.register("gold", () -> TierMaterial
            .ofVanilla(Tiers.GOLD));
    public static final DeferredHolder<TierMaterial, TierMaterial> NETHERITE = TIERS.register("netherite", () -> TierMaterial
            .ofVanilla(Tiers.NETHERITE));

    public static final DeferredHolder<TierMaterial, TierMaterial> STEEL = TIERS.register("steel", () -> new TierMaterial(
            320, 5.0F, 3.0F, BlockTags.INCORRECT_FOR_IRON_TOOL, 9, Ingredient.of(MetalItemTags.INGOTS_STEEL))
    );*/

    public static void init(IEventBus bus) {
        //TIERS.register(bus); // fixme Crashes at registry event
    }
}
