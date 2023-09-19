package org.red.survival.event.listener;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.red.survival.SurvivalGame;

public class BlockPlaceListener implements Listener {
    @EventHandler
    public void event(BlockPlaceEvent event) {
        Block block = event.getBlock();
        Location blockLocation = block.getLocation();
        block.setMetadata("placed", new FixedMetadataValue(SurvivalGame.getPlugin(), event.getPlayer().getUniqueId().toString()));
    }
}
