package org.red.survival.job;

import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.red.library.A_;
import org.red.library.a_.entity.player.A_Player;
import org.red.library.item.event.EventItem;
import org.red.library.item.event.EventItemAnnotation;

public class JobBookEvent implements EventItem {

    private final Job job;
    public JobBookEvent(Job job) {
        this.job = job;
    }
    @Override
    public NamespacedKey getKey() {
        return new NamespacedKey("jobbook", job.getJobType().name().toLowerCase());
    }

    @EventItemAnnotation(act = EventItemAnnotation.Act.RIGHT_CLICK_AIR)
    public void logInfo1(PlayerInteractEvent event) {
        event.getPlayer().sendMessage(job.jobDescription());
    }

    @EventItemAnnotation(act = EventItemAnnotation.Act.RIGHT_CLICK_BLOCK)
    public void logInfo2(PlayerInteractEvent event) {
        event.getPlayer().sendMessage(job.jobDescription());
    }

    @EventItemAnnotation(act = EventItemAnnotation.Act.RIGHT_CLICK_AIR, shift = true)
    public void getJob1(PlayerInteractEvent event) {
        ItemStack item = event.getPlayer().getInventory().getItemInMainHand();
        item.setAmount(item.getAmount() - 1);
        JobType.setPlayerJobType(A_.getAPlayer(event.getPlayer()), job.getJobType());
        event.getPlayer().sendMessage(ChatColor.YELLOW + "전직 완료!");
    }

    @EventItemAnnotation(act = EventItemAnnotation.Act.RIGHT_CLICK_BLOCK, shift = true)
    public void getJob2(PlayerInteractEvent event) {
        ItemStack item = event.getPlayer().getInventory().getItemInMainHand();
        item.setAmount(item.getAmount() - 1);
        JobType.setPlayerJobType(A_.getAPlayer(event.getPlayer()), job.getJobType());
        event.getPlayer().sendMessage(ChatColor.YELLOW + "전직 완료!");
    }
}
