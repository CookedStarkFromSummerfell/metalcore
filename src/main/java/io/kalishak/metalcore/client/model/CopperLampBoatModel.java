package io.kalishak.metalcore.client.model;

import io.kalishak.metalcore.world.entity.CopperBoat;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class CopperLampBoatModel<E extends CopperBoat> extends CopperBoatModel<E> {
    private static final String POLE = "pole";
    private static final String LAMP = "lamp";
    private final ModelPart pole;
    private final ModelPart lamp;

    public CopperLampBoatModel(ModelPart pRoot) {
        super(pRoot);
        this.pole = pRoot.getChild(POLE);
        this.lamp = pRoot.getChild(LAMP);
    }

    public static void createChildren(PartDefinition pRoot) {
        CopperBoatModel.createChildren(pRoot);
        pRoot.addOrReplaceChild(
                POLE,
                CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F),
                PartPose.ZERO
        );
        pRoot.addOrReplaceChild(
                LAMP,
                CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F),
                PartPose.ZERO
        );
    }

    public static LayerDefinition createBodyModel() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        createChildren(partdefinition);
        return LayerDefinition.create(meshdefinition, 128, 64);
    }
}
