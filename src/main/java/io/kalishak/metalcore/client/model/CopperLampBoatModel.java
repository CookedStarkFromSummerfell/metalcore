package io.kalishak.metalcore.client.model;

import io.kalishak.metalcore.world.entity.CopperBoat;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class CopperLampBoatModel<E extends CopperBoat> extends CopperBoatModel<E> {
	private final ModelPart bb_main;

	public CopperLampBoatModel(ModelPart root) {
		super(root);
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, 0.0F, -14.0F, 16.0F, 3.0F, 28.0F, new CubeDeformation(0.0F))
		.texOffs(60, 0).addBox(-9.0F, -6.0F, 14.0F, 18.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(60, 8).addBox(-8.0F, -6.0F, -16.0F, 16.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(32, 37).addBox(-10.0F, -6.0F, -14.0F, 2.0F, 6.0F, 28.0F, new CubeDeformation(0.0F))
		.texOffs(0, 31).addBox(8.0F, -6.0F, -14.0F, 2.0F, 6.0F, 28.0F, new CubeDeformation(0.0F))
		.texOffs(0, 31).addBox(-1.0F, -20.0F, 14.0F, 2.0F, 14.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-3.0F, -17.0F, 18.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(12, 13).addBox(-2.0F, -19.0F, 19.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 13).addBox(-1.0F, -22.0F, 14.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 13).addBox(-1.0F, -20.0F, 20.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}
}