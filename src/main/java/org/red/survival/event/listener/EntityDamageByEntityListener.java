package org.red.survival.event.listener;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.red.library.A_;
import org.red.library.a_.entity.player.A_Player;
import org.red.survival.job.JobType;
import org.red.survival.util.Util;

public class EntityDamageByEntityListener implements Listener {
    @EventHandler
    public void event(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player player) {
            A_Player aPlayer = A_.getAPlayer(player);
            JobType job = JobType.getPlayerJobType(aPlayer);
            int per = 15;
            switch (job) {
                case HUNTER_3:
                    per+=15;
                case HUNTER_2:
                    event.setDamage(event.getDamage() * (Util.random(per) ? 2 : 1));
                    aPlayer.sendMessage(ChatColor.YELLOW + "[ 크리티컬 ]");
            }
        }
    }
}
