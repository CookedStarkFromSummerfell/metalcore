package io.kalishak.metalcore.api.item.tool;

import io.kalishak.metalcore.api.foundry.TierMaterial;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.block.Block;

import java.util.List;

public class WeatheringDiggerItem extends WeatheringToolItem {
    protected WeatheringDiggerItem(Holder<TierMaterial> tier, TagKey<Block> correctDrops, Properties properties) {
        super(tier, properties.component(DataComponents.TOOL, tier.value().createToolProperties(correctDrops)));
    }

    public static ItemAttributeModifiers createAttributes(Holder<TierMaterial> tier, float attackDamage, float attackSpeed) {
        return ItemAttributeModifiers.builder()
                .add(
                        Attributes.ATTACK_DAMAGE,
                        new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Tool modifier", attackDamage + tier.value().attackDamageBonus(), AttributeModifier.Operation.ADD_VALUE),
                        EquipmentSlotGroup.MAINHAND)
                .add(
                        Attributes.ATTACK_SPEED,
                        new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Tool modifier", attackSpeed, AttributeModifier.Operation.ADD_VALUE),
                        EquipmentSlotGroup.MAINHAND)
                .build();
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        pStack.hurtAndBreak(2, pAttacker, EquipmentSlot.MAINHAND);
        return true;
    }
}
