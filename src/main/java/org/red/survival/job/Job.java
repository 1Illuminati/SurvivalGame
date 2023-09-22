package org.red.survival.job;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.red.library.item.ItemBuilder;
import org.red.survival.job.farmer.Farmer;
import org.red.survival.job.fisherman.FisherMan;
import org.red.survival.job.hunter.Hunter;
import org.red.survival.job.miner.Miner;

public interface Job {
    Miner.Miner_1 MINER_1 = new Miner.Miner_1();
    Miner.Miner_2 MINER_2 = new Miner.Miner_2();
    Miner.Miner_3 MINER_3 = new Miner.Miner_3();
    Farmer.Farmer_1 FARMER_1 = new Farmer.Farmer_1();
    Farmer.Farmer_2 FARMER_2 = new Farmer.Farmer_2();
    Farmer.Farmer_3 FARMER_3 = new Farmer.Farmer_3();
    Hunter.Hunter_1 HUNTER_1 = new Hunter.Hunter_1();
    Hunter.Hunter_2 HUNTER_2 = new Hunter.Hunter_2();
    Hunter.Hunter_3 HUNTER_3 = new Hunter.Hunter_3();
    FisherMan.FisherMan_1 FISHERMAN_1 = new FisherMan.FisherMan_1();
    FisherMan.FisherMan_2 FISHERMAN_2 = new FisherMan.FisherMan_2();
    FisherMan.FisherMan_3 FISHERMAN_3 = new FisherMan.FisherMan_3();
    Unknown UNKNOWN = new Unknown();
    String displayName();
    ItemStack displayItem();
    JobType getJobType();
    String[] jobDescription();
    default ItemStack jobBook() {
        return new ItemBuilder(Material.ENCHANTED_BOOK).setEventItem(new JobBookEvent(this)).setDisplayName(ChatColor.YELLOW + "전직 북").setLore(jobDescription()).build();
    }

    static Job getJobByJobType(JobType type) {
        return switch (type) {
            case MINER_1 -> MINER_1;
            case MINER_2 -> MINER_2;
            case MINER_3 -> MINER_3;
            case FARMER_1 -> FARMER_1;
            case FARMER_2 -> FARMER_2;
            case FARMER_3 -> FARMER_3;
            case HUNTER_1 -> HUNTER_1;
            case HUNTER_2 -> HUNTER_2;
            case HUNTER_3 -> HUNTER_3;
            case FISHERMAN_1 -> FISHERMAN_1;
            case FISHERMAN_2 -> FISHERMAN_2;
            case FISHERMAN_3 -> FISHERMAN_3;
            case UNKNOWN -> UNKNOWN;
        };
    }

    static void load() {
        //do nothing
    }
}
