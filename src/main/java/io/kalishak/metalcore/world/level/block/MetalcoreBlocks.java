package io.kalishak.metalcore.world.level.block;

import io.kalishak.metalcore.Metalcore;
import io.kalishak.metalcore.api.block.WeatheringCopperHolder;
import io.kalishak.metalcore.world.level.block.bell.CopperBellBlock;
import io.kalishak.metalcore.world.level.block.bell.WeatheringCopperBellBlock;
import io.kalishak.metalcore.world.level.block.fan.CopperFanBlock;
import io.kalishak.metalcore.world.level.block.fan.WeatheringCopperFanBlock;
import io.kalishak.metalcore.world.level.block.pipe.WeatheringCopperPipeBlock;
import io.kalishak.metalcore.world.level.block.sign.CopperStandingSignBlock;
import io.kalishak.metalcore.world.level.block.sign.CopperWallSignBlock;
import io.kalishak.metalcore.world.level.block.sign.WeatheringCopperStandingSignBlock;
import io.kalishak.metalcore.world.level.block.sign.WeatheringCopperWallSignBlock;
import io.kalishak.metalcore.world.level.block.sign.hanging.CopperCeilingHangingSignBlock;
import io.kalishak.metalcore.world.level.block.sign.hanging.WeatheringCopperCeilingHangingSignBlock;
import io.kalishak.metalcore.world.level.block.sign.hanging.WeatheringCopperWallHangingSignBlock;
import io.kalishak.metalcore.world.level.block.spikes.CopperSpikesBlock;
import io.kalishak.metalcore.world.level.block.spikes.WeatheringCopperSpikesBlock;
import io.kalishak.metalcore.world.level.block.state.properties.MetalcoreMetalTypes;
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
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(3.0F, 3.0F))
    );
    public static final DeferredBlock<DropExperienceBlock> DEEPSLATE_ALUMINUM_ORE = BLOCKS.register("deepslate_aluminum_ore", () -> new DropExperienceBlock(
            ConstantInt.of(0),
            BlockBehaviour.Properties.ofFullCopy(ALUMINUM_ORE.get())
                    .mapColor(MapColor.DEEPSLATE)
                    .strength(4.5F, 3.0F)
                    .sound(SoundType.DEEPSLATE))
    );

    public static final DeferredBlock<DropExperienceBlock> LEAD_ORE = BLOCKS.register("lead_ore", () -> new DropExperienceBlock(
            ConstantInt.of(0),
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(3.0F, 3.0F))
    );
    public static final DeferredBlock<DropExperienceBlock> DEEPSLATE_LEAD_ORE = BLOCKS.register("deepslate_lead_ore", () -> new DropExperienceBlock(
            ConstantInt.of(0),
            BlockBehaviour.Properties.ofFullCopy(LEAD_ORE.get())
                    .mapColor(MapColor.DEEPSLATE)
                    .strength(4.5F, 3.0F)
                    .sound(SoundType.DEEPSLATE))
    );

    public static final DeferredBlock<DropExperienceBlock> SILICON_ORE = BLOCKS.register("silicon_ore", () -> new DropExperienceBlock(
            ConstantInt.of(0),
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(3.0F, 3.0F)
    ));
    public static final DeferredBlock<DropExperienceBlock> DEEPSLATE_SILICON_ORE = BLOCKS.register("deepslate_silicon_ore", () -> new DropExperienceBlock(
            ConstantInt.of(0),
            BlockBehaviour.Properties.ofFullCopy(SILICON_ORE.get())
                    .mapColor(MapColor.DEEPSLATE)
                    .strength(4.5F, 3.0F)
                    .sound(SoundType.DEEPSLATE)
    ));

    public static final DeferredBlock<DropExperienceBlock> SILVER_ORE = BLOCKS.register("silver_ore", () -> new DropExperienceBlock(
            ConstantInt.of(0),
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(3.0F, 3.0F))
    );
    public static final DeferredBlock<DropExperienceBlock> DEEPSLATE_SILVER_ORE = BLOCKS.register("deepslate_silver_ore", () -> new DropExperienceBlock(
            ConstantInt.of(0),
            BlockBehaviour.Properties.ofFullCopy(SILVER_ORE.get())
                    .mapColor(MapColor.DEEPSLATE)
                    .strength(4.5F, 3.0F)
                    .sound(SoundType.DEEPSLATE))
    );
    public static final DeferredBlock<DropExperienceBlock> END_SILVER_ORE = BLOCKS.register("end_silver_ore", () -> new DropExperienceBlock(
            ConstantInt.of(0),
            BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE))
    );

    public static final DeferredBlock<DropExperienceBlock> TIN_ORE = BLOCKS.register("tin_ore", () -> new DropExperienceBlock(
            ConstantInt.of(0),
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(2.0F, 3.0F)
    ));
    public static final DeferredBlock<DropExperienceBlock> DEEPSLATE_TIN_ORE = BLOCKS.register("deepslate_tin_ore", () -> new DropExperienceBlock(
            ConstantInt.of(0),
            BlockBehaviour.Properties.ofFullCopy(TIN_ORE.get())
                    .mapColor(MapColor.DEEPSLATE)
                    .strength(3.5F, 3.0F)
                    .sound(SoundType.DEEPSLATE)
    ));

    public static final DeferredBlock<Block> RAW_ALUMINUM_BLOCK = BLOCKS.register("raw_aluminum_block", () -> new Block(
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.RAW_IRON)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(5.0F, 6.0F))
    );
    public static final DeferredBlock<Block> ALUMINUM_BLOCK = BLOCKS.register("aluminum_block", () -> new Block(
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.METAL)
                    .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                    .requiresCorrectToolForDrops()
                    .strength(5.0F, 6.0F)
                    .sound(SoundType.METAL))
    );

    public static final DeferredBlock<Block> RAW_LEAD_BLOCK = BLOCKS.register("raw_lead_block", () -> new Block(
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.RAW_IRON)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(5.0F, 6.0F))
    );
    public static final DeferredBlock<Block> LEAD_BLOCK = BLOCKS.register("lead_block", () -> new Block(
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.METAL)
                    .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                    .requiresCorrectToolForDrops()
                    .strength(5.0F, 6.0F)
                    .sound(SoundType.METAL))
    );
    public static final DeferredBlock<Block> RAW_WAXED_LEAD_BLOCK = BLOCKS.register("raw_waxed_lead_block", () -> new Block(
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.RAW_IRON)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(5.0F, 6.0F))
    );
    public static final DeferredBlock<Block> WAXED_LEAD_BLOCK = BLOCKS.register("waxed_lead_block", () -> new Block(
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.METAL)
                    .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                    .requiresCorrectToolForDrops()
                    .strength(5.0F, 6.0F)
                    .sound(SoundType.METAL))
    );

    public static final DeferredBlock<Block> RAW_SILICON_BLOCK = BLOCKS.register("raw_silicon_block", () -> new Block(
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.RAW_IRON)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(4.0F, 5.0F)
    ));

    public static final DeferredBlock<Block> RAW_SILVER_BLOCK = BLOCKS.register("raw_silver_block", () -> new Block(
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.RAW_IRON)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(5.0F, 6.0F))
    );
    public static final DeferredBlock<Block> SILVER_BLOCK = BLOCKS.register("silver_block", () -> new Block(
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.METAL)
                    .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                    .requiresCorrectToolForDrops()
                    .strength(5.0F, 6.0F)
                    .sound(SoundType.METAL))
    );

    public static final DeferredBlock<Block> RAW_TIN_BLOCK = BLOCKS.register("raw_tin_block", () -> new Block(
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.RAW_IRON)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(3.5F, 5.0F))
    );
    public static final DeferredBlock<Block> TIN_BLOCK = BLOCKS.register("tin_block", () -> new Block(
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.METAL)
                    .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                    .requiresCorrectToolForDrops()
                    .strength(3.5F, 5.0F)
                    .sound(SoundType.METAL))
    );

    public static final DeferredBlock<WeatheringCopperPipeBlock> COPPER_PIPE = BLOCKS.register("copper_pipe", () -> new WeatheringCopperPipeBlock(
            WeatheringCopperHolder.WeatherState.UNAFFECTED,
            BlockBehaviour.Properties.of()
                    .mapColor(Blocks.COPPER_BLOCK.defaultMapColor())
                    .requiresCorrectToolForDrops()
                    .strength(3.0F, 6.0F)
                    .sound(SoundType.COPPER))
    );
    public static final DeferredBlock<WeatheringCopperPipeBlock> EXPOSED_COPPER_PIPE = BLOCKS.register("exposed_copper_pipe", () -> new WeatheringCopperPipeBlock(
            WeatheringCopperHolder.WeatherState.EXPOSED,
            BlockBehaviour.Properties.ofFullCopy(COPPER_PIPE.get())
                    .mapColor(MapColor.TERRACOTTA_LIGHT_GRAY))
    );
    public static final DeferredBlock<WeatheringCopperPipeBlock> WEATHERED_COPPER_PIPE = BLOCKS.register("weathered_coppper_pipe", () -> new WeatheringCopperPipeBlock(
            WeatheringCopperHolder.WeatherState.WEATHERED,
            BlockBehaviour.Properties.ofFullCopy(COPPER_PIPE.get())
                    .mapColor(MapColor.WARPED_STEM))
    );
    public static final DeferredBlock<WeatheringCopperPipeBlock> OXIDIZED_COPPER_PIPE = BLOCKS.register("oxidized_copper_pipe", () -> new WeatheringCopperPipeBlock(
            WeatheringCopperHolder.WeatherState.OXIDIZED,
            BlockBehaviour.Properties.ofFullCopy(COPPER_PIPE.get())
                    .mapColor(MapColor.WARPED_NYLIUM))
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
            WeatheringCopperHolder.WeatherState.UNAFFECTED,
            BlockBehaviour.Properties.of()
                    .mapColor(Blocks.COPPER_BLOCK.defaultMapColor())
                    .forceSolidOn()
                    .requiresCorrectToolForDrops()
                    .strength(5.0F)
                    .sound(SoundType.ANVIL).pushReaction(PushReaction.DESTROY))
    );
    public static final DeferredBlock<WeatheringCopperBellBlock> EXPOSED_COPPER_BELL = BLOCKS.register("exposed_copper_bell", () -> new WeatheringCopperBellBlock(
            WeatheringCopperHolder.WeatherState.EXPOSED,
            BlockBehaviour.Properties.ofFullCopy(COPPER_BELL.get())
                    .mapColor(MapColor.TERRACOTTA_LIGHT_GRAY))
    );
    public static final DeferredBlock<WeatheringCopperBellBlock> WEATHERED_COPPER_BELL = BLOCKS.register("weathered_copper_bell", () -> new WeatheringCopperBellBlock(
            WeatheringCopperHolder.WeatherState.WEATHERED,
            BlockBehaviour.Properties.ofFullCopy(COPPER_BELL.get())
                    .mapColor(MapColor.WARPED_STEM))
    );
    public static final DeferredBlock<WeatheringCopperBellBlock> OXIDIZED_COPPER_BELL = BLOCKS.register("oxidized_copper_bell", () -> new WeatheringCopperBellBlock(
            WeatheringCopperHolder.WeatherState.OXIDIZED,
            BlockBehaviour.Properties.ofFullCopy(COPPER_BELL.get())
                    .mapColor(MapColor.WARPED_NYLIUM))
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
            WeatheringCopperHolder.WeatherState.UNAFFECTED,
            BlockBehaviour.Properties.of()
                    .mapColor(Blocks.COPPER_BLOCK.defaultMapColor())
                    .forceSolidOn()
                    .requiresCorrectToolForDrops()
                    .strength(1.5F)
                    .randomTicks()
                    .sound(SoundType.COPPER))
    );
    public static final DeferredBlock<WeatheringCopperSpikesBlock> EXPOSED_COPPER_SPIKES = BLOCKS.register("exposed_copper_spikes", () -> new WeatheringCopperSpikesBlock(
            WeatheringCopperHolder.WeatherState.EXPOSED,
            BlockBehaviour.Properties.ofFullCopy(COPPER_SPIKES.get())
                    .mapColor(MapColor.TERRACOTTA_LIGHT_GRAY))
    );
    public static final DeferredBlock<WeatheringCopperSpikesBlock> WEATHERED_COPPER_SPIKES = BLOCKS.register("weathered_copper_spikes", () -> new WeatheringCopperSpikesBlock(
            WeatheringCopperHolder.WeatherState.WEATHERED,
            BlockBehaviour.Properties.ofFullCopy(COPPER_SPIKES.get())
                    .mapColor(MapColor.WARPED_STEM))
    );
    public static final DeferredBlock<WeatheringCopperSpikesBlock> OXIDIZED_COPPER_SPIKES = BLOCKS.register("oxidized_copper_spikes", () -> new WeatheringCopperSpikesBlock(
            WeatheringCopperHolder.WeatherState.OXIDIZED,
            BlockBehaviour.Properties.ofFullCopy(COPPER_SPIKES.get())
                    .mapColor(MapColor.WARPED_NYLIUM))
    );
    public static final DeferredBlock<CopperSpikesBlock> WAXED_COPPER_SPIKES = BLOCKS.register("waxed_copper_spikes", () -> new CopperSpikesBlock(
            BlockBehaviour.Properties.of()
                    .mapColor(Blocks.COPPER_BLOCK.defaultMapColor())
                    .randomTicks()
                    .forceSolidOn()
                    .requiresCorrectToolForDrops()
                    .strength(1.5F)
                    .sound(SoundType.COPPER))
    );
    public static final DeferredBlock<CopperSpikesBlock> WAXED_EXPOSED_COPPER_SPIKES = BLOCKS.register("waxed_exposed_copper_spikes", () -> new CopperSpikesBlock(
            BlockBehaviour.Properties.ofFullCopy(WAXED_COPPER_SPIKES.get())
                    .mapColor(MapColor.TERRACOTTA_LIGHT_GRAY))
    );
    public static final DeferredBlock<CopperSpikesBlock> WAXED_WEATHERED_COPPER_SPIKES = BLOCKS.register("waxed_weathered_copper_spikes", () -> new CopperSpikesBlock(
            BlockBehaviour.Properties.ofFullCopy(WAXED_COPPER_SPIKES.get())
                    .mapColor(MapColor.WARPED_STEM))
    );
    public static final DeferredBlock<CopperSpikesBlock> WAXED_OXIDIZED_COPPER_SPIKES = BLOCKS.register("waxed_oxidized_copper_spikes", () -> new CopperSpikesBlock(
            BlockBehaviour.Properties.ofFullCopy(WAXED_COPPER_SPIKES.get())
                    .mapColor(MapColor.WARPED_NYLIUM))
    );

    public static final DeferredBlock<WeatheringCopperFanBlock> COPPER_FAN = BLOCKS.register("copper_fan", () -> new WeatheringCopperFanBlock(
            WeatheringCopperHolder.WeatherState.UNAFFECTED,
            BlockBehaviour.Properties.of()
                    .mapColor(Blocks.COPPER_BLOCK.defaultMapColor())
                    .requiresCorrectToolForDrops()
                    .strength(4.5F)
                    .sound(SoundType.COPPER))
    );
    public static final DeferredBlock<WeatheringCopperFanBlock> EXPOSED_COPPER_FAN = BLOCKS.register("exposed_copper_fan", () -> new WeatheringCopperFanBlock(
            WeatheringCopperHolder.WeatherState.EXPOSED,
            BlockBehaviour.Properties.ofFullCopy(COPPER_FAN.get())
                    .mapColor(MapColor.TERRACOTTA_LIGHT_GRAY))
    );
    public static final DeferredBlock<WeatheringCopperFanBlock> WEATHERED_COPPER_FAN = BLOCKS.register("weathered_copper_fan", () -> new WeatheringCopperFanBlock(
            WeatheringCopperHolder.WeatherState.WEATHERED,
            BlockBehaviour.Properties.ofFullCopy(COPPER_FAN.get())
                    .mapColor(MapColor.WARPED_STEM))
    );
    public static final DeferredBlock<WeatheringCopperFanBlock> OXIDIZED_COPPER_FAN = BLOCKS.register("oxidized_copper_fan", () -> new WeatheringCopperFanBlock(
            WeatheringCopperHolder.WeatherState.OXIDIZED,
            BlockBehaviour.Properties.ofFullCopy(COPPER_FAN.get())
                    .mapColor(MapColor.WARPED_NYLIUM))
    );
    public static final DeferredBlock<CopperFanBlock> WAXED_COPPER_FAN = BLOCKS.register("waxed_copper_fan", () -> new CopperFanBlock(
            BlockBehaviour.Properties.ofFullCopy(COPPER_FAN.get()))
    );
    public static final DeferredBlock<CopperFanBlock> WAXED_EXPOSED_COPPER_FAN = BLOCKS.register("waxed_exposed_copper_fan", () -> new CopperFanBlock(
            BlockBehaviour.Properties.ofFullCopy(EXPOSED_COPPER_FAN.get()))
    );
    public static final DeferredBlock<CopperFanBlock> WAXED_WEATHERED_COPPER_FAN = BLOCKS.register("waxed_weathered_copper_fan", () -> new CopperFanBlock(
            BlockBehaviour.Properties.ofFullCopy(WEATHERED_COPPER_FAN.get()))
    );
    public static final DeferredBlock<CopperFanBlock> WAXED_OXIDIZED_COPPER_FAN = BLOCKS.register("waxed_oxidized_copper_fan", () -> new CopperFanBlock(
            BlockBehaviour.Properties.ofFullCopy(OXIDIZED_COPPER_FAN.get()))
    );

    public static final DeferredBlock<WeatheringCopperStandingSignBlock> COPPER_SIGN = BLOCKS.register("copper_sign", () -> new WeatheringCopperStandingSignBlock(
            MetalcoreMetalTypes.COPPER,
            WeatheringCopperHolder.WeatherState.UNAFFECTED,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_ORANGE)
                    .requiresCorrectToolForDrops()
                    .forceSolidOn()
                    .instrument(NoteBlockInstrument.BASS)
                    .noCollission()
                    .strength(1.5F)
                    .sound(SoundType.COPPER))
    );
    public static final DeferredBlock<WeatheringCopperStandingSignBlock> EXPOSED_COPPER_SIGN = BLOCKS.register("exposed_copper_sign", () -> new WeatheringCopperStandingSignBlock(
            MetalcoreMetalTypes.EXPOSED_COPPER,
            WeatheringCopperHolder.WeatherState.EXPOSED,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.TERRACOTTA_LIGHT_GRAY)
                    .requiresCorrectToolForDrops()
                    .forceSolidOn()
                    .instrument(NoteBlockInstrument.BASS)
                    .noCollission()
                    .strength(1.5F)
                    .sound(SoundType.COPPER))
    );
    public static final DeferredBlock<WeatheringCopperStandingSignBlock> WEATHERED_COPPER_SIGN = BLOCKS.register("weathered_copper_sign", () -> new WeatheringCopperStandingSignBlock(
            MetalcoreMetalTypes.WEATHERED_COPPER,
            WeatheringCopperHolder.WeatherState.WEATHERED,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.WARPED_STEM)
                    .requiresCorrectToolForDrops()
                    .forceSolidOn()
                    .instrument(NoteBlockInstrument.BASS)
                    .noCollission()
                    .strength(1.5F)
                    .sound(SoundType.COPPER))
    );
    public static final DeferredBlock<WeatheringCopperStandingSignBlock> OXIDIZED_COPPER_SIGN = BLOCKS.register("oxidized_copper_sign", () -> new WeatheringCopperStandingSignBlock(
            MetalcoreMetalTypes.OXIDIZED_COPPER,
            WeatheringCopperHolder.WeatherState.OXIDIZED,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.WARPED_NYLIUM)
                    .requiresCorrectToolForDrops()
                    .forceSolidOn()
                    .instrument(NoteBlockInstrument.BASS)
                    .noCollission()
                    .strength(1.5F)
                    .sound(SoundType.COPPER))
    );

    public static final DeferredBlock<WeatheringCopperWallSignBlock> COPPER_WALL_SIGN = BLOCKS.register("copper_wall_sign", () -> new WeatheringCopperWallSignBlock(
            MetalcoreMetalTypes.COPPER,
            WeatheringCopperHolder.WeatherState.UNAFFECTED,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_ORANGE)
                    .requiresCorrectToolForDrops()
                    .forceSolidOn()
                    .instrument(NoteBlockInstrument.BASS)
                    .noCollission()
                    .strength(1.5F)
                    .sound(SoundType.COPPER)
                    .lootFrom(COPPER_SIGN))
    );
    public static final DeferredBlock<WeatheringCopperWallSignBlock> EXPOSED_COPPER_WALL_SIGN = BLOCKS.register("exposed_copper_wall_sign", () -> new WeatheringCopperWallSignBlock(
            MetalcoreMetalTypes.EXPOSED_COPPER,
            WeatheringCopperHolder.WeatherState.EXPOSED,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_ORANGE)
                    .requiresCorrectToolForDrops()
                    .forceSolidOn()
                    .instrument(NoteBlockInstrument.BASS)
                    .noCollission()
                    .strength(1.5F)
                    .sound(SoundType.COPPER)
                    .lootFrom(EXPOSED_COPPER_SIGN))
    );
    public static final DeferredBlock<WeatheringCopperWallSignBlock> WEATHERED_COPPER_WALL_SIGN = BLOCKS.register("weathered_copper_wall_sign", () -> new WeatheringCopperWallSignBlock(
            MetalcoreMetalTypes.WEATHERED_COPPER,
            WeatheringCopperHolder.WeatherState.WEATHERED,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_ORANGE)
                    .requiresCorrectToolForDrops()
                    .forceSolidOn()
                    .instrument(NoteBlockInstrument.BASS)
                    .noCollission()
                    .strength(1.5F)
                    .sound(SoundType.COPPER)
                    .lootFrom(WEATHERED_COPPER_SIGN))
    );
    public static final DeferredBlock<WeatheringCopperWallSignBlock> OXIDIZED_COPPER_WALL_SIGN = BLOCKS.register("oxidized_copper_wall_sign", () -> new WeatheringCopperWallSignBlock(
            MetalcoreMetalTypes.OXIDIZED_COPPER,
            WeatheringCopperHolder.WeatherState.OXIDIZED,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_ORANGE)
                    .requiresCorrectToolForDrops()
                    .forceSolidOn()
                    .instrument(NoteBlockInstrument.BASS)
                    .noCollission()
                    .strength(1.5F)
                    .sound(SoundType.COPPER)
                    .lootFrom(OXIDIZED_COPPER_SIGN))
    );

    public static final DeferredBlock<WeatheringCopperCeilingHangingSignBlock> COPPER_HANGING_SIGN = BLOCKS.register("hanging_copper_sign", () -> new WeatheringCopperCeilingHangingSignBlock(
            MetalcoreMetalTypes.COPPER,
            WeatheringCopperHolder.WeatherState.UNAFFECTED,
            BlockBehaviour.Properties.of()
                    .mapColor(Blocks.COPPER_BLOCK.defaultMapColor())
                    .forceSolidOn()
                    .instrument(NoteBlockInstrument.BASS)
                    .noCollission()
                    .strength(1.5F)
                    .requiresCorrectToolForDrops())
    );
    public static final DeferredBlock<WeatheringCopperCeilingHangingSignBlock> EXPOSED_COPPER_HANGING_SIGN = BLOCKS.register("hanging_exposed_copper_sign", () -> new WeatheringCopperCeilingHangingSignBlock(
            MetalcoreMetalTypes.EXPOSED_COPPER,
            WeatheringCopperHolder.WeatherState.EXPOSED,
            BlockBehaviour.Properties.of()
                    .mapColor(Blocks.EXPOSED_COPPER.defaultMapColor())
                    .forceSolidOn()
                    .instrument(NoteBlockInstrument.BASS)
                    .noCollission()
                    .strength(1.5F)
                    .requiresCorrectToolForDrops())
    );
    public static final DeferredBlock<WeatheringCopperCeilingHangingSignBlock> WEATHERED_COPPER_HANGING_SIGN = BLOCKS.register("hanging_weathered_copper_sign", () -> new WeatheringCopperCeilingHangingSignBlock(
            MetalcoreMetalTypes.WEATHERED_COPPER,
            WeatheringCopperHolder.WeatherState.WEATHERED,
            BlockBehaviour.Properties.of()
                    .mapColor(Blocks.WEATHERED_COPPER.defaultMapColor())
                    .forceSolidOn()
                    .instrument(NoteBlockInstrument.BASS)
                    .noCollission()
                    .strength(1.5F)
                    .requiresCorrectToolForDrops())
    );
    public static final DeferredBlock<WeatheringCopperCeilingHangingSignBlock> OXIDIZED_COPPER_HANGING_SIGN = BLOCKS.register("hanging_oxidized_copper_sign", () -> new WeatheringCopperCeilingHangingSignBlock(
            MetalcoreMetalTypes.OXIDIZED_COPPER,
            WeatheringCopperHolder.WeatherState.OXIDIZED,
            BlockBehaviour.Properties.of()
                    .mapColor(Blocks.OXIDIZED_COPPER.defaultMapColor())
                    .forceSolidOn()
                    .instrument(NoteBlockInstrument.BASS)
                    .noCollission()
                    .strength(1.5F)
                    .requiresCorrectToolForDrops())
    );

    public static final DeferredBlock<WeatheringCopperWallHangingSignBlock> COPPER_WALL_HANGING_SIGN = BLOCKS.register("wall_hanging_copper_sign", () -> new WeatheringCopperWallHangingSignBlock(
            MetalcoreMetalTypes.COPPER,
            WeatheringCopperHolder.WeatherState.UNAFFECTED,
            BlockBehaviour.Properties.of()
                    .mapColor(Blocks.COPPER_BLOCK.defaultMapColor())
                    .forceSolidOn()
                    .instrument(NoteBlockInstrument.BASS)
                    .noCollission()
                    .strength(1.5F)
                    .requiresCorrectToolForDrops()
                    .lootFrom(COPPER_HANGING_SIGN))
    );
    public static final DeferredBlock<WeatheringCopperWallHangingSignBlock> EXPOSED_COPPER_WALL_HANGING_SIGN = BLOCKS.register("wall_hanging_exposed_copper_sign", () -> new WeatheringCopperWallHangingSignBlock(
            MetalcoreMetalTypes.EXPOSED_COPPER,
            WeatheringCopperHolder.WeatherState.EXPOSED,
            BlockBehaviour.Properties.of()
                    .mapColor(Blocks.EXPOSED_COPPER.defaultMapColor())
                    .forceSolidOn()
                    .instrument(NoteBlockInstrument.BASS)
                    .noCollission()
                    .strength(1.5F)
                    .requiresCorrectToolForDrops()
                    .lootFrom(EXPOSED_COPPER_HANGING_SIGN))
    );
    public static final DeferredBlock<WeatheringCopperWallHangingSignBlock> WEATHERED_COPPER_WALL_HANGING_SIGN = BLOCKS.register("wall_hanging_weathered_copper_sign", () -> new WeatheringCopperWallHangingSignBlock(
            MetalcoreMetalTypes.WEATHERED_COPPER,
            WeatheringCopperHolder.WeatherState.WEATHERED,
            BlockBehaviour.Properties.of()
                    .mapColor(Blocks.WEATHERED_COPPER.defaultMapColor())
                    .forceSolidOn()
                    .instrument(NoteBlockInstrument.BASS)
                    .noCollission()
                    .strength(1.5F)
                    .requiresCorrectToolForDrops()
                    .lootFrom(WEATHERED_COPPER_HANGING_SIGN))
    );
    public static final DeferredBlock<WeatheringCopperWallHangingSignBlock> OXIDIZED_COPPER_WALL_HANGING_SIGN = BLOCKS.register("wall_hanging_oxidized_copper_sign", () -> new WeatheringCopperWallHangingSignBlock(
            MetalcoreMetalTypes.OXIDIZED_COPPER,
            WeatheringCopperHolder.WeatherState.OXIDIZED,
            BlockBehaviour.Properties.of()
                    .mapColor(Blocks.OXIDIZED_COPPER.defaultMapColor())
                    .forceSolidOn()
                    .instrument(NoteBlockInstrument.BASS)
                    .noCollission()
                    .strength(1.5F)
                    .requiresCorrectToolForDrops()
                    .lootFrom(OXIDIZED_COPPER_HANGING_SIGN))
    );

    public static final DeferredBlock<CopperStandingSignBlock> WAXED_COPPER_SIGN = BLOCKS.register("waxed_copper_sign", () -> new CopperStandingSignBlock(
            MetalcoreMetalTypes.COPPER,
            BlockBehaviour.Properties.of()
                    .mapColor(Blocks.COPPER_BLOCK.defaultMapColor())
                    .requiresCorrectToolForDrops()
                    .forceSolidOn()
                    .instrument(NoteBlockInstrument.BASS)
                    .noCollission()
                    .strength(1.5F)
                    .sound(SoundType.COPPER))
    );
    public static final DeferredBlock<CopperStandingSignBlock> WAXED_EXPOSED_COPPER_SIGN = BLOCKS.register("waxed_exposed_copper_sign", () -> new CopperStandingSignBlock(
            MetalcoreMetalTypes.EXPOSED_COPPER,
            BlockBehaviour.Properties.of()
                    .mapColor(Blocks.EXPOSED_COPPER.defaultMapColor())
                    .requiresCorrectToolForDrops()
                    .forceSolidOn()
                    .instrument(NoteBlockInstrument.BASS)
                    .noCollission()
                    .strength(1.5F)
                    .sound(SoundType.COPPER))
    );
    public static final DeferredBlock<CopperStandingSignBlock> WAXED_WEATHERED_COPPER_SIGN = BLOCKS.register("waxed_weathered_copper_sign", () -> new CopperStandingSignBlock(
            MetalcoreMetalTypes.WEATHERED_COPPER,
            BlockBehaviour.Properties.of()
                    .mapColor(Blocks.WEATHERED_COPPER.defaultMapColor())
                    .requiresCorrectToolForDrops()
                    .forceSolidOn()
                    .instrument(NoteBlockInstrument.BASS)
                    .noCollission()
                    .strength(1.5F)
                    .sound(SoundType.COPPER))
    );
    public static final DeferredBlock<CopperStandingSignBlock> WAXED_OXIDIZED_COPPER_SIGN = BLOCKS.register("waxed_oxidized_copper_sign", () -> new CopperStandingSignBlock(
            MetalcoreMetalTypes.OXIDIZED_COPPER,
            BlockBehaviour.Properties.of()
                    .mapColor(Blocks.OXIDIZED_COPPER.defaultMapColor())
                    .requiresCorrectToolForDrops()
                    .forceSolidOn()
                    .instrument(NoteBlockInstrument.BASS)
                    .noCollission()
                    .strength(1.5F)
                    .sound(SoundType.COPPER))
    );

    public static final DeferredBlock<CopperWallSignBlock> WAXED_COPPER_WALL_SIGN = BLOCKS.register("waxed_copper_wall_sign", () -> new CopperWallSignBlock(
            MetalcoreMetalTypes.COPPER,
            BlockBehaviour.Properties.of()
                    .mapColor(Blocks.COPPER_BLOCK.defaultMapColor())
                    .requiresCorrectToolForDrops()
                    .forceSolidOn()
                    .instrument(NoteBlockInstrument.BASS)
                    .noCollission()
                    .strength(1.5F)
                    .sound(SoundType.COPPER)
                    .lootFrom(WAXED_COPPER_SIGN))
    );
    public static final DeferredBlock<CopperWallSignBlock> WAXED_EXPOSED_COPPER_WALL_SIGN = BLOCKS.register("waxed_exposed_copper_wall_sign", () -> new CopperWallSignBlock(
            MetalcoreMetalTypes.EXPOSED_COPPER,
            BlockBehaviour.Properties.of()
                    .mapColor(Blocks.EXPOSED_COPPER.defaultMapColor())
                    .requiresCorrectToolForDrops()
                    .forceSolidOn()
                    .instrument(NoteBlockInstrument.BASS)
                    .noCollission()
                    .strength(1.5F)
                    .sound(SoundType.COPPER)
                    .lootFrom(WAXED_EXPOSED_COPPER_SIGN))
    );
    public static final DeferredBlock<CopperWallSignBlock> WAXED_WEATHERED_COPPER_WALL_SIGN = BLOCKS.register("waxed_weathered_copper_wall_sign", () -> new CopperWallSignBlock(
            MetalcoreMetalTypes.WEATHERED_COPPER,
            BlockBehaviour.Properties.of()
                    .mapColor(Blocks.WEATHERED_COPPER.defaultMapColor())
                    .requiresCorrectToolForDrops()
                    .forceSolidOn()
                    .instrument(NoteBlockInstrument.BASS)
                    .noCollission()
                    .strength(1.5F)
                    .sound(SoundType.COPPER)
                    .lootFrom(WAXED_WEATHERED_COPPER_SIGN))
    );
    public static final DeferredBlock<CopperWallSignBlock> WAXED_OXIDIZED_COPPER_WALL_SIGN = BLOCKS.register("waxed_oxidized_copper_wall_sign", () -> new CopperWallSignBlock(
            MetalcoreMetalTypes.OXIDIZED_COPPER,
            BlockBehaviour.Properties.of()
                    .mapColor(Blocks.OXIDIZED_COPPER.defaultMapColor())
                    .requiresCorrectToolForDrops()
                    .forceSolidOn()
                    .instrument(NoteBlockInstrument.BASS)
                    .noCollission()
                    .strength(1.5F)
                    .sound(SoundType.COPPER)
                    .lootFrom(WAXED_OXIDIZED_COPPER_SIGN))
    );

    public static final DeferredBlock<CopperCeilingHangingSignBlock> WAXED_COPPER_HANGING_SIGN = BLOCKS.register("waxed_hanging_copper_sign", () -> new CopperCeilingHangingSignBlock(
            MetalcoreMetalTypes.COPPER,
            BlockBehaviour.Properties.of()
                    .mapColor(Blocks.COPPER_BLOCK.defaultMapColor())
                    .forceSolidOn()
                    .instrument(NoteBlockInstrument.BASS)
                    .noCollission()
                    .strength(1.5F)
                    .requiresCorrectToolForDrops())
    );
    public static final DeferredBlock<CopperCeilingHangingSignBlock> WAXED_EXPOSED_COPPER_HANGING_SIGN = BLOCKS.register("waxed_hanging_exposed_copper_sign", () -> new CopperCeilingHangingSignBlock(
            MetalcoreMetalTypes.EXPOSED_COPPER,
            BlockBehaviour.Properties.of()
                    .mapColor(Blocks.EXPOSED_COPPER.defaultMapColor())
                    .forceSolidOn()
                    .instrument(NoteBlockInstrument.BASS)
                    .noCollission()
                    .strength(1.5F)
                    .requiresCorrectToolForDrops())
    );
    public static final DeferredBlock<CopperCeilingHangingSignBlock> WAXED_WEATHERED_COPPER_HANGING_SIGN = BLOCKS.register("waxed_hanging_weathered_copper_sign", () -> new CopperCeilingHangingSignBlock(
            MetalcoreMetalTypes.WEATHERED_COPPER,
            BlockBehaviour.Properties.of()
                    .mapColor(Blocks.WEATHERED_COPPER.defaultMapColor())
                    .forceSolidOn()
                    .instrument(NoteBlockInstrument.BASS)
                    .noCollission()
                    .strength(1.5F)
                    .requiresCorrectToolForDrops())
    );
    public static final DeferredBlock<CopperCeilingHangingSignBlock> WAXED_OXIDIZED_COPPER_HANGING_SIGN = BLOCKS.register("waxed_hanging_oxidized_copper_sign", () -> new CopperCeilingHangingSignBlock(
            MetalcoreMetalTypes.OXIDIZED_COPPER,
            BlockBehaviour.Properties.of()
                    .mapColor(Blocks.OXIDIZED_COPPER.defaultMapColor())
                    .forceSolidOn()
                    .instrument(NoteBlockInstrument.BASS)
                    .noCollission()
                    .strength(1.5F)
                    .requiresCorrectToolForDrops())
    );

    public static final DeferredBlock<CopperCeilingHangingSignBlock> WAXED_COPPER_WALL_HANGING_SIGN = BLOCKS.register("wall_hanging_waxed_copper_sign", () -> new CopperCeilingHangingSignBlock(
            MetalcoreMetalTypes.COPPER,
            BlockBehaviour.Properties.of()
                    .mapColor(Blocks.COPPER_BLOCK.defaultMapColor())
                    .forceSolidOn()
                    .instrument(NoteBlockInstrument.BASS)
                    .noCollission()
                    .strength(1.5F)
                    .requiresCorrectToolForDrops()
                    .lootFrom(WAXED_COPPER_HANGING_SIGN))
    );
    public static final DeferredBlock<CopperCeilingHangingSignBlock> WAXED_EXPOSED_COPPER_WALL_HANGING_SIGN = BLOCKS.register("wall_hanging_waxed_exposed_copper_sign", () -> new CopperCeilingHangingSignBlock(
            MetalcoreMetalTypes.EXPOSED_COPPER,
            BlockBehaviour.Properties.of()
                    .mapColor(Blocks.EXPOSED_COPPER.defaultMapColor())
                    .forceSolidOn()
                    .instrument(NoteBlockInstrument.BASS)
                    .noCollission()
                    .strength(1.5F)
                    .requiresCorrectToolForDrops()
                    .lootFrom(WAXED_EXPOSED_COPPER_HANGING_SIGN))
    );
    public static final DeferredBlock<CopperCeilingHangingSignBlock> WAXED_WEATHERED_COPPER_WALL_HANGING_SIGN = BLOCKS.register("wall_hanging_waxed_weathered_copper_sign", () -> new CopperCeilingHangingSignBlock(
            MetalcoreMetalTypes.WEATHERED_COPPER,
            BlockBehaviour.Properties.of()
                    .mapColor(Blocks.WEATHERED_COPPER.defaultMapColor())
                    .forceSolidOn()
                    .instrument(NoteBlockInstrument.BASS)
                    .noCollission()
                    .strength(1.5F)
                    .requiresCorrectToolForDrops()
                    .lootFrom(WAXED_WEATHERED_COPPER_HANGING_SIGN))
    );
    public static final DeferredBlock<CopperCeilingHangingSignBlock> WAXED_OXIDIZED_COPPER_WALL_HANGING_SIGN = BLOCKS.register("wall_hanging_waxed_oxidized_copper_sign", () -> new CopperCeilingHangingSignBlock(
            MetalcoreMetalTypes.OXIDIZED_COPPER,
            BlockBehaviour.Properties.of()
                    .mapColor(Blocks.OXIDIZED_COPPER.defaultMapColor())
                    .forceSolidOn()
                    .instrument(NoteBlockInstrument.BASS)
                    .noCollission()
                    .strength(1.5F)
                    .requiresCorrectToolForDrops()
                    .lootFrom(WAXED_OXIDIZED_COPPER_HANGING_SIGN))
    );

    public static void init(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
