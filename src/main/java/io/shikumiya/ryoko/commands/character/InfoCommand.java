package io.shikumiya.ryoko.commands.character;

import io.shikumiya.ryoko.messages.UsageMessage;
import io.shikumiya.ryoko.messages.MessageHelper;
import io.shikumiya.ryoko.characters.Character;
import io.shikumiya.ryoko.characters.CharacterManager;
import org.bukkit.command.CommandSender;

public class InfoCommand {

    public void onCommand(CommandSender sender, String[] args) {

        if (args.length < 3) {
            MessageHelper.sendMessage(sender, UsageMessage.Character_Info);
            return;
        };

        Character character = CharacterManager.getCharacter(args[2]);
        if (!(character == null)) {

            String ID = character.getID();
            String NAME = character.getName();
            MessageHelper.sendMessage(sender, "<bold><gradient:#3C85DE:#9AD1E6>Character Info:</gradient>", true);
            MessageHelper.sendMessage(sender, "ID: " + ID, true);
            MessageHelper.sendMessage(sender, "NAME: " + NAME, true);

        } else {
            MessageHelper.sendMessage(sender, "not found character.");
        };

    }
}
