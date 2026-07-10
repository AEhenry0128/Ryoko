package io.shikumiya.ryoko;

import io.shikumiya.ryoko.characters.CharacterHandler;
import io.shikumiya.ryoko.commands.RyokoCommand;
import io.shikumiya.ryoko.listeners.CastKeyListener;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class main extends JavaPlugin {

    @Override
    public void onEnable() {

        this.getCommand("ryoko").setExecutor(new RyokoCommand());

        ConfigHandler.createDefaultFolder(getDataFolder());
        ConfigHandler.createDefaultFile(getDataFolder());

        CharacterHandler.getFile();

        getServer().getPluginManager().registerEvents(new CastKeyListener(this), this);
    }

}
