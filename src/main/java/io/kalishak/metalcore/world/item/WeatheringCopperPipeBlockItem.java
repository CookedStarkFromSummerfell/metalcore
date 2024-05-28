package io.kalishak.metalcore.world.item;

import io.kalishak.metalcore.client.renderer.MetalcoreBEWLR;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.function.Consumer;

public class WeatheringCopperPipeBlockItem extends BlockItem {
    public WeatheringCopperPipeBlockItem(DeferredBlock<? extends Block> block, Properties properties) {
        super(block.get(), properties);
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                return MetalcoreBEWLR.INSTANCE;
            }
        });
    }
}
