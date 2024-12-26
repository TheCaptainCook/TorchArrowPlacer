package github.com.thecaptaincook.torchArrowPlacer.commands;

import github.com.thecaptaincook.torchArrowPlacer.recipe.torchArrowRecipe;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import static java.lang.Integer.parseInt;

public class torchArrowGiveCommand implements CommandExecutor {

    private final torchArrowRecipe recipeCommand = new torchArrowRecipe();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        int itemsNeeded = 0;

        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            Inventory playerInventory = player.getInventory();
            GameMode playerGameMode = player.getGameMode();

            /*
                command written - /tap 123
                player.sendMessage("command Sender = " + commandSender); --> craftplayer(name=caspainplaysgame)
                player.sendMessage("command = " + command); --> tap
                player.sendMessage("string(s) = " + s); --> tap
                player.sendMessage("string 0 = " + strings[0]); --> 123
                player.sendMessage("Strings.length = " + strings.length); --> 1
                 */

            if (playerGameMode == GameMode.CREATIVE) {

                if (s.equalsIgnoreCase("tap")) {
                    try {
                        itemsNeeded = parseInt(strings[0]);
                        if (itemsNeeded > 0 && itemsNeeded <= 64) {
                            player.sendMessage("You have requested " + itemsNeeded + " torch arrows!");
                            playerInventory.addItem(recipeCommand.craftArrowTorch());
                            return true;
                        } else if (itemsNeeded <= 0) {
                            player.sendMessage("You can't request less than 1 torch arrow!");
                            return true;
                        } else{
                            player.sendMessage("You can't request more than 64 torch arrows at a time!");
                            return true;
                        }
                    } catch (NumberFormatException e) {
                        player.sendMessage("You must enter a number!");
                        return true;
                    }
                }
                } else {
                    player.sendMessage("You must be in creative mode to use this command!");
                }
            } else {
                commandSender.sendMessage("You must be a player to use this command!");
                return true;
            }
        return true;
    }
}