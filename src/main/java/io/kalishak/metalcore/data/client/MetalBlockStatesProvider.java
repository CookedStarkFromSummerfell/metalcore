package io.kalishak.metalcore.data.client;

import io.kalishak.metalcore.world.level.block.MetalcoreBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
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
    }
}
