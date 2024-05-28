package io.kalishak.metalcore.world.item;

import io.kalishak.metalcore.world.level.block.entity.CopperSignBlockEntity;
import io.kalishak.metalcore.world.level.block.sign.CopperSignBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;

public class CopperSignItem extends StandingAndWallBlockItem {
    public CopperSignItem(Block block, Block wallBlock, Properties properties, Direction attachmentDirection) {
        super(block, wallBlock, properties, attachmentDirection);
    }

    public CopperSignItem(Block block, Block wallBlock, Properties properties) {
        super(block, wallBlock, properties, Direction.DOWN);
    }

    @Override
    protected boolean updateCustomBlockEntityTag(BlockPos pos, Level level, @Nullable Player player, ItemStack stack, BlockState state) {
        boolean flag = super.updateCustomBlockEntityTag(pos, level, player, stack, state);
        if (!level.isClientSide && !flag && player != null && level.getBlockEntity(pos) instanceof CopperSignBlockEntity sign && level.getBlockState(pos).getBlock() instanceof CopperSignBlock signBlock) {
            signBlock.openTextEdit(player, sign, true);
        }

        return flag;
    }
}
