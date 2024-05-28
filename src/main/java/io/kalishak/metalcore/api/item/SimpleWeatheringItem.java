package io.kalishak.metalcore.api.item;

import io.kalishak.metalcore.api.block.WeatheringCopperHolder;
import io.kalishak.metalcore.component.MetalcoreComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

public class SimpleWeatheringItem extends Item implements WeatheringCopperItem {
    public SimpleWeatheringItem(Properties pProperties) {
        super(pProperties.component(MetalcoreComponents.WEATHERED_ITEM, new WeatheredComponent(WeatheringCopperHolder.WeatherState.UNAFFECTED, false)));
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
