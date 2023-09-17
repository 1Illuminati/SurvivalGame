package org.red.survival.gamble.rsp;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.red.library.a_.entity.player.A_Player;
import org.red.survival.SurvivalGame;
import org.red.survival.gamble.GambleMenuGui;
import org.red.survival.gamble.rsp.user.RspUser;
import org.red.survival.gamble.rsp.user.RspUserComputer;
import org.red.survival.gamble.rsp.user.RspUserPlayer;

public class Rsp {
    private final RspUserPlayer player;
    private final RspUser opponent;
    private final boolean isOpponentComputer;
    private final int gameMoney;

    public Rsp(A_Player player, int gameMoney) {
        this.player = new RspUserPlayer(player);
        this.isOpponentComputer = true;
        this.opponent = new RspUserComputer();
        this.gameMoney = gameMoney;
    }

    public Rsp(A_Player player, A_Player opponent, int gameMoney) {
        this.player = new RspUserPlayer(player);
        this.isOpponentComputer = false;
        this.opponent = new RspUserPlayer(opponent);
        this.gameMoney = gameMoney;
    }

    public boolean isOpponentISComputer() {
        return this.isOpponentComputer;
    }

    public RspResult checkResult() {
        if (this.player.getChoice() == this.opponent.getChoice()) return RspResult.DRAW;
        if (this.player.getChoice() == RspChoice.UNKNOWN) return RspResult.LOSE;
        if (this.opponent.getChoice() == RspChoice.UNKNOWN) return RspResult.WIN;

        if (this.player.getChoice() == RspChoice.ROCK) {
            if (this.opponent.getChoice() == RspChoice.SCISSORS) return RspResult.WIN;
            else return RspResult.LOSE;
        } else if (this.player.getChoice() == RspChoice.PAPER) {
            if (this.opponent.getChoice() == RspChoice.ROCK) return RspResult.WIN;
            else return RspResult.LOSE;
        } else {
            if (this.opponent.getChoice() == RspChoice.PAPER) return RspResult.WIN;
            else return RspResult.LOSE;
        }
    }

    public void startGame() {
        if (this.isOpponentComputer) {
            this.player.addMoney(-gameMoney);
            this.opponent.addMoney(-gameMoney);
        }

        this.setUiPlayer(this.player, this.opponent);

        if (!isOpponentISComputer()) {
            this.setUiPlayer((RspUserPlayer) this.opponent, this.player);
        }
        Bukkit.getScheduler().runTaskLater(SurvivalGame.getPlugin(), this::endGame, 120);
    }

    public void setUiPlayer(RspUserPlayer player, RspUser opponent) {
        RspGui playerGui = new RspGui(player, opponent);
        A_Player aPlayer = player.getPlayer();
        aPlayer.openInventory(playerGui.getInventory());
        player.setGui(playerGui);

        for (int i = 0; i < 3; i++) {
            Bukkit.getScheduler().runTaskLater(SurvivalGame.getPlugin(), () -> {
                aPlayer.playSound(aPlayer.getLocation(), Sound.BLOCK_ANVIL_PLACE, 1, 1);
            }, i * 20);
        }
        Bukkit.getScheduler().runTaskLater(SurvivalGame.getPlugin(), () -> player.getGui().showResult(), 80);
        Bukkit.getScheduler().runTaskLater(SurvivalGame.getPlugin(), () -> {
            aPlayer.closeInventoryIgnoreEvent();
            aPlayer.openInventory(new GambleMenuGui(aPlayer).getInventory());
        }, 120);
    }

    public void endGame() {
        RspResult result = this.checkResult();

        if (result == RspResult.WIN) {
            this.player.addMoney(gameMoney * 2);
            this.player.sendMessage("§a" + this.opponent.getDisplayName() + "§f님에게 §a" + gameMoney + "원§f을 얻었습니다.");
            this.opponent.sendMessage("§a" + this.player.getDisplayName()  + "§f님에게 §c" + gameMoney + "원§f을 잃었습니다.");
        } else if (result == RspResult.LOSE) {
            this.opponent.addMoney(gameMoney * 2);
            this.player.sendMessage("§a" + this.opponent.getDisplayName()  + "§f님에게 §c" + gameMoney + "원§f을 잃었습니다.");
            this.opponent.sendMessage("§a" + this.player.getDisplayName()  + "§f님에게 §a" + gameMoney + "원§f을 얻었습니다.");
        } else {
            this.player.addMoney(gameMoney);
            this.opponent.addMoney(gameMoney);
            this.player.sendMessage("§a" + this.opponent.getDisplayName()  + "§f님과 비겼습니다.");
            this.opponent.sendMessage("§a" + this.player.getDisplayName()  + "§f님과 비겼습니다.");
        }
    }
}
