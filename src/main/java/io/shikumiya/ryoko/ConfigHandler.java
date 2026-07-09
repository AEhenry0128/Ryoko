package io.shikumiya.ryoko;

import java.io.File;

public class ConfigHandler {

    public static void onServerStart(File RyokoDirectory) {

        File CharacterFolder = new File(RyokoDirectory, "characters");
        File DataFolder = new File(RyokoDirectory, "data");
        File PlayerDataFolder = new File(DataFolder, "players");

        if (!CharacterFolder.exists()) CharacterFolder.mkdirs();
        if (!DataFolder.exists()) DataFolder.mkdirs();
        if (!PlayerDataFolder.exists()) PlayerDataFolder.mkdirs();

    }

}
