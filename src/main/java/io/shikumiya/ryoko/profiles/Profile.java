package io.shikumiya.ryoko.profiles;

import io.shikumiya.ryoko.characters.Character;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

public class Profile {

    private UUID UNIQUE_ID;
    private String DISPLAY_NAME;
    private String CURRENT_CHARACTER;
    private int JUMPING_STATUS;
    private boolean LAST_JUMP_INPUT;

    public Profile(Player player) {
        this.UNIQUE_ID = player.getUniqueId();
        this.DISPLAY_NAME = player.getName();
        this.CURRENT_CHARACTER = "";
        this.JUMPING_STATUS = 0;
    }

    public Profile(Map<String, Object> profile) {
        this.UNIQUE_ID = UUID.fromString((String) profile.get("uniqueID"));
        this.DISPLAY_NAME = profile.get("displayName").toString();
        this.CURRENT_CHARACTER = profile.get("current_character").toString();
        this.JUMPING_STATUS = 0;
        this.LAST_JUMP_INPUT = false;
    }

    public Map<String, Object> getJSONMap() {

        Map<String, Object> Map = new LinkedHashMap<>();
        Map.put("uniqueID", UNIQUE_ID);
        Map.put("displayName", DISPLAY_NAME);
        Map.put("current_character", CURRENT_CHARACTER);
        Map.put("has_characters", new HashMap<>());

        return Map;
    }

    public void setCharacter(Character character) {
        this.CURRENT_CHARACTER = character.getID();
    }

    public void removeCharacter() {this.CURRENT_CHARACTER = "";}

    public void setJumpStatus(int status) {
        this.JUMPING_STATUS = status;
    }

    public void setLastJumpInput(boolean TF) {
        this.LAST_JUMP_INPUT = TF;
    }

    public UUID getUUID() {
        return this.UNIQUE_ID;
    }

    public String getDisplayName() {
        return this.DISPLAY_NAME;
    }

    public String getCurrentCharacter() {
        return this.CURRENT_CHARACTER;
    }

    public int getJumpStatus() {
        return this.JUMPING_STATUS;
    }

    public boolean getLastJumpInput() {
        return this.LAST_JUMP_INPUT;
    }

}
