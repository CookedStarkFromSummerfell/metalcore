package io.kalishak.metalcore.api.item;

import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;

import java.util.Optional;

public interface ChangeOverTimeItem<T extends Enum<T>> {
    Optional<Holder<Item>> getNext(Holder<Item> holder);

    float getChanceModifier();

    default void changeOverTime(Holder<Item> holder, ServerLevel level, InteractionHand hand, LivingEntity entity, RandomSource random) {
        float f = 0.05688889F;

        if (random.nextFloat() < f) {
            getNextItem(holder, random).ifPresent(item -> entity.setItemInHand(hand, item.value().getDefaultInstance()));
        }
    }

    T getAge();

    default Optional<Holder<Item>> getNextItem(Holder<Item> holder, RandomSource random) {
        return random.nextFloat() < getChanceModifier() ? getNext(holder) : Optional.empty();
    }
}
