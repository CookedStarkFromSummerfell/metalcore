package io.kalishak.metalcore.api.item.tool;

import io.kalishak.metalcore.api.foundry.TierMaterial;
import net.minecraft.core.Holder;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.common.ToolAction;
import net.neoforged.neoforge.common.ToolActions;

public class WeatheringPickaxeItem extends WeatheringDiggerItem {
    public WeatheringPickaxeItem(Holder<TierMaterial> tier, Properties properties) {
        super(tier, BlockTags.MINEABLE_WITH_PICKAXE, properties);
    }

    @Override
    public boolean canPerformAction(ItemStack stack, ToolAction toolAction) {
        return ToolActions.DEFAULT_PICKAXE_ACTIONS.contains(toolAction);
    }
}
