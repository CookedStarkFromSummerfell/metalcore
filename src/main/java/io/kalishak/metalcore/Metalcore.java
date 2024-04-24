package io.kalishak.metalcore;

import io.kalishak.metalcore.world.item.MetalcoreItems;
import io.kalishak.metalcore.world.level.block.MetalcoreBlocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;

@Mod(Metalcore.MODID)
public class Metalcore {
    public static final String MODID = "metalcore";

    public Metalcore(IEventBus eventBus) {
        MetalcoreBlocks.init(eventBus);
        MetalcoreItems.init(eventBus);

        ModLoadingContext.get().getActiveContainer().registerConfig(ModConfig.Type.SERVER, MetalcoreConfig.SERVER_SPEC);
    }
}
