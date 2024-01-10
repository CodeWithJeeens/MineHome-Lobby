package eu.minehome.minehomelobby.listener;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import static org.bukkit.GameMode.ADVENTURE;


public class JoinEvent implements Listener {

    @EventHandler
    public void playerJoin (PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if (p.getGameMode().equals(ADVENTURE)) {
            return;
        }else {
            p.setGameMode(ADVENTURE);
        }
        e.setJoinMessage(null);
    }

}

