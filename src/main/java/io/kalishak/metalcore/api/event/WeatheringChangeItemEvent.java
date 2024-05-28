package io.kalishak.metalcore.api.event;

import io.kalishak.metalcore.api.item.WeatheredComponent;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.Event;

public class WeatheringChangeItemEvent extends Event {
    private final ItemStack weatheringItem;
    private final WeatheredComponent oldState;
    private final WeatheredComponent newState;

    public WeatheringChangeItemEvent(ItemStack weatheringItem, WeatheredComponent oldState, WeatheredComponent newState) {
        this.weatheringItem = weatheringItem;
        this.oldState = oldState;
        this.newState = newState;
    }

    public ItemStack getItem() {
        return this.weatheringItem;
    }

    public WeatheredComponent getOldState() {
        return this.oldState;
    }

    public WeatheredComponent getNewState() {
        return this.newState;
    }
}
