package org.red.survival.job.farmer;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.red.library.item.ItemBuilder;
import org.red.survival.job.Job;
import org.red.survival.job.JobBookEvent;
import org.red.survival.job.JobType;

public abstract class Farmer implements Job {
    public static class Farmer_1 extends Farmer {
        private final ItemStack display = new ItemBuilder(Material.WOODEN_HOE).setDisplayName(ChatColor.WHITE + displayName()).build();
        @Override
        public String displayName() {
            return "농부 1차";
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
                ChatColor.WHITE + "직업: "+ ChatColor.GRAY + displayName(),
                "",
                ChatColor.WHITE + "능력:",
                ChatColor.GRAY + "- 15%확률로 수확하는 농작물의 양이 2배가 됩니다.",
                "",
                ChatColor.WHITE + "쉬프트 우클릭시 해당 직업으로 전직하게 됩니다.",
            };
        }
    }

    public static class Farmer_2 extends Farmer {

        private final ItemStack display = new ItemBuilder(Material.IRON_HOE).setDisplayName(ChatColor.WHITE + displayName()).build();

        @Override
        public String displayName() {
            return "농부 2차";
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
                ChatColor.WHITE + "직업: "+ ChatColor.GRAY + displayName(),
                "",
                ChatColor.WHITE + "능력",
                ChatColor.GRAY + "- 30%확률로 수확하는 농작물의 양이 2배가 됩니다.",
                ChatColor.GRAY + "- 수확한 농작물이 경험치를 제공하게 됩니다.",
                "",
                ChatColor.WHITE + "쉬프트 우클릭시 해당 직업으로 전직하게 됩니다.",
            };
        }
    }

    public static class Farmer_3 extends Farmer {
        private final ItemStack display = new ItemBuilder(Material.NETHERITE_HOE).setDisplayName(ChatColor.WHITE + displayName()).build();

        @Override
        public String displayName() {
            return "농부 3차";
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
                ChatColor.WHITE + "직업: "+ ChatColor.GRAY + displayName(),
                "",
                ChatColor.WHITE + "능력",
                ChatColor.GRAY + "- 45%확률로 수확하는 농작물의 양이 2배가 됩니다.",
                ChatColor.GRAY + "- 수확한 농작물이 더 많은 경험치를 제공하게 됩니다.",
                ChatColor.GRAY + "- 수확한 농작물이 땅에 드랍되지 않고 인벤토리로 바로 들어오게 됩니다.",
                "",
                ChatColor.WHITE + "쉬프트 우클릭시 해당 직업으로 전직하게 됩니다.",
            };
        }
    }
}