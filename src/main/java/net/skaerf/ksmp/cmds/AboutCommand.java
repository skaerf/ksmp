package net.skaerf.ksmp.cmds;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AboutCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            System.out.println("Console is not allowed to request information on users.");
        }
        else {
            Player player = (Player) sender;
            if (args.length == 0) {
                player.sendMessage(ChatColor.RED+"Please specify a player! /"+cmd+" <player>");
            }
            else {
                String argument = args[0];
                Player requestedPlayerOnline = Bukkit.getPlayer(argument);
                OfflinePlayer requestedPlayerOffline;
                if (requestedPlayerOnline == null) {
                    player.sendMessage("Player is not online, checking database. Information may not be up-to-date.");
                    requestedPlayerOffline = Bukkit.getOfflinePlayer(argument);
                }

            }
        }
        return true;
    }
}
