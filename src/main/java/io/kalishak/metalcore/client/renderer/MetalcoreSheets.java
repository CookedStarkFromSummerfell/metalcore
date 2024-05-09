package io.kalishak.metalcore.client.renderer;

import io.kalishak.metalcore.Metalcore;
import io.kalishak.metalcore.api.block.Pipe;
import io.kalishak.metalcore.api.block.PipeBlockEntity;
import io.kalishak.metalcore.api.block.WeatheringCopperHolder;
import io.kalishak.metalcore.world.level.block.MetalcoreBlocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.level.block.Block;

public class MetalcoreSheets {
    public static final ResourceLocation COPPER_BELL_SHEET = new ResourceLocation(Metalcore.MODID, "textures/atlas/copper_bells.png");
    public static final ResourceLocation COPPER_SHIELD_SHEET = new ResourceLocation(Metalcore.MODID, "textures/atlas/copper_shields.png");
    public static final ResourceLocation PIPE_SHEET = new ResourceLocation(Metalcore.MODID, "textures/atlas/pipes.png");
    private static final RenderType COPPER_SHIELD_SHEET_TYPE = RenderType.entityNoOutline(COPPER_SHIELD_SHEET);
    private static final RenderType PIPE_SHEET_TYPE = RenderType.entityCutoutNoCull(PIPE_SHEET);

    public static final Material COPPER_BELL = copperBellMaterial(WeatheringCopperHolder.WeatherState.UNAFFECTED);
    public static final Material EXPOSED_COPPER_BELL = copperBellMaterial(WeatheringCopperHolder.WeatherState.EXPOSED);
    public static final Material WEATHERED_COPPER_BELL = copperBellMaterial(WeatheringCopperHolder.WeatherState.WEATHERED);
    public static final Material OXIDIZED_COPPER_BELL = copperBellMaterial(WeatheringCopperHolder.WeatherState.OXIDIZED);

    public static final Material PIPE_COPPER_LOCATION = pipeMaterial("copper");
    public static final Material PIPE_EXPOSED_COPPER_LOCATION = pipeMaterial("exposed_copper");
    public static final Material PIPE_WEATHERED_COPPER_LOCATION = pipeMaterial("weathered_copper");
    public static final Material PIPE_OXIDIZED_COPPER_LOCATION = pipeMaterial("oxidized_copper");
    public static final Material PIPE_STEEL_GLASS_LOCATION = pipeMaterial("steel_glass");
    public static final Material PIPE_ALUMINUM_LOCATION = pipeMaterial("aluminum");
    public static final Material PIPE_SILVER_LOCATION = pipeMaterial("silver");
    public static final Material PIPE_ISOLATED_LOCATION = pipeMaterial("isolated");

    public static final Material COPPER_SHIELD = shieldMaterial(WeatheringCopperHolder.WeatherState.UNAFFECTED);
    public static final Material EXPOSED_COPPER_SHIELD = shieldMaterial(WeatheringCopperHolder.WeatherState.EXPOSED);
    public static final Material WEATHERED_COPPER_SHIELD = shieldMaterial(WeatheringCopperHolder.WeatherState.WEATHERED);
    public static final Material OXIDIZED_COPPER_SHIELD = shieldMaterial(WeatheringCopperHolder.WeatherState.OXIDIZED);

    private static Material copperBellMaterial(WeatheringCopperHolder.WeatherState weatherState) {
        return new Material(InventoryMenu.BLOCK_ATLAS, new ResourceLocation(Metalcore.MODID, "entity/copper_bell/" + weatherState.getSerializedName() + ".png"));
    }

    private static Material pipeMaterial(String pipeName) {
        return new Material(InventoryMenu.BLOCK_ATLAS, new ResourceLocation(Metalcore.MODID, "entity/pipe/" + pipeName + ".png"));
    }

    private static Material shieldMaterial(WeatheringCopperHolder.WeatherState weatherState) {
        return new Material(Sheets.SHIELD_SHEET, new ResourceLocation(Metalcore.MODID, "entity/shield/" + weatherState.getSerializedName() + ".png"));
    }

    public static Material getCopperBellMaterial(Holder<Block> block) {
        if (block.value() instanceof WeatheringCopperHolder weatheringCopper) {
            return switch (weatheringCopper.getAge()) {
                case UNAFFECTED -> COPPER_BELL;
                case EXPOSED -> EXPOSED_COPPER_BELL;
                case WEATHERED -> WEATHERED_COPPER_BELL;
                case OXIDIZED -> OXIDIZED_COPPER_BELL;
            };
        }

        if (block.is(MetalcoreBlocks.WAXED_COPPER_BELL.getKey())) {
            return COPPER_BELL;
        } else if (block.is(MetalcoreBlocks.WAXED_EXPOSED_COPPER_BELL.getKey())) {
            return EXPOSED_COPPER_BELL;
        } else if (block.is(MetalcoreBlocks.WAXED_WEATHERED_COPPER_BELL.getKey())) {
            return WEATHERED_COPPER_BELL;
        } else if (block.is(MetalcoreBlocks.WAXED_OXIDIZED_COPPER_BELL.getKey())) {
            return OXIDIZED_COPPER_BELL;
        }

        return null;
    }

    public static <E extends PipeBlockEntity> Material getPipeMaterial(E pipe, Pipe.Type type, WeatheringCopperHolder.WeatherState weatherState) {
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

    public static Material getShieldMaterial(WeatheringCopperHolder.WeatherState weatherState) {
        return switch (weatherState) {
            case UNAFFECTED -> COPPER_SHIELD;
            case EXPOSED -> EXPOSED_COPPER_SHIELD;
            case WEATHERED -> WEATHERED_COPPER_SHIELD;
            case OXIDIZED -> OXIDIZED_COPPER_SHIELD;
        };
    }
}
