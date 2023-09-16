package org.red.survival.gamble;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.red.library.a_.entity.player.A_Player;
import org.red.library.inventory.CustomGui;
import org.red.library.item.ItemBuilder;
import org.red.survival.SurvivalGame;
import org.red.survival.util.Util;

public class RspGame {
    private final A_Player player;
    private final A_Player opponent;
    private final boolean isOpponentComputer;
    private RspGameEnum playerChoice = RspGameEnum.NOT_YET;
    private RspGameEnum opponentChoice = RspGameEnum.NOT_YET;
    public RspGame(A_Player player) {
        this.player = player;
        this.isOpponentComputer = true;
        this.opponent = null;
    }

    public RspGame(A_Player player, A_Player opponent) {
        this.player = player;
        this.isOpponentComputer = false;
        this.opponent = opponent;
    }

    public boolean isOpponentISComputer() {
        return this.isOpponentComputer;
    }

    public VictoryResult checkResult() {
        if (this.playerChoice == this.opponentChoice) return VictoryResult.DRAW;
        if (this.playerChoice == RspGameEnum.NOT_YET) return VictoryResult.LOSE;
        if (this.opponentChoice == RspGameEnum.NOT_YET) return VictoryResult.WIN;

        if (this.playerChoice == RspGameEnum.ROCK) {
            if (this.opponentChoice == RspGameEnum.SCISSORS) return VictoryResult.WIN;
            else return VictoryResult.LOSE;
        } else if (this.playerChoice == RspGameEnum.PAPER) {
            if (this.opponentChoice == RspGameEnum.ROCK) return VictoryResult.WIN;
            else return VictoryResult.LOSE;
        } else {
            if (this.opponentChoice == RspGameEnum.PAPER) return VictoryResult.WIN;
            else return VictoryResult.LOSE;
        }
    }

    public static class RSPGameGui extends CustomGui {
        private static final ItemStack COMPUTER = new ItemBuilder(Material.IRON_INGOT).setDisplayName("§7컴퓨터").setCustomModelData(500).build();
        private static final ItemStack ROCK = new ItemBuilder(Material.IRON_INGOT).setDisplayName("§7바위").setCustomModelData(501).build();
        private static final ItemStack PAPER = new ItemBuilder(Material.IRON_INGOT).setDisplayName("§7보").setCustomModelData(502).build();
        private static final ItemStack SCISSORS = new ItemBuilder(Material.IRON_INGOT).setDisplayName("§7가위").setCustomModelData(503).build();
        public RSPGameGui(RspGameUser player, RspGameUser opponent) {
            super(54);

            this.setItem(2, player.getDisplayItem());
            this.setItem(6, opponent.getDisplayItem());

            this.setItem(48, ROCK);
            this.setButton(48, event -> {
                player.setChoice(RspGameEnum.ROCK);
            });

            this.setItem(49, PAPER);
            this.setButton(49, event -> {
                player.setChoice(RspGameEnum.PAPER);
            });

            this.setItem(50, SCISSORS);
            this.setButton(50, event -> {
                player.setChoice(RspGameEnum.SCISSORS);
            });

            for (int i = 0; i < 5; i++) {
                Bukkit.getScheduler().runTaskLater(SurvivalGame.getPlugin(), () -> {

                }, i);
            }
        }
    }

    public interface RspGameUser {
        RspGameEnum getChoice();

        void setChoice(RspGameEnum choice);

        ItemStack getDisplayItem();

        void setMoney(int money);
    }

    private static class RspGameComputer implements RspGameUser {
        private RspGameEnum choice = RspGameEnum.NOT_YET;

        @Override
        public RspGameEnum getChoice() {
            return choice;
        }

        @Override
        public void setChoice(RspGameEnum choice) {
            this.choice = choice;
        }

        @Override
        public ItemStack getDisplayItem() {
            return RSPGameGui.COMPUTER;
        }

        @Override
        public void setMoney(int money) {

        }
    }

    private static class RspGamePlayer implements RspGameUser {
        private final A_Player player;
        private RspGameEnum choice = RspGameEnum.NOT_YET;

        public RspGamePlayer(A_Player player) {
            this.player = player;
        }

        @Override
        public RspGameEnum getChoice() {
            return choice;
        }

        @Override
        public void setChoice(RspGameEnum choice) {
            this.choice = choice;
        }

        @Override
        public ItemStack getDisplayItem() {
            return Util.getPlayerHead(player);
        }

        @Override
        public void setMoney(int money) {
            player.getEconomyAccount().setBalance(money);
        }
    }

    public enum RspGameEnum {
        ROCK, SCISSORS, PAPER, NOT_YET
    }

    public enum VictoryResult {
        WIN, LOSE, DRAW
    }

}
