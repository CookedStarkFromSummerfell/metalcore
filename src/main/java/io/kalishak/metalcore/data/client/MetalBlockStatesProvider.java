package io.kalishak.metalcore.data.client;

import io.kalishak.metalcore.world.level.block.CopperFanBlock;
import io.kalishak.metalcore.world.level.block.CopperSpikesBlock;
import io.kalishak.metalcore.world.level.block.MetalcoreBlocks;
import io.kalishak.metalcore.world.level.block.CopperBellBlock;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BellAttachType;
import net.neoforged.neoforge.client.model.generators.BlockModelBuilder;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class MetalBlockStatesProvider extends BlockStateProvider {
    public MetalBlockStatesProvider(PackOutput output, String modid, ExistingFileHelper exFileHelper) {
        super(output, modid, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(MetalcoreBlocks.ALUMINUM_ORE.get());
        simpleBlock(MetalcoreBlocks.DEEPSLATE_ALUMINUM_ORE.get());
        simpleBlock(MetalcoreBlocks.LEAD_ORE.get());
        simpleBlock(MetalcoreBlocks.DEEPSLATE_LEAD_ORE.get());
        simpleBlock(MetalcoreBlocks.SILICON_ORE.get());
        simpleBlock(MetalcoreBlocks.DEEPSLATE_SILICON_ORE.get());
        simpleBlock(MetalcoreBlocks.SILVER_ORE.get());
        simpleBlock(MetalcoreBlocks.DEEPSLATE_SILVER_ORE.get());
        simpleBlock(MetalcoreBlocks.END_SILVER_ORE.get());
        simpleBlock(MetalcoreBlocks.TIN_ORE.get());
        simpleBlock(MetalcoreBlocks.DEEPSLATE_TIN_ORE.get());
        simpleBlock(MetalcoreBlocks.ALUMINUM_BLOCK.get());
        simpleBlock(MetalcoreBlocks.RAW_ALUMINUM_BLOCK.get());
        simpleBlock(MetalcoreBlocks.LEAD_BLOCK.get());
        simpleBlock(MetalcoreBlocks.RAW_LEAD_BLOCK.get());
        simpleBlock(MetalcoreBlocks.WAXED_LEAD_BLOCK.get());
        simpleBlock(MetalcoreBlocks.RAW_WAXED_LEAD_BLOCK.get());
        simpleBlock(MetalcoreBlocks.RAW_SILICON_BLOCK.get());
        simpleBlock(MetalcoreBlocks.SILVER_BLOCK.get());
        simpleBlock(MetalcoreBlocks.RAW_SILVER_BLOCK.get());
        simpleBlock(MetalcoreBlocks.RAW_TIN_BLOCK.get());
        simpleBlock(MetalcoreBlocks.TIN_BLOCK.get());
        particleOnly(MetalcoreBlocks.COPPER_PIPE.get(), Blocks.COPPER_BLOCK);
        particleOnly(MetalcoreBlocks.EXPOSED_COPPER_PIPE.get(), Blocks.EXPOSED_COPPER);
        particleOnly(MetalcoreBlocks.WEATHERED_COPPER_PIPE.get(), Blocks.WEATHERED_COPPER);
        particleOnly(MetalcoreBlocks.OXIDIZED_COPPER_PIPE.get(), Blocks.OXIDIZED_COPPER);
        particleOnly(MetalcoreBlocks.WAXED_COPPER_PIPE.get(), Blocks.COPPER_BLOCK);
        particleOnly(MetalcoreBlocks.WAXED_EXPOSED_COPPER_PIPE.get(), Blocks.EXPOSED_COPPER);
        particleOnly(MetalcoreBlocks.WAXED_WEATHERED_COPPER_PIPE.get(), Blocks.WEATHERED_COPPER);
        particleOnly(MetalcoreBlocks.WAXED_OXIDIZED_COPPER_PIPE.get(), Blocks.OXIDIZED_COPPER);
        bell(MetalcoreBlocks.COPPER_BELL.get());
        bell(MetalcoreBlocks.EXPOSED_COPPER_BELL.get());
        bell(MetalcoreBlocks.WEATHERED_COPPER_BELL.get());
        bell(MetalcoreBlocks.OXIDIZED_COPPER_BELL.get());
        bell(MetalcoreBlocks.WAXED_COPPER_BELL.get(), MetalcoreBlocks.COPPER_BELL.get());
        bell(MetalcoreBlocks.WAXED_EXPOSED_COPPER_BELL.get(), MetalcoreBlocks.EXPOSED_COPPER_BELL.get());
        bell(MetalcoreBlocks.WAXED_WEATHERED_COPPER_BELL.get(), MetalcoreBlocks.WEATHERED_COPPER_BELL.get());
        bell(MetalcoreBlocks.WAXED_OXIDIZED_COPPER_BELL.get(), MetalcoreBlocks.OXIDIZED_COPPER_BELL.get());
        spikes(MetalcoreBlocks.COPPER_SPIKES.get());
        spikes(MetalcoreBlocks.EXPOSED_COPPER_SPIKES.get());
        spikes(MetalcoreBlocks.WEATHERED_COPPER_SPIKES.get());
        spikes(MetalcoreBlocks.OXIDIZED_COPPER_SPIKES.get());
        spikes(MetalcoreBlocks.WAXED_COPPER_SPIKES.get(), MetalcoreBlocks.COPPER_SPIKES.get());
        spikes(MetalcoreBlocks.WAXED_EXPOSED_COPPER_SPIKES.get(), MetalcoreBlocks.EXPOSED_COPPER_SPIKES.get());
        spikes(MetalcoreBlocks.WAXED_WEATHERED_COPPER_SPIKES.get(), MetalcoreBlocks.WEATHERED_COPPER_SPIKES.get());
        spikes(MetalcoreBlocks.WAXED_OXIDIZED_COPPER_SPIKES.get(), MetalcoreBlocks.OXIDIZED_COPPER_SPIKES.get());
        fan(MetalcoreBlocks.COPPER_FAN.get());
        fan(MetalcoreBlocks.EXPOSED_COPPER_FAN.get());
        fan(MetalcoreBlocks.WEATHERED_COPPER_FAN.get());
        fan(MetalcoreBlocks.OXIDIZED_COPPER_FAN.get());
        fan(MetalcoreBlocks.WAXED_COPPER_FAN.get(), MetalcoreBlocks.COPPER_FAN.get());
        fan(MetalcoreBlocks.WAXED_EXPOSED_COPPER_FAN.get(), MetalcoreBlocks.EXPOSED_COPPER_FAN.get());
        fan(MetalcoreBlocks.WAXED_WEATHERED_COPPER_FAN.get(), MetalcoreBlocks.WEATHERED_COPPER_FAN.get());
        fan(MetalcoreBlocks.WAXED_OXIDIZED_COPPER_FAN.get(), MetalcoreBlocks.OXIDIZED_COPPER_FAN.get());
    }

    private ResourceLocation id(Block block) {
        return BuiltInRegistries.BLOCK.getKey(block);
    }

    private void particleOnly(Block block, Block particleBlock) {
        ResourceLocation id = id(block);

        getVariantBuilder(block)
                .partialState()
                .setModels(ConfiguredModel.builder()
                        .modelFile(models().getBuilder(id.toString()).texture("particle", id(particleBlock).withPrefix("block/")))
                        .build()
                );
    }

    private void bell(Block block, Block textures) {
        getVariantBuilder(block).forAllStatesExcept(state -> {
            int rotation = (int) state.getValue(CopperBellBlock.FACING).toYRot();
            BellAttachType attachType = state.getValue(CopperBellBlock.ATTACHMENT);

            return ConfiguredModel.builder()
                    .modelFile(getBellModel(attachType, id(textures)))
                    .rotationY(rotation)
                    .build();

        }, CopperBellBlock.POWERED, CopperBellBlock.WATERLOGGED);
    }

    private void bell(Block block) {
        bell(block, block);
    }

    private ModelFile getBellModel(BellAttachType attachType, ResourceLocation bellId) {
        String parent = switch (attachType) {
            case FLOOR -> "floor";
            case CEILING -> "ceiling";
            case SINGLE_WALL -> "wall";
            case DOUBLE_WALL -> "between_walls";
        };

        return models()
                .withExistingParent(bellId + "_" + parent, new ResourceLocation("bell_" + parent))
                .texture("particle", bellId.withPrefix("block/") + "_bottom");
    }

    private void spikes(Block block, Block texturesIn) {
        getVariantBuilder(block).forAllStatesExcept(state -> {
            ResourceLocation id = id(texturesIn);
            String parts = "_parts_" + state.getValue(CopperSpikesBlock.PARTS);
            return ConfiguredModel.builder()
                    .modelFile(models().cross(id + parts, id.withPrefix("block/").withSuffix(parts)).renderType("cutout"))
                    .build();
        }, CopperSpikesBlock.WATERLOGGED);
    }

    private void spikes(Block block) {
        spikes(block, block);
    }

    private void fan(Block block, Block texturesIn) {
        ResourceLocation id = id(texturesIn).withPrefix("block/");

        getVariantBuilder(block).forAllStates(state -> {
            Direction facing = state.getValue(CopperFanBlock.FACING);
            Direction.Axis axis = facing.getAxis();
            String vertical = axis == Direction.Axis.Y ? "_vertical" : "";
            String powered = state.getValue(CopperFanBlock.POWERED) ? "_on" : "";
            BlockModelBuilder model;

            if (vertical.isEmpty()) {
                model = models().orientable(id(block) + powered, id.withSuffix("_side"), id.withSuffix("_top"), id.withSuffix("_bottom"));
            } else {
                model = models().orientableVertical(id(block) + vertical + powered, id.withSuffix("_side"), id.withSuffix("_top"));
            }

            var configuredModel = ConfiguredModel.builder().modelFile(model).rotationY(((int) facing.toYRot() + 180) % 360);

            if (!vertical.isEmpty()) {
                configuredModel = configuredModel.rotationX(facing == Direction.DOWN ? 180 : 0);
            }

            return configuredModel.build();
        });
    }

    private void fan(Block block) {
        fan(block, block);
    }
}
