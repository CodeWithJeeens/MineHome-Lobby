package eu.minehome.minehomelobby.listener;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class LobbyInventoryEvent implements Listener{

    @EventHandler
    public void OnNavigator(PlayerInteractEvent e) {

        Player p = e.getPlayer();
//Navigator//
        try {
            if (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                if (e.getItem().getItemMeta().getDisplayName().equals("§b§lNavigator")) {
                    Inventory Navigator = Bukkit.createInventory(null, 9 * 5, "§b§lNavigator");

                    // TODO: Add Copmpas Items

                    ItemStack spawn = new ItemStack(Material.NETHER_STAR);
                    ItemMeta spawnMeta = spawn.getItemMeta();
                    spawnMeta.setDisplayName("§b§lSpawn");
                    spawn.setItemMeta(spawnMeta);


                    Navigator.setItem(31, spawn);

                    p.openInventory(Navigator);

                }
            }
        } catch (Exception e1) {
        }

    }


}
