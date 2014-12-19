package com.minegusta.mginfractions;

import com.demigodsrpg.infractions.Backend;
import com.demigodsrpg.infractions.spigot.SpigotBackend;
import org.bukkit.configuration.Configuration;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    private static SpigotBackend BACKEND;
    private static Configuration CONFIG;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        BACKEND = new SpigotBackend(new MGInfractionsConfig(getConfig()));
        CONFIG = getConfig();
    }

    public static Backend getBackend() {
        return BACKEND;
    }

    public static Configuration getPluginConfig() {
        return CONFIG;
    }

    @Override
    public void onDisable() {

    }
}
