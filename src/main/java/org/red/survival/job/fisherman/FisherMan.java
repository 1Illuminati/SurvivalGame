package org.red.survival.job.fisherman;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.red.library.item.ItemBuilder;
import org.red.survival.job.Job;
import org.red.survival.job.JobBookEvent;
import org.red.survival.job.JobType;

public abstract class FisherMan implements Job {
    @Override
    public Job[] jobLevels() {
        return new FisherMan[] {
                new FisherMan_1(),
                new FisherMan_2(),
                new FisherMan_3()
        };
    }
    public static class FisherMan_1 extends FisherMan {

        private final ItemStack display = new ItemBuilder(Material.COD).setDisplayName(ChatColor.WHITE + displayName()).build();
        private final ItemStack book = new ItemBuilder(Material.ENCHANTED_BOOK).setEventItem(new JobBookEvent(this)).setDisplayName(ChatColor.YELLOW + displayName()).setLore(jobDescription()).build();

        @Override
        public String displayName() {
            return "어부1차";
        }

        @Override
        public ItemStack displayItem() {
            return display;
        }

        @Override
        public JobType getJobType() {
            return JobType.FISHERMAN_1;
        }

        @Override
        public String[] jobDescription() {
            return new String[] {
                    ChatColor.WHITE + displayName(),
                    "",
                    ChatColor.WHITE + "33%확률로 낚은 어획물이 2배가 됩니다."
            };
        }

        @Override
        public ItemStack jobBook() {
            return book;
        }
    }

    public static class FisherMan_2 extends FisherMan {

        private final ItemStack display = new ItemBuilder(Material.SADDLE).setDisplayName(ChatColor.WHITE + displayName()).build();
        private final ItemStack book = new ItemBuilder(Material.ENCHANTED_BOOK).setEventItem(new JobBookEvent(this)).setDisplayName(ChatColor.YELLOW + displayName()).setLore(jobDescription()).build();

        @Override
        public String displayName() {
            return "어부2차";
        }

        @Override
        public ItemStack displayItem() {
            return display;
        }

        @Override
        public JobType getJobType() {
            return JobType.FISHERMAN_2;
        }

        @Override
        public String[] jobDescription() {
            return new String[] {
                    ChatColor.WHITE + displayName(),
                    "",
                    ChatColor.WHITE + "66%확률로 낚은 어획물이 2배가 됩니다."
            };
        }

        @Override
        public ItemStack jobBook() {
            return book;
        }
    }

    public static class FisherMan_3 extends FisherMan {

        private final ItemStack display = new ItemBuilder(Material.TROPICAL_FISH).setDisplayName(ChatColor.WHITE + displayName()).build();
        private final ItemStack book = new ItemBuilder(Material.ENCHANTED_BOOK).setEventItem(new JobBookEvent(this)).setDisplayName(ChatColor.YELLOW + displayName()).setLore(jobDescription()).build();

        @Override
        public String displayName() {
            return "어부3차";
        }

        @Override
        public ItemStack displayItem() {
            return display;
        }

        @Override
        public JobType getJobType() {
            return JobType.FISHERMAN_3;
        }

        @Override
        public String[] jobDescription() {
            return new String[] {
                    ChatColor.WHITE + displayName(),
                    "",
                    ChatColor.WHITE + "99%확률로 낚은 어획물이 2배가 됩니다."
            };
        }

        @Override
        public ItemStack jobBook() {
            return book;
        }
    }
}
