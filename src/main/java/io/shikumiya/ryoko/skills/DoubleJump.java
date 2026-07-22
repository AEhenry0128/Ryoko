package io.shikumiya.ryoko.skills;

import io.shikumiya.ryoko.characters.Character;
import io.shikumiya.ryoko.characters.CharacterManager;
import io.shikumiya.ryoko.profiles.Profile;
import io.shikumiya.ryoko.profiles.ProfileManager;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.player.PlayerInputEvent;
import org.bukkit.util.Vector;

import java.util.HashSet;
import java.util.Set;

public class DoubleJump implements Listener {

    private final JavaPlugin plugin;

    public DoubleJump(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJump(PlayerInputEvent event) {

        Player player = event.getPlayer();
        Profile profile = ProfileManager.getProfile(player);

        int status = profile.getJumpStatus();
        if (player.isOnGround() && status !=0) {
            profile.setJumpStatus(0);
        }

        boolean key = event.getInput().isJump();
        boolean last_key = profile.getLastJumpInput();
        profile.setLastJumpInput(key);
        if (!(key && !last_key)) return;

        GameMode gamemode = player.getGameMode();
        if (gamemode == GameMode.CREATIVE || gamemode == GameMode.SPECTATOR) return;

        Character character = CharacterManager.getCharacter(profile.getCurrentCharacter());
        if (character == null || !character.isDoubleJump()) return;

        if (!player.isOnGround() && status == 0) {
            profile.setJumpStatus(1);
            Vector boost = player.getVelocity().setY(0.6);
            player.setVelocity(boost);
        }

    }
}
