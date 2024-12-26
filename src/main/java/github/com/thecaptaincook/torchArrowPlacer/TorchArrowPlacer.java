package github.com.thecaptaincook.torchArrowPlacer;

import github.com.thecaptaincook.torchArrowPlacer.commands.torchArrowGiveCommand;
import github.com.thecaptaincook.torchArrowPlacer.listeners.torchArrowPlacerListener;
import github.com.thecaptaincook.torchArrowPlacer.recipe.torchArrowRecipe;
import org.bukkit.plugin.java.JavaPlugin;

public final class TorchArrowPlacer extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        System.out.println("Torch Arrow Placer has been enabled! HELLO!");

        final torchArrowRecipe recipes = new torchArrowRecipe();
        recipes.craftArrowTorch();

        getServer().getPluginManager().registerEvents(new torchArrowPlacerListener(), this);
        getCommand("tap").setExecutor(new torchArrowGiveCommand());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("Torch Arrow Placer has been disabled! GOODBYE!");
    }
}
