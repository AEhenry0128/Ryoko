package io.shikumiya.ryoko.profiles;

import com.google.common.collect.Maps;
import org.bukkit.entity.Player;

import java.util.Map;
import java.util.UUID;

public class ProfileManager {

    private static final Map<UUID, Profile> LoadedProfiles = Maps.newConcurrentMap();

    public static void RegisterProfile(Profile profile) {
        UUID UUID = profile.getUUID();
        LoadedProfiles.put(UUID, profile);
    }

    public static void removeProfile(Profile profile) {
        UUID UUID = profile.getUUID();
        LoadedProfiles.remove(UUID);
    }

    public static Profile getProfile(Player player) {
        return LoadedProfiles.get(player.getUniqueId());
    }

}

