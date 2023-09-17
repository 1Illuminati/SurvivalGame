package org.red.survival.gamble.rsp.user;

import org.bukkit.inventory.ItemStack;
import org.red.survival.gamble.rsp.RspChoice;
import org.red.survival.gamble.rsp.RspGui;

public interface RspUser {
    RspChoice getChoice();

    void setChoice(RspChoice choice);

    ItemStack getDisplayItem();

    String getDisplayName();

    void addMoney(int money);

    void sendMessage(String message);

}
