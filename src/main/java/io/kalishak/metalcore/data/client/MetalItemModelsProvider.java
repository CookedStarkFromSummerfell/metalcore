package io.kalishak.metalcore.data.client;

import io.kalishak.metalcore.Metalcore;
import io.kalishak.metalcore.api.block.SixwayStorageBlock;
import io.kalishak.metalcore.api.item.TieredToolItem;
import io.kalishak.metalcore.world.item.MetalcoreItems;
import io.kalishak.metalcore.world.item.WeatheringCopperShieldItem;
import io.kalishak.metalcore.world.level.block.CopperBellBlock;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.List;
import java.util.function.Predicate;

public class MetalItemModelsProvider extends ItemModelProvider {
    public MetalItemModelsProvider(PackOutput output, String modid, ExistingFileHelper existingFileHelper) {
        super(output, modid, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        List<Item> items = BuiltInRegistries.ITEM.entrySet()
                .stream()
                .filter(entry -> entry.getKey().location().getNamespace().equals(Metalcore.MODID))
                .map(entry -> entry.getValue().asItem())
                .filter(offList())
                .toList();

        shield(MetalcoreItems.COPPER_SHIELD.get());

        for (Item item : items) {
            if (item instanceof BlockItem blockItem
                    && !(blockItem.getBlock() instanceof CopperBellBlock)
                    && !(blockItem.getBlock() instanceof SixwayStorageBlock<?>)) {
                basicBlock(item);
            } else {
                if (item instanceof TieredToolItem) {
                    basicTool(item);

                } else {
                    basicItem(item);
                }
            }
        }
    }

    private String name(Item item) {
        return BuiltInRegistries.ITEM.getKey(item).getPath();
    }

    private Predicate<Item> offList() {
        return item -> item instanceof WeatheringCopperShieldItem;
    }

    private void basicBlock(Item item) {
        getBuilder(name(item))
                .parent(new ModelFile.UncheckedModelFile(new ResourceLocation(Metalcore.MODID, "block/" + name(item))));
    }

    private void basicTool(Item item) {
        getBuilder(name(item))
                .parent(new ModelFile.UncheckedModelFile(new ResourceLocation("item/handheld")))
                .texture("layer0", modLoc(name(item)).withSuffix("item/"));
    }

    private void shield(Item item) {
        shieldBlocking(item);

        getBuilder(name(item))
                .parent(new ModelFile.UncheckedModelFile(new ResourceLocation("item/shield")))
                .override()
                .predicate(new ResourceLocation("blocking"), 1.0F)
                .model(new ModelFile.UncheckedModelFile(new ResourceLocation("item/shield_blocking")))
                .end();
    }

    private void shieldBlocking(Item item) {
        getBuilder(name(item) + "_blocking")
            .parent(new ModelFile.UncheckedModelFile(new ResourceLocation("item/shield_blocking")));
    }
}
