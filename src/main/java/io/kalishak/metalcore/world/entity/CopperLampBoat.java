package io.kalishak.metalcore.world.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class CopperLampBoat extends CopperBoat {
    public CopperLampBoat(EntityType<? extends CopperLampBoat> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public CopperLampBoat(Level pLevel) {
        this(MetalcoreEntityTypes.COPPER_LAMP_BOAT.get(), pLevel);
    }

    public CopperLampBoat(EntityType<? extends CopperLampBoat> entityType, Level level, double x, double y, double z) {
        super(entityType, level, x, y, z);
    }

    public CopperLampBoat(Level level, double x, double y, double z) {
        this(MetalcoreEntityTypes.COPPER_LAMP_BOAT.get(), level, x, y, z);
    }
}
