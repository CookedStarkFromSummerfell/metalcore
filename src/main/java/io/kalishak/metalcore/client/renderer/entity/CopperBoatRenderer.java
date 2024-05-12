package io.kalishak.metalcore.client.renderer.entity;

import com.google.common.collect.ImmutableMap;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.datafixers.util.Pair;
import com.mojang.math.Axis;
import io.kalishak.metalcore.Metalcore;
import io.kalishak.metalcore.client.MetalcoreModelLayers;
import io.kalishak.metalcore.client.model.CopperBoatModel;
import io.kalishak.metalcore.client.model.CopperLampBoatModel;
import io.kalishak.metalcore.world.entity.CopperBoat;
import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.WaterPatchModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.joml.Quaternionf;

import java.util.Map;
import java.util.stream.Stream;

@OnlyIn(Dist.CLIENT)
public class CopperBoatRenderer<E extends CopperBoat> extends EntityRenderer<E> {
    private final Map<CopperBoat.Type, Pair<ResourceLocation, ListModel<E>>> boatResources;

    public CopperBoatRenderer(EntityRendererProvider.Context context, boolean hasLamp) {
        super(context);

        this.boatResources = Stream.of(CopperBoat.Type.values())
                .collect(ImmutableMap.toImmutableMap(
                        key -> (CopperBoat.Type) key,
                        value -> Pair.of(getTextureLocation(value, hasLamp), createBoatModel(context, value, hasLamp))
                ));
    }

    private static ResourceLocation getTextureLocation(CopperBoat.Type type, boolean hasLamp) {
        return new ResourceLocation(
                Metalcore.MODID,
                "textures/entity/copper" + (hasLamp ? "_lamp" : "") + "_boat/" + type.getName() + ".png"
        );
    }

    private ListModel<E> createBoatModel(EntityRendererProvider.Context context, CopperBoat.Type type, boolean hasLamp) {
        ModelLayerLocation modelLayerLocation = hasLamp ? MetalcoreModelLayers.createCopperLampBoatModel(type) : MetalcoreModelLayers.createCopperBoatModel(type);
        ModelPart modelPart = context.bakeLayer(modelLayerLocation);

        if (hasLamp) {
            return new CopperLampBoatModel<>(modelPart);
        } else {
            return new CopperBoatModel<>(modelPart);
        }
    }

    @Override
    public void render(E copperboat, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        poseStack.pushPose();
        poseStack.translate(0.0F, 0.375F, 0.0F);
        poseStack.mulPose(Axis.YP.rotationDegrees(180.0F - entityYaw));

        float f = (float) copperboat.getHurtTime() - partialTick;
        float f1 = copperboat.getDamage() - partialTick;

        if (f1 < 0.0F) {
            f1 = 0.0F;
        }

        if (f > 0.0F) {
            poseStack.mulPose(Axis.XP.rotationDegrees(Mth.sin(f) * f * f1 / 10.0F * (float) copperboat.getHurtDir()));
        }

        float f2 = copperboat.getBubbleAngle(partialTick);
        if (!Mth.equal(f2, 0.0F)) {
            poseStack.mulPose(new Quaternionf().setAngleAxis(copperboat.getBubbleAngle(partialTick) * (float) (Math.PI / 180.0F), 1.0F, 0.0F, 1.0F));
        }

        Pair<ResourceLocation, ListModel<E>> pair = getModelWithLocation(copperboat);
        ResourceLocation resourceLocation = pair.getFirst();
        ListModel<E> listModel = pair.getSecond();

        poseStack.scale(-1.0F, -1.0F, 1.0F);
        poseStack.mulPose(Axis.YP.rotationDegrees(90.0F));
        listModel.setupAnim(copperboat, partialTick, 0.0F, -0.1F, 0.0F, 0.0F);

        VertexConsumer vertexConsumer = buffer.getBuffer(listModel.renderType(resourceLocation));
        listModel.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);

        if (!copperboat.isUnderWater()) {
            VertexConsumer vertexConsumer1 = buffer.getBuffer(RenderType.waterMask());

            if (listModel instanceof WaterPatchModel waterPatchModel) {
                waterPatchModel.waterPatch().render(poseStack, vertexConsumer1, packedLight, OverlayTexture.NO_OVERLAY);
            }
        }

        poseStack.popPose();
        super.render(copperboat, entityYaw, partialTick, poseStack, buffer, packedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(E pEntity) {
        return getModelWithLocation(pEntity).getFirst();
    }

    public Pair<ResourceLocation, ListModel<E>> getModelWithLocation(E copperBoat) {
        return this.boatResources.get(copperBoat.getVariant());
    }
}
