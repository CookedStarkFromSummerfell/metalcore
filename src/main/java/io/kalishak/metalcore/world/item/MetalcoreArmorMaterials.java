package io.kalishak.metalcore.world.item;

import io.kalishak.metalcore.Metalcore;
import io.kalishak.metalcore.tags.MetalItemTags;
import net.minecraft.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.EnumMap;
import java.util.List;

public final class MetalcoreArmorMaterials {
    public static final DeferredRegister<ArmorMaterial> ARMOR_MATERIALS = DeferredRegister.create(Registries.ARMOR_MATERIAL, Metalcore.MODID);

    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> STEEL = ARMOR_MATERIALS.register("steel", () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
        map.put(ArmorItem.Type.BOOTS, 2);
        map.put(ArmorItem.Type.LEGGINGS, 4);
        map.put(ArmorItem.Type.CHESTPLATE, 6);
        map.put(ArmorItem.Type.HELMET, 3);
        map.put(ArmorItem.Type.BODY, 8);
    }), 8, SoundEvents.ARMOR_EQUIP_IRON, () -> Ingredient.of(MetalItemTags.INGOTS_STEEL), List.of(new ArmorMaterial.Layer(new ResourceLocation(Metalcore.MODID, "steel"))), 1.0F, 0.0F));

    public static void init(IEventBus bus) {
        ARMOR_MATERIALS.register(bus);
    }
}
