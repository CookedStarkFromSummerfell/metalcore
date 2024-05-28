package io.kalishak.metalcore.world.item;

import io.kalishak.metalcore.api.block.WeatheringCopperHolder;
import io.kalishak.metalcore.api.item.WeatheredComponent;
import io.kalishak.metalcore.api.item.WeatheringCopperItem;
import io.kalishak.metalcore.component.MetalcoreComponents;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

public class WeatheringShovelItem extends ShovelItem implements WeatheringCopperItem {
    public WeatheringShovelItem(Tier tier, Properties properties) {
        super(tier, properties.component(MetalcoreComponents.WEATHERED_ITEM, new WeatheredComponent(WeatheringCopperHolder.WeatherState.UNAFFECTED, false)));
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        if (!pLevel.isClientSide) {
            changeOverTime(pStack, pLevel, pEntity, pSlotId);
        }
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext cxt, List<Component> tooltip, TooltipFlag flag) {
        applyTooltip(stack, tooltip);
    }
}
