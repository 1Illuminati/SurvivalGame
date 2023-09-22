package org.red.survival.event.listener;

import org.bukkit.NamespacedKey;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.red.library.A_;
import org.red.library.a_.entity.player.A_Player;
import org.red.survival.SurvivalGame;
import org.red.survival.job.Job;
import org.red.survival.job.JobType;
import org.red.survival.util.ScoreBoardHelper;

public class PlayerJoinListener implements Listener {
    @EventHandler(priority = EventPriority.HIGHEST)
    public void event(PlayerJoinEvent event) {
        SurvivalGame.sendDebugLog("PlayerJoinEvent: " + event.getPlayer().getName() + " joined the server.");
        A_Player player = A_.getAPlayer(event.getPlayer());
        ScoreBoardHelper scoreBoardHelper = new ScoreBoardHelper(player.getPlayer());
        scoreBoardHelper.setTitle("§f§l[V]arallel World");

        player.addPlayerRunnable(new NamespacedKey(SurvivalGame.getPlugin(), "scoreboard"), () -> {
            scoreBoardHelper.setSlot(7, "§m                                    ");
            scoreBoardHelper.setSlot(6, " §f§l플레이어: " + "§7" + player.getName());
            scoreBoardHelper.setSlot(5, "");
            scoreBoardHelper.setSlot(4, " §f§l소지금: " + "§7" + player.getEconomyAccount().getBalance());
            scoreBoardHelper.setSlot(3, "");
            scoreBoardHelper.setSlot(2, " §f§l직업: " + "§7" + Job.getJobByJobType(JobType.getPlayerJobType(player)).displayName());
            scoreBoardHelper.setSlot(1, "§m                                    ");
        }, 5);
    }
}
