package eu.minehome.minehomelobby;

import eu.minehome.minehomelobby.commands.BuildCmd;
import eu.minehome.minehomelobby.listener.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class MineHome_Lobby extends JavaPlugin {

    @Override
    public void onEnable() {
        registerEvents();
        registerCommands();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void registerEvents() {

        Bukkit.getPluginManager().registerEvents(new JoinEvent(), this);
        Bukkit.getPluginManager().registerEvents(new QuitEvent(), this);
        Bukkit.getPluginManager().registerEvents(new BreakEvent(),this);
        Bukkit.getPluginManager().registerEvents(new PlaceEvent(),this);
        Bukkit.getPluginManager().registerEvents(new InteractEvent(),this);

    }
    private void registerCommands() {

        getCommand("build").setExecutor(new BuildCmd());

    }
}
