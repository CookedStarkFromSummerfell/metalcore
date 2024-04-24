package io.kalishak.metalcore.tags;

import io.kalishak.metalcore.Metalcore;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.material.Fluid;

public class MetalFluidTags {
    public static final TagKey<Fluid> MOLTEN_ALUMINUM = commonTag("molten_aluminum");
    public static final TagKey<Fluid> MOLTEN_BRONZE = commonTag("molten_bronze");
    public static final TagKey<Fluid> MOLTEN_COPPER = commonTag("molten_copper");
    public static final TagKey<Fluid> MOLTEN_GOLD = commonTag("molten_gold");
    public static final TagKey<Fluid> MOLTEN_IRON = commonTag("molten_iron");
    public static final TagKey<Fluid> MOLTEN_LEAD = commonTag("molten_lead");
    public static final TagKey<Fluid> MOLTEN_TIN = commonTag("molten_tin");
    public static final TagKey<Fluid> MOLTEN_SILVER = commonTag("molten_silver");
    public static final TagKey<Fluid> MOLTEN_STEEL = commonTag("molten_steel");

    private static TagKey<Fluid> commonTag(String tagName) {
        return FluidTags.create(new ResourceLocation("c", tagName));
    }

    private static TagKey<Fluid> modTag(String tagName) {
        return FluidTags.create(new ResourceLocation(Metalcore.MODID, tagName));
    }
}
