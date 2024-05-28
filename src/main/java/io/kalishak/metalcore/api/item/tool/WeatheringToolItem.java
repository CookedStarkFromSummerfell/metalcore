package io.kalishak.metalcore.api.item.tool;

import io.kalishak.metalcore.api.block.WeatheringCopperHolder;
import io.kalishak.metalcore.api.foundry.TierMaterial;
import io.kalishak.metalcore.api.item.SimpleWeatheringItem;
import io.kalishak.metalcore.api.item.WeatheredComponent;
import io.kalishak.metalcore.component.MetalcoreComponents;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class WeatheringToolItem extends SimpleWeatheringItem {
    protected final Holder<TierMaterial> tier;

    public WeatheringToolItem(Holder<TierMaterial> tier, Item.Properties properties) {
        super(properties);
        this.tier = tier;
    }

    public Holder<TierMaterial> getTier() {
        return this.tier;
    }

    @Override
    public int getEnchantmentValue(ItemStack stack) {
        return this.tier.value().enchantmentValue();
    }

    @Override
    public boolean isValidRepairItem(ItemStack pToRepair, ItemStack pRepair) {
        WeatheredComponent weatheredComponent = pToRepair.get(MetalcoreComponents.WEATHERED_ITEM);
        boolean flag = weatheredComponent == null;
        boolean repairable = super.isValidRepairItem(pToRepair, pRepair);

        if (!flag) {
            return repairable && weatheredComponent.age() == WeatheringCopperHolder.WeatherState.UNAFFECTED;
        }

        return repairable || canRepairWith(pToRepair, pRepair);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext cxt, List<Component> tooltip, TooltipFlag flag) {
        applyTooltip(stack, tooltip);
    }
}
