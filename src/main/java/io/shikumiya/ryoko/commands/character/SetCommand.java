package io.shikumiya.ryoko.commands.character;

import io.shikumiya.ryoko.characters.Character;
import io.shikumiya.ryoko.characters.CharacterManager;
import io.shikumiya.ryoko.messages.MessageHelper;
import io.shikumiya.ryoko.messages.UsageMessage;
import io.shikumiya.ryoko.profiles.Profile;
import io.shikumiya.ryoko.profiles.ProfileLoader;
import io.shikumiya.ryoko.profiles.ProfileManager;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetCommand {

    public void onCommand(CommandSender sender, String[] args) {

        if (args.length < 4) {
            MessageHelper.sendMessage(sender, UsageMessage.Character_Add);
            return;
        };

        Player player = Bukkit.getPlayer(args[2]);
        if (player == null) {
            MessageHelper.sendMessage(sender, "player not found.");
            return;
        }

        Character character = CharacterManager.getCharacter(args[3]);
        if (character == null) {
            MessageHelper.sendMessage(sender, "character not found");
            return;
        }

        Profile profile = ProfileManager.getProfile(player);
        profile.setCharacter(character);
        player.getInventory().setHeldItemSlot(7);
        ProfileLoader.save(profile);

    }

}
