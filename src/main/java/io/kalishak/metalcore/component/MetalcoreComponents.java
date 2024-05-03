package io.kalishak.metalcore.component;

import io.kalishak.metalcore.Metalcore;
import io.kalishak.metalcore.api.item.WeatheredComponent;
import net.minecraft.core.component.DataComponentType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public final class MetalcoreComponents {
    private static final DeferredRegister.DataComponents DATA_COMPONENTS = DeferredRegister.createDataComponents(Metalcore.MODID);

    public static final Supplier<DataComponentType<WeatheredComponent>> WEATHERED_ITEM = DATA_COMPONENTS.registerComponentType("weathered_copper", builder -> builder.persistent(WeatheredComponent.CODEC).networkSynchronized(WeatheredComponent.STREAM_CODEC));

    public static void init(IEventBus bus) {
        DATA_COMPONENTS.register(bus);
    }
}
