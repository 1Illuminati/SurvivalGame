package org.red.survival.event.listener;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPhysicsEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.red.library.A_;
import org.red.library.a_.entity.player.A_Player;
import org.red.survival.SurvivalGame;
import org.red.survival.job.JobType;
import org.red.survival.util.Util;

import java.util.UUID;

public class BlockBreakListener implements Listener {
    @EventHandler
    public void event(BlockBreakEvent event) {
        Block block = event.getBlock();
        Material material = block.getType();
        A_Player player = A_.getAPlayer(event.getPlayer());
        JobType job = JobType.getPlayerJobType(player);

        switch(material) {
            case COAL_ORE, COPPER_ORE, IRON_ORE, GOLD_ORE, DIAMOND_ORE, EMERALD_ORE,LAPIS_ORE,REDSTONE_ORE, NETHER_QUARTZ_ORE, DEEPSLATE_COAL_ORE,
                    DEEPSLATE_COPPER_ORE, DEEPSLATE_IRON_ORE, DEEPSLATE_GOLD_ORE, DEEPSLATE_DIAMOND_ORE, DEEPSLATE_EMERALD_ORE, DEEPSLATE_LAPIS_ORE,
                    DEEPSLATE_REDSTONE_ORE, NETHER_GOLD_ORE, ANCIENT_DEBRIS, OBSIDIAN, STONE, DEEPSLATE-> {
                if (block.hasMetadata("placed")) return;
                int per = 15;
                int buff = 20;
                switch(job) {
                    case MINER_3:
                        per += 15;
                        buff += 20;
                    case MINER_2:
                        per += 15;
                        player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 20 * buff, 1));
                    case MINER_1:
                        if (Util.random(per)) {
                            Util.dropNaturally(block, player.getItemInHand());
                        }
                    break;
                }
            }
            case POTATOES, CARROTS, WHEAT, COCOA, NETHER_WART, BEETROOTS -> {
                if (block.getBlockData() instanceof Ageable ageable) {
                    if (ageable.getAge() == ageable.getMaximumAge()) {
                        int per = 15;
                        int exp = 4;
                        switch(job) {
                            case FARMER_3:
                                per += 15;
                                exp*=3;
                            case FARMER_2:
                                event.setExpToDrop(exp);
                                per += 15;
                            case FARMER_1:
                                if (Util.random(per)) {
                                    Util.dropNaturally(block, player.getItemInHand());
                                }
                            break;
                        }
                    }
                }
            }
            case SUGAR_CANE, BAMBOO, CACTUS, KELP_PLANT, MELON, PUMPKIN -> {
                block.setMetadata("break_farmer", new FixedMetadataValue(SurvivalGame.getPlugin(), player.getUniqueId().toString()));
                if (block.hasMetadata("placed")) return;
                int per = 15;
                int exp = 4;
                switch(job) {
                    case FARMER_3:
                        per += 15;
                        exp*=3;
                    case FARMER_2:
                        event.setExpToDrop(exp);
                        per += 15;
                    case FARMER_1:
                        if (Util.random(per)) {
                            Util.dropNaturally(block, player.getItemInHand());
                        }
                    break;
                }
            }
        }
    }
    @EventHandler
    public void event2(BlockPhysicsEvent event) {
        Block block = event.getBlock();
        Block sourceBlock = event.getSourceBlock();
        if (sourceBlock.hasMetadata("break_farmer")) {
            FixedMetadataValue value = (FixedMetadataValue) sourceBlock.getMetadata("break_farmer").get(0);
            A_Player player = A_.getAPlayer(UUID.fromString(value.asString()));
            JobType job = JobType.getPlayerJobType(player);

            int per = 15;
            int exp = 4;
            switch(job) {
                case FARMER_3:
                    per += 15;
                    exp*=3;
                case FARMER_2:
                    block.getWorld().spawn(block.getLocation(), ExperienceOrb.class).setExperience(exp);
                    per += 15;
                case FARMER_1:
                    if (Util.random(per)) {
                        Util.dropNaturally(block, player.getItemInHand());
                    }
                break;
            }
        }
    }
}
