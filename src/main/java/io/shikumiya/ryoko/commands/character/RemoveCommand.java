package io.shikumiya.ryoko.commands.character;

import io.shikumiya.ryoko.messages.MessageHelper;
import io.shikumiya.ryoko.messages.UsageMessage;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RemoveCommand {

    public void onCommand(CommandSender sender, String[] args) {

        if (args.length < 3) {
            MessageHelper.sendMessage(sender, UsageMessage.Character_Remove);
            return;
        };

        Player player = Bukkit.getPlayer(args[2]);
        if (player == null) {
            MessageHelper.sendMessage(sender, "player not found.");
            return;
        }

        MessageHelper.sendMessage(sender, "removed!");
    }
}
