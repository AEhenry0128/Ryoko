package io.shikumiya.ryoko;

import io.shikumiya.ryoko.characters.CharacterLoader;
import io.shikumiya.ryoko.commands.RyokoCommand;
import io.shikumiya.ryoko.configs.ConfigManager;
import io.shikumiya.ryoko.listeners.CastKeyListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class main extends JavaPlugin {

    @Override
    public void onEnable() {

        this.getCommand("ryoko").setExecutor(new RyokoCommand());

        ConfigManager.createDefaultFolder(getDataFolder());
        ConfigManager.createDefaultFile(getDataFolder());

        CharacterLoader.load();

        getServer().getPluginManager().registerEvents(new CastKeyListener(this), this);
    }

}
