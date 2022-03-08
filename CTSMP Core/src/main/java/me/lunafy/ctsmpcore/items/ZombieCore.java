package me.lunafy.ctsmpcore.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ZombieCore {
    public static ItemStack getItem() {
        ItemStack coreItem = new ItemStack(Material.ROTTEN_FLESH);
        ItemMeta coreMeta = coreItem.getItemMeta();

        coreItem.addUnsafeEnchantment(Enchantment.WATER_WORKER, 1);

        List<String> lore = new ArrayList<String>();
        lore.add("");
        lore.add(ChatColor.WHITE + "A rare core from the");
        lore.add(ChatColor.WHITE + "depths of a Zombie's within.");
        lore.add(ChatColor.WHITE + "Use this wisely, it may be undeadly.");

        coreMeta.setLore(lore);

        coreMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        coreMeta.setDisplayName(ChatColor.BLUE + "Zombie Core");

        coreItem.setItemMeta(coreMeta);

        return coreItem;
    }
}
