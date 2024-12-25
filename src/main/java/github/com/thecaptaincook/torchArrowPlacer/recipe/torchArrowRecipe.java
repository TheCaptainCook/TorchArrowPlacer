package github.com.thecaptaincook.torchArrowPlacer.recipe;


import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

import static org.bukkit.Bukkit.getServer;

public class torchArrowRecipe {

    public ItemStack craftArrowTorch() {

        //Creating NamespacedKey for the Torch Arrow
        NamespacedKey arrowTorchKey = new NamespacedKey("torchArrow", "arrow_torch");

        //Creating ItemStack for the Torch Arrow
        ItemStack arrowTorch = new ItemStack(Material.ARROW);
        ItemMeta arrowTorchMeta = arrowTorch.getItemMeta();

        //Setting Display Name for the Torch Arrow
        arrowTorchMeta.setDisplayName(ChatColor.GOLD + "🔦 Torch Arrow 🔦 ");

        //Adding Enchants for the Torch Arrow
        arrowTorchMeta.addEnchant(Enchantment.EFFICIENCY, 1, true);

        //Hiding Enchants for the Torch Arrow
        arrowTorchMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        //Adding Lore for the Torch Arrow
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.GRAY + "This arrow will place a torch");
        lore.add(ChatColor.GRAY + "where it lands.");

        //Set Lore to the Torch Arrow
        arrowTorchMeta.setLore(lore);
        arrowTorch.setItemMeta(arrowTorchMeta);

        //Shapeless recipe for crafting Torch Arrow
        ShapelessRecipe arrowTorchRecipe = new ShapelessRecipe(arrowTorchKey, arrowTorch);
        arrowTorchRecipe.addIngredient(Material.ARROW, 1);
        arrowTorchRecipe.addIngredient(Material.TORCH, 1);
        getServer().addRecipe(arrowTorchRecipe);

        return arrowTorch;

    }


}
