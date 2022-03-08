package me.lunafy.hypixelcrafting;

import me.lunafy.hypixelcrafting.events.InventoryOpen;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;


public final class HypixelCrafting extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new InventoryOpen(), this);
        getLogger().info(ChatColor.GREEN + "CTSMPCrafting: Online");
    }

    @Override
    public void onDisable() {
        getLogger().info(ChatColor.RED + "CTSMPCrafting: Offline");
    }
}
