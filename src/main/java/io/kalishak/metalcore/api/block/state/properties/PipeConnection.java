package io.kalishak.metalcore.api.block.state.properties;

import net.minecraft.util.StringRepresentable;

public enum PipeConnection implements StringRepresentable {
    DEFAULT("default"),
    NONE("none"),
    RECEIVE("receive"),
    EXTRACT("extract");

    private final String value;

    PipeConnection(final String value) {
        this.value = value;
    }

    @Override
    public String getSerializedName() {
        return this.value;
    }

    @Override
    public String toString() {
        return getSerializedName();
    }

    public boolean isConnected() {
        return this != NONE;
    }

    public boolean isReceiving() {
        return this == RECEIVE;
    }

    public boolean isExtracting() {
        return this == EXTRACT;
    }
}
