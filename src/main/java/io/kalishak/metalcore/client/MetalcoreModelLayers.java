package io.kalishak.metalcore.client;

import io.kalishak.metalcore.Metalcore;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public final class MetalcoreModelLayers {
    public static final ModelLayerLocation COPPER_BELL = create("copper_bell");
    public static final ModelLayerLocation COPPER_SHIELD = create("copper_shield");
    public static final ModelLayerLocation PIPE = create("pipe");

    private static ModelLayerLocation create(String assetName) {
        return new ModelLayerLocation(new ResourceLocation(Metalcore.MODID, assetName), "main");
    }
}
