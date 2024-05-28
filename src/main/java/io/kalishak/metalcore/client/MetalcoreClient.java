package io.kalishak.metalcore.client;

import io.kalishak.metalcore.Metalcore;
import io.kalishak.metalcore.api.client.renderer.PipeRenderer;
import io.kalishak.metalcore.api.item.WeatheringCopperItem;
import io.kalishak.metalcore.client.renderer.CopperBellRenderer;
import io.kalishak.metalcore.client.renderer.CopperSignRenderer;
import io.kalishak.metalcore.client.renderer.WeatheringCopperShieldModel;
import io.kalishak.metalcore.client.renderer.entity.CopperHangingSignRenderer;
import io.kalishak.metalcore.world.entity.CopperBoat;
import io.kalishak.metalcore.world.item.MetalcoreItems;
import io.kalishak.metalcore.world.item.WeatheringCopperShieldItem;
import io.kalishak.metalcore.world.level.block.entity.MetalcoreBlockEntityType;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

import java.util.function.Supplier;

@EventBusSubscriber(value = Dist.CLIENT, modid = Metalcore.MODID, bus = EventBusSubscriber.Bus.MOD)
public class MetalcoreClient {
    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(MetalcoreModelLayers.COPPER_BELL, CopperBellRenderer::createBodyLayer);
        //registerCopperBoats(event, false, CopperBoatModel::createBodyModel);
        //registerCopperBoats(event, true, CopperLampBoatModel::createBodyModel);
        event.registerLayerDefinition(MetalcoreModelLayers.COPPER_SHIELD, WeatheringCopperShieldModel::createBodyLayer);
        event.registerLayerDefinition(MetalcoreModelLayers.PIPE, PipeRenderer::createBodyLayer);

    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(MetalcoreBlockEntityType.COPPER_BELL.get(), CopperBellRenderer::new);
        event.registerBlockEntityRenderer(MetalcoreBlockEntityType.PIPE.get(), PipeRenderer::new);
        //event.registerEntityRenderer(MetalcoreEntityTypes.COPPER_BOAT.get(), (cxt) -> new CopperBoatRenderer<>(cxt, false));
        //event.registerEntityRenderer(MetalcoreEntityTypes.COPPER_LAMP_BOAT.get(), (cxt) -> new CopperBoatRenderer<>(cxt, true));
        event.registerBlockEntityRenderer(MetalcoreBlockEntityType.COPPER_SIGN.get(), CopperSignRenderer::new);
        event.registerBlockEntityRenderer(MetalcoreBlockEntityType.HANGING_COPPER_SIGN.get(), CopperHangingSignRenderer::new);
    }

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(MetalcoreClient::addPredicates);
    }

    private static void addPredicates() {
        ItemProperties.register(MetalcoreItems.COPPER_AXE.asItem(), WeatheringCopperItem.WEATHERING_STATE_PREDICATE, WeatheringCopperItem::getPredicate);
        ItemProperties.register(MetalcoreItems.COPPER_HOE.asItem(), WeatheringCopperItem.WEATHERING_STATE_PREDICATE, WeatheringCopperItem::getPredicate);
        ItemProperties.register(MetalcoreItems.COPPER_PICKAXE.asItem(), WeatheringCopperItem.WEATHERING_STATE_PREDICATE, WeatheringCopperItem::getPredicate);
        ItemProperties.register(MetalcoreItems.COPPER_SHOVEL.asItem(), WeatheringCopperItem.WEATHERING_STATE_PREDICATE, WeatheringCopperItem::getPredicate);
        ItemProperties.register(MetalcoreItems.COPPER_SWORD.asItem(), WeatheringCopperItem.WEATHERING_STATE_PREDICATE, WeatheringCopperItem::getPredicate);
        ItemProperties.register(MetalcoreItems.COPPER_SHIELD.asItem(), new ResourceLocation("blocking"), WeatheringCopperShieldItem::getBlockingPredicate);
        ItemProperties.register(MetalcoreItems.WEATHERING_COPPER_HELMET.asItem(), WeatheringCopperItem.WEATHERING_STATE_PREDICATE, WeatheringCopperItem::getPredicate);
        ItemProperties.register(MetalcoreItems.WEATHERING_COPPER_CHESTPLATE.asItem(), WeatheringCopperItem.WEATHERING_STATE_PREDICATE, WeatheringCopperItem::getPredicate);
        ItemProperties.register(MetalcoreItems.WEATHERING_COPPER_LEGGINGS.asItem(), WeatheringCopperItem.WEATHERING_STATE_PREDICATE, WeatheringCopperItem::getPredicate);
        ItemProperties.register(MetalcoreItems.WEATHERING_COPPER_BOOTS.asItem(), WeatheringCopperItem.WEATHERING_STATE_PREDICATE, WeatheringCopperItem::getPredicate);
    }

    private static void registerCopperBoats(EntityRenderersEvent.RegisterLayerDefinitions event, boolean withLamp, Supplier<LayerDefinition> layerDefinition) {
        for (CopperBoat.Type type : CopperBoat.Type.values()) {
            event.registerLayerDefinition((withLamp ? MetalcoreModelLayers.createCopperLampBoatModel(type) : MetalcoreModelLayers.createCopperBoatModel(type)), layerDefinition);
        }
    }
}
