package io.shikumiya.ryoko.profiles;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.shikumiya.ryoko.configs.Paths;
import io.shikumiya.ryoko.utils.RyokoJSONReader;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class ProfileLoader {

    public static Profile loadFromFile(Player player) {

        File file = new File(Paths.PlayerDataFolder,player.getUniqueId() + ".json");

        if (!file.exists()) {
            createProfile(player);
        }

        Map<String, Object> data = RyokoJSONReader.read(file);
        return new Profile(data);

    }

    public static void save(Profile profile) {
        File file = new File(Paths.PlayerDataFolder,profile.getUUID() + ".json");
        RyokoJSONReader.write(file, profile.getJSONMap());
    }

    public static void createProfile(Player player) {
        File file = new File(Paths.PlayerDataFolder,player.getUniqueId() + ".json");
        Profile data = new Profile(player);
        RyokoJSONReader.write(file, data.getJSONMap());
    }




}
