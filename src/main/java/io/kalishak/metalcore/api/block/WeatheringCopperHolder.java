package io.kalishak.metalcore.api.block;

import com.google.common.base.Suppliers;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import io.kalishak.metalcore.world.level.block.MetalcoreBlocks;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import java.util.Optional;
import java.util.function.Supplier;

public interface WeatheringCopperHolder extends WeatheringCopper {
    Supplier<BiMap<Holder<Block>, Holder<Block>>> NEXT_BY_BLOCK = Suppliers.memoize(
            () -> ImmutableBiMap.<Holder<Block>, Holder<Block>>builder()
                    .put(MetalcoreBlocks.COPPER_PIPE, MetalcoreBlocks.EXPOSED_COPPER_PIPE)
                    .put(MetalcoreBlocks.EXPOSED_COPPER_PIPE, MetalcoreBlocks.WEATHERED_COPPER_PIPE)
                    .put(MetalcoreBlocks.WEATHERED_COPPER_PIPE, MetalcoreBlocks.OXIDIZED_COPPER_PIPE)
                    .put(MetalcoreBlocks.COPPER_BELL, MetalcoreBlocks.EXPOSED_COPPER_BELL)
                    .put(MetalcoreBlocks.EXPOSED_COPPER_BELL, MetalcoreBlocks.WEATHERED_COPPER_BELL)
                    .put(MetalcoreBlocks.WEATHERED_COPPER_BELL, MetalcoreBlocks.OXIDIZED_COPPER_BELL)
                    .put(MetalcoreBlocks.COPPER_SPIKES, MetalcoreBlocks.EXPOSED_COPPER_SPIKES)
                    .put(MetalcoreBlocks.EXPOSED_COPPER_SPIKES, MetalcoreBlocks.WEATHERED_COPPER_SPIKES)
                    .put(MetalcoreBlocks.WEATHERED_COPPER_SPIKES, MetalcoreBlocks.OXIDIZED_COPPER_SPIKES)
                    .build()
    );

    Supplier<BiMap<Holder<Block>, Holder<Block>>> PREVIOUS_BY_BLOCK = Suppliers.memoize(() -> NEXT_BY_BLOCK.get().inverse());

    static Optional<Holder<Block>> getPrevious(Holder<Block> block) {
        return Optional.ofNullable(PREVIOUS_BY_BLOCK.get().get(block));
    }

    static Holder<Block> getFirst(Holder<Block> block) {
        Holder<Block> previous = block;

        for (Holder<Block> blockIn = PREVIOUS_BY_BLOCK.get().get(block); blockIn != null; blockIn = PREVIOUS_BY_BLOCK.get().get(blockIn)) {
            previous = blockIn;
        }

        return previous;
    }

    static Optional<BlockState> getPrevious(BlockState blockState) {
        return getPrevious(blockState.getBlockHolder()).map(block -> block.value().withPropertiesOf(blockState));
    }

    static Optional<Holder<Block>> getNext(Holder<Block> block) {
        return Optional.ofNullable(NEXT_BY_BLOCK.get().get(block));
    }

    static BlockState getFirst(BlockState blockState) {
        return getFirst(blockState.getBlockHolder()).value().withPropertiesOf(blockState);
    }

    @Override
    default Optional<BlockState> getNext(BlockState pState) {
        return getNext(pState.getBlockHolder()).map(block -> block.value().withPropertiesOf(pState));
    }

    @Override
    @Deprecated
    default float getChanceModifier() {
        return getChanceModifierForState(((Block) this).defaultBlockState());
    }

    default float getChanceModifierForState(BlockState pState) {
        boolean flag = pState.hasProperty(BlockStateProperties.WATERLOGGED);
        float modifier = getAge() == WeatherState.UNAFFECTED ? 0.75F : 1.0F;

        if (flag && pState.getValue(BlockStateProperties.WATERLOGGED)) {
            modifier += 0.25F;
        }

        return modifier;
    }
}
