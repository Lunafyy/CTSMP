package me.lunafy.hypixelcrafting.events;

import me.lunafy.hypixelcrafting.guis.CraftingGUI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;

public class InventoryOpen implements Listener {

    @EventHandler
    public void invOpen(InventoryOpenEvent event) {
        System.out.println(event.getInventory().getType());
        if(event.getInventory().getType() == InventoryType.WORKBENCH) {
            event.setCancelled(true);
            CraftingGUI.show((Player)event.getPlayer());
        }
    }
}
