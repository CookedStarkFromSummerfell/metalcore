package io.kalishak.metalcore;

import io.kalishak.metalcore.config.MetalcoreConfig;
import io.kalishak.metalcore.data.MetalcoreDataGenerators;
import io.kalishak.metalcore.data.MetalcoreDatapackRegistries;
import io.kalishak.metalcore.world.item.MetalcoreArmorMaterials;
import io.kalishak.metalcore.world.item.MetalcoreCreativeModeTabs;
import io.kalishak.metalcore.world.item.MetalcoreItems;
import io.kalishak.metalcore.world.item.MetalcoreTiers;
import io.kalishak.metalcore.world.level.block.MetalcoreBlocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.registries.NewRegistryEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(Metalcore.MODID)
public class Metalcore {
    public static final String MODID = "metalcore";

    public static final Logger LOGGER = LoggerFactory.getLogger(Metalcore.class);

    public Metalcore(IEventBus eventBus) {
        MetalcoreArmorMaterials.init(eventBus);
        MetalcoreBlocks.init(eventBus);
        MetalcoreCreativeModeTabs.init(eventBus);
        MetalcoreTiers.init(eventBus);
        MetalcoreItems.init(eventBus);

        eventBus.addListener(NewRegistryEvent.class, event -> event.register(MetalcoreRegistries.TIER_MATERIALS));
        eventBus.addListener(MetalcoreDatapackRegistries::registerDatapackRegistries);

        eventBus.addListener(MetalcoreItems::appendItems);
        eventBus.addListener(MetalcoreDataGenerators::gatherData);

        ModLoadingContext.get().getActiveContainer().registerConfig(ModConfig.Type.SERVER, MetalcoreConfig.SERVER_SPEC);
    }
}
