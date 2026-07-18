package io.shikumiya.ryoko.listeners;

import io.shikumiya.ryoko.profiles.Profile;
import io.shikumiya.ryoko.profiles.ProfileLoader;
import io.shikumiya.ryoko.profiles.ProfileManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayerDataUpdateListener implements Listener {

    private final JavaPlugin plugin;

    public PlayerDataUpdateListener(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        Profile profile = ProfileLoader.loadFromFile(player);
        ProfileManager.RegisterProfile(profile);
    }
}
