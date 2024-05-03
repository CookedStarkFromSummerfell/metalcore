package io.kalishak.metalcore.data.client;

import io.kalishak.metalcore.world.level.block.MetalcoreBlocks;
import io.kalishak.metalcore.world.level.block.CopperBellBlock;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BellAttachType;
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
        bell(MetalcoreBlocks.COPPER_BELL.get());
        bell(MetalcoreBlocks.EXPOSED_COPPER_BELL.get());
        bell(MetalcoreBlocks.WEATHERED_COPPER_BELL.get());
        bell(MetalcoreBlocks.OXIDIZED_COPPER_BELL.get());
        spikes(MetalcoreBlocks.COPPER_SPIKES.get());
        spikes(MetalcoreBlocks.EXPOSED_COPPER_SPIKES.get());
        spikes(MetalcoreBlocks.WEATHERED_COPPER_SPIKES.get());
        spikes(MetalcoreBlocks.OXIDIZED_COPPER_SPIKES.get());
        spikes(MetalcoreBlocks.WAXED_COPPER_SPIKES.get(), id(MetalcoreBlocks.COPPER_SPIKES.get()));
        spikes(MetalcoreBlocks.WAXED_EXPOSED_COPPER_SPIKES.get(), id(MetalcoreBlocks.EXPOSED_COPPER_SPIKES.get()));
        spikes(MetalcoreBlocks.WAXED_WEATHERED_COPPER_SPIKES.get(), id(MetalcoreBlocks.WEATHERED_COPPER_SPIKES.get()));
        spikes(MetalcoreBlocks.WAXED_OXIDIZED_COPPER_SPIKES.get(), id(MetalcoreBlocks.OXIDIZED_COPPER_SPIKES.get()));
    }

    private ResourceLocation id(Block block) {
        return BuiltInRegistries.BLOCK.getKey(block);
    }

    private void particleOnly(Block block, Block particleBlock) {
        ResourceLocation id = id(block);

        getVariantBuilder(block)
                .partialState()
                .setModels(ConfiguredModel.builder()
                        .modelFile(models().getBuilder(id.toString()).texture("particle", id(particleBlock)))
                        .build()
                );
    }

    private void bell(Block block) {
        ResourceLocation id = id(block);

        getVariantBuilder(block).forAllStatesExcept(state -> {
            int rotation = (int) state.getValue(CopperBellBlock.FACING).toYRot();
            BellAttachType attachType = state.getValue(CopperBellBlock.ATTACHMENT);

            return ConfiguredModel.builder()
                    .modelFile(getBellModel(attachType, id))
                    .rotationY(rotation)
                    .build();

        }, CopperBellBlock.POWERED, CopperBellBlock.WATERLOGGED);
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

    private void spikes(Block block, ResourceLocation texturesIn) {
        simpleBlock(block, models().cross(id(block).toString(), texturesIn.withPrefix("block/")));
    }

    private void spikes(Block block) {
        spikes(block, id(block));
    }
}
