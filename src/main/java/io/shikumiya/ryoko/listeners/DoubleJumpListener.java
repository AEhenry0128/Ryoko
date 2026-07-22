package io.shikumiya.ryoko.listeners;

import io.shikumiya.ryoko.messages.MessageHelper;
import io.shikumiya.ryoko.profiles.Profile;
import io.shikumiya.ryoko.profiles.ProfileManager;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.player.PlayerInputEvent;
import org.bukkit.util.Vector;

public class DoubleJumpListener implements Listener {

    private final JavaPlugin plugin;

    public DoubleJumpListener(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJump(PlayerInputEvent event) {

        if (!event.getInput().isJump()) return;

        Player player = event.getPlayer();
        GameMode gamemode = player.getGameMode();
        if (gamemode == GameMode.CREATIVE || gamemode == GameMode.SPECTATOR) return;

        Profile profile = ProfileManager.getProfile(player);
        int status = profile.getJumpStatus();

        if (!player.isOnGround() && status == 0) {
            status += 1;
            profile.setJumpStatus(status);
            Vector boost = player.getLocation().getDirection().multiply(0.6).setY(0.9);
            player.setVelocity(boost);
        } else if (player.isOnGround()) {
            profile.setJumpStatus(0);
        }

    }
}
