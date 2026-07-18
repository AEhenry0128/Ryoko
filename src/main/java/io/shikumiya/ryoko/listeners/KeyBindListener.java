package io.shikumiya.ryoko.listeners;

import io.shikumiya.ryoko.messages.MessageHelper;
import io.shikumiya.ryoko.skills.CastMythicSkill;
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
        if (true) {

            int previousSlot = event.getPreviousSlot();
            int newSlot = event.getNewSlot();

            event.setCancelled(true);
            MessageHelper.sendMessage(player, String.valueOf(newSlot));
        }
    }

    @EventHandler
    public void pressF(PlayerSwapHandItemsEvent event) {

        Player player = event.getPlayer();
        if (true) {

            event.setCancelled(true);
            CastMythicSkill.onCast(player,"hello_world");
        }
    }

    @EventHandler
    public void pressQ(PlayerDropItemEvent event) {

        Player player = event.getPlayer();
        if (true) {

            event.setCancelled(true);
        }
    }

}
