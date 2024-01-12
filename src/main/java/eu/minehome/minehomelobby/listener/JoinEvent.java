package eu.minehome.minehomelobby.listener;

import eu.minehome.minehomelobby.MineHome_Lobby;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {

    private final FileConfiguration configcfg = MineHome_Lobby.getInstance().getConfigFile().getConfigcfg();

    @EventHandler
    public void playerJoin (PlayerJoinEvent e) {

        e.getPlayer().setGameMode(GameMode.ADVENTURE);
        e.setJoinMessage(null);
        if (configcfg.getBoolean("Sound.JoinSound")){
            e.getPlayer().playSound(e.getPlayer().getLocation(), (Sound.ENTITY_PLAYER_LEVELUP), 3, 3);
        }
    }
}

