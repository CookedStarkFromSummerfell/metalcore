package io.kalishak.metalcore.api.item;

import com.google.common.collect.Maps;
import io.kalishak.metalcore.component.MetalcoreComponents;
import net.minecraft.Util;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.WeatheringCopper;
import org.jetbrains.annotations.Nullable;

import java.util.EnumMap;

public interface WeatheringCopperItem {
    EnumMap<WeatheringCopper.WeatherState, Float> DURABILITY_PER_AGE_MODIFIER = Util.make(Maps.newEnumMap(WeatheringCopper.WeatherState.class), map -> {
        map.put(WeatheringCopper.WeatherState.UNAFFECTED, 1.0F);
        map.put(WeatheringCopper.WeatherState.EXPOSED, 0.8F);
        map.put(WeatheringCopper.WeatherState.WEATHERED, 0.6F);
        map.put(WeatheringCopper.WeatherState.OXIDIZED, 0.45F);
    });

    static int durabilityForWeatheredState(ItemStack stack) {
        WeatheredComponent weatheredComponent = stack.get(MetalcoreComponents.WEATHERED_ITEM);
        int damage = stack.getDamageValue();

        if (weatheredComponent != null) {
            damage = Mth.floor(damage * DURABILITY_PER_AGE_MODIFIER.get(weatheredComponent.age()));
        }

        return damage;
    }

    default @Nullable WeatheredComponent getWeatheredComponent(ItemStack stack) {
        return stack.get(MetalcoreComponents.WEATHERED_ITEM);
    }

    default WeatheringCopper.WeatherState getWeatheredState(ItemStack stack) {
        WeatheredComponent weatheredComponent = getWeatheredComponent(stack);
        return weatheredComponent != null ? weatheredComponent.age() : WeatheringCopper.WeatherState.UNAFFECTED;
    }

    default WeatheringCopper.WeatherState nextState(ItemStack stack) {
        WeatheredComponent weatheredComponent = getWeatheredComponent(stack);

        if (weatheredComponent == null) {
            throw new IllegalStateException("WeatheredComponent is null!");
        }

        int i = Math.min(weatheredComponent.age().ordinal() + 1, WeatheringCopper.WeatherState.values().length - 1);

        return WeatheringCopper.WeatherState.values()[i];
    }

    float getChance(ItemStack stack);
}
