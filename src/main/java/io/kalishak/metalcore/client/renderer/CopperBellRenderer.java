package io.kalishak.metalcore.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import io.kalishak.metalcore.Metalcore;
import io.kalishak.metalcore.api.block.WeatheringCopperHolder;
import io.kalishak.metalcore.client.MetalcoreModelLayers;
import io.kalishak.metalcore.world.level.block.entity.CopperBellBlockEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class CopperBellRenderer implements BlockEntityRenderer<CopperBellBlockEntity> {
    private static final String BELL_BODY = "bell_body";
    private static final String BELL_BASE = "bell_base";
    private final ModelPart bellBody;

    public CopperBellRenderer(BlockEntityRendererProvider.Context cxt) {
        ModelPart modelPart = cxt.bakeLayer(MetalcoreModelLayers.COPPER_BELL);
        this.bellBody = modelPart.getChild(BELL_BODY);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition partdefinition1 = partdefinition.addOrReplaceChild(
                BELL_BODY,
                CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -6.0F, -3.0F, 6.0F, 7.0F, 6.0F), PartPose.offset(8.0F, 12.0F, 8.0F)
        );
        partdefinition1.addOrReplaceChild(
                BELL_BASE,
                CubeListBuilder.create().texOffs(0, 13).addBox(4.0F, 4.0F, 4.0F, 8.0F, 2.0F, 8.0F), PartPose.offset(-8.0F, -12.0F, -8.0F)
        );
        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    @Override
    public void render(CopperBellBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay) {
        float f = (float)pBlockEntity.ticks + pPartialTick;
        float f1 = 0.0F;
        float f2 = 0.0F;
        if (pBlockEntity.shaking) {
            float f3 = Mth.sin(f / (float) Math.PI) / (4.0F + f / 3.0F);
            if (pBlockEntity.clickDirection == Direction.NORTH) {
                f1 = -f3;
            } else if (pBlockEntity.clickDirection == Direction.SOUTH) {
                f1 = f3;
            } else if (pBlockEntity.clickDirection == Direction.EAST) {
                f2 = -f3;
            } else if (pBlockEntity.clickDirection == Direction.WEST) {
                f2 = f3;
            }
        }

        this.bellBody.xRot = f1;
        this.bellBody.zRot = f2;
        VertexConsumer vertexconsumer = MetalcoreSheets.getCopperBellMaterial(pBlockEntity.getBlockState().getBlockHolder()).buffer(pBuffer, RenderType::entitySolid);
        this.bellBody.render(pPoseStack, vertexconsumer, pPackedLight, pPackedOverlay);
    }
}
