package io.kalishak.metalcore.world.item;

import io.kalishak.metalcore.api.block.WeatheringCopperHolder;
import io.kalishak.metalcore.api.item.WeatheredComponent;
import io.kalishak.metalcore.api.item.WeatheringCopperItem;
import io.kalishak.metalcore.component.MetalcoreComponents;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Tier;

public class WeatheringShovelItem extends ShovelItem implements WeatheringCopperItem {
    public WeatheringShovelItem(Tier tier, Properties properties) {
        super(tier, properties.component(MetalcoreComponents.WEATHERED_ITEM, new WeatheredComponent(WeatheringCopperHolder.WeatherState.UNAFFECTED, false)));
    }
}
