package com.minegusta.mginfractions.commands;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.minegusta.mginfractions.infractions.Reason;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class InfractionCommand implements TabExecutor {

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender s, Command cmd, String label, String[] args) {
        if (args.length == 1) {
            final String playerName = args[0].toLowerCase();
            return Lists.newArrayList(Collections2.transform(Collections2.filter(Bukkit.getOnlinePlayers(), new Predicate<Player>() {
                @Override
                public boolean apply(Player player) {
                    return player.getName().toLowerCase().startsWith(playerName) || ChatColor.stripColor(player.getDisplayName()).toLowerCase().startsWith(playerName);
                }
            }), new Function<Player, String>() {
                @Override
                public String apply(Player player) {
                    return player.getName();
                }
            }));
        } else if (args.length == 2) {
            final String reason = args[1].toLowerCase();
            List<String> reasons = new ArrayList<String>();

            for (Reason r : Reason.values()) {
                if (r.name().startsWith(reason)) {
                    reasons.add(r.name());
                }
            }
            return reasons;
        }
        return new ArrayList<String>();
    }
}
