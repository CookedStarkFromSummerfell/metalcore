package io.kalishak.metalcore.world.level.block;

import io.kalishak.metalcore.Metalcore;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
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

    public static final DeferredBlock<WeatheringCopperPipeBlock> COPPER_PIPE = BLOCKS.register("copper_pipe", () -> new WeatheringCopperPipeBlock(
            WeatheringCopper.WeatherState.UNAFFECTED,
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.COPPER))
    );
    public static final DeferredBlock<WeatheringCopperPipeBlock> EXPOSED_COPPER_PIPE = BLOCKS.register("exposed_copper_pipe", () -> new WeatheringCopperPipeBlock(
            WeatheringCopper.WeatherState.EXPOSED,
            BlockBehaviour.Properties.ofFullCopy(COPPER_PIPE.get()).mapColor(MapColor.TERRACOTTA_LIGHT_GRAY))
    );
    public static final DeferredBlock<WeatheringCopperPipeBlock> WEATHERED_COPPER_PIPE = BLOCKS.register("weathered_coppper_pipe", () -> new WeatheringCopperPipeBlock(
            WeatheringCopper.WeatherState.WEATHERED,
            BlockBehaviour.Properties.ofFullCopy(COPPER_PIPE.get()).mapColor(MapColor.WARPED_STEM))
    );
    public static final DeferredBlock<WeatheringCopperPipeBlock> OXIDIZED_COPPER_PIPE = BLOCKS.register("oxidized_copper_pipe", () -> new WeatheringCopperPipeBlock(
            WeatheringCopper.WeatherState.OXIDIZED,
            BlockBehaviour.Properties.ofFullCopy(COPPER_PIPE.get()).mapColor(MapColor.WARPED_NYLIUM))
    );
    public static final DeferredBlock<Block> WAXED_COPPER_PIPE = BLOCKS.register("waxed_copper_pipe", () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(COPPER_PIPE.get()))
    );
    public static final DeferredBlock<Block> WAXED_EXPOSED_COPPER_PIPE = BLOCKS.register("waxed_exposed_copper_pipe", () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(EXPOSED_COPPER_PIPE.get()))
    );
    public static final DeferredBlock<Block> WAXED_WEATHERED_COPPER_PIPE = BLOCKS.register("waxed_weathered_copper_pipe", () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(WEATHERED_COPPER_PIPE.get()))
    );
    public static final DeferredBlock<Block> WAXED_OXIDIZED_COPPER_PIPE = BLOCKS.register("waxed_oxidized_copper_pipe", () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(OXIDIZED_COPPER_PIPE.get()))
    );

    public static final DeferredBlock<WeatheringCopperBellBlock> COPPER_BELL = BLOCKS.register("copper_bell", () -> new WeatheringCopperBellBlock(
            WeatheringCopper.WeatherState.UNAFFECTED,
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).forceSolidOn().requiresCorrectToolForDrops().strength(5.0F).sound(SoundType.ANVIL).pushReaction(PushReaction.DESTROY))
    );
    public static final DeferredBlock<WeatheringCopperBellBlock> EXPOSED_COPPER_BELL = BLOCKS.register("exposed_copper_bell", () -> new WeatheringCopperBellBlock(
            WeatheringCopper.WeatherState.EXPOSED,
            BlockBehaviour.Properties.ofFullCopy(COPPER_BELL.get()).mapColor(MapColor.TERRACOTTA_LIGHT_GRAY))
    );
    public static final DeferredBlock<WeatheringCopperBellBlock> WEATHERED_COPPER_BELL = BLOCKS.register("exposed_copper_bell", () -> new WeatheringCopperBellBlock(
            WeatheringCopper.WeatherState.WEATHERED,
            BlockBehaviour.Properties.ofFullCopy(COPPER_BELL.get()).mapColor(MapColor.WARPED_STEM))
    );
    public static final DeferredBlock<WeatheringCopperBellBlock> OXIDIZED_COPPER_BELL = BLOCKS.register("exposed_copper_bell", () -> new WeatheringCopperBellBlock(
            WeatheringCopper.WeatherState.OXIDIZED,
            BlockBehaviour.Properties.ofFullCopy(COPPER_BELL.get()).mapColor(MapColor.WARPED_NYLIUM))
    );
    public static final DeferredBlock<CopperBellBlock> WAXED_COPPER_BELL = BLOCKS.register("waxed_copper_bell", () -> new CopperBellBlock(
            BlockBehaviour.Properties.ofFullCopy(COPPER_BELL.get()))
    );
    public static final DeferredBlock<CopperBellBlock> WAXED_EXPOSED_COPPER_BELL = BLOCKS.register("waxed_exposed_copper_bell", () -> new CopperBellBlock(
            BlockBehaviour.Properties.ofFullCopy(EXPOSED_COPPER_BELL.get()))
    );
    public static final DeferredBlock<CopperBellBlock> WAXED_WEATHERED_COPPER_BELL = BLOCKS.register("waxed_weathered_copper_bell", () -> new CopperBellBlock(
            BlockBehaviour.Properties.ofFullCopy(WEATHERED_COPPER_BELL.get()))
    );
    public static final DeferredBlock<CopperBellBlock> WAXED_OXIDIZED_COPPER_BELL = BLOCKS.register("waxed_oxidized_copper_bell", () -> new CopperBellBlock(
            BlockBehaviour.Properties.ofFullCopy(OXIDIZED_COPPER_BELL.get()))
    );

    public static final DeferredBlock<WeatheringCopperSpikesBlock> COPPER_SPIKES = BLOCKS.register("copper_spikes", () -> new WeatheringCopperSpikesBlock(
            WeatheringCopper.WeatherState.UNAFFECTED,
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).forceSolidOn().requiresCorrectToolForDrops().strength(1.5F).randomTicks().sound(SoundType.COPPER))
    );
    public static final DeferredBlock<WeatheringCopperSpikesBlock> EXPOSED_COPPER_SPIKES = BLOCKS.register("exposed_copper_spikes", () -> new WeatheringCopperSpikesBlock(
            WeatheringCopper.WeatherState.EXPOSED,
            BlockBehaviour.Properties.ofFullCopy(COPPER_SPIKES.get()).mapColor(MapColor.TERRACOTTA_LIGHT_GRAY))
    );
    public static final DeferredBlock<WeatheringCopperSpikesBlock> WEATHERED_COPPER_SPIKES = BLOCKS.register("weathered_copper_spikes", () -> new WeatheringCopperSpikesBlock(
            WeatheringCopper.WeatherState.WEATHERED,
            BlockBehaviour.Properties.ofFullCopy(COPPER_SPIKES.get()).mapColor(MapColor.WARPED_STEM))
    );
    public static final DeferredBlock<WeatheringCopperSpikesBlock> OXIDIZED_COPPER_SPIKES = BLOCKS.register("oxidized_copper_spikes", () -> new WeatheringCopperSpikesBlock(
            WeatheringCopper.WeatherState.OXIDIZED,
            BlockBehaviour.Properties.ofFullCopy(COPPER_SPIKES.get()).mapColor(MapColor.WARPED_NYLIUM))
    );
    public static final DeferredBlock<CopperSpikesBlock> WAXED_COPPER_SPIKES = BLOCKS.register("waxed_copper_spikes", () -> new CopperSpikesBlock(
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).forceSolidOn().requiresCorrectToolForDrops().strength(1.5F).sound(SoundType.COPPER))
    );
    public static final DeferredBlock<CopperSpikesBlock> WAXED_EXPOSED_COPPER_SPIKES = BLOCKS.register("waxed_exposed_copper_spikes", () -> new CopperSpikesBlock(
            BlockBehaviour.Properties.ofFullCopy(WAXED_COPPER_SPIKES.get()).mapColor(MapColor.TERRACOTTA_LIGHT_GRAY))
    );
    public static final DeferredBlock<CopperSpikesBlock> WAXED_WEATHERED_COPPER_SPIKES = BLOCKS.register("waxed_weathered_copper_spikes", () -> new CopperSpikesBlock(
            BlockBehaviour.Properties.ofFullCopy(WAXED_COPPER_SPIKES.get()).mapColor(MapColor.TERRACOTTA_LIGHT_GRAY))
    );
    public static final DeferredBlock<CopperSpikesBlock> WAXED_OXIDIZED_COPPER_SPIKES = BLOCKS.register("waxed_oxidized_copper_spikes", () -> new CopperSpikesBlock(
            BlockBehaviour.Properties.ofFullCopy(WAXED_COPPER_SPIKES.get()).mapColor(MapColor.TERRACOTTA_LIGHT_GRAY))
    );

    //Copper fans and copper spikes and waxed entries

    public static void init(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
