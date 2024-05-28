package io.kalishak.metalcore.world.level.block.state.properties;

import io.kalishak.metalcore.api.block.state.properties.MetalType;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public final class MetalcoreMetalTypes {
    public static final MetalType COPPER = MetalType.register(new MetalType(
            "copper",
            BlockSetType.COPPER,
            SoundType.METAL,
            SoundType.HANGING_SIGN)
    );

    public static final MetalType EXPOSED_COPPER = MetalType.register(new MetalType(
            "exposed_copper",
            MetalcoreBlockSetTypes.EXPOSED_COPPER,
            SoundType.METAL,
            SoundType.HANGING_SIGN)
    );

    public static final MetalType WEATHERED_COPPER = MetalType.register(new MetalType(
            "weathered_copper",
            MetalcoreBlockSetTypes.WEATHERED_COPPER,
            SoundType.METAL,
            SoundType.HANGING_SIGN)
    );

    public static final MetalType OXIDIZED_COPPER = MetalType.register(new MetalType(
            "oxidized_copper",
            MetalcoreBlockSetTypes.OXIDIZED_COPPER,
            SoundType.METAL,
            SoundType.HANGING_SIGN)
    );
}
