package io.kalishak.metalcore.world.item;

import io.kalishak.metalcore.api.item.WeatheredComponent;
import io.kalishak.metalcore.api.item.WeatheringCopperItem;
import io.kalishak.metalcore.client.renderer.MetalcoreBEWLR;
import io.kalishak.metalcore.component.MetalcoreComponents;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.block.WeatheringCopper;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.ToolAction;
import net.neoforged.neoforge.common.ToolActions;

import java.util.function.Consumer;

public class WeatheringCopperShieldItem extends Item implements WeatheringCopperItem, Equipable {
    public static final int EFFECTIVE_BLOCK_DELAY = 5;
    public static final float MINIMUM_DURABILITY_DAMAGE = 3.0F;

    public WeatheringCopperShieldItem(Properties pProperties) {
        super(pProperties.component(MetalcoreComponents.WEATHERED_ITEM, new WeatheredComponent(WeatheringCopper.WeatherState.UNAFFECTED, false)));
        DispenserBlock.registerBehavior(this, ArmorItem.DISPENSE_ITEM_BEHAVIOR);
    }

    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.BLOCK;
    }

    @Override
    public int getUseDuration(ItemStack pStack) {
        return 72000;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack stack = pPlayer.getItemInHand(pUsedHand);
        pPlayer.startUsingItem(pUsedHand);
        return InteractionResultHolder.consume(stack);
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);

        WeatheredComponent weatheredComponent = pStack.get(MetalcoreComponents.WEATHERED_ITEM);
        if (weatheredComponent != null) {
            if (getChance(pStack) < pLevel.random.nextFloat()) {
                weatheredComponent = new WeatheredComponent(nextState(pStack), true);
                pStack.set(MetalcoreComponents.WEATHERED_ITEM, weatheredComponent);
            }
        }
    }

    @Override
    public boolean isValidRepairItem(ItemStack pStack, ItemStack pRepairCandidate) {
        return pRepairCandidate.is(Tags.Items.INGOTS_COPPER) || super.isValidRepairItem(pStack, pRepairCandidate);
    }

    @Override
    public boolean canPerformAction(ItemStack stack, ToolAction toolAction) {
        return ToolActions.DEFAULT_SHIELD_ACTIONS.contains(toolAction);
    }

    @Override
    public EquipmentSlot getEquipmentSlot() {
        return EquipmentSlot.OFFHAND;
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                return MetalcoreBEWLR.getInstance();
            }
        });
    }

    @Override
    public float getChance(ItemStack stack) {
        return 0.005F;
    }
}
