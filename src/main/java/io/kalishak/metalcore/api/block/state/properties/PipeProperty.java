package io.kalishak.metalcore.api.block.state.properties;

import com.google.common.base.Predicates;
import com.google.common.collect.Lists;
import net.minecraft.world.level.block.state.properties.EnumProperty;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PipeProperty extends EnumProperty<PipeConnection> {
    public static final PipeProperty CONNECTED_NORTH = PipeProperty.create("connected_north");
    public static final PipeProperty CONNECTED_EAST = PipeProperty.create("connected_east");
    public static final PipeProperty CONNECTED_SOUTH = PipeProperty.create("connected_south");
    public static final PipeProperty CONNECTED_WEST = PipeProperty.create("connected_west");
    public static final PipeProperty CONNECTED_UP = PipeProperty.create("connected_up");
    public static final PipeProperty CONNECTED_DOWN = PipeProperty.create("connected_down");

    protected PipeProperty(String name, Collection<PipeConnection> values) {
        super(name, PipeConnection.class, values);
    }

    public static PipeProperty create(String name) {
        return create(name, Predicates.alwaysTrue());
    }

    public static PipeProperty create(String name, Predicate<PipeConnection> filter) {
        return create(name, Arrays.stream(PipeConnection.values()).filter(filter).collect(Collectors.toList()));
    }

    public static PipeProperty create(String name, PipeConnection... values) {
        return create(name, Lists.newArrayList(values));
    }

    public static PipeProperty create(String name, Collection<PipeConnection> values) {
        return new PipeProperty(name, values);
    }
}
