package io.shikumiya.ryoko.players;

import io.shikumiya.ryoko.MessageHelper;
import io.shikumiya.ryoko.main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerDataManager {

    private static final Map<Player, String> playerCList = new HashMap<>();

    public static void setPlayerCharacter(Player player, String character) {

        playerCList.put(player, character);

    }

    public static boolean getC(Player player) {
        return playerCList.containsKey(player);
    }

    public static void removePlayerCharacter(Player player) {
        playerCList.remove(player);
    }

    public static void PlayerDataUpdate(Player player ) {

        UUID uuid = player.getUniqueId();
        File File = new File("plugins/Ryoko/data/players",uuid + ".json");

        if (!File.exists()) {
            try {
                File.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}

