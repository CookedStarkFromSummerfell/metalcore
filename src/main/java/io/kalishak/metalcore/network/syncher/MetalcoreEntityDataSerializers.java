package io.kalishak.metalcore.network.syncher;

import io.kalishak.metalcore.Metalcore;
import io.kalishak.metalcore.api.network.syncher.MetalcoreApiEntityDataSerializers;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public final class MetalcoreEntityDataSerializers {
    private static final DeferredRegister<EntityDataSerializer<?>> SERIALIZERS = DeferredRegister.create(NeoForgeRegistries.ENTITY_DATA_SERIALIZERS, Metalcore.MODID);

    public static void init(IEventBus bus) {
        SERIALIZERS.register("weathering_state", MetalcoreApiEntityDataSerializers.WEATHERING_STATE);
        SERIALIZERS.register(bus);
    }
}
