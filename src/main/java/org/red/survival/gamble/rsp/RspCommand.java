package org.red.survival.gamble.rsp;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.red.library.a_.entity.player.A_Player;
import org.red.library.command.AbstractPlayerCommand;

import java.util.Collections;
import java.util.List;

public class RspCommand extends AbstractPlayerCommand {
    @Override
    public @NotNull String getName() {
        return "rsp";
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull String s, String[] strings) {
        A_Player player = A_Player.getAPlayer((Player) commandSender);
        Rsp rsp;

        if (strings.length >= 2) {
            rsp = new Rsp(player, A_Player.getAPlayer(strings[1]), Integer.parseInt(strings[0]));
        } else {
            rsp = new Rsp(player, Integer.parseInt(strings[0]));
        }

        rsp.startGame();
        return true;
    }

    @Override
    public List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull String s, String[] strings) {
        return strings.length == 1 ? Collections.singletonList("[금액]") : null;
    }
}
