package io.shikumiya.ryoko.characters;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

import java.util.List;

public class Character {

    private String ID;
    private String NAME;
    private List<String> DESCRIPTION;
    private boolean DOUBLE_JUMP;
    private boolean GLIDING;
    private boolean OFFHAND_ITEM;
    private String[] ABILITY;


    public Character(ConfigurationSection config) {
        this.ID = config.getName();
        this.NAME = config.getString("Name");
        this.DESCRIPTION = config.getStringList("Description");
        this.DOUBLE_JUMP = true;
        this.GLIDING = true;
        this.OFFHAND_ITEM = false;
    }

    public String getID() {
        return this.ID;
    }

    public String getName() {
        return this.NAME;
    }

    public List<String> Description() {
        return this.DESCRIPTION;
    }

}
