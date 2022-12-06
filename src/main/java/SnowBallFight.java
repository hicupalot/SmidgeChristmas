import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.inventory.ItemStack;

public class SnowBallFight implements Listener {
    //Replaces Depleted Snowballs
    @EventHandler
    public void onSnowBallThrow(ProjectileLaunchEvent e) {
        if (e.getEntityType().equals(EntityType.PLAYER)) {
            if (Config.snowBallFight.containsValue(true)) {
                if (e.getEntity() instanceof Snowball snow) { //e.getEntity refers to the projectile
                    if (snow.getShooter() instanceof Player player) {
                        ItemStack snowball = new ItemStack(Material.SNOWBALL,1);
                        player.getInventory().addItem(snowball);
                        ///END OF CODE TO REPLACE SNOWBALLS
                    }
                }
            }
        }
    }

    @EventHandler
    public void onSnowBallHit(ProjectileHitEvent e) {
        String missMessage = ChatColor.translateAlternateColorCodes('&',"&cYou Missed!");
        if (Config.snowBallFight.containsValue(true)) {
            if (e.getEntity() instanceof Snowball snow) {
                if (snow.getShooter() instanceof Player) {
                    Player player = (Player) snow.getShooter();
                    Entity hitEntity = e.getHitEntity();
                    Block hitBlock = e.getHitBlock();
                    if (hitEntity==null){
                        player.sendMessage(missMessage);
                    }
                    else if (!hitEntity.getType().equals(EntityType.PLAYER)){
                        player.sendMessage(missMessage);
                    }
                    else if (hitEntity.getUniqueId().equals(player.getUniqueId())){
                        String howonEarth = ChatColor.translateAlternateColorCodes('&',"&cYou hit yourself, how on earth did you even do that??");
                        player.sendMessage(howonEarth);
                    }
                    else {
                      if (hitEntity instanceof Player){
                         ((Player) hitEntity).damage(2);
                       }
                    }
                }
            }
        }
    }
}