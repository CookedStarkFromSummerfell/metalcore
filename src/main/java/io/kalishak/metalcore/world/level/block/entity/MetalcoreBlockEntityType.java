package io.kalishak.metalcore.world.level.block.entity;

import io.kalishak.metalcore.Metalcore;
import io.kalishak.metalcore.api.block.PipeBlockEntity;
import io.kalishak.metalcore.world.level.block.MetalcoreBlocks;
import net.minecraft.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.util.datafix.fixes.References;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

@SuppressWarnings("ConstantConditions")
public final class MetalcoreBlockEntityType {
    private static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, Metalcore.MODID);

    public static final Supplier<BlockEntityType<PipeBlockEntity>> PIPE = BLOCK_ENTITIES.register("pipe", () -> BlockEntityType.Builder.of(PipeBlockEntity::new)
            .build(Util.fetchChoiceType(References.BLOCK_ENTITY, "pipe")));
    public static final Supplier<BlockEntityType<CopperPipeBlockEntity>> COPPER_PIPE = BLOCK_ENTITIES.register("copper_pipe", () -> BlockEntityType.Builder.of(CopperPipeBlockEntity::new,
                    MetalcoreBlocks.COPPER_PIPE.get(), MetalcoreBlocks.EXPOSED_COPPER_PIPE.get(), MetalcoreBlocks.WEATHERED_COPPER_PIPE.get(), MetalcoreBlocks.OXIDIZED_COPPER_PIPE.get(),
                    MetalcoreBlocks.WAXED_COPPER_PIPE.get(), MetalcoreBlocks.WAXED_EXPOSED_COPPER_PIPE.get(), MetalcoreBlocks.WAXED_WEATHERED_COPPER_PIPE.get(), MetalcoreBlocks.WAXED_OXIDIZED_COPPER_PIPE.get())
            .build(Util.fetchChoiceType(References.BLOCK_ENTITY, "copper_pipe")));
    public static final Supplier<BlockEntityType<CopperBellBlockEntity>> COPPER_BELL = BLOCK_ENTITIES.register("copper_bell", () -> BlockEntityType.Builder.of(CopperBellBlockEntity::new,
                    MetalcoreBlocks.COPPER_BELL.get(), MetalcoreBlocks.EXPOSED_COPPER_BELL.get(), MetalcoreBlocks.WEATHERED_COPPER_BELL.get(), MetalcoreBlocks.OXIDIZED_COPPER_BELL.get(),
                    MetalcoreBlocks.WAXED_COPPER_BELL.get(), MetalcoreBlocks.WAXED_EXPOSED_COPPER_BELL.get(), MetalcoreBlocks.WAXED_WEATHERED_COPPER_BELL.get(), MetalcoreBlocks.WAXED_OXIDIZED_COPPER_BELL.get())
            .build(Util.fetchChoiceType(References.BLOCK_ENTITY, "copper_bell")));
    public static final Supplier<BlockEntityType<CopperFanBlockEntity>> COPPER_FAN = BLOCK_ENTITIES.register("copper_fan", () -> BlockEntityType.Builder.of(CopperFanBlockEntity::new,
                    MetalcoreBlocks.COPPER_FAN.get(), MetalcoreBlocks.EXPOSED_COPPER_FAN.get(), MetalcoreBlocks.WEATHERED_COPPER_FAN.get(), MetalcoreBlocks.OXIDIZED_COPPER_FAN.get())
            .build(Util.fetchChoiceType(References.BLOCK_ENTITY, "copper_fan")));
    public static final Supplier<BlockEntityType<CopperSignBlockEntity>> COPPER_SIGN = BLOCK_ENTITIES.register("copper_sign", () -> BlockEntityType.Builder.of(CopperSignBlockEntity::new,
                    MetalcoreBlocks.COPPER_SIGN.get(), MetalcoreBlocks.COPPER_WALL_SIGN.get(), MetalcoreBlocks.WAXED_COPPER_SIGN.get(), MetalcoreBlocks.WAXED_COPPER_WALL_SIGN.get(),
                    MetalcoreBlocks.EXPOSED_COPPER_SIGN.get(), MetalcoreBlocks.EXPOSED_COPPER_WALL_SIGN.get(), MetalcoreBlocks.WAXED_EXPOSED_COPPER_SIGN.get(), MetalcoreBlocks.WAXED_EXPOSED_COPPER_WALL_SIGN.get(),
                    MetalcoreBlocks.WEATHERED_COPPER_SIGN.get(), MetalcoreBlocks.WEATHERED_COPPER_WALL_SIGN.get(), MetalcoreBlocks.WAXED_WEATHERED_COPPER_SIGN.get(), MetalcoreBlocks.WAXED_WEATHERED_COPPER_WALL_SIGN.get(),
                    MetalcoreBlocks.OXIDIZED_COPPER_SIGN.get(), MetalcoreBlocks.OXIDIZED_COPPER_WALL_SIGN.get(), MetalcoreBlocks.WAXED_OXIDIZED_COPPER_SIGN.get(), MetalcoreBlocks.WAXED_OXIDIZED_COPPER_WALL_SIGN.get())
            .build(Util.fetchChoiceType(References.BLOCK_ENTITY, "copper_sign")));
    public static final Supplier<BlockEntityType<HangingCopperSignBlockEntity>> HANGING_COPPER_SIGN = BLOCK_ENTITIES.register("hanging_copper_sign", () -> BlockEntityType.Builder.of(HangingCopperSignBlockEntity::new,
                    MetalcoreBlocks.COPPER_HANGING_SIGN.get(), MetalcoreBlocks.COPPER_WALL_HANGING_SIGN.get(), MetalcoreBlocks.WAXED_COPPER_HANGING_SIGN.get(), MetalcoreBlocks.WAXED_COPPER_WALL_HANGING_SIGN.get(),
                    MetalcoreBlocks.EXPOSED_COPPER_HANGING_SIGN.get(), MetalcoreBlocks.EXPOSED_COPPER_WALL_HANGING_SIGN.get(), MetalcoreBlocks.WAXED_EXPOSED_COPPER_HANGING_SIGN.get(), MetalcoreBlocks.WAXED_EXPOSED_COPPER_WALL_HANGING_SIGN.get(),
                    MetalcoreBlocks.WEATHERED_COPPER_HANGING_SIGN.get(), MetalcoreBlocks.WEATHERED_COPPER_WALL_HANGING_SIGN.get(), MetalcoreBlocks.WAXED_WEATHERED_COPPER_HANGING_SIGN.get(), MetalcoreBlocks.WAXED_WEATHERED_COPPER_WALL_HANGING_SIGN.get(),
                    MetalcoreBlocks.OXIDIZED_COPPER_HANGING_SIGN.get(), MetalcoreBlocks.OXIDIZED_COPPER_WALL_HANGING_SIGN.get(), MetalcoreBlocks.WAXED_OXIDIZED_COPPER_HANGING_SIGN.get(), MetalcoreBlocks.WAXED_OXIDIZED_COPPER_WALL_HANGING_SIGN.get())
            .build(Util.fetchChoiceType(References.BLOCK_ENTITY, "hanging_copper_sign")));

    public static void init(IEventBus bus) {
        BLOCK_ENTITIES.register(bus);
    }
}