package io.shikumiya.ryoko.commands.others;

import io.shikumiya.ryoko.messages.MessageHelper;
import org.bukkit.command.CommandSender;

public class Version {

    public void onCommand(CommandSender sender) {
        String ver = "beta";
        MessageHelper.sendMessage(sender, ver);

    }
}
