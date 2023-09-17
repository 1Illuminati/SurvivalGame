package org.red.survival.gamble.rsp.user;

import org.bukkit.inventory.ItemStack;
import org.red.library.a_.entity.player.A_Player;
import org.red.survival.gamble.rsp.RspChoice;
import org.red.survival.gamble.rsp.RspGui;
import org.red.survival.util.Util;

public class RspUserPlayer implements RspUser {
    private final A_Player player;
    private RspChoice choice = RspChoice.UNKNOWN;
    private RspGui gui;

    public RspUserPlayer(A_Player player) {
        this.player = player;
    }

    @Override
    public RspChoice getChoice() {
        return choice;
    }

    @Override
    public void setChoice(RspChoice choice) {
        this.choice = choice;
    }

    @Override
    public ItemStack getDisplayItem() {
        return Util.getPlayerHead(player);
    }

    @Override
    public String getDisplayName() {
        return player.getName();
    }

    @Override
    public void addMoney(int money) {
        player.getEconomyAccount().addBalance(money);
    }

    @Override
    public void sendMessage(String message) {
        player.sendMessage(message);
    }

    public A_Player getPlayer() {
        return player;
    }

    public void setGui(RspGui gui) {
        this.gui = gui;
    }

    public RspGui getGui() {
        return gui;
    }
}
