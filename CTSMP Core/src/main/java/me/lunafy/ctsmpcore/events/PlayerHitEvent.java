package me.lunafy.ctsmpcore.events;

import me.lunafy.ctsmpcore.CTSMPCore;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.List;

public class PlayerHitEvent implements Listener {
    @EventHandler
    public void onPlayerAttack(EntityDamageByEntityEvent event){
        if(event.getEntity() instanceof Player && event.getDamager() instanceof Player){
            CTSMPCore core = CTSMPCore.getPlugin(CTSMPCore.class);
            FileConfiguration config = core.getConfig();
            Player player = (Player) event.getEntity();
            List<String> friends = config.getStringList(player.getUniqueId().toString());
            if(friends.contains(event.getDamager().getUniqueId().toString())){
                event.setCancelled(true);
            }
        }
    }
}
