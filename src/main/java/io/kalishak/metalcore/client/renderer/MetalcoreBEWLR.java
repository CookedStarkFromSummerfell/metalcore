package io.kalishak.metalcore.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import io.kalishak.metalcore.api.block.PipeBlockEntity;
import io.kalishak.metalcore.api.client.renderer.MetalcoreSheets;
import io.kalishak.metalcore.api.item.WeatheredComponent;
import io.kalishak.metalcore.component.MetalcoreComponents;
import io.kalishak.metalcore.world.item.MetalcoreItems;
import io.kalishak.metalcore.world.level.block.MetalcoreBlocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ShieldModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.BlockPos;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class MetalcoreBEWLR extends BlockEntityWithoutLevelRenderer {
    private final PipeBlockEntity copperPipe = new PipeBlockEntity(BlockPos.ZERO, MetalcoreBlocks.COPPER_PIPE.get().defaultBlockState());
    private final PipeBlockEntity exposedPipe = new PipeBlockEntity(BlockPos.ZERO, MetalcoreBlocks.EXPOSED_COPPER_PIPE.get().defaultBlockState());
    private final PipeBlockEntity weatheredPipe = new PipeBlockEntity(BlockPos.ZERO, MetalcoreBlocks.WEATHERED_COPPER_PIPE.get().defaultBlockState());
    private final PipeBlockEntity oxidizedPipe = new PipeBlockEntity(BlockPos.ZERO, MetalcoreBlocks.OXIDIZED_COPPER_PIPE.get().defaultBlockState());
    private ShieldModel shieldModel;

    private MetalcoreBEWLR() {
        super(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
    }

    public static MetalcoreBEWLR getInstance() {
        return new MetalcoreBEWLR();
    }

    @Override
    public void onResourceManagerReload(ResourceManager pResourceManager) {
        this.shieldModel = new ShieldModel(Minecraft.getInstance().getEntityModels().bakeLayer(ModelLayers.SHIELD));
    }

    @Override
    public void renderByItem(ItemStack pStack, ItemDisplayContext pDisplayContext, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay) {
        Item item = pStack.getItem();
        if (item instanceof BlockItem blockItem) {
            Block block = blockItem.getBlock();
            BlockEntity be;

            if (block instanceof WeatheringCopper weatheringCopper) {
                be = switch (weatheringCopper.getAge()) {
                    case UNAFFECTED -> copperPipe;
                    case EXPOSED -> exposedPipe;
                    case WEATHERED -> weatheredPipe;
                    case OXIDIZED -> oxidizedPipe;
                };

                Minecraft.getInstance().getBlockEntityRenderDispatcher().renderItem(be, pPoseStack, pBuffer, pPackedLight, pPackedOverlay)
            }
        } else {
            if (pStack.is(MetalcoreItems.COPPER_SHIELD)) {
                WeatheredComponent weatheredComponent = pStack.get(MetalcoreComponents.WEATHERED_ITEM);
                WeatheringCopper.WeatherState weatherState = WeatheringCopper.WeatherState.UNAFFECTED;

                if (weatheredComponent != null) {
                    weatherState = weatheredComponent.age();
                }

                pPoseStack.pushPose();
                pPoseStack.scale(1.0F, -1.0F, -1.0F);
                Material material = MetalcoreSheets.getShieldMaterial(weatherState);
                VertexConsumer vertexConsumer = material.sprite()
                        .wrap(ItemRenderer.getFoilBufferDirect(pBuffer, this.shieldModel.renderType(material.atlasLocation()), true, pStack.hasFoil()));

                this.shieldModel.handle().render(pPoseStack, vertexConsumer, pPackedLight, pPackedOverlay);
                this.shieldModel.plate().render(pPoseStack, vertexConsumer, pPackedLight, pPackedOverlay);

                pPoseStack.popPose();
            }
        }
    }
}
