package io.shikumiya.ryoko.characters;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class PlayerManager {

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
}

