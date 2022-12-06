import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.net.http.WebSocket;
import java.util.*;

public class IceSkating implements Listener {
    @EventHandler
    public void onIceWalk(PlayerMoveEvent e) {
        Player player = e.getPlayer();
        UUID playerUUID = player.getUniqueId();
        Block block = player.getLocation().getBlock().getRelative(BlockFace.DOWN);
        if (player.getInventory().getBoots()==null) {
            return;
        }
        if (!player.getInventory().getBoots().getItemMeta().hasDisplayName()) {
            return;
        }
        if (player.getInventory().getBoots().equals(Material.IRON_BOOTS)) {
            if (player.getInventory().getBoots().getItemMeta().getDisplayName().equals("Ice Skates")) {
                if (block.getType().equals(Material.ICE) || block.getType().equals(Material.BLUE_ICE) ||
                        block.getType().equals(Material.PACKED_ICE)){
                    HashMap<UUID, Boolean> isSkating = new HashMap<>();
                    if (!isSkating.containsKey(playerUUID)) {
                        isSkating.put(player.getUniqueId(), true);
                    }
                    while (isSkating.containsKey(player.getUniqueId())) {
                        player.setWalkSpeed(0.4f);
                    }
                    if (isSkating.containsKey(playerUUID)) {
                        if (!block.getType().equals(Material.ICE) && !block.getType().equals(Material.BLUE_ICE) &&
                                !block.getType().equals(Material.PACKED_ICE)){
                            player.setWalkSpeed(0.2f); //0.2 Is the Default WalkSpeed
                            isSkating.remove(playerUUID);
                        }
                    }
                }
            }
        }
    }
}
