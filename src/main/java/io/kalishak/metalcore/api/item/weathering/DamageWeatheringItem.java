package io.kalishak.metalcore.api.item.weathering;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class DamageWeatheringItem extends Item {
    public DamageWeatheringItem(Properties pProperties) {
        super(pProperties);
    }

    public static float getPredicate(ItemStack stack, @Nullable ClientLevel level, @Nullable LivingEntity entity, int seed) {
        return (float) DamageState.fromDamageValue(stack).ordinal();
    }

    protected enum DamageState {
        NONE,
        PARTIAL,
        HALF,
        MINIMAL;

        static DamageState fromDamageValue(ItemStack stack) {
            int maxDamage = stack.getMaxDamage();
            int damage = stack.getDamageValue();

            float percentage = (float) damage / (float) maxDamage;

            if (percentage < 0.25F) {
                return MINIMAL;
            } else if (percentage < 0.5F) {
                return HALF;
            } else if (percentage < 0.75F) {
                return PARTIAL;
            }

            return NONE;
        }
    }
}
