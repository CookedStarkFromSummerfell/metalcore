package io.kalishak.metalcore.api.block;

import com.mojang.serialization.Codec;
import io.kalishak.metalcore.api.datamaps.MetalcoreApiDatamaps;
import io.kalishak.metalcore.api.datamaps.WeatheringCopperDataMap;
import io.netty.buffer.ByteBuf;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ChangeOverTimeBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Optional;

public interface WeatheringCopperHolder extends ChangeOverTimeBlock<WeatheringCopperHolder.WeatherState>, ToolActionStateModifable {
    static Optional<Holder<Block>> getNext(Holder<Block> block) {
        WeatheringCopperDataMap data = block.getData(MetalcoreApiDatamaps.WEATHERING_COPPER);
        if (data == null) {
            return Optional.empty();
        } else {
            if (data.nextWeatheringBlock().isPresent()) {
                return Optional.of(BuiltInRegistries.BLOCK.getHolderOrThrow(data.nextWeatheringBlock().get()));
            }
        }

        return Optional.empty();
    }

    static Optional<Holder<Block>> getPrevious(Holder<Block> block) {
        WeatheringCopperDataMap data = block.getData(MetalcoreApiDatamaps.WEATHERING_COPPER);
        if (data == null) {
            return Optional.empty();
        } else {
            if (data.previousWeatheringBlock().isPresent()) {
                return Optional.of(BuiltInRegistries.BLOCK.getHolderOrThrow(data.previousWeatheringBlock().get()));
            }
        }

        return Optional.empty();
    }

    static Holder<Block> getFirst(Holder<Block> block) {
        Optional<Holder<Block>> previous = getPrevious(block);

        return previous.map(blockHolder -> getPrevious(blockHolder).orElse(block)).orElse(block);
    }

    @Override
    default Optional<BlockState> getNext(BlockState blockState) {
        return getNext(blockState.getBlockHolder()).map(blockHolder -> blockHolder.value().withPropertiesOf(blockState));
    }

    static Optional<BlockState> getPrevious(BlockState blockState) {
        return getPrevious(blockState.getBlockHolder()).map(blockHolder -> blockHolder.value().withPropertiesOf(blockState));
    }

    static BlockState getFirst(BlockState blockState) {
        return getFirst(blockState.getBlockHolder()).value().withPropertiesOf(blockState);
    }

    @Override
    default float getChanceModifier() {
        return getAge() == WeatherState.UNAFFECTED ? 0.75F : 1.0F;
    }

    enum WeatherState implements StringRepresentable {
        UNAFFECTED("unaffected"),
        EXPOSED("exposed"),
        WEATHERED("weathered"),
        OXIDIZED("oxidized");

        public static final Codec<WeatherState> CODEC = StringRepresentable.fromEnum(WeatherState::values);
        public static final StreamCodec<ByteBuf, WeatherState> STREAM_CODEC = ByteBufCodecs.fromCodec(CODEC);
        private final String name;

        WeatherState(String pName) {
            this.name = pName;
        }

        @Override
        public String getSerializedName() {
            return this.name;
        }

        public ChatFormatting getTextColor() {
            return switch (this) {
                case WEATHERED -> ChatFormatting.DARK_GREEN;
                case EXPOSED -> ChatFormatting.GREEN;
                default -> ChatFormatting.DARK_GRAY;
            };
        }
    }
}
