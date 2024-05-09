package io.kalishak.metalcore.world.level.block;

import io.kalishak.metalcore.api.block.ToolActionStateModifable;
import io.kalishak.metalcore.api.datamaps.MetalcoreApiDatamaps;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Optional;

public interface WaxableBlock extends ToolActionStateModifable {
    static Optional<BlockState> getWaxed(BlockState state) {
        var waxable = state.getBlockHolder().getData(MetalcoreApiDatamaps.WAXABLES);

        return waxable == null ? Optional.empty() : Optional.of(BuiltInRegistries.BLOCK.getHolderOrThrow(waxable.key())).map(block -> block.value().withPropertiesOf(state));
    }

    static Optional<BlockState> getDefault(BlockState state) {
        var unwaxed = state.getBlockHolder().getData(MetalcoreApiDatamaps.UNWAXED);

        return unwaxed == null ? Optional.empty() : Optional.of(BuiltInRegistries.BLOCK.getHolderOrThrow(unwaxed.key())).map(block -> block.value().withPropertiesOf(state));
    }
}
