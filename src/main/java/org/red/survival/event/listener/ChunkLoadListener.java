package org.red.survival.event.listener;

import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkLoadEvent;
import org.red.library.a_.entity.A_Entity;
import org.red.survival.entity.CustomEntityMaker;

public class ChunkLoadListener implements Listener {
    @EventHandler
    public void event(ChunkLoadEvent event) {
        if (!event.isNewChunk()) return;

        Entity[] entities = event.getChunk().getEntities();
        CustomEntityMaker maker = CustomEntityMaker.getInstance();

        for (Entity entity : entities) maker.makeEntity(A_Entity.getAEntity(entity));
    }
}
