package org.red.survival.job;

import org.red.library.a_.entity.player.A_Player;
public enum JobType {
    /**
     * 광부 1차
     */
    MINER_1(),
    /**
     * 광부 2차
     */
    MINER_2(),
    /**
     * 광부 3차
     */
    MINER_3(),
    /**
     * 농부 1차
     */
    FARMER_1(),
    /**
     * 농부 2차
     */
    FARMER_2(),
    /**
     * 농부 3차
     */
    FARMER_3(),
    /**
     * 사냥꾼 1차
     */
    HUNTER_1(),
    /**
     * 사냥꾼 2차
     */
    HUNTER_2(),
    /**
     * 사냥꾼 3차
     */
    HUNTER_3(),
    /**
     * 낚시꾼 1차
     */
    FISHERMAN_1(),
    /**
     * 낚시꾼 2차
     */
    FISHERMAN_2(),
    /**
     * 낚시꾼 3차
     */
    FISHERMAN_3();
    JobType() {
    }

    public static JobType getPlayerJobType(A_Player player) {
        return JobType.valueOf(player.getDataMap().getString("job"));
    }

    public static boolean isPlayerJobType(A_Player player, JobType type) {
        return getPlayerJobType(player) == type;
    }

    public static void setPlayerJobType(A_Player player, JobType type) {
        player.getDataMap().put("job", type.name());
    }
}
