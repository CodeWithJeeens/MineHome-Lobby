package eu.minehome.minehomelobby.listener;

;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerBucketFillEvent;

import static eu.minehome.minehomelobby.utils.Settings.*;

public class InteractEvent implements Listener {
    @EventHandler
    public void BucketEmptyEvent(PlayerBucketEmptyEvent e){
        Player p = e.getPlayer();
        if(p.getWorld().getName().equals(LobbyWorld)) {
            e.setCancelled(true);
            p.sendMessage(Prefix + NoBreakMsg);
        }
    }
    @EventHandler
    public void BucketEmptyEvent(PlayerBucketFillEvent e){
        Player p = e.getPlayer();
        if(p.getWorld().getName().equals(LobbyWorld)) {
            e.setCancelled(true);
            p.sendMessage(Prefix + NoBreakMsg);
        }
    }
}
