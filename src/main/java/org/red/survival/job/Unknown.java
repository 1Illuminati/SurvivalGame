package org.red.survival.job;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.red.library.item.ItemBuilder;

public class Unknown implements Job {
    private final ItemStack display = new ItemBuilder(Material.LEATHER_CHESTPLATE).setDisplayName(ChatColor.WHITE + displayName()).build();
    private final ItemStack book = new ItemBuilder(Material.ENCHANTED_BOOK).setEventItem(new JobBookEvent(this)).setDisplayName(ChatColor.YELLOW + displayName()).setLore(jobDescription()).build();
    @Override
    public String displayName() {
        return "무직";
    }

    @Override
    public ItemStack displayItem() {
        return display;
    }

    @Override
    public JobType getJobType() {
        return JobType.UNKNOWN;
    }

    @Override
    public String[] jobDescription() {
        return new String[] {
            ChatColor.WHITE + "무직입니다."
        };
    }

    @Override
    public Job[] jobLevels() {
        return new Job[0];
    }

    @Override
    public ItemStack jobBook() {
        return book;
    }
}
