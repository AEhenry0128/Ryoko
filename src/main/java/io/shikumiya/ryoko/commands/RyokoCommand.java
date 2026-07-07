package io.shikumiya.ryoko.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import io.shikumiya.ryoko.commands.others.*;
import io.shikumiya.ryoko.commands.character.*;

public class RyokoCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length == 0) return true;

        switch (args[0].toLowerCase()) {
            case "version" -> new Version().onCommand(sender);
            case "reload" -> new Reload().onCommand(sender);
            case "character" -> new CharacterCommand().onCommand(sender, args);
        }
        return true;
    }
}
