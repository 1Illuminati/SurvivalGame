package org.red.survival.event.listener;

import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;
import org.red.library.a_.entity.player.A_Player;
import org.red.survival.job.JobType;
import org.red.survival.util.Util;

public class FishingListener implements Listener {
    @EventHandler
    public void event(PlayerFishEvent event) {
        if (event.getState() == PlayerFishEvent.State.CAUGHT_FISH) {
            A_Player player = A_Player.getAPlayer(event.getPlayer());
            JobType job = JobType.getPlayerJobType(player);
            ItemStack caught = ((Item) event.getCaught()).getItemStack();
            int per = 33;
            switch(job) {
                case FISHERMAN_3:
                    per += 33;
                case FISHERMAN_2:
                    per += 33;
                case FISHERMAN_1:
                    if (Util.random(per)) caught.setAmount(caught.getAmount() * 2);
                break;
            }
        }
    }
}
