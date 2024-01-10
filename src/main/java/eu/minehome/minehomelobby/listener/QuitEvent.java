package eu.minehome.minehomelobby.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import static org.bukkit.GameMode.ADVENTURE;

public class QuitEvent implements Listener {

    @EventHandler
    public void playerQuit (PlayerQuitEvent e) {
        Player p = e.getPlayer();

        e.setQuitMessage(null);
    }
}
