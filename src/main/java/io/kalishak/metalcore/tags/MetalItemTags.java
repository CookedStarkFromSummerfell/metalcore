package io.kalishak.metalcore.tags;

import io.kalishak.metalcore.Metalcore;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class MetalItemTags {
    public static final TagKey<Item> ALUMINUM_ORES = commonTag("aluminum_ores");
    public static final TagKey<Item> TIN_ORES = commonTag("tin_ores");
    public static final TagKey<Item> LEAD_ORES = commonTag("lead_ores");
    public static final TagKey<Item> SILVER_ORES = commonTag("silver_ores");

    private static TagKey<Item> commonTag(String tagName) {
        return ItemTags.create(new ResourceLocation("c", tagName));
    }

    private static TagKey<Item> modTag(String tagName) {
        return ItemTags.create(new ResourceLocation(Metalcore.MODID, tagName));
    }
}
