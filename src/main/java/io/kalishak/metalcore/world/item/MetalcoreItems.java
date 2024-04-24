package io.kalishak.metalcore.world.item;

import io.kalishak.metalcore.Metalcore;
import io.kalishak.metalcore.world.level.block.MetalcoreBlocks;
import net.minecraft.world.item.BlockItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class MetalcoreItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Metalcore.MODID);

    public static final DeferredItem<BlockItem> ALUMINUM_ORE = ITEMS.registerSimpleBlockItem(MetalcoreBlocks.ALUMINUM_ORE);
    public static final DeferredItem<BlockItem> DEEPSLATE_ALUMINUM_ORE = ITEMS.registerSimpleBlockItem(MetalcoreBlocks.DEEPSLATE_ALUMINUM_ORE);
    public static final DeferredItem<BlockItem> RAW_ALUMINUM_BLOCK = ITEMS.registerSimpleBlockItem(MetalcoreBlocks.RAW_ALUMINUM_BLOCK);
    public static final DeferredItem<BlockItem> ALUMINUM_BLOCK = ITEMS.registerSimpleBlockItem(MetalcoreBlocks.ALUMINUM_BLOCK);

    public static void init(IEventBus bus) {
        ITEMS.register(bus);
    }
}
