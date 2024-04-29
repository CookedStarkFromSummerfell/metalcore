package io.kalishak.metalcore.config;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

public class MetalcoreConfig {
    public static final ModConfigSpec SERVER_SPEC;
    public static final Server SERVER;

    public static class Server {
        public final SpawnWeight aluminumSpawnWeight;
        public final SpawnWeight leadSpawnWeight;
        public final SpawnWeight siliconSpawnWeight;
        public final SpawnWeight silverSpawnWeight;
        public final SpawnWeight tinSpawnWeight;

        public Server(ModConfigSpec.Builder builder) {
            builder.push("World Generation");
            this.aluminumSpawnWeight = new SpawnWeight(
                    builder,
                    bld -> bld.comment("Spawn weight of aluminum ores").translation("config.metalcore.server.spawn_weight.aluminum").define("Aluminum Spawn Weight", 80),
                    bld -> bld.define("Aluminum Ore spawns from y", -14),
                    bld -> bld.define("Aluminum Ore spawn to y", 184)
            );
            this.leadSpawnWeight = new SpawnWeight(
                    builder,
                    bld -> bld.comment("Spawn weight of lead ores").translation("config.metalcore.server.spawn_weight.lead").define("Lead Spawn Weight", 20),
                    bld -> bld.define("Lead Ore spawns from y", 32),
                    bld -> bld.define("Lead Ore spawn to y", 89)
            );
            this.siliconSpawnWeight = new SpawnWeight(
                    builder,
                    bld -> bld.comment("Spawn weight of silicon ores").translation("config.metalcore.server.spawn_weight.silicon").define("Silicon Spawn Weight", 40),
                    bld -> bld.define("Silicon Ore spawns from y", 75),
                    bld -> bld.define("Silicon Ore spawn to y", 254)
            );
            this.silverSpawnWeight = new SpawnWeight(
                    builder,
                    bld -> bld.comment("Spawn weight of silver ores").translation("config.metalcore.server.spawn_weight.silver").define("Silver Spawn Weight", 15),
                    bld -> bld.define("Silver Ore spawns from y", -12),
                    bld -> bld.define("Silver Ore spawn to y", 60)
            );
            this.tinSpawnWeight = new SpawnWeight(
                    builder,
                    bld -> bld.comment("Spawn weight of tin ores").translation("config.metalcore.server.spawn_weight.tin").define("Tin Spawn Weight", 60),
                    bld -> bld.define("Tin Ore spawns from y", 0),
                    bld -> bld.define("Tin Ore spawn to y", 80)
            );
            builder.pop();
        }

        @SubscribeEvent
        public void onConfigLoad(ModConfigEvent.Loading event) {
            this.aluminumSpawnWeight.configEventLoaded();
            this.leadSpawnWeight.configEventLoaded();
            this.siliconSpawnWeight.configEventLoaded();
            this.silverSpawnWeight.configEventLoaded();
            this.tinSpawnWeight.configEventLoaded();
        }
    }

    static {
        var pair = new ModConfigSpec.Builder().configure(Server::new);
        SERVER_SPEC = pair.getRight();
        SERVER = pair.getLeft();
    }
}
