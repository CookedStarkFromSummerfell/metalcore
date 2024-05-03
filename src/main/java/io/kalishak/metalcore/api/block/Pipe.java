package io.kalishak.metalcore.api.block;

import com.mojang.serialization.Codec;
import net.minecraft.util.StringRepresentable;

import java.util.Locale;

public interface Pipe {

    enum Type implements StringRepresentable {
        ITEM,
        FLUID,
        ENERGY;

        public static final Codec<Type> CODEC = StringRepresentable.fromEnum(Type::values);

        @Override
        public String getSerializedName() {
            return name().toLowerCase(Locale.ROOT);
        }
    }
}
