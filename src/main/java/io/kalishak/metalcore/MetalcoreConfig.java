package io.kalishak.metalcore;

import net.neoforged.neoforge.common.ModConfigSpec;

public class MetalcoreConfig {
    public static final ModConfigSpec SERVER_SPEC;
    public static final Server SERVER;

    public static class Server {
        public Server(ModConfigSpec.Builder builder) {

        }
    }

    static {
        var pair = new ModConfigSpec.Builder().configure(Server::new);
        SERVER_SPEC = pair.getRight();
        SERVER = pair.getLeft();
    }
}
