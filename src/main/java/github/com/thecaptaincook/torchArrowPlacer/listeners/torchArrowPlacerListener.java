package github.com.thecaptaincook.torchArrowPlacer.listeners;

import github.com.thecaptaincook.torchArrowPlacer.recipe.torchArrowRecipe;
import org.bukkit.block.Block;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class torchArrowPlacerListener implements Listener {

    private final torchArrowRecipe recipe = new torchArrowRecipe();

    @EventHandler
    public void onProjectileHit(ProjectileHitEvent event) {

        Player player = (Player) event.getEntity().getShooter();
        Arrow arrow = (Arrow) event.getEntity();
        Block block = event.getHitBlock();

/*
        Debugging
        player.sendMessage("Player name is: " + player.getName());              // Player name is: caspainplaysgame
        player.sendMessage("Projectile Hit Event!");                            // Projectile Hit Event!

        player.sendMessage("Block Type: " + block.getType());                   // Block Type: Dark oak leaves
        player.sendMessage("Block Location: " + block.getLocation());           // Block Location: Location{world=CraftWorld{name=world},x=0.0,y=0.0,z=0.0,pitch=0.0,yaw=0.0}
        player.sendMessage("Block Location X: " + block.getLocation().getX());  // Block Location X: 360
        player.sendMessage("Block Location Y: " + block.getLocation().getY());  // Block Location Y: 84
        player.sendMessage("Block Location Z: " + block.getLocation().getZ());  // Block Location Z: 172
        assert player != null;
        player.sendMessage("block face" + event.getHitBlockFace());              // block faceUP, south, east, west, north, down
*/

        if (block == null) {
            player.sendMessage("You missed the block!");
        }
        else {
            player.sendMessage("Entity: " + arrow);
        }
    }
}