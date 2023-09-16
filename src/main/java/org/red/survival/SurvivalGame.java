package org.red.survival;

import org.bukkit.plugin.java.JavaPlugin;

public final class SurvivalGame extends JavaPlugin {
    private static SurvivalGame instance;

    public static SurvivalGame getPlugin() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
    }

    @Override
    public void onDisable() {

    }
}
