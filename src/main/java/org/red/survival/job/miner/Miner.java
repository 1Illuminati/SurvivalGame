package org.red.survival.job.miner;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.red.library.item.ItemBuilder;
import org.red.survival.job.Job;
import org.red.survival.job.JobBookEvent;
import org.red.survival.job.JobType;

public abstract class Miner implements Job {
    @Override
    public Job[] jobLevels() {
        return new Miner[] {
                new Miner_1(),
                new Miner_2(),
                new Miner_3()
        };
    }
    public static class Miner_1 extends Miner {
        private final ItemStack display = new ItemBuilder(Material.WOODEN_PICKAXE).setDisplayName(ChatColor.WHITE + displayName()).build();
        private final ItemStack book = new ItemBuilder(Material.ENCHANTED_BOOK).setEventItem(new JobBookEvent(this)).setDisplayName(ChatColor.YELLOW + displayName()).setLore(jobDescription()).build();

        @Override
        public String displayName() {
            return "광부1차";
        }

        @Override
        public ItemStack displayItem() {
            return display;
        }

        @Override
        public JobType getJobType() {
            return JobType.MINER_1;
        }

        @Override
        public String[] jobDescription() {
            return new String[] {
                    ChatColor.WHITE + displayName(),
                    "",
                    ChatColor.WHITE + "33%확률로 채굴한 광물의 드랍템이 2배가 됩니다."
            };
        }

        @Override
        public ItemStack jobBook() {
            return book;
        }
    }

    public static class Miner_2 extends Miner {

        private final ItemStack display = new ItemBuilder(Material.IRON_PICKAXE).setDisplayName(ChatColor.WHITE + displayName()).build();
        private final ItemStack book = new ItemBuilder(Material.ENCHANTED_BOOK).setEventItem(new JobBookEvent(this)).setDisplayName(ChatColor.YELLOW + displayName()).setLore(jobDescription()).build();

        @Override
        public String displayName() {
            return "광부2차";
        }

        @Override
        public ItemStack displayItem() {
            return display;
        }

        @Override
        public JobType getJobType() {
            return JobType.MINER_2;
        }

        @Override
        public String[] jobDescription() {
            return new String[] {
                    ChatColor.WHITE + displayName(),
                    "",
                    ChatColor.WHITE + "66%확률로 채굴한 광물의 드랍템이 2배가 됩니다."
            };
        }

        @Override
        public ItemStack jobBook() {
            return book;
        }
    }

    public static class Miner_3 extends Miner {

        private final ItemStack display = new ItemBuilder(Material.NETHERITE_PICKAXE).setDisplayName(ChatColor.WHITE + displayName()).build();
        private final ItemStack book = new ItemBuilder(Material.ENCHANTED_BOOK).setEventItem(new JobBookEvent(this)).setDisplayName(ChatColor.YELLOW + displayName()).setLore(jobDescription()).build();

        @Override
        public String displayName() {
            return "광부3차";
        }

        @Override
        public ItemStack displayItem() {
            return display;
        }

        @Override
        public JobType getJobType() {
            return JobType.MINER_3;
        }

        @Override
        public String[] jobDescription() {
            return new String[] {
                    ChatColor.WHITE + displayName(),
                    "",
                    ChatColor.WHITE + "99%확률로 채굴한 광물의 드랍템이 2배가 됩니다."
            };
        }

        @Override
        public ItemStack jobBook() {
            return book;
        }
    }
}
