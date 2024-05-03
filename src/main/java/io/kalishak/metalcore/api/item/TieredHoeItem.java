package io.kalishak.metalcore.api.item;

import com.mojang.datafixers.util.Pair;
import io.kalishak.metalcore.api.tier.TierMaterial;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.neoforged.neoforge.common.ToolAction;
import net.neoforged.neoforge.common.ToolActions;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class TieredHoeItem extends TieredDiggerItem {
    protected TieredHoeItem(Holder<TierMaterial> tier, Properties properties) {
        super(tier, BlockTags.MINEABLE_WITH_HOE, properties);
    }

    public static Consumer<UseOnContext> changeIntoState(BlockState pState) {
        return cxt -> {
            cxt.getLevel().setBlock(cxt.getClickedPos(), pState, 11);
            cxt.getLevel().gameEvent(GameEvent.BLOCK_CHANGE, cxt.getClickedPos(), GameEvent.Context.of(cxt.getPlayer(), pState));
        };
    }

    public static Consumer<UseOnContext> changeIntoStateAndDropItem(BlockState pState, ItemLike pItemToDrop) {
        return cxt -> {
            cxt.getLevel().setBlock(cxt.getClickedPos(), pState, 11);
            cxt.getLevel().gameEvent(GameEvent.BLOCK_CHANGE, cxt.getClickedPos(), GameEvent.Context.of(cxt.getPlayer(), pState));
            Block.popResourceFromFace(cxt.getLevel(), cxt.getClickedPos(), cxt.getClickedFace(), new ItemStack(pItemToDrop));
        };
    }

    public static boolean onlyIfAirAbove(UseOnContext cxt) {
        return cxt.getClickedFace() != Direction.DOWN && cxt.getLevel().getBlockState(cxt.getClickedPos().above()).isAir();
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        BlockPos blockpos = pContext.getClickedPos();
        BlockState toolModifiedState = level.getBlockState(blockpos).getToolModifiedState(pContext, ToolActions.HOE_TILL, false);
        Pair<Predicate<UseOnContext>, Consumer<UseOnContext>> pair = toolModifiedState == null ? null : Pair.of(ctx -> true, changeIntoState(toolModifiedState));

        if (pair == null) {
            return InteractionResult.PASS;
        } else {
            Predicate<UseOnContext> predicate = pair.getFirst();
            Consumer<UseOnContext> consumer = pair.getSecond();

            if (predicate.test(pContext)) {
                Player player = pContext.getPlayer();
                level.playSound(player, blockpos, SoundEvents.HOE_TILL, SoundSource.BLOCKS, 1.0F, 1.0F);

                if (!level.isClientSide) {
                    consumer.accept(pContext);

                    if (player != null) {
                        pContext.getItemInHand().hurtAndBreak(1, player, LivingEntity.getSlotForHand(pContext.getHand()));
                    }
                }

                return InteractionResult.sidedSuccess(level.isClientSide);
            } else {
                return InteractionResult.PASS;
            }
        }
    }

    @Override
    public boolean canPerformAction(ItemStack stack, ToolAction toolAction) {
        return ToolActions.DEFAULT_HOE_ACTIONS.contains(toolAction);
    }
}
