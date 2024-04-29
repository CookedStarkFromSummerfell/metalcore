package io.kalishak.metalcore.world.level.block;

import io.kalishak.metalcore.Metalcore;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
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

    public static final DeferredBlock<DropExperienceBlock> ALUMINUM_ORE = BLOCKS.register("aluminum_ore", () -> new DropExperienceBlock(
            ConstantInt.of(0),
            BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 3.0F))
    );
    public static final DeferredBlock<DropExperienceBlock> DEEPSLATE_ALUMINUM_ORE = BLOCKS.register("deepslate_aluminum_ore", () -> new DropExperienceBlock(
            ConstantInt.of(0),
            BlockBehaviour.Properties.ofFullCopy(ALUMINUM_ORE.get()).mapColor(MapColor.DEEPSLATE).strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE))
    );

    public static final DeferredBlock<DropExperienceBlock> LEAD_ORE = BLOCKS.register("lead_ore", () -> new DropExperienceBlock(
            ConstantInt.of(0),
            BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 3.0F))
    );
    public static final DeferredBlock<DropExperienceBlock> DEEPSLATE_LEAD_ORE = BLOCKS.register("deepslate_lead_ore", () -> new DropExperienceBlock(
            ConstantInt.of(0),
            BlockBehaviour.Properties.ofFullCopy(LEAD_ORE.get()).mapColor(MapColor.DEEPSLATE).strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE))
    );

    public static final DeferredBlock<DropExperienceBlock> SILICON_ORE = BLOCKS.register("silicon_ore", () -> new DropExperienceBlock(
            ConstantInt.of(0),
            BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 3.0F)
    ));
    public static final DeferredBlock<DropExperienceBlock> DEEPSLATE_SILICON_ORE = BLOCKS.register("deepslate_silicon_ore", () -> new DropExperienceBlock(
            ConstantInt.of(0),
            BlockBehaviour.Properties.ofFullCopy(SILICON_ORE.get()).mapColor(MapColor.DEEPSLATE).strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE)
    ));

    public static final DeferredBlock<DropExperienceBlock> SILVER_ORE = BLOCKS.register("silver_ore", () -> new DropExperienceBlock(
            ConstantInt.of(0),
            BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 3.0F))
    );
    public static final DeferredBlock<DropExperienceBlock> DEEPSLATE_SILVER_ORE = BLOCKS.register("deepslate_silver_ore", () -> new DropExperienceBlock(
            ConstantInt.of(0),
            BlockBehaviour.Properties.ofFullCopy(SILVER_ORE.get()).mapColor(MapColor.DEEPSLATE).strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE))
    );
    public static final DeferredBlock<DropExperienceBlock> END_SILVER_ORE = BLOCKS.register("end_silver_ore", () -> new DropExperienceBlock(
            ConstantInt.of(0),
            BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE))
    );

    public static final DeferredBlock<DropExperienceBlock> TIN_ORE = BLOCKS.register("tin_ore", () -> new DropExperienceBlock(
            ConstantInt.of(0),
            BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 3.0F)
    ));
    public static final DeferredBlock<DropExperienceBlock> DEEPSLATE_TIN_ORE = BLOCKS.register("deepslate_tin_ore", () -> new DropExperienceBlock(
            ConstantInt.of(0),
            BlockBehaviour.Properties.ofFullCopy(TIN_ORE.get()).mapColor(MapColor.DEEPSLATE).strength(3.5F, 3.0F).sound(SoundType.DEEPSLATE)
    ));

    public static final DeferredBlock<Block> RAW_ALUMINUM_BLOCK = BLOCKS.register("raw_aluminum_block", () -> new Block(
            BlockBehaviour.Properties.of().mapColor(MapColor.RAW_IRON).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(5.0F, 6.0F))
    );
    public static final DeferredBlock<Block> ALUMINUM_BLOCK = BLOCKS.register("aluminum_block", () -> new Block(
            BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL))
    );

    public static final DeferredBlock<Block> RAW_LEAD_BLOCK = BLOCKS.register("raw_lead_block", () -> new Block(
            BlockBehaviour.Properties.of().mapColor(MapColor.RAW_IRON).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(5.0F, 6.0F))
    );
    public static final DeferredBlock<Block> LEAD_BLOCK = BLOCKS.register("lead_block", () -> new Block(
            BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL))
    );
    public static final DeferredBlock<Block> RAW_WAXED_LEAD_BLOCK = BLOCKS.register("raw_waxed_lead_block", () -> new Block(
            BlockBehaviour.Properties.of().mapColor(MapColor.RAW_IRON).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(5.0F, 6.0F))
    );
    public static final DeferredBlock<Block> WAXED_LEAD_BLOCK = BLOCKS.register("waxed_lead_block", () -> new Block(
            BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL))
    );

    public static final DeferredBlock<Block> RAW_SILICON_BLOCK = BLOCKS.register("raw_silicon_block", () -> new Block(
            BlockBehaviour.Properties.of().mapColor(MapColor.RAW_IRON).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(4.0F, 5.0F)
    ));

    public static final DeferredBlock<Block> RAW_SILVER_BLOCK = BLOCKS.register("raw_silver_block", () -> new Block(
            BlockBehaviour.Properties.of().mapColor(MapColor.RAW_IRON).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(5.0F, 6.0F))
    );
    public static final DeferredBlock<Block> SILVER_BLOCK = BLOCKS.register("silver_block", () -> new Block(
            BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL))
    );

    public static final DeferredBlock<Block> RAW_TIN_BLOCK = BLOCKS.register("raw_tin_block", () -> new Block(
            BlockBehaviour.Properties.of().mapColor(MapColor.RAW_IRON).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.5F, 5.0F))
    );
    public static final DeferredBlock<Block> TIN_BLOCK = BLOCKS.register("tin_block", () -> new Block(
            BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE).requiresCorrectToolForDrops().strength(3.5F, 5.0F).sound(SoundType.METAL))
    );

    public static void init(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
