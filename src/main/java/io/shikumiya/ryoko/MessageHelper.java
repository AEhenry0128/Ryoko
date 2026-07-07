package io.shikumiya.ryoko;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MessageHelper {

    private static final Component CHAT_PREFIX = MiniMessage.miniMessage().deserialize("<bold><#99785D>[<gradient:#B5DE73:#EDF7DA>Ryoko</gradient><#99785D>]</bold> ");
    private static final Component CONSOLE_PREFIX = MiniMessage.miniMessage().deserialize("<gray>[<aqua>Ryoko<gray>] ");

    public static void sendMessage(CommandSender sender, String message) {

        Component prefix = (sender instanceof Player) ? CHAT_PREFIX:CONSOLE_PREFIX;
        Component convert = MiniMessage.miniMessage().deserialize("<gray>" + message);
        Component finalMessage = prefix.append(convert);
        sender.sendMessage(finalMessage);

    }

}
