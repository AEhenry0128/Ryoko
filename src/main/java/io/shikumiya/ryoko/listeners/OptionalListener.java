package io.shikumiya.ryoko.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class OptionalListener implements Listener {

    private final JavaPlugin plugin;

    public OptionalListener(JavaPlugin plugin) {
        this.plugin = plugin;
    }


}
