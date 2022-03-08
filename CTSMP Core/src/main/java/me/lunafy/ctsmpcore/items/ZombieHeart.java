package me.lunafy.ctsmpcore.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ZombieHeart {
    public static ItemStack getItem() {
        ItemStack heartItem = new ItemStack(Material.FERMENTED_SPIDER_EYE);
        ItemMeta heartMeta = heartItem.getItemMeta();

        heartItem.addUnsafeEnchantment(Enchantment.WATER_WORKER, 1);

        List<String> lore = new ArrayList<String>();
        lore.add("");
        lore.add(ChatColor.WHITE + "How did you get this?!");
        lore.add(ChatColor.WHITE + "This isn't supposed to");
        lore.add(ChatColor.WHITE + "be accessible to humans!");

        heartMeta.setLore(lore);

        heartMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        heartMeta.setDisplayName(ChatColor.RED + "Zombie Heart");

        heartItem.setItemMeta(heartMeta);

        return heartItem;
    }
}
