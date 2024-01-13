package eu.minehome.minehomelobby;

import com.google.gson.JsonArray;
import eu.minehome.minehomelobby.commands.BuildCmd;
import eu.minehome.minehomelobby.commands.SetSpawnCmd;
import eu.minehome.minehomelobby.configfile.ConfigFile;
import eu.minehome.minehomelobby.configfile.LocationFile;
import eu.minehome.minehomelobby.configfile.MessagesFile;
import eu.minehome.minehomelobby.listener.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class MineHome_Lobby extends JavaPlugin {

    public static MineHome_Lobby instance;
    private MessagesFile messagesFile;
    private ConfigFile configFile;
    private LocationFile locationFile;


    @Override
    public void onEnable() {

        createConfig();
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
        Bukkit.getPluginManager().registerEvents(new PlayerDamageEvent(), this);
        Bukkit.getPluginManager().registerEvents(new InventarInteractEvent(), this);
        Bukkit.getPluginManager().registerEvents(new LobbyInventoryEvent(), this);

    }
    private void registerCommands() {

    getCommand("build").setExecutor(new BuildCmd());
    getCommand("setspawn").setExecutor(new SetSpawnCmd());

    }

    private void createConfig(){
        instance = this;

        messagesFile = new MessagesFile();
        messagesFile.createFile();

        configFile = new ConfigFile();
        configFile.createFile();

        locationFile = new LocationFile();
        locationFile.createFile();

    }

    public MessagesFile getMessagesFile() {return messagesFile;}
    public ConfigFile getConfigFile() {
        return configFile;
    }
    public LocationFile getLocationFile() {return locationFile;}
    public static MineHome_Lobby getInstance(){return instance;}
}
