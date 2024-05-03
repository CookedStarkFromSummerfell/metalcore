package io.kalishak.metalcore.api.client.renderer;

import io.kalishak.metalcore.Metalcore;
import io.kalishak.metalcore.api.block.Pipe;
import io.kalishak.metalcore.api.block.PipeBlockEntity;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.WeatheringCopper;

public class MetalcoreSheets {
    public static final ResourceLocation PIPE_SHEET = new ResourceLocation(Metalcore.MODID, "textures/atlas/pipes.png");
    public static final ResourceLocation COPPER_SHIELD_SHEET = new ResourceLocation(Metalcore.MODID, "textures/atlas/copper_shields.png");
    private static final RenderType PIPE_SHEET_TYPE = RenderType.entityCutoutNoCull(PIPE_SHEET);
    private static final RenderType COPPER_SHIELD_SHEET_TYPE = RenderType.entityNoOutline(COPPER_SHIELD_SHEET);

    public static final Material PIPE_COPPER_LOCATION = pipeMaterial("copper");
    public static final Material PIPE_EXPOSED_COPPER_LOCATION = pipeMaterial("exposed_copper");
    public static final Material PIPE_WEATHERED_COPPER_LOCATION = pipeMaterial("weathered_copper");
    public static final Material PIPE_OXIDIZED_COPPER_LOCATION = pipeMaterial("oxidized_copper");
    public static final Material PIPE_STEEL_GLASS_LOCATION = pipeMaterial("steel_glass");
    public static final Material PIPE_ALUMINUM_LOCATION = pipeMaterial("aluminum");
    public static final Material PIPE_SILVER_LOCATION = pipeMaterial("silver");
    public static final Material PIPE_ISOLATED_LOCATION = pipeMaterial("isolated");

    public static final Material COPPER_SHIELD = shieldMaterial(WeatheringCopper.WeatherState.UNAFFECTED);
    public static final Material EXPOSED_COPPER_SHIELD = shieldMaterial(WeatheringCopper.WeatherState.EXPOSED);
    public static final Material WEATHERED_COPPER_SHIELD = shieldMaterial(WeatheringCopper.WeatherState.WEATHERED);
    public static final Material OXIDIZED_COPPER_SHIELD = shieldMaterial(WeatheringCopper.WeatherState.OXIDIZED);

    public static Material shieldMaterial(WeatheringCopper.WeatherState weatherState) {
        return new Material(COPPER_SHIELD_SHEET, new ResourceLocation(Metalcore.MODID, "entity/shield/" + weatherState.getSerializedName()));
    }

    private static Material pipeMaterial(String pipeName) {
        return new Material(PIPE_SHEET, new ResourceLocation(Metalcore.MODID, "entity/pipe/" + pipeName));
    }

    public static <E extends PipeBlockEntity> Material getPipeMaterial(E pipe, Pipe.Type type, WeatheringCopper.WeatherState weatherState) {
        if (type == Pipe.Type.ITEM && weatherState != null) {
            return switch (weatherState) {
                case EXPOSED -> PIPE_EXPOSED_COPPER_LOCATION;
                case WEATHERED -> PIPE_WEATHERED_COPPER_LOCATION;
                case OXIDIZED -> PIPE_OXIDIZED_COPPER_LOCATION;
                default -> PIPE_COPPER_LOCATION;
            };
        } else if (type == Pipe.Type.FLUID) {
            return PIPE_STEEL_GLASS_LOCATION;
        }

        return PIPE_ALUMINUM_LOCATION;
    }

    public static Material getShieldMaterial(WeatheringCopper.WeatherState weatherState) {
        return switch (weatherState) {
            case UNAFFECTED -> COPPER_SHIELD;
            case EXPOSED -> EXPOSED_COPPER_SHIELD;
            case WEATHERED -> WEATHERED_COPPER_SHIELD;
            case OXIDIZED -> OXIDIZED_COPPER_SHIELD;
        };
    }
}
