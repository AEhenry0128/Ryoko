package io.shikumiya.ryoko.commands.character;

import io.shikumiya.ryoko.characters.CharacterManager;
import io.shikumiya.ryoko.messages.MessageHelper;
import org.bukkit.command.CommandSender;

import java.util.Set;

public class ListCommand {

    public void onCommand(CommandSender sender, String[] args) {

        Set<String> character = CharacterManager.getAllCharacter();

        if (!(character == null)) {
            MessageHelper.sendMessage(sender, character.toString());
        } else {
            MessageHelper.sendMessage(sender, "empty");
        }

    }
}
