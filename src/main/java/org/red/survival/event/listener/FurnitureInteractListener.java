package org.red.survival.event.listener;

import dev.lone.itemsadder.api.CustomFurniture;
import dev.lone.itemsadder.api.Events.FurnitureInteractEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.red.library.A_;
import org.red.library.a_.entity.player.A_Player;
import org.red.survival.SurvivalGame;
import org.red.survival.gamble.rsp.Rsp;

public class FurnitureInteractListener implements Listener {
    @EventHandler
    public void event(FurnitureInteractEvent event) {
        CustomFurniture furniture = event.getFurniture();
        SurvivalGame.sendDebugLog(furniture.getNamespacedID());

        if (furniture.getNamespacedID().equals("elitecreatures:casino_decoration_v1_game_slot")) {
            new Rsp(A_.getAPlayer(event.getPlayer()), 100).startGame();
        }
    }
}
