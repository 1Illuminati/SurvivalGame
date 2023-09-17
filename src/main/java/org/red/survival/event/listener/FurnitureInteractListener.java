package org.red.survival.event.listener;

import dev.lone.itemsadder.api.CustomFurniture;
import dev.lone.itemsadder.api.Events.FurnitureInteractEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.red.survival.SurvivalGame;

public class FurnitureInteractListener implements Listener {
    @EventHandler
    public void event(FurnitureInteractEvent event) {
        CustomFurniture furniture = event.getFurniture();
        SurvivalGame.sendLog(furniture.getNamespacedID());
    }
}
