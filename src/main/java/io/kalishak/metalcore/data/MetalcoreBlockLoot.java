package io.kalishak.metalcore.data;

import io.kalishak.metalcore.world.item.MetalcoreItems;
import io.kalishak.metalcore.world.level.block.MetalcoreBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;

import java.util.Set;

public class MetalcoreBlockLoot extends BlockLootSubProvider {
    protected MetalcoreBlockLoot() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        add(MetalcoreBlocks.ALUMINUM_ORE.get(), block -> createOreDrop(block, MetalcoreItems.RAW_ALUMINUM.get()));
        add(MetalcoreBlocks.DEEPSLATE_ALUMINUM_ORE.get(), block -> createOreDrop(block, MetalcoreItems.RAW_ALUMINUM.get()));
        add(MetalcoreBlocks.LEAD_ORE.get(), block -> createOreDrop(block, MetalcoreItems.RAW_LEAD.get()));
        add(MetalcoreBlocks.DEEPSLATE_LEAD_ORE.get(), block -> createOreDrop(block, MetalcoreItems.RAW_LEAD.get()));
        add(MetalcoreBlocks.SILICON_ORE.get(), block -> createOreDrop(block, MetalcoreItems.RAW_SILICON.get()));
        add(MetalcoreBlocks.DEEPSLATE_SILICON_ORE.get(), block -> createOreDrop(block, MetalcoreItems.RAW_SILICON.get()));
        add(MetalcoreBlocks.SILVER_ORE.get(), block -> createOreDrop(block, MetalcoreItems.RAW_SILVER.get()));
        add(MetalcoreBlocks.DEEPSLATE_SILVER_ORE.get(), block -> createOreDrop(block, MetalcoreItems.RAW_SILVER.get()));
        add(MetalcoreBlocks.END_SILVER_ORE.get(), block -> createOreDrop(block, MetalcoreItems.RAW_SILVER.get()));
        add(MetalcoreBlocks.TIN_ORE.get(), block -> createOreDrop(block, MetalcoreItems.RAW_TIN.get()));
        add(MetalcoreBlocks.DEEPSLATE_TIN_ORE.get(), block -> createOreDrop(block, MetalcoreItems.RAW_TIN.get()));
        dropSelf(MetalcoreBlocks.RAW_ALUMINUM_BLOCK.get());
        dropSelf(MetalcoreBlocks.ALUMINUM_BLOCK.get());
        dropSelf(MetalcoreBlocks.RAW_LEAD_BLOCK.get());
        dropSelf(MetalcoreBlocks.LEAD_BLOCK.get());
        dropOther(MetalcoreBlocks.RAW_WAXED_LEAD_BLOCK.get(), MetalcoreBlocks.RAW_LEAD_BLOCK);
        dropOther(MetalcoreBlocks.WAXED_LEAD_BLOCK.get(), MetalcoreBlocks.LEAD_BLOCK);
        dropSelf(MetalcoreBlocks.RAW_SILICON_BLOCK.get());
        dropSelf(MetalcoreBlocks.RAW_SILVER_BLOCK.get());
        dropSelf(MetalcoreBlocks.SILVER_BLOCK.get());
        dropSelf(MetalcoreBlocks.RAW_TIN_BLOCK.get());
        dropSelf(MetalcoreBlocks.TIN_BLOCK.get());
        dropSelf(MetalcoreBlocks.COPPER_PIPE.get());
        dropSelf(MetalcoreBlocks.EXPOSED_COPPER_PIPE.get());
        dropSelf(MetalcoreBlocks.WEATHERED_COPPER_PIPE.get());
        dropSelf(MetalcoreBlocks.OXIDIZED_COPPER_PIPE.get());
        dropSelf(MetalcoreBlocks.COPPER_BELL.get());
        dropSelf(MetalcoreBlocks.EXPOSED_COPPER_BELL.get());
        dropSelf(MetalcoreBlocks.WEATHERED_COPPER_BELL.get());
        dropSelf(MetalcoreBlocks.OXIDIZED_COPPER_BELL.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return MetalcoreBlocks.BLOCKS.getEntries().stream().map(holder -> (Block) holder.get()).toList();
    }
}
