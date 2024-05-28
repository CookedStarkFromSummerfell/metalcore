package io.kalishak.metalcore.client.renderer;

import com.google.common.collect.ImmutableMap;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import io.kalishak.metalcore.api.block.state.properties.MetalType;
import io.kalishak.metalcore.client.MetalcoreModelLayers;
import io.kalishak.metalcore.world.level.block.entity.CopperSignBlockEntity;
import io.kalishak.metalcore.world.level.block.sign.CopperSignBlock;
import io.kalishak.metalcore.world.level.block.sign.CopperStandingSignBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.BlockPos;
import net.minecraft.util.FastColor;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.entity.SignText;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

import java.util.List;
import java.util.Map;

@OnlyIn(Dist.CLIENT)
public class CopperSignRenderer implements BlockEntityRenderer<CopperSignBlockEntity> {
    private static final String STICK = "stick";
    private static final int BLACK_TEXT_OUTLINE_COLOR = -988212;
    private static final int OUTLINE_RENDER_DISTANCE = Mth.square(16);
    private static final float RENDER_SCALE = 0.6666667F;
    private static final Vec3 TEXT_OFFSET = new Vec3(0.0, 0.33333334F, 0.046666667F);
    private final Map<MetalType, CopperSignModel> signModels;
    private final Font font;

    public CopperSignRenderer(BlockEntityRendererProvider.Context context) {
        this.signModels = MetalType.values().collect(ImmutableMap.toImmutableMap(
                key -> key,
                value -> new CopperSignModel(context.bakeLayer(MetalcoreModelLayers.createSignModelName(value)))));

        this.font = context.getFont();
    }

    public void render(CopperSignBlockEntity sign, float partialTick, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay) {
        BlockState blockState = sign.getBlockState();
        CopperSignBlock signBlock = (CopperSignBlock) blockState.getBlock();
        MetalType metalType = CopperSignBlock.getMetalType(signBlock);
        CopperSignModel signModel = this.signModels.get(metalType);

        signModel.stick.visible = blockState.getBlock() instanceof StandingSignBlock;
        renderSignWithText(sign, poseStack, buffer, packedLight, packedOverlay, blockState, signBlock, metalType, signModel);
    }

    public float getSignModelRenderScale() {
        return RENDER_SCALE;
    }

    public float getSignTextRenderScale() {
        return RENDER_SCALE;
    }

    protected void renderSignWithText(CopperSignBlockEntity sign, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay, BlockState state, CopperSignBlock signBlock, MetalType metalType, Model model) {
        poseStack.pushPose();
        translateSign(poseStack, -signBlock.getYRotationDegrees(state), state);
        renderSign(poseStack, buffer, packedLight, packedOverlay, metalType, model);
        renderSignText(sign.getBlockPos(), sign.getFrontText(), poseStack, buffer, packedLight, sign.getTextLineHeight(), sign.getMaxTextLineWidth(), true);
        renderSignText(sign.getBlockPos(), sign.getBackText(), poseStack, buffer, packedLight, sign.getTextLineHeight(), sign.getMaxTextLineWidth(), false);
        poseStack.popPose();
    }

    protected void translateSign(PoseStack poseStack, float yRot, BlockState state) {
        poseStack.translate(0.5F, 0.75F * this.getSignModelRenderScale(), 0.5F);
        poseStack.mulPose(Axis.YP.rotationDegrees(yRot));
        if (!(state.getBlock() instanceof StandingSignBlock)) {
            poseStack.translate(0.0F, -0.3125F, -0.4375F);
        }
    }

    protected void renderSign(PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay, MetalType metalType, Model model) {
        poseStack.pushPose();
        float f = getSignModelRenderScale();
        poseStack.scale(f, -f, -f);
        Material material = this.getSignMaterial(metalType);
        VertexConsumer vertexconsumer = material.buffer(buffer, model::renderType);
        renderSignModel(poseStack, packedLight, packedOverlay, model, vertexconsumer);
        poseStack.popPose();
    }

    protected void renderSignModel(PoseStack poseStack, int packedLight, int packedOverlay, Model model, VertexConsumer vertexConsumer) {
        CopperSignModel signModel = (CopperSignModel) model;
        signModel.root.render(poseStack, vertexConsumer, packedLight, packedOverlay);
    }

    protected Material getSignMaterial(MetalType metalType) {
        return MetalcoreSheets.getSignMaterial(metalType);
    }

    protected void renderSignText(BlockPos pos, SignText text, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int lineHeight, int maxWidth, boolean isFrontText) {
        poseStack.pushPose();

        translateSignText(poseStack, isFrontText, getTextOffset());
        int i = getDarkColor(text);
        int j = 4 * lineHeight / 2;

        FormattedCharSequence[] aformattedcharsequence = text.getRenderMessages(Minecraft.getInstance().isTextFilteringEnabled(), component -> {
            List<FormattedCharSequence> list = this.font.split(component, maxWidth);
            return list.isEmpty() ? FormattedCharSequence.EMPTY : list.getFirst();
        });

        int k;
        boolean flag;
        int l;

        if (text.hasGlowingText()) {
            k = text.getColor().getTextColor();
            flag = isOutlineVisible(pos, k);
            l = 15728880;
        } else {
            k = i;
            flag = false;
            l = packedLight;
        }

        for (int i1 = 0; i1 < 4; i1++) {
            FormattedCharSequence formattedCharSequence = aformattedcharsequence[i1];
            float f = (float) (-this.font.width(formattedCharSequence) / 2);

            if (flag) {
                this.font.drawInBatch8xOutline(formattedCharSequence, f, (float)(i1 * lineHeight - j), k, i, poseStack.last().pose(), buffer, l);
            } else {
                this.font.drawInBatch(
                        formattedCharSequence,
                        f,
                        (float)(i1 * lineHeight - j),
                        k,
                        false,
                        poseStack.last().pose(),
                        buffer,
                        Font.DisplayMode.POLYGON_OFFSET,
                        0,
                        l
                );
            }
        }

        poseStack.popPose();
    }

    protected  void translateSignText(PoseStack poseStack, boolean isFrontText, Vec3 offset) {
        if (!isFrontText) {
            poseStack.mulPose(Axis.YP.rotationDegrees(180.0F));
        }

        float f = 0.015625F * getSignTextRenderScale();
        poseStack.translate(offset.x, offset.y, offset.z);
        poseStack.scale(f, -f, f);
    }

    Vec3 getTextOffset() {
        return TEXT_OFFSET;
    }

    protected static boolean isOutlineVisible(BlockPos pos, int textColor) {
        if (textColor == DyeColor.BLACK.getTextColor()) {
            return true;
        } else {
            Minecraft minecraft = Minecraft.getInstance();
            LocalPlayer localplayer = minecraft.player;

            if (localplayer != null && minecraft.options.getCameraType().isFirstPerson() && localplayer.isScoping()) {
                return true;
            } else {
                Entity entity = minecraft.getCameraEntity();
                return entity != null && entity.distanceToSqr(Vec3.atCenterOf(pos)) < (double)OUTLINE_RENDER_DISTANCE;
            }
        }
    }

    public static int getDarkColor(SignText signText) {
        int i = signText.getColor().getTextColor();
        if (i == DyeColor.BLACK.getTextColor() && signText.hasGlowingText()) {
            return -988212;
        } else {
            double d0 = 0.4;
            int j = (int)((double) FastColor.ARGB32.red(i) * 0.4);
            int k = (int)((double)FastColor.ARGB32.green(i) * 0.4);
            int l = (int)((double)FastColor.ARGB32.blue(i) * 0.4);
            return FastColor.ARGB32.color(0, j, k, l);
        }
    }

    public static CopperSignModel createSignModel(EntityModelSet entityModelSet, MetalType metalType) {
        return new CopperSignModel(entityModelSet.bakeLayer(MetalcoreModelLayers.createSignModelName(metalType)));
    }

    public static LayerDefinition createSignLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        partdefinition.addOrReplaceChild("sign", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -14.0F, -1.0F, 24.0F, 12.0F, 2.0F), PartPose.ZERO);
        partdefinition.addOrReplaceChild("stick", CubeListBuilder.create().texOffs(0, 14).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 14.0F, 2.0F), PartPose.ZERO);
        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    @Override
    public AABB getRenderBoundingBox(CopperSignBlockEntity blockEntity) {
        if (blockEntity.getBlockState().getBlock() instanceof CopperStandingSignBlock) {
            BlockPos pos = blockEntity.getBlockPos();
            return new AABB(pos.getX(), pos.getY(), pos.getZ(), pos.getX() + 1.0, pos.getY() + 1.125, pos.getZ() + 1.0);
        }
        return BlockEntityRenderer.super.getRenderBoundingBox(blockEntity);
    }

    @OnlyIn(Dist.CLIENT)
    public static final class CopperSignModel extends Model {
        public final ModelPart root;
        public final ModelPart stick;

        public CopperSignModel(ModelPart root) {
            super(RenderType::entityCutoutNoCull);
            this.root = root;
            this.stick = root.getChild("stick");
        }

        @Override
        public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
            this.root.render(poseStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        }
    }
}
