package io.shikumiya.ryoko.commands.character;

import io.shikumiya.ryoko.MessageHelper;
import io.shikumiya.ryoko.characters.CharacterManager;
import io.shikumiya.ryoko.players.PlayerDataManager;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetCommand {

    public void onCommand(CommandSender sender, String[] args) {

        if (args.length < 4) {
            CharacterCommand.usageMessage(sender);
            return;
        };

        Player player = Bukkit.getPlayer(args[2]);
        if (player == null) {
            MessageHelper.sendMessage(sender, "player not found.");
            return;
        }

        String character = args[3];
        if (!(CharacterManager.getLoadedCharacter().contains(character))) {
            MessageHelper.sendMessage(sender, "character not found.");
            return;
        }

        PlayerDataManager.setPlayerCharacter(player, character);
        MessageHelper.sendMessage(sender, "set!");
    }

}
