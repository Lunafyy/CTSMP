package me.lunafy.hypixelcrafting.guis;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class CraftingGUI {
    public static void show(Player player) {
        Inventory craftingGUI = Bukkit.createInventory(null, 54, "Crafting Table");

        for(int i=0;i<10;i++) {
            craftingGUI.setItem(i, createGuiItem(Material.BLACK_STAINED_GLASS_PANE, " "));
        }

        for(int i=14;i<19;i++) {
            craftingGUI.setItem(i, createGuiItem(Material.BLACK_STAINED_GLASS_PANE, " "));
        }

        craftingGUI.setItem(23, createGuiItem(Material.BLACK_STAINED_GLASS_PANE, " "));
        craftingGUI.setItem(24, createGuiItem(Material.BLACK_STAINED_GLASS_PANE, " "));

        // Item Slot
        craftingGUI.setItem(25, createGuiItem(Material.BARRIER, ChatColor.RED + "Craft an Item"));

        player.openInventory(craftingGUI);
    }

    private static ItemStack createGuiItem(final Material material, final String name, final String... lore) {
        final ItemStack item = new ItemStack(material, 1);
        final ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(name);

        meta.setLore(Arrays.asList(lore));

        item.setItemMeta(meta);

        return item;
    }
}
