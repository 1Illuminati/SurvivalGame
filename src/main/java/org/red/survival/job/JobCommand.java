package org.red.survival.job;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.red.library.command.AbstractPlayerCommand;

import java.util.ArrayList;
import java.util.List;

public class JobCommand extends AbstractPlayerCommand {
    private final List<String> jobList = new ArrayList<>();

    public JobCommand() {
        for (JobType jobType : JobType.values()) {
            jobList.add(jobType.name());
        }
    }

    @Override
    public @NotNull String getName() {
        return "job";
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull String s, String[] strings) {
        ((Player) commandSender).getInventory().addItem(Job.getJobByJobType(JobType.valueOf(strings[0])).jobBook());
        return true;
    }

    @Override
    public List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull String s, String[] strings) {
        return strings.length == 1 ? jobList : new ArrayList<>();
    }
}
