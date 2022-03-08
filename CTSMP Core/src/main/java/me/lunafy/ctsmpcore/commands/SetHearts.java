package me.lunafy.ctsmpcore.commands;

import me.lunafy.ctsmpcore.items.Heart;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class SetHearts implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(player.isOp()){
                Player victim = Bukkit.getPlayer(args[0]);
                if(victim != null) {
                    double maxHealth = Double.parseDouble(args[1]);
                    victim.setMaxHealth(maxHealth);
                    victim.setHealth(maxHealth);
                    player.sendMessage(ChatColor.GREEN + "Success! Set " + args[0] + "'s hearts to " + args[1] + "!");
                    victim.sendMessage(ChatColor.GREEN + "Wait! " + player.getDisplayName() + " has set your hearts to " + (int) maxHealth / 2 + "!");
                } else {
                    player.sendMessage(ChatColor.RED + "Failed! Couldn't find a user by the name of " + args[0]);
                }
            } else {
                player.sendMessage(ChatColor.RED + "Stop! Who told you about this?");
            }
        } else {
            System.out.println(ChatColor.RED + "Only players can use this command!");
        }
        return true;
    }
}
