package io.kalishak.metalcore.api.tier;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.kalishak.metalcore.Metalcore;
import io.kalishak.metalcore.MetalcoreRegistries;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.ApiStatus;

public record TierMaterial(int uses, float speed, float attackDamageBonus, TagKey<Block> incorrectBlocksForDrops,
                           int echantmentValue, Ingredient repairIngredient) implements Tier {
    public static final ResourceKey<Registry<TierMaterial>> REGISTRY_KEY = ResourceKey.createRegistryKey(new ResourceLocation(Metalcore.MODID, "tier_material"));
    public static final Codec<TierMaterial> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.INT.fieldOf("uses").forGetter(TierMaterial::uses),
            Codec.FLOAT.fieldOf("speed").forGetter(TierMaterial::speed),
            Codec.FLOAT.fieldOf("attack_damage_bonus").forGetter(TierMaterial::attackDamageBonus),
            TagKey.codec(Registries.BLOCK).fieldOf("incorrect_blocks_for_drops").forGetter(TierMaterial::incorrectBlocksForDrops),
            Codec.INT.fieldOf("enchantment_value").forGetter(TierMaterial::echantmentValue),
            Ingredient.CODEC.fieldOf("repair_ingredient").forGetter(TierMaterial::repairIngredient)
    ).apply(instance, TierMaterial::new));

    @ApiStatus.Internal
    public static TierMaterial ofVanilla(Tier tier) {
        return new TierMaterial(
                tier.getUses(),
                tier.getSpeed(),
                tier.getAttackDamageBonus(),
                tier.getIncorrectBlocksForDrops(),
                tier.getEnchantmentValue(),
                tier.getRepairIngredient()
        );
    }

    @Override
    public int getUses() {
        return this.uses;
    }

    @Override
    public float getSpeed() {
        return this.speed;
    }

    @Override
    public float getAttackDamageBonus() {
        return this.attackDamageBonus;
    }

    @Override
    public TagKey<Block> getIncorrectBlocksForDrops() {
        return this.incorrectBlocksForDrops;
    }

    @Override
    public int getEnchantmentValue() {
        return this.echantmentValue;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient;
    }
}
