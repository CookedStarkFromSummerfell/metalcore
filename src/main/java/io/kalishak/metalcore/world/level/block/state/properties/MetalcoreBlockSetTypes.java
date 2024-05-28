package io.kalishak.metalcore.world.level.block.state.properties;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public final class MetalcoreBlockSetTypes {
    public static final BlockSetType EXPOSED_COPPER = BlockSetType.register(
            new BlockSetType(
                    "exposed_copper",
                    true,
                    true,
                    false,
                    BlockSetType.PressurePlateSensitivity.MOBS,
                    SoundType.COPPER,
                    SoundEvents.COPPER_DOOR_CLOSE,
                    SoundEvents.COPPER_DOOR_OPEN,
                    SoundEvents.COPPER_TRAPDOOR_CLOSE,
                    SoundEvents.COPPER_TRAPDOOR_OPEN,
                    SoundEvents.METAL_PRESSURE_PLATE_CLICK_OFF,
                    SoundEvents.METAL_PRESSURE_PLATE_CLICK_ON,
                    SoundEvents.STONE_BUTTON_CLICK_OFF,
                    SoundEvents.STONE_BUTTON_CLICK_ON)
    );

    public static final BlockSetType WEATHERED_COPPER = BlockSetType.register(
            new BlockSetType(
                    "weathered_copper",
                    true,
                    false,
                    false,
                    BlockSetType.PressurePlateSensitivity.MOBS,
                    SoundType.COPPER,
                    SoundEvents.COPPER_DOOR_CLOSE,
                    SoundEvents.COPPER_DOOR_OPEN,
                    SoundEvents.COPPER_TRAPDOOR_CLOSE,
                    SoundEvents.COPPER_TRAPDOOR_OPEN,
                    SoundEvents.METAL_PRESSURE_PLATE_CLICK_OFF,
                    SoundEvents.METAL_PRESSURE_PLATE_CLICK_ON,
                    SoundEvents.STONE_BUTTON_CLICK_OFF,
                    SoundEvents.STONE_BUTTON_CLICK_ON)
    );

    public static final BlockSetType OXIDIZED_COPPER = BlockSetType.register(
            new BlockSetType(
                    "oxidized_copper",
                    false,
                    false,
                    false,
                    BlockSetType.PressurePlateSensitivity.MOBS,
                    SoundType.COPPER,
                    SoundEvents.COPPER_DOOR_CLOSE,
                    SoundEvents.COPPER_DOOR_OPEN,
                    SoundEvents.COPPER_TRAPDOOR_CLOSE,
                    SoundEvents.COPPER_TRAPDOOR_OPEN,
                    SoundEvents.METAL_PRESSURE_PLATE_CLICK_OFF,
                    SoundEvents.METAL_PRESSURE_PLATE_CLICK_ON,
                    SoundEvents.STONE_BUTTON_CLICK_OFF,
                    SoundEvents.STONE_BUTTON_CLICK_ON)
    );
}
