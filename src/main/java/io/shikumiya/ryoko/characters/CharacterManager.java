package io.shikumiya.ryoko.characters;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class CharacterManager {

    private static final Map<String, Map<?, ?>> LoadedCharacter = new LinkedHashMap<>();

    public static Set<String> getLoadedCharacter() {
        return LoadedCharacter.keySet();
    }

    public static void addCharacter(String ID, Map<?,?> DATA) {
        LoadedCharacter.put(ID, DATA);
    }

}
