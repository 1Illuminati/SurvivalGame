package org.red.survival.gamble.rsp;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.inventory.ItemStack;
import org.red.library.a_.entity.player.A_Player;
import org.red.library.inventory.CustomGui;
import org.red.library.item.ItemBuilder;
import org.red.survival.SurvivalGame;
import org.red.survival.gamble.rsp.user.RspUser;
import org.red.survival.gamble.rsp.user.RspUserPlayer;

public class RspGui extends CustomGui {
    private static final ItemStack ROCK = new ItemBuilder(Material.IRON_INGOT).setDisplayName("§7바위").setCustomModelData(501).build();
    private static final ItemStack PAPER = new ItemBuilder(Material.IRON_INGOT).setDisplayName("§7보").setCustomModelData(502).build();
    private static final ItemStack SCISSORS = new ItemBuilder(Material.IRON_INGOT).setDisplayName("§7가위").setCustomModelData(503).build();
    public RspGui(RspUserPlayer player, RspUser opponent, Rsp game) {
        super(54);

        A_Player aPlayer = player.getPlayer();

        this.setItem(49, player.getDisplayItem());
        this.setItem(4, opponent.getDisplayItem());

        this.setItem(12, ROCK);
        this.setItem(39, ROCK);
        this.setButton(39, event -> {
            player.setChoice(RspChoice.ROCK);
        });

        this.setItem(13, PAPER);
        this.setItem(40, PAPER);
        this.setButton(40, event -> {
            player.setChoice(RspChoice.PAPER);
        });

        this.setItem(14, SCISSORS);
        this.setItem(41, SCISSORS);
        this.setButton(41, event -> {
            player.setChoice(RspChoice.SCISSORS);
        });

        for (int i = 0; i < 5; i++) {
            Bukkit.getScheduler().runTaskLater(SurvivalGame.getPlugin(), () -> {
                aPlayer.playSound(aPlayer.getLocation(), Sound.BLOCK_ANVIL_HIT, 1, 1);
            }, i * 20);
        }

        Bukkit.getScheduler().runTaskLater(SurvivalGame.getPlugin(), () -> {
            this.setItem(12, new ItemStack(Material.AIR));
            this.setItem(13, new ItemStack(Material.AIR));
            this.setItem(14, new ItemStack(Material.AIR));
            this.setItem(39, new ItemStack(Material.AIR));
            this.removeButton(39);
            this.setItem(40, new ItemStack(Material.AIR));
            this.removeButton(40);
            this.setItem(41, new ItemStack(Material.AIR));
            this.removeButton(41);

            switch (player.getChoice()) {
                case ROCK:
                    this.setItem(39, ROCK);
                break;
                case PAPER:
                    this.setItem(40, PAPER);
                break;
                case SCISSORS:
                    this.setItem(41, SCISSORS);
                break;
            }

            switch (opponent.getChoice()) {
                case ROCK:
                    this.setItem(12, ROCK);
                break;
                case PAPER:
                    this.setItem(13, PAPER);
                break;
                case SCISSORS:
                    this.setItem(14, SCISSORS);
                break;
            }

            aPlayer.playSound(aPlayer.getLocation(), Sound.ITEM_GOAT_HORN_SOUND_7, 1, 1);
        }, 120);


        Bukkit.getScheduler().runTaskLater(SurvivalGame.getPlugin(), game::endGame, 160);
    }
}
