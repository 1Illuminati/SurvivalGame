package org.red.survival.job.miner;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.red.library.item.ItemBuilder;
import org.red.survival.job.Job;
import org.red.survival.job.JobBookEvent;
import org.red.survival.job.JobType;

public abstract class Miner implements Job {
    public static class Miner_1 extends Miner {
        private final ItemStack display = new ItemBuilder(Material.WOODEN_PICKAXE).setDisplayName(ChatColor.WHITE + displayName()).build();
        @Override
        public String displayName() {
            return "광부 1차";
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
                ChatColor.WHITE + "직업: "+ ChatColor.GRAY + displayName(),
                "",
                ChatColor.WHITE + "능력",
                ChatColor.GRAY + "- 15%확률로 채굴한 광물의 양이 2배가 됩니다.",
                "",
                ChatColor.WHITE + "쉬프트 우클릭시 해당 직업으로 전직하게 됩니다.",
            };
        }
    }

    public static class Miner_2 extends Miner {
        private final ItemStack display = new ItemBuilder(Material.IRON_PICKAXE).setDisplayName(ChatColor.WHITE + displayName()).build();
        @Override
        public String displayName() {
            return "광부 2차";
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
                ChatColor.WHITE + "직업: "+ ChatColor.GRAY + displayName(),
                "",
                ChatColor.WHITE + "능력",
                ChatColor.GRAY + "- 30%확률로 채굴한 광물 혹은 돌의 양이 2배가 됩니다.",
                ChatColor.GRAY + "- 광물 혹은 돌을 채굴한 후 20%확률로 5초간 성급함II 부여됩니다.",
                "",
                ChatColor.WHITE + "쉬프트 우클릭시 해당 직업으로 전직하게 됩니다.",
            };
        }
    }

    public static class Miner_3 extends Miner {
        private final ItemStack display = new ItemBuilder(Material.NETHERITE_PICKAXE).setDisplayName(ChatColor.WHITE + displayName()).build();
        @Override
        public String displayName() {
            return "광부 3차";
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
                ChatColor.WHITE + "직업: "+ ChatColor.GRAY + displayName(),
                "",
                ChatColor.WHITE + "능력",
                ChatColor.GRAY + "- 45%확률로 채굴한 광물 혹은 돌의 양이 2배가 됩니다.",
                ChatColor.GRAY + "- 광물 혹은 돌을 채굴한 후 40%확률로 10초간 성급함II 부여됩니다.",
                ChatColor.GRAY + "- 돌을 채굴한 후 25%확률로 랜덤한 광물이 드랍됩니다.",
                "",
                ChatColor.WHITE + "쉬프트 우클릭시 해당 직업으로 전직하게 됩니다.",
            };
        }
    }
}
