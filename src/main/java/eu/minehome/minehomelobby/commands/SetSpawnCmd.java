package eu.minehome.minehomelobby.commands;

import eu.minehome.minehomelobby.MineHome_Lobby;
import eu.minehome.minehomelobby.configfile.ConfigFile;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

import static eu.minehome.minehomelobby.utils.Settings.*;


public class SetSpawnCmd implements CommandExecutor {

    private final FileConfiguration messagescfg = MineHome_Lobby.getInstance().getMessagesFile().getMessagescfg();
    FileConfiguration locationcfg = MineHome_Lobby.getInstance().getLocationFile().getLocationcfg();
    String Prefix = messagescfg.getString("Lobby.Prefix");
    String SetSpawnUse = messagescfg.getString("Messages.SetSpawnUse");
    String SetSpawnSet = messagescfg.getString("Messages.SetSpawnSet");
    String NoPerms = messagescfg.getString("Messages.NoPerms");

    @Override
    public boolean onCommand( CommandSender sender, Command command, String s, String[] args) {
        Player p =(Player) sender;
        if (!(sender instanceof Player)){
            return true;
        }
        if (args.length != 0){
            p.sendMessage(Prefix + SetSpawnUse);
            return true;
        }
        if (!(p.hasPermission(LobbySetSpawn))){
            p.sendMessage(Prefix + NoPerms);
            return true;
        }

        locationcfg.set("Spawn.World", p.getLocation().getWorld().getName());
        locationcfg.set("Spawn.X", p.getLocation().getX());
        locationcfg.set("Spawn.Y", p.getLocation().getY());
        locationcfg.set("Spawn.Z", p.getLocation().getZ());
        locationcfg.set("Spawn.Yaw", p.getLocation().getYaw());
        locationcfg.set("Spawn.Pitch", p.getLocation().getPitch());

        MineHome_Lobby.getInstance().getLocationFile().save();

        p.sendMessage(Prefix + SetSpawnSet);
        return true;
    }

}
