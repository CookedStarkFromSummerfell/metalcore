package io.kalishak.metalcore.data.client;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;

import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public abstract class MetalAtlasProvider implements DataProvider {
    private final Map<String, Atlas> data = new LinkedHashMap<>();
    private final PackOutput output;
    private final String modId;

    public MetalAtlasProvider(PackOutput packOutput, String modId) {
        this.output = packOutput;
        this.modId = modId;
    }

    protected abstract void addAtlases();

    @Override
    public CompletableFuture<?> run(CachedOutput cache) {
        addAtlases();

        if (!this.data.isEmpty()) {
            return save(cache, this.output.getOutputFolder(PackOutput.Target.RESOURCE_PACK).resolve(this.modId).resolve("atlases"));
        }

        return CompletableFuture.allOf();
    }

    @Override
    public String getName() {
        return "Atlases for mod: " + this.modId;
    }

    private CompletableFuture<?> save(CachedOutput cache, Path outputFolder) {
        for (Map.Entry<String, Atlas> entry : this.data.entrySet()) {
            JsonObject json = new JsonObject();
            JsonArray sourcesObj = new JsonArray();
            JsonObject atlasObj = new JsonObject();
            atlasObj.addProperty("type", entry.getValue().type());
            atlasObj.addProperty("source", entry.getValue().source());
            atlasObj.addProperty("prefix", entry.getValue().prefix());
            sourcesObj.add(atlasObj);
            json.add("sources", sourcesObj);

            DataProvider.saveStable(cache, json, outputFolder.resolve(entry.getKey() + ".json"));
        }

        return CompletableFuture.allOf();
    }

    public void add(String name, String type, String source, String prefix) {
        if (this.data.put(name, new Atlas(type, source, prefix)) != null) {
            throw new IllegalStateException("Duplicate atlas: " + name);
        }
    }

    public void addItem(String name, String type) {
        String suffix = name.substring(0, name.length() - 1);
        add(name, type, "block/" + suffix, "block/" + suffix + "/");
    }

    public void addBlock(String name, String type) {
        String suffix = name.substring(0, name.length() - 1);
        add(name, type, "item/" + suffix, "item/" + suffix + "/");
    }

    public void addEntity(String name, String type) {
        String suffix = name.substring(0, name.length() - 1);
        add(name, type, "entity/" + suffix, "entity/" + suffix + "/");
    }

    private record Atlas(String type, String source, String prefix) {}
}
