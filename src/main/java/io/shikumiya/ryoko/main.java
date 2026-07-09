package io.shikumiya.ryoko;

import io.shikumiya.ryoko.characters.CharacterLoader;
import io.shikumiya.ryoko.commands.RyokoCommand;
import io.shikumiya.ryoko.listeners.CastKeyListener;
import org.bukkit.plugin.java.JavaPlugin;
import java.io.File;

public final class main extends JavaPlugin {

    @Override
    public void onEnable() {

        saveDefaultConfig();

        this.getCommand("ryoko").setExecutor(new RyokoCommand());

        ConfigHandler.onServerStart(getDataFolder());
        CharacterLoader.getFile();

        getServer().getPluginManager().registerEvents(new CastKeyListener(this), this);
    }



}
