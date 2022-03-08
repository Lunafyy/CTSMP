package me.lunafy.ctsmpcore.recipes;

import me.lunafy.ctsmpcore.CTSMPCore;
import me.lunafy.ctsmpcore.items.ZombieCore;
import me.lunafy.ctsmpcore.items.ZombieHeart;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ShapedRecipe;

public class ZombieHeartRecipe {
    public static ShapedRecipe getRecipe() {
        NamespacedKey heartKey = new NamespacedKey(CTSMPCore.getPlugin(CTSMPCore.class), "ZOMBIE_HEART");

        ShapedRecipe zombieHeart = new ShapedRecipe(heartKey, ZombieHeart.getItem());

        zombieHeart.shape("CCC", "CCC", "CCC");

        zombieHeart.setIngredient('C', ZombieCore.getItem());

        return zombieHeart;
    }
}
