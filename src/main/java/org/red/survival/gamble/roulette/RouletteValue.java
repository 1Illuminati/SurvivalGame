package org.red.survival.gamble.roulette;

import org.bukkit.inventory.ItemStack;

public enum RouletteValue {
    RED(1, null),
    BLACK(2, null),
    GREEN(3, null);
    public final int value;
    public final ItemStack itemStack;
    RouletteValue(int value, ItemStack itemStack) {
        this.value = value;
        this.itemStack = itemStack;
    }
}
