package io.kalishak.metalcore.api.foundry;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.ApiStatus;

import java.util.List;
import java.util.function.Supplier;

@Deprecated
@ApiStatus.ScheduledForRemoval(inVersion = "1.1")
public record TierMaterial(int uses, float speed,
                           float attackDamageBonus,
                           TagKey<Block> incorrectBlocksForDrops,
                           int enchantmentValue,
                           Supplier<Ingredient> repairIngredient) implements Tier {
    public static final ResourceKey<Registry<Tier>> REGISTRY_KEY = ResourceKey.createRegistryKey(new ResourceLocation("tier_material"));
    //public static final Codec<Holder<Tier>> CODEC = MetalcoreRegistries.TIER_MATERIALS.holderByNameCodec();

    @Override
    @Deprecated
    public int getUses() {
        return uses();
    }

    @Override
    @Deprecated
    public float getSpeed() {
        return speed();
    }

    @Override
    @Deprecated
    public float getAttackDamageBonus() {
        return attackDamageBonus();
    }

    @Override
    @Deprecated
    public TagKey<Block> getIncorrectBlocksForDrops() {
        return incorrectBlocksForDrops();
    }

    @Override
    @Deprecated
    public int getEnchantmentValue() {
        return enchantmentValue();
    }

    @Override
    @Deprecated
    public Ingredient getRepairIngredient() {
        return repairIngredient().get();
    }

    public Tool createToolProperties(TagKey<Block> correctDrops) {
        return new Tool(List.of(Tool.Rule.deniesDrops(this.incorrectBlocksForDrops), Tool.Rule.minesAndDrops(correctDrops, this.speed)), 1.0F, 1);
    }
}
