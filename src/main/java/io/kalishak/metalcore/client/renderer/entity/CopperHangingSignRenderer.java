package io.kalishak.metalcore.client.renderer.entity;

import com.google.common.collect.ImmutableMap;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import io.kalishak.metalcore.api.block.state.properties.MetalType;
import io.kalishak.metalcore.client.MetalcoreModelLayers;
import io.kalishak.metalcore.client.renderer.CopperSignRenderer;
import io.kalishak.metalcore.client.renderer.MetalcoreSheets;
import io.kalishak.metalcore.world.level.block.entity.CopperSignBlockEntity;
import io.kalishak.metalcore.world.level.block.sign.CopperSignBlock;
import io.kalishak.metalcore.world.level.block.sign.hanging.CopperCeilingHangingSignBlock;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.resources.model.Material;
import net.minecraft.world.level.block.CeilingHangingSignBlock;
import net.minecraft.world.level.block.SignBlock;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

import java.util.Map;

@OnlyIn(Dist.CLIENT)
public class CopperHangingSignRenderer extends CopperSignRenderer {
    private static final String PLANK = "plank";
    private static final String V_CHAINS = "vChains";
    private static final String NORMAL_CHAINS = "normalChains";
    private static final String CHAIN_L_1 = "chainL1";
    private static final String CHAIN_L_2 = "chainL2";
    private static final String CHAIN_R_1 = "chainR1";
    private static final String CHAIN_R_2 = "chainR2";
    private static final String BOARD = "board";
    private static final float MODEL_RENDER_SCALE = 1.0F;
    private static final float TEXT_RENDER_SCALE = 0.9F;
    private static final Vec3 TEXT_OFFSET = new Vec3(0.0, -0.32F, 0.073F);
    private final Map<MetalType, CopperHangingSignModel> hangingSignModels;

    public CopperHangingSignRenderer(BlockEntityRendererProvider.Context context) {
        super(context);
        this.hangingSignModels = MetalType.values().collect(ImmutableMap.toImmutableMap(
                key -> key,
                value -> new CopperHangingSignModel(context.bakeLayer(MetalcoreModelLayers.createHangingSignModelName(value)))
                ));
    }

    @Override
    public float getSignModelRenderScale() {
        return MODEL_RENDER_SCALE;
    }

    @Override
    public float getSignTextRenderScale() {
        return TEXT_RENDER_SCALE;
    }

    @Override
    public void render(CopperSignBlockEntity sign, float partialTick, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay) {
        BlockState blockState = sign.getBlockState();
        CopperSignBlock signBlock = (CopperSignBlock) blockState.getBlock();
        MetalType metalType = CopperSignBlock.getMetalType(signBlock);
        CopperHangingSignModel signModel = this.hangingSignModels.get(metalType);
        signModel.evaluateVisibleParts(blockState);
        renderSignWithText(sign, poseStack, buffer, packedLight, packedOverlay, blockState, signBlock, metalType, signModel);
    }

    @Override
    protected void translateSign(PoseStack poseStack, float yRot, BlockState state) {
        poseStack.translate(0.5, 0.9375, 0.5);
        poseStack.mulPose(Axis.YP.rotationDegrees(yRot));
        poseStack.translate(0.0F, -0.3125F, 0.0F);
    }

    @Override
    protected void renderSignModel(PoseStack poseStack, int packedLight, int packedOverlay, Model model, VertexConsumer vertexConsumer) {
        CopperHangingSignModel signModel = (CopperHangingSignModel) model;
        signModel.root.render(poseStack, vertexConsumer, packedLight, packedOverlay);
    }

    @Override
    protected Material getSignMaterial(MetalType metalType) {
        return MetalcoreSheets.getHangingSignMaterial(metalType);
    }

    public static Vec3 getTextOffset() {
        return TEXT_OFFSET;
    }

    public static LayerDefinition createHangingSignLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        partdefinition.addOrReplaceChild("board", CubeListBuilder.create().texOffs(0, 12).addBox(-7.0F, 0.0F, -1.0F, 14.0F, 10.0F, 2.0F), PartPose.ZERO);
        partdefinition.addOrReplaceChild("plank", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -6.0F, -2.0F, 16.0F, 2.0F, 4.0F), PartPose.ZERO);
        PartDefinition partdefinition1 = partdefinition.addOrReplaceChild("normalChains", CubeListBuilder.create(), PartPose.ZERO);
        partdefinition1.addOrReplaceChild(
                "chainL1",
                CubeListBuilder.create().texOffs(0, 6).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 6.0F, 0.0F),
                PartPose.offsetAndRotation(-5.0F, -6.0F, 0.0F, 0.0F, (float) (-Math.PI / 4), 0.0F)
        );
        partdefinition1.addOrReplaceChild(
                "chainL2",
                CubeListBuilder.create().texOffs(6, 6).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 6.0F, 0.0F),
                PartPose.offsetAndRotation(-5.0F, -6.0F, 0.0F, 0.0F, (float) (Math.PI / 4), 0.0F)
        );
        partdefinition1.addOrReplaceChild(
                "chainR1",
                CubeListBuilder.create().texOffs(0, 6).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 6.0F, 0.0F),
                PartPose.offsetAndRotation(5.0F, -6.0F, 0.0F, 0.0F, (float) (-Math.PI / 4), 0.0F)
        );
        partdefinition1.addOrReplaceChild(
                "chainR2",
                CubeListBuilder.create().texOffs(6, 6).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 6.0F, 0.0F),
                PartPose.offsetAndRotation(5.0F, -6.0F, 0.0F, 0.0F, (float) (Math.PI / 4), 0.0F)
        );
        partdefinition.addOrReplaceChild("vChains", CubeListBuilder.create().texOffs(14, 6).addBox(-6.0F, -6.0F, 0.0F, 12.0F, 6.0F, 0.0F), PartPose.ZERO);
        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    @OnlyIn(Dist.CLIENT)
    public static final class CopperHangingSignModel extends Model {
        public final ModelPart root;
        public final ModelPart plank;
        public final ModelPart vChains;
        public final ModelPart normalChains;

        public CopperHangingSignModel(ModelPart pRoot) {
            super(RenderType::entityCutoutNoCull);
            this.root = pRoot;
            this.plank = pRoot.getChild("plank");
            this.normalChains = pRoot.getChild("normalChains");
            this.vChains = pRoot.getChild("vChains");
        }

        public void evaluateVisibleParts(BlockState state) {
            boolean flag = !(state.getBlock() instanceof CopperCeilingHangingSignBlock);
            this.plank.visible = flag;
            this.vChains.visible = false;
            this.normalChains.visible = true;

            if (!flag) {
                boolean flag1 = state.getValue(BlockStateProperties.ATTACHED);
                this.normalChains.visible = !flag1;
                this.vChains.visible = flag1;
            }
        }

        @Override
        public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
            this.root.render(poseStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        }
    }
}
