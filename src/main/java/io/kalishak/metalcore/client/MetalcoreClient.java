package io.kalishak.metalcore.client;

import io.kalishak.metalcore.Metalcore;
import io.kalishak.metalcore.api.client.renderer.PipeRenderer;
import io.kalishak.metalcore.api.item.WeatheringCopperItem;
import io.kalishak.metalcore.client.renderer.CopperBellRenderer;
import io.kalishak.metalcore.client.renderer.WeatheringCopperShieldModel;
import io.kalishak.metalcore.client.renderer.entity.CopperBoatRenderer;
import io.kalishak.metalcore.world.entity.MetalcoreEntityTypes;
import io.kalishak.metalcore.world.item.MetalcoreItems;
import io.kalishak.metalcore.world.level.block.entity.MetalcoreBlockEntityType;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

import java.util.function.BiFunction;
import java.util.function.Function;

@EventBusSubscriber(value = Dist.CLIENT, modid = Metalcore.MODID, bus = EventBusSubscriber.Bus.MOD)
public class MetalcoreClient {
    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(MetalcoreModelLayers.COPPER_BELL, CopperBellRenderer::createBodyLayer);
        event.registerLayerDefinition(MetalcoreModelLayers.COPPER_SHIELD, WeatheringCopperShieldModel::createBodyLayer);
        event.registerLayerDefinition(MetalcoreModelLayers.PIPE, PipeRenderer::createBodyLayer);

    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(MetalcoreBlockEntityType.COPPER_BELL.get(), CopperBellRenderer::new);
        event.registerBlockEntityRenderer(MetalcoreBlockEntityType.PIPE.get(), PipeRenderer::new);
        
        event.registerEntityRenderer(MetalcoreEntityTypes.COPPER_BOAT.get(), (cxt) -> new CopperBoatRenderer<>(cxt, false));
        event.registerEntityRenderer(MetalcoreEntityTypes.COPPER_LAMP_BOAT.get(), (cxt) -> new CopperBoatRenderer<>(cxt, true));
    }

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(MetalcoreClient::addPredicates);
    }

    private static void addPredicates() {
        addPredicate(MetalcoreItems.COPPER_AXE, WeatheringCopperItem.WEATHERING_STATE_PREDICATE, WeatheringCopperItem::getPredicate);
        addPredicate(MetalcoreItems.COPPER_HOE, WeatheringCopperItem.WEATHERING_STATE_PREDICATE, WeatheringCopperItem::getPredicate);
        addPredicate(MetalcoreItems.COPPER_PICKAXE, WeatheringCopperItem.WEATHERING_STATE_PREDICATE, WeatheringCopperItem::getPredicate);
        addPredicate(MetalcoreItems.COPPER_SHOVEL, WeatheringCopperItem.WEATHERING_STATE_PREDICATE, WeatheringCopperItem::getPredicate);
        addPredicate(MetalcoreItems.COPPER_SWORD, WeatheringCopperItem.WEATHERING_STATE_PREDICATE, WeatheringCopperItem::getPredicate);
        addPredicate(MetalcoreItems.COPPER_SHIELD, new ResourceLocation("blocking"), (stack, entity) -> entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F);
    }

    private static void addPredicate(ItemLike itemLike, ResourceLocation predicateId, BiFunction<ItemStack, LivingEntity, Float> function) {
        ItemProperties.register(
                itemLike.asItem(),
                predicateId,
                (pStack, pLevel, pEntity, pSeed) -> pEntity != null ? function.apply(pStack, pEntity) : 0.0F
        );
    }
}
