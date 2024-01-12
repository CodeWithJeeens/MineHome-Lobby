package eu.minehome.minehomelobby;

import eu.minehome.minehomelobby.commands.BuildCmd;
import eu.minehome.minehomelobby.configfile.ConfigFile;
import eu.minehome.minehomelobby.configfile.MessagesFile;
import eu.minehome.minehomelobby.listener.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class MineHome_Lobby extends JavaPlugin {

    public static MineHome_Lobby instance;
    private MessagesFile messagesFile;
    private ConfigFile configFile;


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

    }
    private void registerCommands() {

    getCommand("build").setExecutor(new BuildCmd());

    }

    private void createConfig(){
        instance = this;

        messagesFile = new MessagesFile();
        messagesFile.createFile();

        configFile = new ConfigFile();
        configFile.createFile();

    }

    public MessagesFile getMessagesFile() {return messagesFile;}
    public ConfigFile getConfigFile() {
        return configFile;
    }
    public static MineHome_Lobby getInstance(){return instance;}
}
