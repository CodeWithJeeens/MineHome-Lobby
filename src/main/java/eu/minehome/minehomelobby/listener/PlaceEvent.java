package eu.minehome.minehomelobby.listener;

import eu.minehome.minehomelobby.MineHome_Lobby;
import org.bukkit.GameMode;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import static eu.minehome.minehomelobby.utils.Settings.*;

public class PlaceEvent implements Listener {

    private final FileConfiguration messagescfg = MineHome_Lobby.getInstance().getMessagesFile().getMessagescfg();

    //private final FileConfiguration configcfg = MineHome_Lobby.getInstance().getConfigFile().getConfigcfg();

    @EventHandler
    public void OnPlaceEvent (BlockPlaceEvent e) {

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
}
