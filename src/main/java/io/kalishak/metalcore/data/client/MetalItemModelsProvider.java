package io.kalishak.metalcore.data.client;

import com.google.common.collect.ImmutableList;
import io.kalishak.metalcore.Metalcore;
import io.kalishak.metalcore.world.item.TieredToolItem;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
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
                .toList();

        for (Item item : items) {
            if (item instanceof BlockItem) {
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
        return item -> true;
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
}
