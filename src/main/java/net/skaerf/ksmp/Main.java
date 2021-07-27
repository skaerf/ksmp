package net.skaerf.ksmp;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class Main extends JavaPlugin implements Listener {

    private static int i;
    private int actionBarScheduler;

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
                i = 0;
                actionBarScheduler = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(Main.class), () -> {
                    for (Player online : Bukkit.getOnlinePlayers()) {
                        online.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(ChatColor.translateAlternateColorCodes('&', "&6You are playing on KSMP &7- &fsponsored by &3riplhost")));
                    }
                    if (i == 4) {
                        i = 0;
                        Bukkit.getScheduler().cancelTask(actionBarScheduler);
                    }
                    else {
                        i += 1;
                    }
                }, 0, 40);
            }
        }.runTaskTimer(this, 0, 20 * 60 * 15);
    }

}
