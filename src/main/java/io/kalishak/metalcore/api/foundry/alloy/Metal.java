package io.kalishak.metalcore.api.foundry.alloy;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.kalishak.metalcore.api.registries.MetalcoreApiRegistries;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.RegistryFileCodec;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;

import java.util.Optional;

public record Metal(int tintColor, int overlayTintColor, float meltingPoint, float hardness, float resistance, int hardeningTime, boolean weathering,
                    Optional<TagKey<Item>> validItems, Optional<TagKey<Block>> validBlocks, Optional<TagKey<Fluid>> validFluids) {
    public static final Codec<Metal> DIRECT_CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.INT.fieldOf("tint_color").forGetter(Metal::tintColor),
            Codec.INT.fieldOf("overlay_tint_color").forGetter(Metal::overlayTintColor),
            Codec.FLOAT.fieldOf("melting_point").forGetter(Metal::meltingPoint),
            Codec.FLOAT.fieldOf("hardness").forGetter(Metal::hardness),
            Codec.FLOAT.fieldOf("resistance").forGetter(Metal::resistance),
            Codec.INT.fieldOf("hardening_time").forGetter(Metal::hardeningTime),
            Codec.BOOL.fieldOf("weathering").forGetter(Metal::weathering),
            TagKey.codec(Registries.ITEM).optionalFieldOf("valid_items").forGetter(Metal::validItems),
            TagKey.codec(Registries.BLOCK).optionalFieldOf("valid_blocks").forGetter(Metal::validBlocks),
            TagKey.codec(Registries.FLUID).optionalFieldOf("valid_fluids").forGetter(Metal::validFluids)
    ).apply(instance, Metal::new));
    public static final Codec<Holder<Metal>> CODEC = RegistryFileCodec.create(MetalcoreApiRegistries.METAL_KEY, DIRECT_CODEC);

    public static Metal of(int tintColor, int overlayTintColor, float meltingPoint, float hardness, float resistance, int hardeningTime, boolean weathering, TagKey<Item> validItems, TagKey<Block> validBlocks, TagKey<Fluid> validFluids) {
        return new Metal(
                tintColor,
                overlayTintColor,
                meltingPoint,
                hardness,
                resistance,
                hardeningTime,
                weathering,
                Optional.of(validItems),
                Optional.of(validBlocks),
                Optional.of(validFluids)
        );
    }
}
