package io.kalishak.metalcore.api.item;

import io.kalishak.metalcore.api.block.WeatheringCopperHolder;
import io.kalishak.metalcore.api.datamaps.MetalcoreApiDatamaps;
import io.kalishak.metalcore.api.datamaps.WeatheringItemDataMap;
import io.kalishak.metalcore.component.MetalcoreComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.items.IItemHandler;
import org.jetbrains.annotations.Nullable;

public class SwapableWeatheringCopperItem extends Item implements WeatheringCopperItem {
    protected static final float BASE_CHANCE = 0.0013666F;
    protected final WeatheringCopperHolder.WeatherState weatherState;

    public SwapableWeatheringCopperItem(WeatheringCopperHolder.WeatherState weatherState, Properties pProperties) {
        super(pProperties.component(MetalcoreComponents.WAXED, false));
        this.weatherState = weatherState;
    }

    @Override
    public WeatheringCopperHolder.WeatherState getWeatheredState(ItemStack stack) {
        return this.weatherState;
    }

    protected boolean isWaxed(ItemStack stack) {
        var data = stack.get(MetalcoreComponents.WAXED);

        return data != null && data;
    }

    @Nullable
    protected WeatheringCopperHolder.WeatherState nextState(ItemStack stack) {
        if (isWaxed(stack) || this.weatherState == WeatheringCopperHolder.WeatherState.OXIDIZED) {
            return null;
        }

        int i = Math.min(this.weatherState.ordinal() + 1, WeatheringCopperHolder.WeatherState.values().length - 1);
        return WeatheringCopperHolder.WeatherState.values()[i];
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);

        changeOverTime(pStack, pLevel, pEntity, pSlotId);
    }

    @Override
    public void changeOverTime(ItemStack stack, Level level, Entity entity, int slotId) {
        if (!level.isClientSide) {
            if (!isWaxed(stack)) {
                IItemHandler itemHandler = entity.getCapability(Capabilities.ItemHandler.ENTITY);
                WeatheringItemDataMap weatheringItemDataMap = stack.getItemHolder().getData(MetalcoreApiDatamaps.WEATHERING_ITEM);
                if (itemHandler != null && weatheringItemDataMap != null && weatheringItemDataMap.nextWeatheringItem().isPresent()) {
                    Item item = BuiltInRegistries.ITEM.get(weatheringItemDataMap.nextWeatheringItem().get());

                    if (item != null && shouldWeather(stack, level)) {
                        ItemStack nextStack = new ItemStack(item, stack.getCount());
                        itemHandler.insertItem(slotId, nextStack, false);
                    }
                }
            }
        }
    }

    @Override
    public float getChance(ItemStack stack) {
        return (this.weatherState == WeatheringCopperHolder.WeatherState.UNAFFECTED ? 0.75F : 1.0F) * BASE_CHANCE;
    }
}
