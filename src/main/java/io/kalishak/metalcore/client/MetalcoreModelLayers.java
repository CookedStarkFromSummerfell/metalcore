package io.kalishak.metalcore.client;

import io.kalishak.metalcore.Metalcore;
import io.kalishak.metalcore.api.block.state.properties.MetalType;
import io.kalishak.metalcore.world.entity.CopperBoat;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public final class MetalcoreModelLayers {
    public static final ModelLayerLocation COPPER_BELL = create("copper_bell");
    public static final ModelLayerLocation COPPER_SHIELD = create("copper_shield");
    public static final ModelLayerLocation PIPE = create("pipe");

    public static ModelLayerLocation createCopperLampBoatModel(CopperBoat.Type type) {
        return create("copper_lamp_boat/" + type.getName());
    }

    public static ModelLayerLocation createCopperBoatModel(CopperBoat.Type type) {
        return create("copper_boat/" + type.getName());
    }

    public static ModelLayerLocation createSignModelName(MetalType metalType) {
        ResourceLocation location = new ResourceLocation(Metalcore.MODID, metalType.name());
        return new ModelLayerLocation(location.withPrefix("weathering_sign/"), "main");
    }

    public static ModelLayerLocation createHangingSignModelName(MetalType metalType) {
        ResourceLocation location = new ResourceLocation(Metalcore.MODID, metalType.name());
        return new ModelLayerLocation(location.withPrefix("weathering_hanging_sign/"), "main");
    }

    private static ModelLayerLocation create(String assetName) {
        return new ModelLayerLocation(new ResourceLocation(Metalcore.MODID, assetName), "main");
    }
}
