package io.shikumiya.ryoko.commands.character;

import io.shikumiya.ryoko.MessageHelper;
import org.bukkit.command.CommandSender;

public class CharacterCommand {

    public void onCommand(CommandSender sender, String[] args) {

        if (args.length < 2) {
            usageMessage(sender);
            return;
        }

        switch (args[1].toLowerCase()) {
            case "set" -> new SetCommand().onCommand(sender, args);
            case "list" -> new ListCommand().onCommand(sender);
            case "remove" -> new RemoveCommand().onCommand(sender, args);
            default -> usageMessage(sender);
        }
    }

    public static void usageMessage(CommandSender sender) {
        MessageHelper.sendMessage(sender, "/ryoko character <set/remove/list> [player] [character]");
    }

}
