package me.lunafy.ctsmpcore;

import me.lunafy.ctsmpcore.commands.NewHeart;
import me.lunafy.ctsmpcore.commands.SetHearts;
import me.lunafy.ctsmpcore.events.PlayerDeathEvent;
import me.lunafy.ctsmpcore.events.PlayerInteractEvent;
import me.lunafy.ctsmpcore.recipes.ZombieCoreRecipe;
import me.lunafy.ctsmpcore.recipes.ZombieHeartOfLifeRecipe;
import me.lunafy.ctsmpcore.recipes.ZombieHeartRecipe;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class CTSMPCore extends JavaPlugin {

    @Override
    public void onEnable() {
        // Register Events
        getServer().getPluginManager().registerEvents(new PlayerDeathEvent(), this);
        getServer().getPluginManager().registerEvents(new PlayerInteractEvent(), this);

        // Register Commands
        this.getCommand("newheart").setExecutor(new NewHeart());
        this.getCommand("sethearts").setExecutor(new SetHearts());

        // Register Crafting Recipes
        getServer().addRecipe(ZombieCoreRecipe.getRecipe());
        getServer().addRecipe(ZombieHeartRecipe.getRecipe());
        getServer().addRecipe(ZombieHeartOfLifeRecipe.getRecipe());

        getLogger().info(ChatColor.GREEN + "CTSMPCore: Online");
    }

    @Override
    public void onDisable() {
        getLogger().info(ChatColor.RED + "CTSMPCore: Offline");
    }
}
