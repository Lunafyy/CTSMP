package me.lunafy.ctsmpcore.recipes;

import me.lunafy.ctsmpcore.CTSMPCore;
import me.lunafy.ctsmpcore.items.ZombieCore;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

public class ZombieCoreRecipe {
    public static ShapedRecipe getRecipe() {
        NamespacedKey coreKey = new NamespacedKey(CTSMPCore.getPlugin(CTSMPCore.class), "ZOMBIE_CORE");

        ShapedRecipe zombieCore = new ShapedRecipe(coreKey, ZombieCore.getItem());

        zombieCore.shape("GGG", "GFG", "GGG");

        zombieCore.setIngredient('G', Material.GOLD_BLOCK);
        zombieCore.setIngredient('F', Material.ROTTEN_FLESH);

        return zombieCore;
    }
}
