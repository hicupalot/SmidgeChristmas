import org.bukkit.plugin.java.JavaPlugin;

public class SmidgeChristmas extends JavaPlugin {
    @Override
    public void onEnable() {
        getCommand("ToggleSnowBallFight").setExecutor(new ToggleSnowBallFight());
        getServer().getPluginManager().registerEvents(new IceSkating(), this);
        getServer().getPluginManager().registerEvents(new SnowBallFight(), this);
        getCommand("SecretSanta").setExecutor(new SecretSanta());

    }

    @Override
    public void onDisable() {

    }
}
