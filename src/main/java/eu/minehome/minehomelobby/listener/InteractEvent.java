package eu.minehome.minehomelobby.listener;

import eu.minehome.minehomelobby.MineHome_Lobby;
import org.bukkit.GameMode;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.*;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerBucketFillEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;

import static eu.minehome.minehomelobby.utils.Settings.BuildPerms;


public class InteractEvent implements Listener {

    private final FileConfiguration messagescfg = MineHome_Lobby.getInstance().getMessagesFile().getMessagescfg();
    @EventHandler
    public void BucketEmptyEvent(PlayerBucketEmptyEvent e){

        String Prefix = messagescfg.getString("Lobby.Prefix");
        String LobbyWorld = messagescfg.getString("Lobby.World");
        String NoBreakMsg = messagescfg.getString("Messages.NoBarking");

        Player p = e.getPlayer();
        if(p.getWorld().getName().equals(LobbyWorld)) {
            if(p.hasPermission(BuildPerms) && p.getGameMode() == (GameMode.CREATIVE)){
                e.setCancelled(false);
            } else if (!p.hasPermission(BuildPerms) || p.getGameMode() != (GameMode.CREATIVE)) {
                e.setCancelled(true);
                p.sendMessage(Prefix + NoBreakMsg);
            }
        }

    }
    @EventHandler
    public void BucketEmptyEvent(PlayerBucketFillEvent e){

        String Prefix = messagescfg.getString("Lobby.Prefix");
        String LobbyWorld = messagescfg.getString("Lobby.World");
        String NoBreakMsg = messagescfg.getString("Messages.NoBarking");

        Player p = e.getPlayer();

        if(p.getWorld().getName().equals(LobbyWorld)) {
            if(p.hasPermission(BuildPerms) && p.getGameMode() == (GameMode.CREATIVE)){
                e.setCancelled(false);
            } else if (!p.hasPermission(BuildPerms) || p.getGameMode() != (GameMode.CREATIVE)) {
                e.setCancelled(true);
                p.sendMessage(Prefix + NoBreakMsg);
            }
        }

    }
    @EventHandler
    public void ItemMoveEvent(InventoryClickEvent e){

        if (e.getWhoClicked() instanceof Player){
            Player p = (Player) e.getWhoClicked();
            if (p.hasPermission(BuildPerms) && p.getGameMode() == (GameMode.CREATIVE)){
                e.setCancelled(false);
            } else if (!p.hasPermission(BuildPerms) || p.getGameMode() != (GameMode.CREATIVE)) {
                e.setCancelled(true);
            }
        }
    }
    @EventHandler
    public void ItemSwapHandEvent(PlayerSwapHandItemsEvent e){
        e.setCancelled(true);
    }

}
