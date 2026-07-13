package io.shikumiya.ryoko.players;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerDataManager {

    private static final Map<Player, String> playerCList = new HashMap<>();

    public static void setPlayerCharacter(Player player, String character) {

        playerCList.put(player, character);
        PlayerDataUpdate(player, character);

    }

    public static boolean getC(Player player) {
        return playerCList.containsKey(player);
    }

    public static void removePlayerCharacter(Player player) {
        playerCList.remove(player);
    }

    public static void PlayerDataUpdate(Player player,String character) {

        UUID uuid = player.getUniqueId();
        File file = new File("plugins/Ryoko/data/players",uuid + ".json");

        if (!file.exists()) {
            PlayerDataCreate(file,player);
        }

        Map<String, Object> data = new LinkedHashMap<>();
        data.put("uuid", player.getUniqueId());
        data.put("name", player.getName());
        data.put("character", character);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter(file)) {
            gson.toJson(data, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void PlayerDataCreate(File file, Player player) {
        try {
            file.createNewFile();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

