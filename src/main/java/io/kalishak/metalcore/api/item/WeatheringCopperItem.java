package io.kalishak.metalcore.api.item;

import io.kalishak.metalcore.api.block.WeatheringCopperHolder;
import io.kalishak.metalcore.api.event.WeatheringChangeItemEvent;
import io.kalishak.metalcore.api.registries.MetalcoreApiGameRules;
import io.kalishak.metalcore.component.MetalcoreComponents;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.NeoForge;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface WeatheringCopperItem {
    ResourceLocation WEATHERING_STATE_PREDICATE = new ResourceLocation("c:weathering_state");
    float BASE_CHANCE = 0.0013666F;

    static float getPredicate(ItemStack stack, @Nullable ClientLevel level, @Nullable LivingEntity entity, int seed) {
        if (stack.getItem() instanceof WeatheringCopperItem weatheringCopperItem) {
            return (float) weatheringCopperItem.getWeatheredState(stack).ordinal();
        }

        return 0.0F;
    }

    static @Nullable WeatheredComponent getWeatheredComponent(ItemStack stack) {
        return stack.get(MetalcoreComponents.WEATHERED_ITEM);
    }

    default WeatheringCopperHolder.WeatherState getWeatheredState(ItemStack stack) {
        WeatheredComponent weatheredComponent = getWeatheredComponent(stack);
        return weatheredComponent != null ? weatheredComponent.age() : WeatheringCopperHolder.WeatherState.UNAFFECTED;
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

    default void changeOverTime(ItemStack stack, Level level, Entity entity, int slotId) {
        WeatheredComponent weatheringComponent = getWeatheredComponent(stack);

        if (weatheringComponent != null && shouldWeather(stack, level)) {
            WeatheringChangeItemEvent event = new WeatheringChangeItemEvent(stack, weatheringComponent, nextState(weatheringComponent));
            NeoForge.EVENT_BUS.post(event);

            stack.set(MetalcoreComponents.WEATHERED_ITEM, event.getNewState());
        }
    }

    default float getChance(ItemStack stack) {
        var component = getWeatheredComponent(stack);

        if (component == null) {
            return 0.0F;
        }

        return (component.age() == WeatheringCopperHolder.WeatherState.UNAFFECTED ? 0.75F : 1.0F) * BASE_CHANCE;
    }

    default boolean shouldWeather(ItemStack stack, Level level) {
        float chance = getChance(stack);

        if (chance == 0.0F) {
            return false;
        }

        return level.random.nextFloat() < level.getGameRules().getRule(MetalcoreApiGameRules.RULE_WEATHERING_CHANCE).get() * chance / stack.getCount();
    }

    default boolean canRepairWith(ItemStack toRepair, ItemStack repairItem) {
        return false;
    }

    default void applyTooltip(ItemStack stack, List<Component> tooltip) {
        WeatheredComponent weatheringComponent = getWeatheredComponent(stack);

        if (weatheringComponent != null && weatheringComponent.showInTooltip()) {
            tooltip.add(Component
                    .translatable("item.c.weathering_state." + weatheringComponent.age().getSerializedName())
                    .withStyle(weatheringComponent.age().getTextColor())
            );
        }
    }
}
