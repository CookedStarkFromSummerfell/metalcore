package io.kalishak.metalcore.api.item;

import io.kalishak.metalcore.api.block.WeatheringCopperHolder;
import io.kalishak.metalcore.component.MetalcoreComponents;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class WeatheringArmorItem extends ArmorItem implements WeatheringCopperItem {
    public WeatheringArmorItem(Holder<ArmorMaterial> armorMaterial, Type armorType, Properties properties) {
        super(armorMaterial, armorType, properties.component(MetalcoreComponents.WEATHERED_ITEM, new WeatheredComponent(WeatheringCopperHolder.WeatherState.UNAFFECTED, false)));
    }

    @Override
    public boolean isValidRepairItem(ItemStack pToRepair, ItemStack pRepair) {
        WeatheredComponent weatheredComponent = pToRepair.get(MetalcoreComponents.WEATHERED_ITEM);
        boolean flag = weatheredComponent == null;
        boolean repairable = super.isValidRepairItem(pToRepair, pRepair);

        if (!flag) {
            return repairable && weatheredComponent.age() == WeatheringCopperHolder.WeatherState.UNAFFECTED;
        }

        return repairable || canRepairWith(pToRepair, pRepair);
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        if (!pLevel.isClientSide) {
            changeOverTime(pStack, pLevel, pEntity, pSlotId);
        }
    }

    @Override
    public @Nullable ResourceLocation getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, ArmorMaterial.Layer layer, boolean innerModel) {
        WeatheredComponent weatheredComponent = stack.get(MetalcoreComponents.WEATHERED_ITEM);
        if (weatheredComponent != null) {
            String modId = BuiltInRegistries.ITEM.getKey(stack.getItem()).getNamespace();
            String materialName = BuiltInRegistries.ARMOR_MATERIAL.getKey(this.material.value()).getPath();
            return new ResourceLocation(
                    modId,
                    "textures/models/armor/" + weatheredComponent.age().getSerializedName() + "_" + materialName + "_layer_" + (innerModel ? 2 : 1) + ".png"
            );
        }

        return super.getArmorTexture(stack, entity, slot, layer, innerModel);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext cxt, List<Component> tooltip, TooltipFlag flag) {
        applyTooltip(stack, tooltip);
    }
}
