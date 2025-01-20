package io.github.wkmartins.keepEffectsAfterDeath;

import org.bukkit.plugin.java.JavaPlugin;

public final class KeepEffectsAfterDeath extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new DeathRespawnListener(), this);

    }

    @Override
    public void onDisable() {
    }
}
