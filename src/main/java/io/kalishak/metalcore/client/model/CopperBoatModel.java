package io.kalishak.metalcore.client.model;

import com.google.common.collect.ImmutableList;
import io.kalishak.metalcore.world.entity.CopperBoat;
import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.WaterPatchModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class CopperBoatModel<E extends CopperBoat> extends ListModel<E> implements WaterPatchModel {
    protected static final String LEFT_PADDLE = "left_paddle";
    protected static final String RIGHT_PADDLE = "right_paddle";
    protected static final String WATER_PATCH = "water_patch";
    protected static final String BOTTOM = "bottom";
    protected static final String BACK = "back";
    protected static final String FRONT = "front";
    protected static final String RIGHT = "right";
    protected static final String LEFT = "left";
    private final ModelPart leftPaddle;
    private final ModelPart rightPaddle;
    private final ModelPart waterPatch;
    private final ImmutableList<ModelPart> parts;

    public CopperBoatModel(ModelPart pRoot) {
        this.leftPaddle = pRoot.getChild(LEFT_PADDLE);
        this.rightPaddle = pRoot.getChild(RIGHT_PADDLE);
        this.waterPatch = pRoot.getChild(WATER_PATCH);
        this.parts = this.createPartsBuilder(pRoot).build();
    }

    protected ImmutableList.Builder<ModelPart> createPartsBuilder(ModelPart pRoot) {
        ImmutableList.Builder<ModelPart> builder = new ImmutableList.Builder<>();
        builder.add(
                pRoot.getChild(BOTTOM),
                pRoot.getChild(BACK),
                pRoot.getChild(FRONT),
                pRoot.getChild(RIGHT),
                pRoot.getChild(LEFT),
                this.leftPaddle,
                this.rightPaddle
        );
        return builder;
    }

    public static void createChildren(PartDefinition pRoot) {
        pRoot.addOrReplaceChild(
                BOTTOM,
                CubeListBuilder.create().texOffs(0, 0).addBox(-14.0F, -9.0F, -3.0F, 28.0F, 16.0F, 3.0F),
                PartPose.offsetAndRotation(0.0F, 3.0F, 1.0F, (float) (Math.PI / 2), 0.0F, 0.0F)
        );
        pRoot.addOrReplaceChild(
                BACK,
                CubeListBuilder.create().texOffs(0, 19).addBox(-13.0F, -7.0F, -1.0F, 18.0F, 6.0F, 2.0F),
                PartPose.offsetAndRotation(-15.0F, 4.0F, 4.0F, 0.0F, (float) (Math.PI * 3.0 / 2.0), 0.0F)
        );
        pRoot.addOrReplaceChild(
                FRONT,
                CubeListBuilder.create().texOffs(0, 27).addBox(-8.0F, -7.0F, -1.0F, 16.0F, 6.0F, 2.0F),
                PartPose.offsetAndRotation(15.0F, 4.0F, 0.0F, 0.0F, (float) (Math.PI / 2), 0.0F)
        );
        pRoot.addOrReplaceChild(
                RIGHT,
                CubeListBuilder.create().texOffs(0, 35).addBox(-14.0F, -7.0F, -1.0F, 28.0F, 6.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, 4.0F, -9.0F, 0.0F, (float) Math.PI, 0.0F)
        );
        pRoot.addOrReplaceChild(
                LEFT, CubeListBuilder.create().texOffs(0, 43).addBox(-14.0F, -7.0F, -1.0F, 28.0F, 6.0F, 2.0F), PartPose.offset(0.0F, 4.0F, 9.0F)
        );
        int j1 = 20;
        int k1 = 7;
        int l1 = 6;
        float f = -5.0F;
        pRoot.addOrReplaceChild(
                LEFT_PADDLE,
                CubeListBuilder.create().texOffs(62, 0).addBox(-1.0F, 0.0F, -5.0F, 2.0F, 2.0F, 18.0F).addBox(-1.001F, -3.0F, 8.0F, 1.0F, 6.0F, 7.0F),
                PartPose.offsetAndRotation(3.0F, -5.0F, 9.0F, 0.0F, 0.0F, (float) (Math.PI / 16))
        );
        pRoot.addOrReplaceChild(
                RIGHT_PADDLE,
                CubeListBuilder.create().texOffs(62, 20).addBox(-1.0F, 0.0F, -5.0F, 2.0F, 2.0F, 18.0F).addBox(0.001F, -3.0F, 8.0F, 1.0F, 6.0F, 7.0F),
                PartPose.offsetAndRotation(3.0F, -5.0F, -9.0F, 0.0F, (float) Math.PI, (float) (Math.PI / 16))
        );
        pRoot.addOrReplaceChild(
                WATER_PATCH,
                CubeListBuilder.create().texOffs(0, 0).addBox(-14.0F, -9.0F, -3.0F, 28.0F, 16.0F, 3.0F),
                PartPose.offsetAndRotation(0.0F, -3.0F, 1.0F, (float) (Math.PI / 2), 0.0F, 0.0F)
        );
    }

    public static LayerDefinition createBodyModel() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        createChildren(partdefinition);
        return LayerDefinition.create(meshdefinition, 128, 64);
    }

    public void setupAnim(E pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        animatePaddle(pEntity, 0, this.leftPaddle, pLimbSwing);
        animatePaddle(pEntity, 1, this.rightPaddle, pLimbSwing);
    }

    public ImmutableList<ModelPart> parts() {
        return this.parts;
    }

    @Override
    public ModelPart waterPatch() {
        return this.waterPatch;
    }

    private static <E extends CopperBoat> void animatePaddle(E pBoat, int pSide, ModelPart pPaddle, float pLimbSwing) {
        float f = pBoat.getRowingTime(pSide, pLimbSwing);
        pPaddle.xRot = Mth.clampedLerp((float) (-Math.PI / 3), (float) (-Math.PI / 12), (Mth.sin(-f) + 1.0F) / 2.0F);
        pPaddle.yRot = Mth.clampedLerp((float) (-Math.PI / 4), (float) (Math.PI / 4), (Mth.sin(-f + 1.0F) + 1.0F) / 2.0F);
        if (pSide == 1) {
            pPaddle.yRot = (float) Math.PI - pPaddle.yRot;
        }
    }
}
