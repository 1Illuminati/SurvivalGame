package org.red.survival.entity;

import org.bukkit.entity.EntityType;

public final class CustomEntityUtil {
    private CustomEntityUtil() throws IllegalAccessException {
        throw new IllegalAccessException("Utility class");
    }

    public static CustomEntityType getEntityType(EntityType type) {
        return switch(type) {
            case PLAYER -> CustomEntityType.PLAYER;
            case VILLAGER, WANDERING_TRADER -> CustomEntityType.NPC;
            case WOLF, ZOGLIN -> CustomEntityType.STRONG_ANIMAL;
            case WARDEN, ENDER_DRAGON, WITHER -> CustomEntityType.BOSS;
            case IRON_GOLEM, PIGLIN_BRUTE, ELDER_GUARDIAN, SNOWMAN -> CustomEntityType.MIDDLEBOSS;
            case COD, COW, PIG, SHEEP, SALMON, RABBIT, TROPICAL_FISH, TURTLE, HORSE, LLAMA, CAMEL, ALLAY, AXOLOTL, BAT, PUFFERFISH, SNIFFER, GOAT,
                    PANDA, PARROT, POLAR_BEAR, FOX, BEE, CHICKEN, DONKEY, MULE, MUSHROOM_COW, OCELOT, SQUID, GLOW_SQUID, FROG, CAT, DOLPHIN, TRADER_LLAMA
                    -> CustomEntityType.WEAK_ANIMAL;
            case ZOMBIE, SKELETON, SHULKER, SKELETON_HORSE, ZOMBIE_HORSE, WITHER_SKELETON, STRAY, HUSK, ZOMBIE_VILLAGER, ZOMBIFIED_PIGLIN, BLAZE, CREEPER, CAVE_SPIDER, DROWNED,
                    ENDERMAN, ENDERMITE, EVOKER, GHAST, GIANT, GUARDIAN, ILLUSIONER, MAGMA_CUBE, PHANTOM, PILLAGER, RAVAGER, SILVERFISH, SLIME, SPIDER, VEX, VINDICATOR, WITCH, HOGLIN, PIGLIN
                    -> CustomEntityType.MOB;
            default -> CustomEntityType.OTHER;
        };
    }
}
