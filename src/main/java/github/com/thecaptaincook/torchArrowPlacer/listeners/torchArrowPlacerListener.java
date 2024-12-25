package github.com.thecaptaincook.torchArrowPlacer.listeners;

import github.com.thecaptaincook.torchArrowPlacer.recipe.torchArrowRecipe;
import org.bukkit.Material;
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
        if (event.getEntity() instanceof Arrow arrow) {
            if (arrow.getShooter() instanceof Player player) {
                if (player.getInventory().contains(recipe.craftArrowTorch())) {
                    Block block = arrow.getLocation().getBlock();
                    if (block.getType() == Material.AIR) {
                        block.setType(Material.TORCH);
                        player.getInventory().removeItem(recipe.craftArrowTorch());
                    }
                }
            }

        }
    }
}