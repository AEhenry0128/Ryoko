package io.shikumiya.ryoko.listeners;

import io.papermc.paper.event.player.PlayerInventorySlotChangeEvent;
import io.shikumiya.ryoko.messages.MessageHelper;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Testing implements Listener {

    private final JavaPlugin plugin;

    public Testing(JavaPlugin plugin) {
        this.plugin = plugin;
    }

//    @EventHandler
//    public void test(InventoryOpenEvent event) {
//        HumanEntity player = event.getPlayer();
//        System.out.println("test 觸發, inv=" + event.getInventory().getType()
//                + ", this=" + this);
//        MessageHelper.sendMessage(player, "test");
//    }

}
