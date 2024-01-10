package eu.minehome.minehomelobby.listener;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import static eu.minehome.minehomelobby.utils.Settings.*;

public class BreakEvent implements Listener {

    @EventHandler
    public void OnBreakEvent (BlockBreakEvent e) {
        Player p = e.getPlayer();

        if(p.getWorld().getName().equals(LobbyWorld)) {
            e.setCancelled(true);
            p.sendMessage(Prefix + NoBreakMsg);
        }
    }
}
