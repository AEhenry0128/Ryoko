package io.shikumiya.ryoko.characters;

import com.google.common.collect.Maps;
import java.util.Map;

public class CharacterManager {

    private static final Map<String, Character> LoadedCharacter = Maps.newConcurrentMap();

    public static void RegisterCharacter(Character character) {
        String NAME = character.getID();
        LoadedCharacter.put(NAME, character);
    }


}
