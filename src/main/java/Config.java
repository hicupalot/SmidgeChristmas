import org.bukkit.ChatColor;

import java.util.HashMap;
import java.util.UUID;

public class Config {
    public static SmidgeChristmas plugin;

    public Config(SmidgeChristmas instance) {
        plugin = instance;
    }
    public static final HashMap<UUID, Boolean> snowBallFight = new HashMap<UUID, Boolean>();
    public static final String noPermission = ChatColor.translateAlternateColorCodes('&',
            "&c[Smidge] You do not have permission");
    public static final String notPlayer = ChatColor.translateAlternateColorCodes('&',
            "&c[Smidge] You must be a player to do this");
}
