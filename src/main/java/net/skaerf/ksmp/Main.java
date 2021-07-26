package net.skaerf.ksmp;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class Main extends JavaPlugin implements Listener {

    public void onEnable() {
        runnable();
        ActionBar.enableThings();
        getServer().getPluginManager().registerEvents(this, this);
        System.out.println("[KSMP] Base plugin initialising");
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.sendTitle(ChatColor.translateAlternateColorCodes('&', "&7Welcome to &bKSMP"), ChatColor.translateAlternateColorCodes('&', "&6Season Eight &7- &fsponsored by &3riplhost"), 10, 50, 10);
    }

    public void runnable() {
        new BukkitRunnable() {

            @Override
            public void run() {
                ActionBar.sendActionBarToAllPlayers(ChatColor.translateAlternateColorCodes('&', "&6You are playing on KSMP &7- &fsponsored by &3riplhost"), 10);
            }
        }.runTaskLaterAsynchronously(this, 60000);
    }

}
