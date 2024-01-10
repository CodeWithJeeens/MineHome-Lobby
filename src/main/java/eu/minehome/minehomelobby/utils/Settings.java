package eu.minehome.minehomelobby.utils;

import org.bukkit.ChatColor;

public class Settings {
    /** Chat Stuff */
    public final static String Prefix = ChatColor.AQUA + "Lobby " + ChatColor.GRAY + "| ";
    public final static String NoBreakMsg = ChatColor.GRAY+"Du bist noch in der "+ChatColor.RED+"Lobby"+ ChatColor.GRAY+"!";
    public final static String NoPems = ChatColor.GRAY+"Dazu hast du keine "+ChatColor.RED+"Rechte"+ ChatColor.GRAY+"!";
    public final static String BuildOnMsg = ChatColor.GRAY+"Du bist jetzt im "+ChatColor.GREEN+"Baumodus"+ ChatColor.GRAY+"!";
    public final static String BuildoffMsg = ChatColor.GRAY+"Du bist nicht mehr im  "+ChatColor.RED+"Baumodus"+ ChatColor.GRAY+"!";
    public final static String LobbyWorld = "world";

    public final static String LobbyGamemode= "GameMode.ADVENTURE";

    /** Permissionen */
    public final static String BuildPerms = "Lobby.Build";
}
