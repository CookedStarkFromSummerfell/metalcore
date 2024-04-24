package io.kalishak.metalcore.world.level.block;

import io.kalishak.metalcore.Metalcore;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class MetalcoreBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Metalcore.MODID);

    //Aluminum
    public static final DeferredBlock<DropExperienceBlock> ALUMINUM_ORE = BLOCKS.register("aluminum_ore", () -> new DropExperienceBlock(
            ConstantInt.of(0),
            BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 3.0F))
    );
    public static final DeferredBlock<DropExperienceBlock> DEEPSLATE_ALUMINUM_ORE = BLOCKS.register("deepslate_aluminum_ore", () -> new DropExperienceBlock(
            ConstantInt.of(0),
            BlockBehaviour.Properties.ofFullCopy(ALUMINUM_ORE.get()).mapColor(MapColor.DEEPSLATE).strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE))
    );
    public static final DeferredBlock<Block> RAW_ALUMINUM_BLOCK = BLOCKS.register("raw_aluminum_block", () -> new Block(
            BlockBehaviour.Properties.of().mapColor(MapColor.RAW_IRON).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(5.0F, 6.0F))
    );
    public static final DeferredBlock<Block> ALUMINUM_BLOCK = BLOCKS.register("aluminum_block", () -> new Block(
            BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL))
    );

    public static void init(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
