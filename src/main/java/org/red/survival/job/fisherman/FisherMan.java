package org.red.survival.job.fisherman;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.red.library.item.ItemBuilder;
import org.red.survival.job.Job;
import org.red.survival.job.JobType;

public abstract class FisherMan implements Job {
    public static class FisherMan_1 extends FisherMan {
        private final ItemStack display = new ItemBuilder(Material.COD).setDisplayName(ChatColor.WHITE + displayName()).build();

        @Override
        public String displayName() {
            return "어부 1차";
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
                ChatColor.WHITE + "직업: "+ ChatColor.GRAY + displayName(),
                "",
                ChatColor.WHITE + "능력",
                ChatColor.GRAY + "- 15%확률로 낚은 어획물의 양이 2배가 됩니다.",
                "",
                ChatColor.WHITE + "쉬프트 우클릭시 해당 직업으로 전직하게 됩니다.",
            };
        }
    }

    public static class FisherMan_2 extends FisherMan {
        private final ItemStack display = new ItemBuilder(Material.SADDLE).setDisplayName(ChatColor.WHITE + displayName()).build();
        @Override
        public String displayName() {
            return "어부 2차";
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
                ChatColor.WHITE + "직업: "+ ChatColor.GRAY + displayName(),
                "",
                ChatColor.WHITE + "능력",
                ChatColor.GRAY + "- 30%확률로 낚은 어획물의 양이 2배가 됩니다.",
                ChatColor.GRAY + "- 5%확률로 보물상자를 낚게됩니다. 보물상자에는 여러가지 아이템이 들어있습니다.",
                "",
                ChatColor.WHITE + "쉬프트 우클릭시 해당 직업으로 전직하게 됩니다.",
            };
        }
    }

    public static class FisherMan_3 extends FisherMan {
        private final ItemStack display = new ItemBuilder(Material.TROPICAL_FISH).setDisplayName(ChatColor.WHITE + displayName()).build();
        @Override
        public String displayName() {
            return "어부 3차";
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
                ChatColor.WHITE + "직업: "+ ChatColor.GRAY + displayName(),
                "",
                ChatColor.WHITE + "능력",
                ChatColor.GRAY + "- 45%확률로 낚은 어획물의 양이 2배가 됩니다.",
                ChatColor.GRAY + "- 10%확률로 보물상자를 낚게됩니다. 보물상자에는 여러가지 아이템이 들어있습니다.",
                ChatColor.GRAY + "- 낚시 성공시 60초간 행운I이 부여됩니다.",
                "",
                ChatColor.WHITE + "쉬프트 우클릭시 해당 직업으로 전직하게 됩니다.",
            };
        }
    }
}
