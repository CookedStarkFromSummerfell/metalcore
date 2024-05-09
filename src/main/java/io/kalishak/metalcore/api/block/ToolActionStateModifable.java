package io.kalishak.metalcore.api.block;

import io.kalishak.metalcore.world.level.block.WaxableBlock;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.ToolAction;
import net.neoforged.neoforge.common.ToolActions;

public interface ToolActionStateModifable {

    default BlockState applyToolAction(BlockState state, UseOnContext context, ToolAction toolAction) {
        ItemStack itemStack = context.getItemInHand();

        if (!itemStack.canPerformAction(toolAction)) {
            return null;
        }

        if (ToolActions.AXE_SCRAPE == toolAction) {
            return WeatheringCopperHolder.getPrevious(state).orElse(null);
        } else if (ToolActions.AXE_WAX_OFF == toolAction) {
            return WaxableBlock.getDefault(state).orElse(null);
        }

        return null;
    }
}
