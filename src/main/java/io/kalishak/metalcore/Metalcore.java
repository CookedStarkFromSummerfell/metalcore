package io.kalishak.metalcore;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;

@Mod(Metalcore.MODID)
public class Metalcore {
    public static final String MODID = "metalcore";

    public Metalcore(IEventBus eventBus) {

        ModLoadingContext.get().getActiveContainer().registerConfig(ModConfig.Type.SERVER, MetalcoreConfig.SERVER_SPEC);
    }
}
