package io.shikumiya.ryoko.characters;

import io.shikumiya.ryoko.MessageHelper;
import io.shikumiya.ryoko.configs.Paths;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import java.io.File;
import java.util.Map;

public class CharacterLoader {

    public static void load() {

        File[] list = Paths.CharacterFolder.listFiles();
        if (list == null) return;

        for (File file : list) {
            if (file.getName().endsWith(".yml")) {
                YamlConfiguration yaml = YamlConfiguration.loadConfiguration(file);
                parse(yaml);
            }
        }
    }

    private static void parse(YamlConfiguration yaml) {

        for (String key : yaml.getKeys(false)) {
            if (!yaml.isConfigurationSection(key)) continue;

            ConfigurationSection section = yaml.getConfigurationSection(key);
            if (!section.contains("Name")) continue;

            Character character = new Character(section);
            CharacterManager.RegisterCharacter(character);
        }
    }



}
