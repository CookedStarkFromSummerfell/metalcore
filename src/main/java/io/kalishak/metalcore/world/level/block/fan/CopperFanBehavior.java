package io.kalishak.metalcore.world.level.block.fan;

import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class CopperFanBehavior {

    /**
    // Something simillar to {@link net.minecraft.core.dispenser.DispenseItemBehavior}
     */
    public static void makeWind(Level level, int speed, Direction facing, Position position, List<? extends Entity> affectedEntities) {
        double x = position.x();
        double y = position.y();
        double z = position.z();

        if (facing.getAxis() == Direction.Axis.Y) {
            y -= 0.125D;
        } else {
            y -= 0.15625D;
        }

        double offset = level.random.nextDouble() * 0.1D + 0.2D;
        Vec3 deltaMovement = new Vec3(
                level.random.triangle((double) facing.getStepX() * offset, 0.0172275D * (double) speed),
                level.random.triangle(0.2D, 0.0172275 * (double) speed),
                level.random.triangle((double) facing.getStepZ() * offset, 0.0172275D * (double) speed)
        );

        affectedEntities.forEach(entity -> entity.setDeltaMovement(deltaMovement));
    }
}
