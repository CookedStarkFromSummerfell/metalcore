package io.kalishak.metalcore.world.item;

import io.kalishak.metalcore.api.tier.TierMaterial;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class TieredToolItem extends Item {
    protected final Holder<TierMaterial> tier;

    public TieredToolItem(Holder<TierMaterial> tier, Item.Properties properties) {
        super(properties);
        this.tier = tier;
    }

    public Holder<TierMaterial> getTier() {
        return this.tier;
    }

    @Override
    public int getEnchantmentValue(ItemStack stack) {
        return this.tier.value().getEnchantmentValue();
    }

    @Override
    public boolean isValidRepairItem(ItemStack pStack, ItemStack pRepairCandidate) {
        return this.tier.value().getRepairIngredient().test(pRepairCandidate) || super.isValidRepairItem(pStack, pRepairCandidate);
    }
}
