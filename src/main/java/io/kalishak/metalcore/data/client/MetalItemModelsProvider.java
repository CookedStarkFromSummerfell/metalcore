package io.kalishak.metalcore.data.client;

import com.google.common.collect.ImmutableList;
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
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
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
        var blackList = ImmutableList.<Item>builder()
                .add(
                        MetalcoreItems.COPPER_SHIELD.get(),
                        MetalcoreItems.COPPER_PIPE.get(), MetalcoreItems.EXPOSED_COPPER_PIPE.get(), MetalcoreItems.WEATHERED_COPPER_PIPE.get(), MetalcoreItems.OXIDIZED_COPPER_PIPE.get(),
                        MetalcoreItems.WAXED_COPPER_PIPE.get(), MetalcoreItems.WAXED_EXPOSED_COPPER_PIPE.get(), MetalcoreItems.WAXED_WEATHERED_COPPER_PIPE.get(), MetalcoreItems.WAXED_OXIDIZED_COPPER_PIPE.get(),
                        MetalcoreItems.COPPER_BELL.get(), MetalcoreItems.EXPOSED_COPPER_BELL.get(), MetalcoreItems.WEATHERED_COPPER_BELL.get(), MetalcoreItems.OXIDIZED_COPPER_BELL.get(),
                        MetalcoreItems.WAXED_COPPER_BELL.get(), MetalcoreItems.WAXED_EXPOSED_COPPER_BELL.get(), MetalcoreItems.WAXED_WEATHERED_COPPER_BELL.get(), MetalcoreItems.WAXED_OXIDIZED_COPPER_BELL.get(),
                        MetalcoreItems.COPPER_SPIKES.get(), MetalcoreItems.EXPOSED_COPPER_SPIKES.get(), MetalcoreItems.WEATHERED_COPPER_SPIKES.get(), MetalcoreItems.OXIDIZED_COPPER_SPIKES.get(),
                        MetalcoreItems.WAXED_COPPER_SPIKES.get(), MetalcoreItems.WAXED_EXPOSED_COPPER_SPIKES.get(), MetalcoreItems.WAXED_WEATHERED_COPPER_SPIKES.get(), MetalcoreItems.WAXED_OXIDIZED_COPPER_SPIKES.get()
                )
                .build();
        var items = BuiltInRegistries.ITEM.entrySet()
                .stream()
                .filter(entry -> entry.getKey().location().getNamespace().equals(Metalcore.MODID))
                .map(entry -> entry.getValue().asItem())
                .filter(item -> !blackList.contains(item))
                .toList();


        shield(MetalcoreItems.COPPER_SHIELD.get());

        entityBuiltin(MetalcoreItems.COPPER_PIPE.get(), id(Items.COPPER_BLOCK));
        entityBuiltin(MetalcoreItems.EXPOSED_COPPER_PIPE.get(), id(Items.EXPOSED_COPPER));
        entityBuiltin(MetalcoreItems.WEATHERED_COPPER_PIPE.get(), id(Items.WEATHERED_COPPER));
        entityBuiltin(MetalcoreItems.OXIDIZED_COPPER_PIPE.get(), id(Items.OXIDIZED_COPPER));
        entityBuiltin(MetalcoreItems.WAXED_COPPER_PIPE.get(), id(Items.COPPER_BLOCK));
        entityBuiltin(MetalcoreItems.WAXED_EXPOSED_COPPER_PIPE.get(), id(Items.EXPOSED_COPPER));
        entityBuiltin(MetalcoreItems.WAXED_WEATHERED_COPPER_PIPE.get(), id(Items.WEATHERED_COPPER));
        entityBuiltin(MetalcoreItems.WAXED_OXIDIZED_COPPER_PIPE.get(), id(Items.OXIDIZED_COPPER));
        basicItem(MetalcoreItems.COPPER_BELL.get());
        waxedItem(MetalcoreItems.EXPOSED_COPPER_BELL.get());
        waxedItem(MetalcoreItems.WEATHERED_COPPER_BELL.get());
        waxedItem(MetalcoreItems.OXIDIZED_COPPER_BELL.get());
        waxedItem(MetalcoreItems.WAXED_COPPER_BELL.get());
        waxedItem(MetalcoreItems.WAXED_EXPOSED_COPPER_BELL.get());
        waxedItem(MetalcoreItems.WAXED_WEATHERED_COPPER_BELL.get());
        waxedItem(MetalcoreItems.WAXED_OXIDIZED_COPPER_BELL.get());
        waxedItem(MetalcoreItems.COPPER_SPIKES.get());
        waxedItem(MetalcoreItems.EXPOSED_COPPER_SPIKES.get());
        waxedItem(MetalcoreItems.WEATHERED_COPPER_SPIKES.get());
        waxedItem(MetalcoreItems.OXIDIZED_COPPER_SPIKES.get());
        waxedItem(MetalcoreItems.WAXED_COPPER_SPIKES.get());
        waxedItem(MetalcoreItems.WAXED_EXPOSED_COPPER_SPIKES.get());
        waxedItem(MetalcoreItems.WAXED_WEATHERED_COPPER_SPIKES.get());
        waxedItem(MetalcoreItems.WAXED_OXIDIZED_COPPER_SPIKES.get());

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

    private ResourceLocation id(Item item) {
        return BuiltInRegistries.ITEM.getKey(item);
    }

    private String name(Item item) {
        return id(item).getPath();
    }

    private void entityBuiltin(Item item, ResourceLocation particleTextures) {
        getBuilder(name(item))
                .parent(new ModelFile.UncheckedModelFile("builtin/entity"))
                .texture("particle", particleTextures.withPrefix("block/"))
                .transforms()
                .transform(ItemDisplayContext.GUI)
                .rotation(30, 45, 0)
                .translation(0, 0, 0)
                .scale(0.625F, 0.625F, 0.625F)
                .end()
                .end();
    }

    private void waxedItem(Item itemIn, ResourceLocation texture) {
        getBuilder(name(itemIn))
                .parent(new ModelFile.UncheckedModelFile("item/generated"))
                .texture("layer0", texture.withPrefix("item/"));
    }

    private void waxedItem(Item itemIn) {
        String name = name(itemIn);
        waxedItem(itemIn, modLoc(name.replace("waxed_", "")));
    }

    private void basicBlock(Item item) {
        getBuilder(name(item))
                .parent(new ModelFile.UncheckedModelFile(new ResourceLocation(Metalcore.MODID, "block/" + name(item))));
    }

    private void basicTool(Item item) {
        getBuilder(name(item))
                .parent(new ModelFile.UncheckedModelFile(new ResourceLocation("item/handheld")))
                .texture("layer0", modLoc(name(item)).withPrefix("item/"));
    }

    private void shield(Item item) {
        String name = name(item);
        shieldBlocking(name);

        getBuilder(name)
                .parent(new ModelFile.UncheckedModelFile(new ResourceLocation("item/shield")))
                .override()
                .predicate(new ResourceLocation("blocking"), 1.0F)
                .model(new ModelFile.UncheckedModelFile(modLoc("item/" + name + "_blocking")))
                .end();
    }

    private void shieldBlocking(String itemName) {
        getBuilder(itemName + "_blocking")
            .parent(new ModelFile.UncheckedModelFile(new ResourceLocation("item/shield_blocking")));
    }
}
