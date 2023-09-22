package org.red.survival.job.hunter;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.red.library.item.ItemBuilder;
import org.red.survival.job.Job;
import org.red.survival.job.JobBookEvent;
import org.red.survival.job.JobType;

public abstract class Hunter implements Job {
    public static class Hunter_1 extends Hunter {
        private final ItemStack display = new ItemBuilder(Material.WOODEN_SWORD).setDisplayName(ChatColor.WHITE + displayName()).build();
        @Override
        public String displayName() {
            return "헌터 1차";
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
                ChatColor.WHITE + "직업: "+ ChatColor.GRAY + displayName(),
                "",
                ChatColor.WHITE + "능력",
                ChatColor.GRAY + "- 15%확률로 사냥한 동물의 전리품이 2배가 됩니다.",
                "",
                ChatColor.WHITE + "쉬프트 우클릭시 해당 직업으로 전직하게 됩니다.",
            };
        }
    }

    public static class Hunter_2 extends Hunter {
        private final ItemStack display = new ItemBuilder(Material.IRON_SWORD).setDisplayName(ChatColor.WHITE + displayName()).build();

        @Override
        public String displayName() {
            return "헌터 2차";
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
                ChatColor.WHITE + "직업: "+ ChatColor.GRAY + displayName(),
                "",
                ChatColor.WHITE + "능력",
                ChatColor.GRAY + "- 30%확률로 사냥한 동물의 전리품이 2배가 됩니다.",
                ChatColor.GRAY + "- 15%확률로 주는 데미지가 2배가 됩니다.",
                "",
                ChatColor.WHITE + "쉬프트 우클릭시 해당 직업으로 전직하게 됩니다.",
            };
        }
    }

    public static class Hunter_3 extends Hunter {
        private final ItemStack display = new ItemBuilder(Material.NETHERITE_SWORD).setDisplayName(ChatColor.WHITE + displayName()).build();
        @Override
        public String displayName() {
            return "헌터 3차";
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
                ChatColor.WHITE + "직업: "+ ChatColor.GRAY + displayName(),
                "",
                ChatColor.WHITE + "능력",
                ChatColor.GRAY + "- 45%확률로 사냥한 동물의 전리품이 2배가 됩니다.",
                ChatColor.GRAY + "- 30%확률로 주는 데미지가 2배가 됩니다.",
                ChatColor.GRAY + "- 몬스터 혹은 동물을 죽일때 마다 체력을 2칸 회복합니다.",
                "",
                ChatColor.WHITE + "쉬프트 우클릭시 해당 직업으로 전직하게 됩니다.",
            };
        }
    }
}
