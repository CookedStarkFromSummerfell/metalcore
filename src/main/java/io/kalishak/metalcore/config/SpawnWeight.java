package io.kalishak.metalcore.config;

import net.neoforged.neoforge.common.ModConfigSpec;

import java.util.function.Function;

public final class SpawnWeight {
    private final ModConfigSpec.ConfigValue<Integer> weight;
    private final ModConfigSpec.ConfigValue<Integer> min;
    private final ModConfigSpec.ConfigValue<Integer> max;

    private boolean seenConfigLoadEvent = false;

    public SpawnWeight(ModConfigSpec.Builder builder, Function<ModConfigSpec.Builder, ModConfigSpec.ConfigValue<Integer>> weight,
                       Function<ModConfigSpec.Builder, ModConfigSpec.ConfigValue<Integer>> min,
                       Function<ModConfigSpec.Builder, ModConfigSpec.ConfigValue<Integer>> max) {
        this.weight = weight.apply(builder);
        this.min = min.apply(builder);
        this.max = max.apply(builder);
    }

    public void configEventLoaded() {
        this.seenConfigLoadEvent = true;
    }

    public int getWeight() {
        return this.seenConfigLoadEvent ? this.weight.get() : -1;
    }

    public int getMin() {
        return this.seenConfigLoadEvent ? this.min.get() : -1;
    }

    public int getMax() {
        return this.seenConfigLoadEvent ? this.max.get() : -1;
    }
}
