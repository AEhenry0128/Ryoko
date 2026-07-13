package io.shikumiya.ryoko.configs;

import io.shikumiya.ryoko.main;

import java.io.File;

public class ConfigManager {

    public static void createDefaultFolder(File RyokoDirectory) {

        if (!Paths.CharacterFolder.exists()) Paths.CharacterFolder.mkdirs();
        if (!Paths.DataFolder.exists()) Paths.DataFolder.mkdirs();
        if (!Paths.PlayerDataFolder.exists()) Paths.PlayerDataFolder.mkdirs();

    }

    public static void createDefaultFile(File RyokoDirectory) {
        if (!Paths.Config_file.exists()) {
            main.getPlugin(main.class).saveResource("config.yml",true);
        }
    }

}
