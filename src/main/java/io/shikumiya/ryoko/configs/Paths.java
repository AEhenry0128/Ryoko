package io.shikumiya.ryoko.configs;
import io.shikumiya.ryoko.main;
import java.io.File;

public class Paths {

    public static final File Ryoko = main.getPlugin(main.class).getDataFolder();

    public static final File CharacterFolder = new File(Ryoko, "characters");
    public static final File DataFolder = new File(Ryoko, "data");
    public static final File PlayerDataFolder = new File(DataFolder, "players");

    public static final File Config_file = new File(Ryoko, "config.yml");

}
