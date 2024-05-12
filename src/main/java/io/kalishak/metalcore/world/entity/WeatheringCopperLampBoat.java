package io.kalishak.metalcore.world.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class WeatheringCopperLampBoat extends CopperLampBoat {
    public WeatheringCopperLampBoat(EntityType<? extends CopperLampBoat> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public WeatheringCopperLampBoat(Level level, double x, double y, double z) {
        super(MetalcoreEntityTypes.WEATHERING_COPPER_LAMP_BOAT.get(), level, x, y, z);
    }
}
