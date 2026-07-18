package io.shikumiya.ryoko.commands.others;

import io.shikumiya.ryoko.characters.CharacterLoader;
import io.shikumiya.ryoko.characters.CharacterManager;
import io.shikumiya.ryoko.messages.MessageHelper;
import org.bukkit.command.CommandSender;

public class Reload {

    public void onCommand(CommandSender sender) {

        CharacterManager.ResetLoadedCharacter();
        CharacterLoader.load();
        MessageHelper.sendMessage(sender, "reload!");
    }

}
