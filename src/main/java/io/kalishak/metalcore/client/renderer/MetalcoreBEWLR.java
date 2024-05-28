package io.kalishak.metalcore.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import io.kalishak.metalcore.api.block.PipeBlockEntity;
import io.kalishak.metalcore.api.block.WeatheringCopperHolder;
import io.kalishak.metalcore.client.MetalcoreModelLayers;
import io.kalishak.metalcore.api.item.WeatheredComponent;
import io.kalishak.metalcore.component.MetalcoreComponents;
import io.kalishak.metalcore.world.item.MetalcoreItems;
import io.kalishak.metalcore.world.level.block.MetalcoreBlocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class MetalcoreBEWLR extends BlockEntityWithoutLevelRenderer {
    public static final MetalcoreBEWLR INSTANCE = new MetalcoreBEWLR();
    private final PipeBlockEntity copperPipe = new PipeBlockEntity(BlockPos.ZERO, MetalcoreBlocks.COPPER_PIPE.get().defaultBlockState());
    private final PipeBlockEntity exposedPipe = new PipeBlockEntity(BlockPos.ZERO, MetalcoreBlocks.EXPOSED_COPPER_PIPE.get().defaultBlockState());
    private final PipeBlockEntity weatheredPipe = new PipeBlockEntity(BlockPos.ZERO, MetalcoreBlocks.WEATHERED_COPPER_PIPE.get().defaultBlockState());
    private final PipeBlockEntity oxidizedPipe = new PipeBlockEntity(BlockPos.ZERO, MetalcoreBlocks.OXIDIZED_COPPER_PIPE.get().defaultBlockState());
    private final WeatheringCopperShieldModel shieldModel = new WeatheringCopperShieldModel(Minecraft.getInstance().getEntityModels().bakeLayer(MetalcoreModelLayers.COPPER_SHIELD));

    private MetalcoreBEWLR() {
        super(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
    }

    @Override
    public void renderByItem(ItemStack pStack, ItemDisplayContext pDisplayContext, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay) {
        Item item = pStack.getItem();
        if (item instanceof BlockItem blockItem) {
            Block block = blockItem.getBlock();
            BlockEntity be;

            if (block instanceof WeatheringCopperHolder weatheringCopper) {
                be = switch (weatheringCopper.getAge()) {
                    case UNAFFECTED -> copperPipe;
                    case EXPOSED -> exposedPipe;
                    case WEATHERED -> weatheredPipe;
                    case OXIDIZED -> oxidizedPipe;
                };

                this.blockEntityRenderDispatcher.renderItem(be, pPoseStack, pBuffer, pPackedLight, pPackedOverlay);
            }
        } else {
            if (pStack.is(MetalcoreItems.COPPER_SHIELD)) {
                WeatheredComponent weatheredComponent = pStack.get(MetalcoreComponents.WEATHERED_ITEM);
                WeatheringCopperHolder.WeatherState weatherState = WeatheringCopperHolder.WeatherState.UNAFFECTED;

                if (weatheredComponent != null) {
                    weatherState = weatheredComponent.age();
                }

                pPoseStack.pushPose();
                pPoseStack.scale(1.0F, -1.0F, -1.0F);
                VertexConsumer vertexConsumer = ItemRenderer.getFoilBufferDirect(pBuffer, this.shieldModel.renderType(WeatheringCopperShieldModel.getTexture(weatherState)), true, pStack.hasFoil());
                this.shieldModel.renderToBuffer(pPoseStack, vertexConsumer, pPackedLight, pPackedOverlay, 1.0F, 1.0F, 1.0F, 1.0F);

                pPoseStack.popPose();
            }
        }
    }
}
