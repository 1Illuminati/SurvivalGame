package org.red.survival.job;

import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
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

    @EventItemAnnotation(act = EventItemAnnotation.Act.RIGHT_CLICK_AIR, shift = EventItemAnnotation.Shift.NOT_PRESSED)
    public void logInfo1(PlayerInteractEvent event) {
        event.getPlayer().sendMessage(job.jobDescription());
        event.getPlayer().sendMessage("쉬프트 우클릭시 해당 직업으로 전직합니다.");
    }

    @EventItemAnnotation(act = EventItemAnnotation.Act.RIGHT_CLICK_BLOCK, shift = EventItemAnnotation.Shift.NOT_PRESSED)
    public void logInfo2(PlayerInteractEvent event) {
        event.getPlayer().sendMessage(job.jobDescription());
        event.getPlayer().sendMessage("쉬프트 우클릭시 해당 직업으로 전직합니다.");
    }

    @EventItemAnnotation(act = EventItemAnnotation.Act.RIGHT_CLICK_AIR, shift = EventItemAnnotation.Shift.PRESSED)
    public void getJob1(PlayerInteractEvent event) {
        ItemStack item = event.getPlayer().getInventory().getItemInMainHand();
        item.setAmount(item.getAmount() - 1);
        JobType.setPlayerJobType(A_Player.getAPlayer(event.getPlayer()), job.getJobType());
        event.getPlayer().sendMessage(ChatColor.YELLOW + "전직 완료!");
    }

    @EventItemAnnotation(act = EventItemAnnotation.Act.RIGHT_CLICK_BLOCK, shift = EventItemAnnotation.Shift.PRESSED)
    public void getJob2(PlayerInteractEvent event) {
        ItemStack item = event.getPlayer().getInventory().getItemInMainHand();
        item.setAmount(item.getAmount() - 1);
        JobType.setPlayerJobType(A_Player.getAPlayer(event.getPlayer()), job.getJobType());
        event.getPlayer().sendMessage(ChatColor.YELLOW + "전직 완료!");
    }
}
