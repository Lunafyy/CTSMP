package me.lunafy.ctsmpcore.recipes;

import me.lunafy.ctsmpcore.CTSMPCore;
import me.lunafy.ctsmpcore.items.Heart;
import me.lunafy.ctsmpcore.items.ZombieHeart;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ShapelessRecipe;

public class ZombieHeartOfLifeRecipe {
    public static ShapelessRecipe getRecipe() {
        NamespacedKey ZHOLKey = new NamespacedKey(CTSMPCore.getPlugin(CTSMPCore.class), "ZOMBIE_HEART_OF_LIFE");

        ShapelessRecipe zombieHeartOfLife = new ShapelessRecipe(ZHOLKey, Heart.getItem(1, Material.NETHER_STAR, "Zombie"));

        zombieHeartOfLife.addIngredient(2, ZombieHeart.getItem());

        return zombieHeartOfLife;
    }
}
