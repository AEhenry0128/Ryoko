package io.shikumiya.ryoko;

import java.io.File;

public class ConfigHandler {

    public static void createDefaultFolder(File RyokoDirectory) {

        File CharacterFolder = new File(RyokoDirectory, "characters");
        File DataFolder = new File(RyokoDirectory, "data");
        File PlayerDataFolder = new File(DataFolder, "players");

        if (!CharacterFolder.exists()) CharacterFolder.mkdirs();
        if (!DataFolder.exists()) DataFolder.mkdirs();
        if (!PlayerDataFolder.exists()) PlayerDataFolder.mkdirs();
    }

    public static void createDefaultFile(File RyokoDirectory) {
        File ConfigFile = new File(RyokoDirectory, "config.yml");
        if (!ConfigFile.exists()) {
            main.getPlugin(main.class).saveResource("config.yml",true);
        }
    }

}
