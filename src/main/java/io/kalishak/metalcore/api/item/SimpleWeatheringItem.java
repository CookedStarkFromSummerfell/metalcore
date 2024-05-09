package io.kalishak.metalcore.api.item;

import io.kalishak.metalcore.api.block.WeatheringCopperHolder;
import io.kalishak.metalcore.component.MetalcoreComponents;
import io.kalishak.metalcore.config.MetalcoreConfig;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class SimpleWeatheringItem extends Item implements WeatheringCopperItem {
    protected final float chance;

    public SimpleWeatheringItem(float chance, Properties pProperties) {
        super(pProperties
                .component(MetalcoreComponents.WEATHERED_ITEM, new WeatheredComponent(WeatheringCopperHolder.WeatherState.UNAFFECTED, false))
                .component(MetalcoreComponents.TICK_CHECK, 0));
        this.chance = chance;
    }

    @Override
    public float getChance(ItemStack stack) {
        WeatheredComponent weatheredComponent = stack.get(MetalcoreComponents.WEATHERED_ITEM);
        return weatheredComponent == null ? 0.0F : (weatheredComponent.age() == WeatheringCopperHolder.WeatherState.UNAFFECTED ? 0.75F : this.chance);
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);

        if (!MetalcoreConfig.SERVER.useDurabilityNotRandom.get()) {
            WeatheredComponent weatheredComponent = pStack.get(MetalcoreComponents.WEATHERED_ITEM);

            if (weatheredComponent != null) {
                if (weatheredComponent.age() != WeatheringCopperHolder.WeatherState.OXIDIZED) {
                    changeOverTime(pStack, pLevel, pEntity);
                } else {
                    pStack.remove(MetalcoreComponents.WEATHERED_ITEM);
                }
            }
        }
    }
}
