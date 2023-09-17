package org.red.survival;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.red.CommediaDell_arte;

public final class SurvivalGame extends JavaPlugin {

    private static boolean debug = true;

    public static void sendLog(Object message) {
        Bukkit.getConsoleSender().sendMessage("§7§l[ §7Game §7§l] §f" + message);
    }

    public static void sendDebugLog(Object message) {
        if (debug)
            Bukkit.getConsoleSender().sendMessage("§7§l[ §7Game Debug §7§l] §f" + message);
    }

    public static boolean isDebug() {
        return debug;
    }

    public static void setDebug(boolean debug) {
        SurvivalGame.debug = debug;
    }

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
