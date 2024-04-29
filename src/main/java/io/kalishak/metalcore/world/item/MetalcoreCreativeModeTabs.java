package io.kalishak.metalcore.world.item;

import io.kalishak.metalcore.Metalcore;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class MetalcoreCreativeModeTabs {
    private static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Metalcore.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> METALCORE_ITEMS = CREATIVE_MODE_TABS.register("items", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.metalcore.items"))
            .icon(MetalcoreItems.ALUMINUM_INGOT::toStack)
            .build());
    /*public static final DeferredHolder<CreativeModeTab, CreativeModeTab> METALCORE_BLOCKS = CREATIVE_MODE_TABS.register("blocks", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.metalcore.blocks"))
            .icon(MetalcoreItems.RAW_ALUMINUM_BLOCK::toStack)
            .build());*/

    public static void init(IEventBus bus) {
        CREATIVE_MODE_TABS.register(bus);
    }
}
