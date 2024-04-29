package io.kalishak.metalcore.api.alloy;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.kalishak.metalcore.Metalcore;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.RegistryFileCodec;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;

public record MetalMaterial(MetalData metalData, TagKey<Block> metalBlocks, TagKey<Item> metalItems, TagKey<Fluid> moltenMetal, boolean isToxic, boolean canOxidize) {
    public static final ResourceKey<Registry<MetalMaterial>> REGISTRY_KEY = ResourceKey.createRegistryKey(new ResourceLocation(Metalcore.MODID, "metal_material"));

    public static final Codec<MetalMaterial> DIRECT_CODEC = RecordCodecBuilder.create(instance -> instance.group(
            MetalData.CODEC.fieldOf("data").forGetter(MetalMaterial::metalData),
            TagKey.codec(Registries.BLOCK).fieldOf("blocks").forGetter(MetalMaterial::metalBlocks),
            TagKey.codec(Registries.ITEM).fieldOf("items").forGetter(MetalMaterial::metalItems),
            TagKey.codec(Registries.FLUID).fieldOf("molten_fluids").forGetter(MetalMaterial::moltenMetal),
            Codec.BOOL.fieldOf("is_toxic").forGetter(MetalMaterial::isToxic),
            Codec.BOOL.fieldOf("can_oxidize").forGetter(MetalMaterial::canOxidize)
    ).apply(instance, instance.stable(MetalMaterial::new)));
    public static final Codec<Holder<MetalMaterial>> CODEC = RegistryFileCodec.create(MetalMaterial.REGISTRY_KEY, DIRECT_CODEC);
}
