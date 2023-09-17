package org.red.survival;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.PluginCommand;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.red.CommediaDell_arte;
import org.red.library.command.AbstractCommand;
import org.red.survival.event.listener.FurnitureInteractListener;
import org.red.survival.gamble.rsp.RspCommand;

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
        this.registerCommand(new RspCommand());
        this.registerEvent(new FurnitureInteractListener());
    }

    @Override
    public void onDisable() {

    }

    private void registerEvent(Listener listener) {
        Bukkit.getPluginManager().registerEvents(listener, this);
    }

    private void registerCommand(AbstractCommand command) {
        PluginCommand cmd = this.getCommand(command.getName());
        if (cmd == null)
            throw new NullPointerException("Command is null");

        cmd.setExecutor(command);
        cmd.setTabCompleter(command);
    }
}
