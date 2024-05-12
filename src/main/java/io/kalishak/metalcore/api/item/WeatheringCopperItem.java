package io.kalishak.metalcore.api.item;

import com.google.common.collect.Maps;
import io.kalishak.metalcore.api.block.WeatheringCopperHolder;
import io.kalishak.metalcore.component.MetalcoreComponents;
import net.minecraft.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.EnumMap;

public interface WeatheringCopperItem {
    EnumMap<WeatheringCopperHolder.WeatherState, Float> DURABILITY_PER_AGE_MODIFIER = Util.make(Maps.newEnumMap(WeatheringCopperHolder.WeatherState.class), map -> {
        map.put(WeatheringCopperHolder.WeatherState.UNAFFECTED, 1.0F);
        map.put(WeatheringCopperHolder.WeatherState.EXPOSED, 0.8F);
        map.put(WeatheringCopperHolder.WeatherState.WEATHERED, 0.6F);
        map.put(WeatheringCopperHolder.WeatherState.OXIDIZED, 0.45F);
    });

    ResourceLocation WEATHERING_STATE_PREDICATE = new ResourceLocation("c:weathering_state");

    static float getPredicate(ItemStack stack, LivingEntity livingEntity) {
        return (float) getWeatheredState(stack).ordinal();
    }

    static int durabilityForWeatheredState(ItemStack stack) {
        WeatheredComponent weatheredComponent = stack.get(MetalcoreComponents.WEATHERED_ITEM);
        int damage = stack.getDamageValue();

        if (weatheredComponent != null) {
            damage = Mth.floor(damage * DURABILITY_PER_AGE_MODIFIER.get(weatheredComponent.age()));
        }

        return damage;
    }

    static @Nullable WeatheredComponent getWeatheredComponent(ItemStack stack) {
        return stack.get(MetalcoreComponents.WEATHERED_ITEM);
    }

    static WeatheringCopperHolder.WeatherState getWeatheredState(ItemStack stack) {
        WeatheredComponent weatheredComponent = getWeatheredComponent(stack);
        return weatheredComponent != null ? weatheredComponent.age() : WeatheringCopperHolder.WeatherState.UNAFFECTED;
    }

    static Component getTranslatedNameWithState(ItemStack stack) {
        return Component.translatable("tooltip.metalcore.weathering_state", stack.getDisplayName());
    }

    default WeatheredComponent nextState(WeatheredComponent weatheredComponent) {
        if (weatheredComponent == null) {
            throw new IllegalStateException("WeatheredComponent is null!");
        }

        if (weatheredComponent.age() == WeatheringCopperHolder.WeatherState.OXIDIZED) {
            return weatheredComponent;
        }

        int i = Math.min(weatheredComponent.age().ordinal() + 1, WeatheringCopperHolder.WeatherState.values().length - 1);

        return new WeatheredComponent(WeatheringCopperHolder.WeatherState.values()[i], true);
    }

    default void changeOverTime(ItemStack stack, Level level, Entity entity) {
        WeatheredComponent weatheringComponent = getWeatheredComponent(stack);
        float f = level.isRainingAt(entity.getOnPos()) ? 2.0F : 1.0F;
        float chance = f * f * getChance(stack);

        if (level.random.nextFloat() < chance) {
            stack.set(MetalcoreComponents.WEATHERED_ITEM, nextState(weatheringComponent));
        }
    }

    default float getChance(ItemStack stack) {
        var component = getWeatheredComponent(stack);

        if (component == null) {
            return 0.0F;
        }

        return component.age() == WeatheringCopperHolder.WeatherState.UNAFFECTED ? 0.75F : 1.0F;
    }
}
