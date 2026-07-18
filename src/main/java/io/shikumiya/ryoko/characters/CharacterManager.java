package io.shikumiya.ryoko.characters;

import com.google.common.collect.Maps;
import java.util.Map;
import java.util.Set;

public class CharacterManager {

    private static final Map<String, Character> LoadedCharacters = Maps.newConcurrentMap();

    public static void RegisterCharacter(Character character) {
        String ID = character.getID();
        LoadedCharacters.put(ID, character);
    }

    public static Character getCharacter(String ID) {
        return LoadedCharacters.get(ID);
    }

    public static Set<String> getAllCharacter() {
        return LoadedCharacters.keySet();
    }

    public static void ResetLoadedCharacter() {
        LoadedCharacters.clear();
    }

    public static int getAmount() {
        return LoadedCharacters.size();
    }

}
