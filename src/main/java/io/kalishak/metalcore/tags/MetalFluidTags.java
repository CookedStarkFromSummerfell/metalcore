package io.kalishak.metalcore.tags;

import io.kalishak.metalcore.Metalcore;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.material.Fluid;

public class MetalFluidTags {
    public static final TagKey<Fluid> MOLTEN_ALUMINUM = commonTag("molten/aluminum");
    public static final TagKey<Fluid> MOLTEN_BRONZE = commonTag("molten/bronze");
    public static final TagKey<Fluid> MOLTEN_COPPER = commonTag("molten/copper");
    public static final TagKey<Fluid> MOLTEN_GOLD = commonTag("molten/gold");
    public static final TagKey<Fluid> MOLTEN_IRON = commonTag("molten/iron");
    public static final TagKey<Fluid> MOLTEN_LEAD = commonTag("molten/lead");
    public static final TagKey<Fluid> MOLTEN_NETHERITE = commonTag("molten/netherite");
    public static final TagKey<Fluid> MOLTEN_STEEL = commonTag("molten/steel");
    public static final TagKey<Fluid> MOLTEN_SILVER = commonTag("molten/silver");
    public static final TagKey<Fluid> MOLTEN_TIN = commonTag("molten/tin");

    private static TagKey<Fluid> commonTag(String tagName) {
        return FluidTags.create(new ResourceLocation("c", tagName));
    }

    private static TagKey<Fluid> modTag(String tagName) {
        return FluidTags.create(new ResourceLocation(Metalcore.MODID, tagName));
    }
}
