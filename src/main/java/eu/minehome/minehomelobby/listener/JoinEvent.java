package eu.minehome.minehomelobby.listener;

import eu.minehome.minehomelobby.MineHome_Lobby;
import eu.minehome.minehomelobby.utils.LobbyInventory;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;


public class JoinEvent implements Listener {

    private final FileConfiguration configcfg = MineHome_Lobby.getInstance().getConfigFile().getConfigcfg();
    private final FileConfiguration messagescfg = MineHome_Lobby.getInstance().getMessagesFile().getMessagescfg();
    String ActionBarVer = messagescfg.getString("Version");

    @EventHandler
    public void playerJoin (PlayerJoinEvent e) {

        Player p = e.getPlayer();

        new BukkitRunnable() {
            @Override
            public void run() {
                if (!p.isOnline()) {
                    cancel(); // this cancels it when they leave
                }
                p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ActionBarVer));
            }
        }.runTaskTimer(MineHome_Lobby.getInstance() /*<-- your plugin instance*/, 5L, 5L); // again, may be running faster than needed


        e.getPlayer().setGameMode(GameMode.ADVENTURE);
        LobbyInventory.SetLobbyInventory(p);
        e.setJoinMessage(null);

        if (configcfg.getBoolean("Sound.JoinSound")){
            e.getPlayer().playSound(e.getPlayer().getLocation(), (Sound.ENTITY_PLAYER_LEVELUP), 3, 3);
        }
    }



}

