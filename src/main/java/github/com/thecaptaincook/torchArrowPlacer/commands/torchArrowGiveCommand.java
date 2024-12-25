package github.com.thecaptaincook.torchArrowPlacer.commands;

import github.com.thecaptaincook.torchArrowPlacer.recipe.torchArrowRecipe;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class torchArrowGiveCommand implements CommandExecutor {

    private final torchArrowRecipe recipe = new torchArrowRecipe();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        Player player = (Player) sender;
        Inventory playerInventory = player.getInventory();
        GameMode playerGameMode = player.getGameMode();

        if (sender instanceof Player) {

            if (playerGameMode ==GameMode.CREATIVE)
            {
                if (args.length == 0) {
                    player.sendMessage("You must specify a command!");
                    return false;
                }
                else if (args[0].equalsIgnoreCase("atc")) {
                    player.sendMessage("You have been given a Torch Arrow!");
                    playerInventory.addItem(recipe.craftArrowTorch());
                    return true;
                }
                else {
                    player.sendMessage("Invalid command!");
                    return false;
                }
            }

        }
        else {
            sender.sendMessage("You must be a player to use this command!");
            return false;
        }
        return true;
    }
}
