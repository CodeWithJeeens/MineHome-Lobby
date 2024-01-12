package eu.minehome.minehomelobby.configfile;

import eu.minehome.minehomelobby.MineHome_Lobby;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class MessagesFile {
    private final File file = new File(MineHome_Lobby.getInstance().getDataFolder().getPath(), "messages.yml");
    private final FileConfiguration messagescfg = YamlConfiguration.loadConfiguration(file);

    public void createFile() {
        if (!file.exists()) {
            try {
                file.getParentFile().mkdir();
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        addDefault();
    }

    private void addDefault() {
        messagescfg.options().copyDefaults(true);
        // Add all Messages to messages.yml
        // cfg.addDefault(messages.path, "messages");
        messagescfg.addDefault("Lobby.Prefix", "§bLobby §7| §7");
        messagescfg.addDefault("Lobby.World", "world");
        messagescfg.addDefault("Messages.NoBarking", "§7Du bist noch in der §4Lobby§7!");
        messagescfg.addDefault("Messages.NoPerms", "§7Dafür hast du keine §4Rechte§7!");
        messagescfg.addDefault("Messages.Build.on", "§7Du bist jetzt im §2Baumodus§7!");
        messagescfg.addDefault("Messages.Build.off", "§7Du bist nicht mehr im §4Baumodus§7!");
        save();
    }

    public void save() {
        try {
            messagescfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public FileConfiguration getMessagescfg() {
        return messagescfg;
    }
}
