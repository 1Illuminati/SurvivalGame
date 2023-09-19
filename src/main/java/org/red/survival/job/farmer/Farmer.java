package org.red.survival.job.farmer;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.red.library.item.ItemBuilder;
import org.red.survival.job.Job;
import org.red.survival.job.JobBookEvent;
import org.red.survival.job.JobType;

public abstract class Farmer implements Job {
    @Override
    public Job[] jobLevels() {
        return new Farmer[] {
                new Farmer_1(),
                new Farmer_2(),
                new Farmer_3()
        };
    }

    public static class Farmer_1 extends Farmer {
        private final ItemStack display = new ItemBuilder(Material.WOODEN_HOE).setDisplayName(ChatColor.WHITE + displayName()).build();
        private final ItemStack book = new ItemBuilder(Material.ENCHANTED_BOOK).setEventItem(new JobBookEvent(this)).setDisplayName(ChatColor.YELLOW + displayName()).setLore(jobDescription()).build();

        @Override
        public String displayName() {
            return "농부1차";
        }

        @Override
        public ItemStack displayItem() {
            return display;
        }

        @Override
        public JobType getJobType() {
            return JobType.FARMER_1;
        }

        @Override
        public String[] jobDescription() {
            return new String[] {
                    ChatColor.WHITE + displayName(),
                    "",
                    ChatColor.WHITE + "33%확률로 캐는 농작물이 2배가 됩니다."
            };
        }

        @Override
        public ItemStack jobBook() {
            return book;
        }
    }

    public static class Farmer_2 extends Farmer {

        private final ItemStack display = new ItemBuilder(Material.IRON_HOE).setDisplayName(ChatColor.WHITE + displayName()).build();
        private final ItemStack book = new ItemBuilder(Material.ENCHANTED_BOOK).setEventItem(new JobBookEvent(this)).setDisplayName(ChatColor.YELLOW + displayName()).setLore(jobDescription()).build();

        @Override
        public String displayName() {
            return "농부2차";
        }

        @Override
        public ItemStack displayItem() {
            return display;
        }

        @Override
        public JobType getJobType() {
            return JobType.FARMER_2;
        }

        @Override
        public String[] jobDescription() {
            return new String[] {
                    ChatColor.WHITE + displayName(),
                    "",
                    ChatColor.WHITE + "66%확률로 캐는 농작물이 2배가 됩니다."
            };
        }

        @Override
        public ItemStack jobBook() {
            return book;
        }
    }

    public static class Farmer_3 extends Farmer {
        private final ItemStack display = new ItemBuilder(Material.NETHERITE_HOE).setDisplayName(ChatColor.WHITE + displayName()).build();
        private final ItemStack book = new ItemBuilder(Material.ENCHANTED_BOOK).setEventItem(new JobBookEvent(this)).setDisplayName(ChatColor.YELLOW + displayName()).setLore(jobDescription()).build();

        @Override
        public String displayName() {
            return "농부3차";
        }

        @Override
        public ItemStack displayItem() {
            return display;
        }

        @Override
        public JobType getJobType() {
            return JobType.FARMER_3;
        }

        @Override
        public String[] jobDescription() {
            return new String[] {
                    ChatColor.WHITE + displayName(),
                    "",
                    ChatColor.WHITE + "99%확률로 캐는 농작물이 2배가 됩니다."
            };
        }

        @Override
        public ItemStack jobBook() {
            return book;
        }
    }
}