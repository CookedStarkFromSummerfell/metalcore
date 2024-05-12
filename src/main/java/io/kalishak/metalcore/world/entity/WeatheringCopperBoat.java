package io.kalishak.metalcore.world.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class WeatheringCopperBoat extends CopperBoat {
    public WeatheringCopperBoat(EntityType<? extends CopperBoat> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public WeatheringCopperBoat(Level level, double x, double y, double z) {
        super(MetalcoreEntityTypes.WEATHERING_COPPER_BOAT.get(), level, x, y, z);
    }
}
