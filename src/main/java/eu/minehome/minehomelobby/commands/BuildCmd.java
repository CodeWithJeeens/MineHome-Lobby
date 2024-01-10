package eu.minehome.minehomelobby.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static eu.minehome.minehomelobby.utils.Settings.*;

public class BuildCmd implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission(BuildPerms)) {
                if (p.getGameMode().equals(GameMode.ADVENTURE)) {
                    p.getInventory().clear();
                    p.setGameMode(GameMode.CREATIVE);
                    p.sendMessage(BuildOnMsg);
                } else {
                    if (p.getGameMode().equals(GameMode.CREATIVE)) {
                        p.getInventory().clear();
                        p.setGameMode(GameMode.ADVENTURE);
                        p.sendMessage(BuildoffMsg);
                    }
                }
            } else {
                p.sendMessage(NoPems);
            }
        }
        return false;
    }
}