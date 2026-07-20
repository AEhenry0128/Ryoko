package io.shikumiya.ryoko.listeners;

import io.shikumiya.ryoko.messages.MessageHelper;
import io.shikumiya.ryoko.profiles.Profile;
import io.shikumiya.ryoko.profiles.ProfileLoader;
import io.shikumiya.ryoko.profiles.ProfileManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class ProfileUpdateListener implements Listener {

    private final JavaPlugin plugin;

    public ProfileUpdateListener(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        Profile profile = ProfileLoader.loadFromFile(player);
        ProfileManager.RegisterProfile(profile);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        Profile profile = ProfileManager.getProfile(player);
        ProfileLoader.save(profile);
        ProfileManager.removeProfile(profile);
        MessageHelper.sendMessage(Bukkit.getConsoleSender(), "test");
    }
}
