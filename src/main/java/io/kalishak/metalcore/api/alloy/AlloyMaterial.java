package io.kalishak.metalcore.api.alloy;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.kalishak.metalcore.Metalcore;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;

import java.util.List;

public record AlloyMaterial(MetalData data, TagKey<Block> metalBlocks, TagKey<Item> metalItems, TagKey<Fluid> moltenMetal, List<AlloyCompound> compounds, boolean isToxic, boolean canOxidize) {
    public static final ResourceKey<Registry<AlloyMaterial>> REGISTRY_KEY = ResourceKey.createRegistryKey(new ResourceLocation(Metalcore.MODID, "alloy_material"));
    public static final Codec<AlloyMaterial> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            MetalData.CODEC.fieldOf("data").forGetter(AlloyMaterial::data),
            TagKey.codec(Registries.BLOCK).fieldOf("blocks").forGetter(AlloyMaterial::metalBlocks),
            TagKey.codec(Registries.ITEM).fieldOf("items").forGetter(AlloyMaterial::metalItems),
            TagKey.codec(Registries.FLUID).fieldOf("molten_fluids").forGetter(AlloyMaterial::moltenMetal),
            AlloyCompound.CODEC.listOf().fieldOf("compounds").flatXmap(list -> {
                AlloyCompound[] compounds = list.toArray(AlloyCompound[]::new);

                if (compounds.length <= 1) {
                    return DataResult.error(() -> "Alloy must have at least two compounds");
                }

                return DataResult.success(List.of(compounds));

            }, DataResult::success).forGetter(AlloyMaterial::compounds),
            Codec.BOOL.fieldOf("is_toxic").forGetter(AlloyMaterial::isToxic),
            Codec.BOOL.fieldOf("can_oxidize").forGetter(AlloyMaterial::canOxidize)
    ).apply(instance, AlloyMaterial::new));
}
