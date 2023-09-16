package org.red.survival.entity;

import org.bukkit.block.Biome;
import org.red.library.a_.entity.A_Entity;
import org.red.library.util.map.DataMap;

public final class CustomEntityMaker {
    private static CustomEntityMaker instance;

    public static CustomEntityMaker getInstance() {
        if (instance == null) {
            instance = new CustomEntityMaker();
        }
        return instance;
    }

    private CustomEntityMaker() {

    }

    public void makeEntity(A_Entity entity) {
        DataMap dataMap = entity.getDataMap();
    }

    private int getLevelByBiome(Biome biome) {
        return switch (biome) {
            case MEADOW -> 1;
            case PLAINS -> 6;
            case RIVER, SUNFLOWER_PLAINS -> 8;
            case FOREST -> 11;
            case FLOWER_FOREST, BIRCH_FOREST -> 13;
            case CHERRY_GROVE -> 15;
            case OLD_GROWTH_BIRCH_FOREST, DESERT, STONY_SHORE -> 21;
            case OCEAN -> 16;
            case DARK_FOREST -> 31;
            case WINDSWEPT_HILLS -> 0;
            case TAIGA -> 0;
            case SWAMP -> 0;
            case MANGROVE_SWAMP -> 0;
            case NETHER_WASTES -> 0;
            case THE_END -> 0;
            case FROZEN_OCEAN -> 0;
            case FROZEN_RIVER -> 0;
            case SNOWY_PLAINS -> 0;
            case MUSHROOM_FIELDS -> 0;
            case BEACH -> 0;
            case JUNGLE -> 0;
            case SPARSE_JUNGLE -> 0;
            case DEEP_OCEAN -> 0;
            case SNOWY_BEACH -> 0;
            case SNOWY_TAIGA -> 0;
            case OLD_GROWTH_PINE_TAIGA -> 0;
            case WINDSWEPT_FOREST -> 0;
            case SAVANNA -> 0;
            case SAVANNA_PLATEAU -> 0;
            case BADLANDS -> 0;
            case WOODED_BADLANDS -> 0;
            case SMALL_END_ISLANDS -> 0;
            case END_MIDLANDS -> 0;
            case END_HIGHLANDS -> 0;
            case END_BARRENS -> 0;
            case WARM_OCEAN -> 0;
            case LUKEWARM_OCEAN -> 0;
            case COLD_OCEAN -> 0;
            case DEEP_LUKEWARM_OCEAN -> 0;
            case DEEP_COLD_OCEAN -> 0;
            case DEEP_FROZEN_OCEAN -> 0;
            case THE_VOID -> 0;
            case WINDSWEPT_GRAVELLY_HILLS -> 0;
            case ICE_SPIKES -> 0;
            case OLD_GROWTH_SPRUCE_TAIGA -> 0;
            case WINDSWEPT_SAVANNA -> 0;
            case ERODED_BADLANDS -> 0;
            case BAMBOO_JUNGLE -> 0;
            case SOUL_SAND_VALLEY -> 0;
            case CRIMSON_FOREST -> 0;
            case WARPED_FOREST -> 0;
            case BASALT_DELTAS -> 0;
            case DRIPSTONE_CAVES -> 0;
            case LUSH_CAVES -> 0;
            case DEEP_DARK -> 0;
            case GROVE -> 0;
            case SNOWY_SLOPES -> 0;
            case FROZEN_PEAKS -> 0;
            case JAGGED_PEAKS -> 0;
            case STONY_PEAKS -> 0;
            case CUSTOM -> 0;
        };
    }
}
