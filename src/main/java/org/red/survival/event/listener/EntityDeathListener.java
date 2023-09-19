package org.red.survival.event.listener;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.red.library.a_.entity.player.A_Player;
import org.red.survival.job.JobType;
import org.red.survival.util.Util;

public class EntityDeathListener implements Listener {
    @EventHandler
    public void event(EntityDeathEvent event) {
        Entity entity = event.getEntity();
        EntityDamageEvent lastDamageCause = entity.getLastDamageCause();

        if (lastDamageCause == null) return;

        if (lastDamageCause instanceof EntityDamageByEntityEvent damageByEntityEvent) {
            if (damageByEntityEvent.getDamager() instanceof Player player) {
                A_Player aPlayer = A_Player.getAPlayer(player);
                JobType job = JobType.getPlayerJobType(aPlayer);

                int per = 33;
                switch (job) {
                    case HUNTER_3:
                        per+= 33;
                    case HUNTER_2:
                        per+= 33;
                    case HUNTER_1:
                        if (Util.random(per)) event.getDrops().forEach(itemStack -> itemStack.setAmount(itemStack.getAmount() * 2));
                    break;
                }
            }
        }
    }
}
