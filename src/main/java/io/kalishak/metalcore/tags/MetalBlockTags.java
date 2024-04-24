package io.kalishak.metalcore.tags;

import io.kalishak.metalcore.Metalcore;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class MetalBlockTags {
    public static final TagKey<Block> ALUMINUM_ORES = commonTag("aluminum_ores");
    public static final TagKey<Block> TIN_ORES = commonTag("tin_ores");
    public static final TagKey<Block> LEAD_ORES = commonTag("lead_ores");
    public static final TagKey<Block> SILVER_ORES = commonTag("silver_ores");

    private static TagKey<Block> commonTag(String tagName) {
        return BlockTags.create(new ResourceLocation("c", tagName));
    }

    private static TagKey<Block> modTag(String tagName) {
        return BlockTags.create(new ResourceLocation(Metalcore.MODID, tagName));
    }
}
