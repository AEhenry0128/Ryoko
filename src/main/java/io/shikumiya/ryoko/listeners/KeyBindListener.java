package io.shikumiya.ryoko.listeners;

import io.shikumiya.ryoko.profiles.Profile;
import io.shikumiya.ryoko.profiles.ProfileManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class KeyBindListener implements Listener {

    private final JavaPlugin plugin;

    public KeyBindListener(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void pressNumber(PlayerItemHeldEvent event) {
        Player player = event.getPlayer();
        if (!hasCharacter(player)) return;
        event.setCancelled(true);
    }

    @EventHandler
    public void pressF(PlayerSwapHandItemsEvent event) {
        Player player = event.getPlayer();
        if (!hasCharacter(player)) return;
        event.setCancelled(true);
    }

    @EventHandler
    public void pressQ(PlayerDropItemEvent event) {
        Player player = event.getPlayer();
        if (!hasCharacter(player)) return;
        event.setCancelled(true);
    }

    private boolean hasCharacter(Player player) {
        Profile profile = ProfileManager.getProfile(player);
        if (profile == null) return false;
        String character = profile.getCurrentCharacter();
        return character != null && !character.isEmpty();
    }

}
