package org.red.survival.util;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.red.library.a_.entity.player.A_Player;

public class Util {
    public static ItemStack getPlayerHead(A_Player player) {
        ItemStack itemStack = new ItemStack(org.bukkit.Material.PLAYER_HEAD);
        SkullMeta skullMeta = (SkullMeta) itemStack.getItemMeta();
        skullMeta.setOwningPlayer(player.getPlayer());
        itemStack.setItemMeta(skullMeta);

        return itemStack;
    }
}
