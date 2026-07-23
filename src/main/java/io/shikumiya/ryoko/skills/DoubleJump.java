package io.shikumiya.ryoko.skills;

import io.shikumiya.ryoko.characters.Character;
import io.shikumiya.ryoko.characters.CharacterManager;
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

        if (player.isOnGround() && profile.getMovementStatus().getJumpStatus() != 0) {
            profile.getMovementStatus().setJumpStatus(0);
        }

        boolean key = event.getInput().isJump();
        boolean last_key = profile.getMovementStatus().getLastJumpInput();
        profile.getMovementStatus().setLastJumpInput(key);
        if (!(key && !last_key)) return;

        GameMode gamemode = player.getGameMode();
        if (gamemode == GameMode.CREATIVE || gamemode == GameMode.SPECTATOR) return;

        Character character = CharacterManager.getCharacter(profile.getCurrentCharacter());
        if (character == null || !character.isDoubleJump()) return;


        if (!player.isOnGround()) {

            int status = profile.getMovementStatus().getJumpStatus();
            switch (status) {
                case 0 -> {
                    profile.getMovementStatus().setJumpStatus(1);
                    Vector doubleJump = player.getVelocity().setY(0.6);
                    player.setVelocity(doubleJump);
                }
                case 1 -> {
                    if (!character.isGliding()) return;
                    profile.getMovementStatus().setJumpStatus(2);
                    Gliding.start(player, profile);
                }
                case 2 -> {
                    profile.getMovementStatus().setJumpStatus(1);
                    Gliding.cancel(profile);
                }
            }
        }
        return;
    }

}
