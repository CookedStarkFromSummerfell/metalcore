package io.kalishak.metalcore.api.registries;

import net.minecraft.world.level.GameRules;

public final class MetalcoreApiGameRules {
    public static final GameRules.Key<GameRules.IntegerValue> RULE_WEATHERING_CHANCE = GameRules.register(
            "weatheringChance", GameRules.Category.UPDATES, GameRules.IntegerValue.create(5)
    );

    public static void init() {}
}
