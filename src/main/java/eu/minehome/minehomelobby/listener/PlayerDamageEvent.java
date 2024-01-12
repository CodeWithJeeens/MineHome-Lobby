package eu.minehome.minehomelobby.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.*;

public class PlayerDamageEvent implements Listener {

    @EventHandler
    public void onPlayerFood (FoodLevelChangeEvent e){
        e.setCancelled(true);
    }
    @EventHandler
    public void onPlayerEntityDamage (EntityDamageEvent e){
        e.setCancelled(true);
    }
    @EventHandler
    public void onPlayerDamageByBlockEvent (EntityDamageByBlockEvent e){
        e.setCancelled(true);
    }
    @EventHandler
    public void onPlayerDamageByBlockEvent (EntityDamageByEntityEvent e){
        e.setCancelled(true);
    }
}
