package org.red.survival.event.listener;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.red.library.a_.entity.player.A_Player;
import org.red.survival.SurvivalGame;
import org.red.survival.job.Job;
import org.red.survival.job.JobType;
import org.red.survival.util.ScoreBoardHelper;

public class PlayerJoinListener implements Listener {
    @EventHandler(priority = EventPriority.HIGHEST)
    public void event(PlayerJoinEvent event) {
        A_Player player = A_Player.getAPlayer(event.getPlayer());

        ScoreBoardHelper scoreBoardHelper = new ScoreBoardHelper(player.getPlayer());
        scoreBoardHelper.setTitle("§f§l[V]arallel World");

        new BukkitRunnable() {
            public void run() {
                if (!player.isOnline()) cancel();
                scoreBoardHelper.setSlot(5, " §f§l플레이어: " + "§7" + player.getName());
                scoreBoardHelper.setSlot(4, "");
                scoreBoardHelper.setSlot(3, " §f§l소지금: " + "§7" + player.getEconomyAccount().getBalance());
                scoreBoardHelper.setSlot(2, "");
                scoreBoardHelper.setSlot(1, " §f§l직업: " + "§7" + Job.getJobByJobType(JobType.getPlayerJobType(player)).displayName());
            }
        }.runTaskTimer(SurvivalGame.getPlugin(), 10, 10);
    }
}
