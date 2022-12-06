import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.*;

public class SecretSanta implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Random rand = new Random();
        ArrayList<String> assignments = new ArrayList<>();
        if (!(sender instanceof Player)) {
            sender.sendMessage(Config.notPlayer);
            return false;
        }
        if (!sender.hasPermission("smidgeChristmas.admin")) {
            sender.sendMessage(Config.noPermission);
            return false;
        }
        ArrayList<Player> players = new ArrayList<>(Bukkit.getOnlinePlayers());
        if (players.size() < 2) {
            String noOnlinePlayers = ChatColor.translateAlternateColorCodes('&', "&cNo One Is Online");
            sender.sendMessage(noOnlinePlayers);
            return false;
        }
        for (Player player : players) {
            // Generate a random index within the players ArrayList
            int index = rand.nextInt(players.size());
            assignments.add(player.getName() + " -> " + players.get(index).getName());
            players.remove(index);
        }
        for (String assignment : assignments) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                player.sendMessage(ChatColor.GREEN + assignment);
            }

            // Clear players and assignments ArrayLists for future use
            players.clear();
            assignments.clear();
        }

        return true;
    }
}

