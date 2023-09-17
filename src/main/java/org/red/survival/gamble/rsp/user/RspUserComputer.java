package org.red.survival.gamble.rsp.user;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.red.library.item.ItemBuilder;
import org.red.survival.SurvivalGame;
import org.red.survival.gamble.rsp.RspChoice;

import java.util.Random;

public class RspUserComputer implements RspUser {
    private static final ItemStack DISPLAY_ITEM = new ItemBuilder(Material.IRON_INGOT).setDisplayName("§7컴퓨터").setCustomModelData(500).build();
    private RspChoice choice = RspChoice.UNKNOWN;

    public RspUserComputer() {
        while (this.choice == RspChoice.UNKNOWN) this.choice = RspChoice.values()[new Random().nextInt(RspChoice.values().length)];
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
        return DISPLAY_ITEM;
    }

    @Override
    public String getDisplayName() {
        return "§7컴퓨터";
    }

    @Override
    public void addMoney(int money) {
        // Do nothing1
    }

    @Override
    public void sendMessage(String message) {
        SurvivalGame.sendDebugLog(message);
    }
}
