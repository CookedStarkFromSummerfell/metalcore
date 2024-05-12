package io.kalishak.metalcore.world.item;

import io.kalishak.metalcore.world.entity.CopperBoat;
import io.kalishak.metalcore.world.entity.CopperLampBoat;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public class CopperLampBoatItem extends CopperBoatItem {
    public CopperLampBoatItem(boolean waxed, CopperBoat.Type type, Properties properties) {
        super(waxed, type, properties);
    }

    @Override
    protected CopperBoat getBoat(Level level, HitResult hitResult, ItemStack stack, Player player) {
        Vec3 vec3 = hitResult.getLocation();
        CopperLampBoat copperBoat = new CopperLampBoat(level, vec3.x, vec3.y, vec3.z);

        if (level instanceof ServerLevel serverLevel) {
            EntityType.<CopperBoat>createDefaultStackConfig(serverLevel, stack, player).accept(copperBoat);
        }

        return copperBoat;
    }
}
