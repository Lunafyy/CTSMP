package me.lunafy.ctsmpcore.events;

import me.lunafy.ctsmpcore.items.Heart;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import org.bukkit.block.data.type.Chest.Type;

public class PlayerDeathEvent implements Listener {
    @EventHandler
    public void OnDeath(org.bukkit.event.entity.PlayerDeathEvent event) {
        Player player = event.getPlayer();
        Location deathLocation = player.getLocation();
        deathLocation.getBlock().setType(Material.CHEST);
        //deathLocation.add(new Vector(1, 0, 0)).getBlock().setType(Material.CHEST);

        final double ChestXCoord = deathLocation.getX();

        final Location ChestXLeft = deathLocation.clone();
        final Location ChestXRight = deathLocation.clone().subtract(new Vector(1, 0, 0));

        Block LeftChestBlock = ChestXLeft.getBlock();
        Block RightChestBlock = ChestXRight.getBlock();



        if(event.getDrops().size() < 27) {
            LeftChestBlock.setType(Material.CHEST);
        } else {
            RightChestBlock.setType(Material.CHEST);

            Chest LeftChest = (Chest) LeftChestBlock.getState();
            Chest RightChest = (Chest) RightChestBlock.getState();

            org.bukkit.block.data.type.Chest LeftChestData = (org.bukkit.block.data.type.Chest) LeftChest.getBlockData();
            org.bukkit.block.data.type.Chest RightChestData = (org.bukkit.block.data.type.Chest) RightChest.getBlockData();

            LeftChestData.setType(Type.RIGHT);
            LeftChestBlock.setBlockData(LeftChestData, true);
            RightChestData.setType(Type.LEFT);
            RightChestBlock.setBlockData(RightChestData, true);
        }

        Chest DeathChest = (Chest) deathLocation.getBlock().getState();
        DeathChest.setCustomName(ChatColor.RED + player.getName() + "'s Death Chest");
        DeathChest.update();

        Chest DChest = (Chest) deathLocation.getBlock().getState();

        for(ItemStack drop : event.getDrops()) {
            DChest.getInventory().addItem(drop);
            DChest = (Chest) deathLocation.getBlock().getState();
        }

        if(player.getKiller() != null) DChest.getInventory().addItem(Heart.getItem(1, Material.NETHER_STAR, player.getKiller().getDisplayName()));

        event.getDrops().clear();

        DeathChest.getWorld().strikeLightningEffect(DeathChest.getLocation());

        if(player.getMaxHealth() <= 2) {
            player.banPlayer("You ran out of hearts!");
            for(Player p : Bukkit.getOnlinePlayers()) {
                p.sendMessage(ChatColor.RED + player.getName() + " ran out of hearts!");
            }
        } else {
            player.setMaxHealth(player.getMaxHealth()-2);
        }
        
        player.sendMessage(ChatColor.RED + "You died! Your loot is at " + LeftChestBlock.getLocation().getX() + ", " + LeftChestBlock.getLocation().getY() + ", " + LeftChestBlock.getLocation().getZ());
    }
}
