package io.shikumiya.ryoko.listeners;

import io.shikumiya.ryoko.characters.PlayerManager;
import io.shikumiya.ryoko.events.CastMythicSkillEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class CastKeyListener implements Listener {

    private final JavaPlugin plugin;

    public CastKeyListener(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void pressNumber(PlayerItemHeldEvent event) {

        Player player = event.getPlayer();
        if (PlayerManager.getC(player)) {

            event.setCancelled(true);
        }
    }

    @EventHandler
    public void pressF(PlayerSwapHandItemsEvent event) {

        Player player = event.getPlayer();
        if (PlayerManager.getC(player)) {

            event.setCancelled(true);
            CastMythicSkillEvent.onCast(player, "hello_world");
        }
    }

    @EventHandler
    public void pressQ(PlayerDropItemEvent event) {

        Player player = event.getPlayer();
        if (PlayerManager.getC(player)) {

            event.setCancelled(true);
        }
    }

}
