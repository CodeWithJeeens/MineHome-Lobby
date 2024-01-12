package eu.minehome.minehomelobby.commands;

import eu.minehome.minehomelobby.MineHome_Lobby;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import static eu.minehome.minehomelobby.utils.Settings.*;

public class BuildCmd implements CommandExecutor {

    private final FileConfiguration cfg = MineHome_Lobby.getInstance().getMessagesFile().getMessagescfg();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {

        String Prefix = cfg.getString("Lobby.Prefix");
        String BuildOn = cfg.getString("Messages.Build.on");
        String BuildOff = cfg.getString("Messages.Build.off");
        String NoPerms = cfg.getString("Messages.NoPerms");


        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission(BuildPerms)) {
                if (p.getGameMode().equals(GameMode.ADVENTURE)) {
                    p.getInventory().clear();
                    p.setGameMode(GameMode.CREATIVE);
                    p.sendMessage(Prefix + BuildOn);
                } else {
                    if (p.getGameMode().equals(GameMode.CREATIVE)) {
                        p.getInventory().clear();
                        p.setGameMode(GameMode.ADVENTURE);
                        p.sendMessage(Prefix + BuildOff);
                    }
                }
            } else {
                p.sendMessage(Prefix + NoPerms);
            }
        }
        return false;
    }
}