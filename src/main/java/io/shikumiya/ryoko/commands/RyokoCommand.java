package io.shikumiya.ryoko.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import io.shikumiya.ryoko.commands.others.*;
import io.shikumiya.ryoko.commands.character.*;
import org.bukkit.command.TabCompleter;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RyokoCommand implements CommandExecutor, TabCompleter {

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

    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1) {
            List<String> subs = List.of("version", "reload", "character");
            return subs.stream()
                    .filter(s -> s.toLowerCase().startsWith(args[0].toLowerCase()))
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }
}
