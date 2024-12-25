package github.com.thecaptaincook.torchArrowPlacer;

import github.com.thecaptaincook.torchArrowPlacer.commands.torchArrowGiveCommand;
import github.com.thecaptaincook.torchArrowPlacer.listeners.torchArrowPlacerListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class TorchArrowPlacer extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        getServer().getPluginManager().registerEvents(new torchArrowPlacerListener(), this);
        getCommand("ta").setExecutor(new torchArrowGiveCommand());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
