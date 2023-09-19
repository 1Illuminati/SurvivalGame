package org.red.survival.event.listener;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPhysicsEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.red.library.a_.entity.player.A_Player;
import org.red.survival.SurvivalGame;
import org.red.survival.job.JobType;
import org.red.survival.util.Util;

import java.util.Collection;
import java.util.UUID;

public class BlockBreakListener implements Listener {
    @EventHandler
    public void event(BlockBreakEvent event) {
        Block block = event.getBlock();
        Material material = block.getType();
        A_Player player = A_Player.getAPlayer(event.getPlayer());
        JobType job = JobType.getPlayerJobType(player);
        Collection<ItemStack> drops = block.getDrops();

        switch(material) {
            case COAL_ORE, COPPER_ORE, IRON_ORE, GOLD_ORE, DIAMOND_ORE, EMERALD_ORE,LAPIS_ORE,REDSTONE_ORE, NETHER_QUARTZ_ORE, DEEPSLATE_COAL_ORE,
                    DEEPSLATE_COPPER_ORE, DEEPSLATE_IRON_ORE, DEEPSLATE_GOLD_ORE, DEEPSLATE_DIAMOND_ORE, DEEPSLATE_EMERALD_ORE, DEEPSLATE_LAPIS_ORE,
                    DEEPSLATE_REDSTONE_ORE, NETHER_GOLD_ORE, ANCIENT_DEBRIS, OBSIDIAN-> {
                if (block.hasMetadata("placed")) return;
                int per = 33;
                switch(job) {
                    case MINER_3:
                        per += 33;
                    case MINER_2:
                        per += 33;
                    case MINER_1:
                        if (Util.random(per)) drops.forEach(itemStack -> itemStack.setAmount(itemStack.getAmount() * 2));
                    break;
                }
            }
            case POTATOES, CARROTS, WHEAT, PUMPKIN, MELON, COCOA, NETHER_WART, BEETROOTS -> {
                if (block instanceof Ageable ageable) {
                    if (ageable.getAge() == ageable.getMaximumAge()) {
                        int per = 33;
                        switch(job) {
                            case FARMER_3:
                                per += 33;
                            case FARMER_2:
                                per += 33;
                            case FARMER_1:
                                if (Util.random(per)) drops.forEach(itemStack -> itemStack.setAmount(itemStack.getAmount() * 2));
                            break;
                        }
                    }
                }
            }
            case SUGAR_CANE, BAMBOO, CACTUS, KELP_PLANT -> {
                block.setMetadata("break_farmer", new FixedMetadataValue(SurvivalGame.getPlugin(), player.getUniqueId().toString()));
                if (block.hasMetadata("placed")) return;
                int per = 33;
                switch(job) {
                    case FARMER_3:
                        per += 33;
                    case FARMER_2:
                        per += 33;
                    case FARMER_1:
                        if (Util.random(per)) drops.forEach(itemStack -> itemStack.setAmount(itemStack.getAmount() * 2));
                    break;
                }
            }
        }
    }
    @EventHandler
    public void event2(BlockPhysicsEvent event) {
        Block block = event.getBlock();

        if (block.hasMetadata("break_farmer")) {
            FixedMetadataValue value = (FixedMetadataValue) block.getMetadata("break_farmer").get(0);
            A_Player player = A_Player.getAPlayer(UUID.fromString(value.asString()));
            JobType job = JobType.getPlayerJobType(player);
            Collection<ItemStack> drops = block.getDrops();

            int per = 33;
            switch(job) {
                case FARMER_3:
                    per += 33;
                case FARMER_2:
                    per += 33;
                case FARMER_1:
                    if (Util.random(per)) drops.forEach(itemStack -> itemStack.setAmount(itemStack.getAmount() * 2));
                break;
            }
        }
    }
}
