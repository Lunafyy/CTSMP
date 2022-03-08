package me.lunafy.ctsmpcore.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Heart {
    public static ItemStack getItem(int strength, Material item, String originatingMob) {
        ItemStack heartItem = new ItemStack(item);
        ItemMeta heartMeta = heartItem.getItemMeta();

        heartMeta.setDisplayName(ChatColor.RED + originatingMob + "'s Heart of Life");

        List<String> lore = new ArrayList<String>();

        lore.add("");
        lore.add(ChatColor.WHITE + "Hearts: " + ChatColor.RED + "+" + strength);
        lore.add("");
        lore.add(ChatColor.WHITE + "A rare heart pulled straight from ");
        lore.add(ChatColor.WHITE + "the depths of a " + originatingMob + "'s chest.");
        lore.add(ChatColor.WHITE + "Use this mythical item at");
        lore.add(ChatColor.WHITE + "your heart's contempt.");
        lore.add("");
        lore.add(ChatColor.YELLOW + "Right-click to use!");

        heartMeta.setLore(lore);

        heartItem.setItemMeta(heartMeta);

        return heartItem;
    }
}
