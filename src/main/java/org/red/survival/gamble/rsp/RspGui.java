package org.red.survival.gamble.rsp;

import dev.lone.itemsadder.api.CustomStack;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.red.a_.entity.A_PlayerImpl;
import org.red.library.a_.entity.player.A_Player;
import org.red.library.inventory.CustomGui;
import org.red.library.item.ItemBuilder;
import org.red.survival.gamble.rsp.user.RspUser;
import org.red.survival.gamble.rsp.user.RspUserPlayer;

public class RspGui extends CustomGui {
    private final RspUserPlayer player;
    private final A_Player aPlayer;
    private final RspUser opponent;
    private final boolean isPGod;
    private final boolean isOGod;


    public RspGui(RspUserPlayer player, RspUser opponent) {
        super(54);
        this.player = player;
        this.aPlayer = player.getPlayer();
        this.opponent = opponent;
        this.isPGod = ((A_PlayerImpl) aPlayer).isArlecchino();
        this.isOGod = opponent instanceof RspUserPlayer && ((A_PlayerImpl) ((RspUserPlayer) opponent).getPlayer()).isArlecchino();

        this.setItem(49, player.getDisplayItem());
        this.setItem(4, opponent.getDisplayItem());
        setChoiceItemPlayer();
        setChoiceItemOpponent();

        this.setButton(39, event -> {
            player.setChoice(RspChoice.ROCK);
            setChoiceItemPlayer();
        });


        this.setButton(40, event -> {
            player.setChoice(RspChoice.PAPER);
            setChoiceItemPlayer();
        });


        this.setButton(41, event -> {
            player.setChoice(RspChoice.SCISSORS);
            setChoiceItemPlayer();
        });
    }

    public void setChoiceItemPlayer() {
        ItemStack pRock = this.setItem(39, CustomStack.getInstance("rsp:p_rock").getItemStack());
        ItemStack pPaper = this.setItem(40, CustomStack.getInstance("rsp:p_paper").getItemStack());
        ItemStack pScissors= this.setItem(41, CustomStack.getInstance("rsp:p_scissors").getItemStack());

        switch (player.getChoice()) {
            case ROCK -> pRock.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 1);
            case PAPER -> pPaper.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 1);
            case SCISSORS -> pScissors.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 1);
        }
    }

    public void setChoiceItemOpponent() {
        ItemStack oRock = this.setItem(12, CustomStack.getInstance("rsp:o_rock").getItemStack());
        ItemStack oPaper = this.setItem(13, CustomStack.getInstance("rsp:o_paper").getItemStack());
        ItemStack oScissors= this.setItem(14, CustomStack.getInstance("rsp:o_scissors").getItemStack());

        if (isPGod) {
            switch (opponent.getChoice()) {
                case ROCK -> oRock.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 1);
                case PAPER -> oPaper.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 1);
                case SCISSORS -> oScissors.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 1);
            }
        }
    }

    public void showResult() {
        this.setItem(12, new ItemStack(Material.AIR));
        this.setItem(13, new ItemStack(Material.AIR));
        this.setItem(14, new ItemStack(Material.AIR));
        this.setItem(39, new ItemStack(Material.AIR));
        this.removeButton(39);
        this.setItem(40, new ItemStack(Material.AIR));
        this.removeButton(40);
        this.setItem(41, new ItemStack(Material.AIR));
        this.removeButton(41);

        RspChoice playerChoice = player.getChoice();
        this.setItem(31, playerChoice == RspChoice.ROCK? CustomStack.getInstance("rsp:p_rock").getItemStack() :
                playerChoice == RspChoice.PAPER? CustomStack.getInstance("rsp:p_paper").getItemStack() :
                        CustomStack.getInstance("rsp:p_scissors").getItemStack());
        RspChoice opponentChoice = opponent.getChoice();
        this.setItem(22, opponentChoice == RspChoice.ROCK? CustomStack.getInstance("rsp:o_rock").getItemStack() :
                opponentChoice == RspChoice.PAPER? CustomStack.getInstance("rsp:o_paper").getItemStack() :
                        CustomStack.getInstance("rsp:o_scissors").getItemStack());

        aPlayer.playSound(aPlayer.getLocation(), Sound.BLOCK_ANVIL_DESTROY, 1, 1);
    }

    @Override
    public void onClick(InventoryClickEvent event) {
        event.setCancelled(true);
        ((Player) event.getWhoClicked()).updateInventory();

        if (isOGod) {
            RspUserPlayer opponentPlayer = (RspUserPlayer) this.opponent;
            RspGui gui = opponentPlayer.getGui();
            gui.setChoiceItemOpponent();
            gui.aPlayer.updateInventory();
        }
    }

    @Override
    public void onClose(InventoryCloseEvent event) {
        RspGui newRspGui = new RspGui(player, opponent);
        aPlayer.openInventory(newRspGui.getInventory());
        player.setGui(newRspGui);
    }
}
