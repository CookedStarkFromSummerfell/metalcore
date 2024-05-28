package io.kalishak.metalcore.api.event;

import io.kalishak.metalcore.api.block.WeatheringCopperHolder;
import net.minecraft.world.entity.item.ItemEntity;
import net.neoforged.neoforge.event.entity.item.ItemEvent;

public class WeatheringChangeItemEntityEvent extends ItemEvent {
    private final WeatheringCopperHolder.WeatherState oldState;
    private final WeatheringCopperHolder.WeatherState newState;

    public WeatheringChangeItemEntityEvent(ItemEntity itemEntity, WeatheringCopperHolder.WeatherState oldState, WeatheringCopperHolder.WeatherState newState) {
        super(itemEntity);
        this.oldState = oldState;
        this.newState = newState;
    }

    public WeatheringCopperHolder.WeatherState getOldState() {
        return this.oldState;
    }

    public WeatheringCopperHolder.WeatherState getNewState() {
        return this.newState;
    }
}
