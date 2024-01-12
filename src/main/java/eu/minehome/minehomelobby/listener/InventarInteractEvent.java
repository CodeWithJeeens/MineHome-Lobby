package eu.minehome.minehomelobby.listener;

import eu.minehome.minehomelobby.MineHome_Lobby;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class InventarInteractEvent implements Listener {

    private final FileConfiguration configcfg = MineHome_Lobby.getInstance().getConfigFile().getConfigcfg();
    @EventHandler
    public void SwitchItem (PlayerItemHeldEvent e) {
        if (configcfg.getBoolean("Sounds.ItemSwitchSound")){
            e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.ENTITY_ITEM_PICKUP, 5, 5 );
        }
    }

    @EventHandler
    public void DropItem(PlayerDropItemEvent e){
        e.setCancelled(true);
    }

    @EventHandler
    public void DropItem(EntityPickupItemEvent e){
        e.setCancelled(true);
    }

}
