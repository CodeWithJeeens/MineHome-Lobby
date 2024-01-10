package eu.minehome.minehomelobby.listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import static eu.minehome.minehomelobby.utils.Settings.*;

public class PlaceEvent implements Listener {

    @EventHandler
    public void OnPlaceEvent (BlockPlaceEvent e) {
        Player p = e.getPlayer();

        if(p.getWorld().getName().equals(LobbyWorld)) {
            e.setCancelled(true);
            p.sendMessage(Prefix + NoBreakMsg);
        }
    }
}
