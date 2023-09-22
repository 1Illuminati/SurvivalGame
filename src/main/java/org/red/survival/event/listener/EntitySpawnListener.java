package org.red.survival.event.listener;

import org.bukkit.entity.Entity;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.red.library.A_;
import org.red.library.a_.entity.A_Entity;
import org.red.survival.entity.CustomEntityMaker;

public class EntitySpawnListener implements Listener {
    @EventHandler
    public void event(EntitySpawnEvent event) {
        Entity entity = event.getEntity();

        if (entity instanceof HumanEntity) return;

        CustomEntityMaker.getInstance().makeEntity(A_.getAEntity(entity));
    }
}
