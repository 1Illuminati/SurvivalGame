package org.red.survival.util;

import org.bukkit.World;
import org.bukkit.block.Block;
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

    public static boolean random(double per) {
        return Math.random() * 100 < per;
    }

    public static void dropNaturally(Block block, ItemStack itemStack)  {
        World world = block.getWorld();
        for (ItemStack drop : block.getDrops(itemStack)) {
            world.dropItemNaturally(block.getLocation(), drop);
        }
    }
}
