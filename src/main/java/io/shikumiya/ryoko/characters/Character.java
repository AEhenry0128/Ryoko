package io.shikumiya.ryoko.characters;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Character {

    private final String ID;
    private final String NAME;
    private final List<String> DESCRIPTION;
    private final boolean DOUBLE_JUMP;
    private final boolean GLIDING;
    private final boolean OFFHAND_ITEM;
    private final Map<String, String> ABILITY;


    public Character(ConfigurationSection config) {
        this.ID = config.getName();
        this.NAME = config.getString("Name");
        this.DESCRIPTION = config.getStringList("Description");
        this.DOUBLE_JUMP = config.getBoolean("Options.DoubleJump", true);
        this.GLIDING = config.getBoolean("Options.Gliding", true);
        this.OFFHAND_ITEM = config.getBoolean("Options.OffhandItem", false);

        this.ABILITY = new HashMap<>();
        for (String line : config.getStringList("Ability")) {
            String[] s = line.trim().split("\\s+", 2);
            if (s.length == 2) {
                ABILITY.put(s[0], s[1]);
            }
        }

    }

    public String getID() {
        return this.ID;
    }

    public String getName() {
        return this.NAME;
    }

    public List<String> getDescription() {
        return this.DESCRIPTION;
    }

    public boolean isDoubleJump() {
        return this.DOUBLE_JUMP;
    }

    public boolean isGliding() {
        return this.GLIDING;
    }

    public boolean isOffhandItem() {
        return this.OFFHAND_ITEM;
    }

    public Map<String, String> getAbility() {
        return this.ABILITY;
    }

    public String getSkill(String SKILL) {
        return this.ABILITY.get(SKILL);
    }
}
