package org.red.survival.job.hunter;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.red.library.item.ItemBuilder;
import org.red.survival.job.Job;
import org.red.survival.job.JobBookEvent;
import org.red.survival.job.JobType;

public abstract class Hunter implements Job {
    @Override
    public Job[] jobLevels() {
        return new Hunter[] {
                new Hunter_1(),
                new Hunter_2(),
                new Hunter_3()
        };
    }
    public static class Hunter_1 extends Hunter {

        private final ItemStack display = new ItemBuilder(Material.WOODEN_SWORD).setDisplayName(ChatColor.WHITE + displayName()).build();
        private final ItemStack book = new ItemBuilder(Material.ENCHANTED_BOOK).setEventItem(new JobBookEvent(this)).setDisplayName(ChatColor.YELLOW + displayName()).setLore(jobDescription()).build();

        @Override
        public String displayName() {
            return "헌터1차";
        }

        @Override
        public ItemStack displayItem() {
            return display;
        }

        @Override
        public JobType getJobType() {
            return JobType.HUNTER_1;
        }

        @Override
        public String[] jobDescription() {
            return new String[] {
                    ChatColor.WHITE + displayName(),
                    "",
                    ChatColor.WHITE + "33%확률로 사냥한 몬스터 혹은 동물의 전리품이 2배가 됩니다."
            };
        }

        @Override
        public ItemStack jobBook() {
            return book;
        }
    }

    public static class Hunter_2 extends Hunter {

        private final ItemStack display = new ItemBuilder(Material.IRON_SWORD).setDisplayName(ChatColor.WHITE + displayName()).build();
        private final ItemStack book = new ItemBuilder(Material.ENCHANTED_BOOK).setEventItem(new JobBookEvent(this)).setDisplayName(ChatColor.YELLOW + displayName()).setLore(jobDescription()).build();

        @Override
        public String displayName() {
            return "헌터2차";
        }

        @Override
        public ItemStack displayItem() {
            return display;
        }

        @Override
        public JobType getJobType() {
            return JobType.HUNTER_2;
        }

        @Override
        public String[] jobDescription() {
            return new String[] {
                    ChatColor.WHITE + displayName(),
                    "",
                    ChatColor.WHITE + "66%확률로 사냥한 몬스터 혹은 동물의 전리품이 2배가 됩니다."
            };
        }

        @Override
        public ItemStack jobBook() {
            return book;
        }
    }

    public static class Hunter_3 extends Hunter {

        private final ItemStack display = new ItemBuilder(Material.NETHERITE_SWORD).setDisplayName(ChatColor.WHITE + displayName()).build();
        private final ItemStack book = new ItemBuilder(Material.ENCHANTED_BOOK).setEventItem(new JobBookEvent(this)).setDisplayName(ChatColor.YELLOW + displayName()).setLore(jobDescription()).build();

        @Override
        public String displayName() {
            return "헌터3차";
        }

        @Override
        public ItemStack displayItem() {
            return display;
        }

        @Override
        public JobType getJobType() {
            return JobType.HUNTER_3;
        }

        @Override
        public String[] jobDescription() {
            return new String[] {
                    ChatColor.WHITE + displayName(),
                    "",
                    ChatColor.WHITE + "99%확률로 사냥한 몬스터 혹은 동물의 전리품이 2배가 됩니다."
            };
        }

        @Override
        public ItemStack jobBook() {
            return book;
        }
    }
}
