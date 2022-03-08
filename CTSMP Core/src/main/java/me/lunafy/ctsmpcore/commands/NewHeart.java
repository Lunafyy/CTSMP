package me.lunafy.ctsmpcore.commands;

import me.lunafy.ctsmpcore.items.Heart;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class NewHeart implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(player.isOp()){
                ItemStack heart = Heart.getItem(Integer.parseInt(args[0]), Material.NETHER_STAR, "Player");
                player.getInventory().addItem(heart);
                player.sendMessage(ChatColor.GREEN + "Success! Summoned a new heart with the health of " + args[0] + "!");
            } else {
                player.sendMessage(ChatColor.RED + "Stop! Who told you about this?");
            }

        } else {
            System.out.println(ChatColor.RED + "Only players can use this command!");
        }
        return true;
    }
}
