package io.shikumiya.ryoko.commands.character;

import io.shikumiya.ryoko.messages.MessageHelper;
import io.shikumiya.ryoko.messages.UsageMessage;
import org.bukkit.command.CommandSender;

public class CharacterCommand {

    public void onCommand(CommandSender sender, String[] args) {

        if (args.length < 2) {
            MessageHelper.sendMessage(sender, UsageMessage.FULL);
            return;
        }

        switch (args[1].toLowerCase()) {
            case "set" -> new SetCommand().onCommand(sender, args);
            case "remove" -> new RemoveCommand().onCommand(sender, args);
            case "list" -> new ListCommand().onCommand(sender, args);
            case "info" -> new InfoCommand().onCommand(sender, args);
            default -> MessageHelper.sendMessage(sender, UsageMessage.FULL);
        }
    }


}
