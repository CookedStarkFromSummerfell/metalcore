package io.kalishak.metalcore.world.entity;

import io.kalishak.metalcore.Metalcore;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public final class MetalcoreEntityTypes {
    private static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(Registries.ENTITY_TYPE, Metalcore.MODID);

    public static final Supplier<EntityType<CopperBoat>> COPPER_BOAT = ENTITY_TYPES.register("copper_boat", () -> EntityType.Builder.<CopperBoat>of(CopperBoat::new, MobCategory.MISC)
            .sized(1.375F, 0.5625F)
            .eyeHeight(0.5625F)
            .clientTrackingRange(10)
            .build("copper_boat")
    );
    public static final Supplier<EntityType<CopperLampBoat>> COPPER_LAMP_BOAT = ENTITY_TYPES.register("copper_lamp_boat", () -> EntityType.Builder.<CopperLampBoat>of(CopperLampBoat::new, MobCategory.MISC)
            .sized(1.375F, 0.5625F)
            .eyeHeight(0.5625F)
            .clientTrackingRange(10)
            .build("copper_lamp_boat")
    );

    public static final Supplier<EntityType<WeatheringCopperBoat>> WEATHERING_COPPER_BOAT = ENTITY_TYPES.register("weathering_copper_boat", () -> EntityType.Builder.<WeatheringCopperBoat>of(WeatheringCopperBoat::new, MobCategory.MISC)
            .sized(1.375F, 0.5625F)
            .eyeHeight(0.5625F)
            .clientTrackingRange(10)
            .build("weathering_copper_boat")
    );
    public static final Supplier<EntityType<WeatheringCopperLampBoat>> WEATHERING_COPPER_LAMP_BOAT = ENTITY_TYPES.register("weathering_copper_lamp_boat", () -> EntityType.Builder.<WeatheringCopperLampBoat>of(WeatheringCopperLampBoat::new, MobCategory.MISC)
            .sized(1.375F, 0.5625F)
            .eyeHeight(0.5625F)
            .clientTrackingRange(10)
            .build("weathering_copper_lamp_boat")
    );

    public static void init(IEventBus bus) {
        ENTITY_TYPES.register(bus);
    }
}
