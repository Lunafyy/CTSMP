package me.lunafy.ctsmpcore.events;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class PlayerInteractEvent implements Listener {
    @EventHandler
    public void onUse(org.bukkit.event.player.PlayerInteractEvent event) {
        ItemStack item = event.getPlayer().getItemInHand();

        System.out.println(item.getType());
        if(item.getType() == Material.NETHER_STAR) {
            ItemMeta meta = item.getItemMeta();
            String displayName = meta.getDisplayName();
            if(displayName.contains("Heart") && meta.hasLore()) {
                Player p = event.getPlayer();
                List<String> lore = meta.getLore();
                int hearts = Integer.parseInt(lore.get(1).split(":")[1].replace(" §c",""));
                int amountOfHearts = item.getAmount();
                int newAmount = amountOfHearts - 1;

                if(newAmount == 0) {
                    p.getInventory().remove(item);
                } else {
                    item.setAmount(newAmount);
                }

                p.setMaxHealth(p.getMaxHealth() + (hearts * 2));
                p.setHealth(p.getMaxHealth());
                p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 100, 0);
            }
        }
    }
}
