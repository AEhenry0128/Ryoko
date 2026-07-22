package io.shikumiya.ryoko.listeners;

import io.shikumiya.ryoko.characters.Character;
import io.shikumiya.ryoko.characters.CharacterManager;
import io.shikumiya.ryoko.messages.MessageHelper;
import io.shikumiya.ryoko.profiles.Profile;
import io.shikumiya.ryoko.profiles.ProfileManager;
import io.shikumiya.ryoko.skills.CastMythicSkill;
import io.shikumiya.ryoko.skills.SkillExecutor;
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
    public void onPressHotKey(PlayerItemHeldEvent event) {

        Player player = event.getPlayer();
        Character character = hasCharacter(player);
        if (character == null) return;

        event.setCancelled(true);
        int slot = event.getNewSlot() + 1;
        String skill = character.getSkill(String.valueOf(slot));
        SkillExecutor.CastSkill(player, skill);
    }

    @EventHandler
    public void onPressF(PlayerSwapHandItemsEvent event) {

        Player player = event.getPlayer();
        Character character = hasCharacter(player);
        if (character == null) return;

        event.setCancelled(true);
        String skill = character.getSkill("F");
        SkillExecutor.CastSkill(player, skill);
    }

    @EventHandler
    public void onPressQ(PlayerDropItemEvent event) {

        Player player = event.getPlayer();
        Character character = hasCharacter(player);
        if (character == null) return;

        event.setCancelled(true);
        String skill = character.getSkill("Q");
        SkillExecutor.CastSkill(player, skill);
     }

    private Character hasCharacter(Player player) {
        Profile profile = ProfileManager.getProfile(player);
        if (profile == null) return null;
        String current_character = profile.getCurrentCharacter();
        if (current_character == null || current_character.isEmpty()) return null;
        return CharacterManager.getCharacter(current_character);
    }

}
