package io.kalishak.metalcore.client;

import io.kalishak.metalcore.Metalcore;
import io.kalishak.metalcore.api.client.MetalcoreModelLayers;
import io.kalishak.metalcore.api.client.renderer.PipeRenderer;
import io.kalishak.metalcore.world.level.block.entity.MetalcoreBlockEntityType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(value = Dist.CLIENT, modid = Metalcore.MODID, bus = EventBusSubscriber.Bus.MOD)
public class MetalcoreClient {
    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(MetalcoreModelLayers.PIPE, PipeRenderer::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(MetalcoreBlockEntityType.PIPE.get(), PipeRenderer::new);
    }
}
