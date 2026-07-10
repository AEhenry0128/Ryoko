package io.shikumiya.ryoko.characters;

import io.shikumiya.ryoko.MessageHelper;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import java.io.File;
import java.util.Map;

public class CharacterHandler {

    public static void getFile() {

        File folder = new File("plugins/Ryoko/characters");
        File[] ALLFILE = folder.listFiles();

        for (File file : ALLFILE) {
            if (file.getName().endsWith(".yml")) {
                YamlConfiguration yaml = YamlConfiguration.loadConfiguration(file);
                checkData(yaml);
            }
        }
        MessageHelper.sendMessage(Bukkit.getConsoleSender(), CharacterManager.getLoadedCharacter().toString());
    }

    private static void checkData(YamlConfiguration yaml) {

        for (String key : yaml.getKeys(false)) {
            if (yaml.isConfigurationSection(key)) {
                ConfigurationSection section = yaml.getConfigurationSection(key);
                if (section.contains("Name")) {
                    Map<String, ?> data = section.getValues(true) ;
                    CharacterManager.addCharacter(key,data);
                }
            }
        }
    }



}
