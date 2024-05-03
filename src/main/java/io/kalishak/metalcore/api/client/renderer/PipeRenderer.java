package io.kalishak.metalcore.api.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import io.kalishak.metalcore.api.block.Pipe;
import io.kalishak.metalcore.api.block.PipeBlockEntity;
import io.kalishak.metalcore.api.block.SixwayStorageBlock;
import io.kalishak.metalcore.api.client.MetalcoreModelLayers;
import io.kalishak.metalcore.world.level.block.MetalcoreBlocks;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.resources.model.Material;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;

@OnlyIn(Dist.CLIENT)
public class PipeRenderer<E extends PipeBlockEntity> implements BlockEntityRenderer<E> {
    private final ModelPart core;
    private final ModelPart pipe;
    private final ModelPart pipeReceive;
    private final ModelPart pipeExtract;

    private Pipe.Type type;
    private @Nullable WeatheringCopper.WeatherState weatherState;

    public PipeRenderer(BlockEntityRendererProvider.Context cxt) {
        ModelPart root = cxt.bakeLayer(MetalcoreModelLayers.PIPE);

        this.core = root.getChild("core");
        this.pipe = root.getChild("pipe");
        this.pipeReceive = root.getChild("receive");
        this.pipeExtract = root.getChild("extract");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition part = mesh.getRoot();

        part.addOrReplaceChild("core", CubeListBuilder.create().texOffs(0, 13).addBox(-2.0F, 8.0F, -2.0F, 4.0F, 4.0F, 4.0F), PartPose.ZERO);
        part.addOrReplaceChild("pipe", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 8.0F, 4.0F), PartPose.rotation(0.0F, 10.0F, 0.0F));
        part.addOrReplaceChild("receive", CubeListBuilder.create().texOffs(11, 7).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 1.0F, 5.0F), PartPose.rotation(0.0F, 10.0F, 0.0F));
        part.addOrReplaceChild("extract", CubeListBuilder.create().texOffs(11, 7).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 1.0F, 5.0F), PartPose.rotation(0.0F, 10.0F, 0.0F));

        return LayerDefinition.create(mesh, 32, 32);
    }

    @Override
    public void render(E pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay) {
        Level level = pBlockEntity.getLevel();
        boolean levelAbsent = level != null;
        BlockState state = levelAbsent ? pBlockEntity.getBlockState() : MetalcoreBlocks.ALUMINUM_BLOCK.get().defaultBlockState(); // change to pipe block
        if (state.getBlock() instanceof SixwayStorageBlock pipeBlock) {
            preRender(pipeBlock);

            pPoseStack.pushPose();
            int light = LevelRenderer.getLightColor(level, state, pBlockEntity.getBlockPos());
            Material material = getMaterial(pBlockEntity);
            VertexConsumer vertexConsumer = material.buffer(pBuffer, RenderType::entityCutout);

            render(pPoseStack, vertexConsumer, light, pPackedLight);

            pPoseStack.popPose();
        }
    }

    private void preRender(SixwayStorageBlock block) {
        this.type = block.getType();
        this.weatherState = block instanceof WeatheringCopper weatheringCopper ? weatheringCopper.getAge() : null;
    }

    private void render(PoseStack poseStack, VertexConsumer vertexConsumer, int light, int overlay) {
        this.core.render(poseStack, vertexConsumer, light, overlay);
        this.pipe.render(poseStack, vertexConsumer, light, overlay);
    }

    private Material getMaterial(E pBlockEntity) {
        return MetalcoreSheets.getPipeMaterial(pBlockEntity, this.type, this.weatherState);
    }
}
