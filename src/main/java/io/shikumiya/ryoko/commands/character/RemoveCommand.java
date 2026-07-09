package io.shikumiya.ryoko.commands.character;

import io.shikumiya.ryoko.MessageHelper;
import io.shikumiya.ryoko.players.PlayerDataManager;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RemoveCommand {

    public void onCommand(CommandSender sender, String[] args) {

        if (args.length < 3) {
            CharacterCommand.usageMessage(sender);
            return;
        };

        Player player = Bukkit.getPlayer(args[2]);
        if (player == null) {
            MessageHelper.sendMessage(sender, "player not found.");
            return;
        }

        PlayerDataManager.removePlayerCharacter(player);
        MessageHelper.sendMessage(sender, "removed!");
    }
}
