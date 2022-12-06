import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ToggleSnowBallFight implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Config.notPlayer);
            return false;
        }
        if (!sender.hasPermission("smidgeChristmas.admin")) {
            sender.sendMessage(Config.noPermission);
            return false;
        }
        Config.snowBallFight.put(((Player) sender).getUniqueId(),true);
        String snowBallFightTime = ChatColor.translateAlternateColorCodes('&',"&bSNOWBALL FIGHT STARTED");
        Bukkit.broadcastMessage(snowBallFightTime);
        for (Player players : Bukkit.getOnlinePlayers()){
         int firstFreeSlot =  players.getInventory().firstEmpty();
            ItemStack snowball = new ItemStack(Material.SNOWBALL,64);
         players.getInventory().setItem(firstFreeSlot, snowball );
        }
        return true;
    }
}
