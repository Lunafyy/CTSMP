package me.lunafy.ctsmpcore.commands;

import me.lunafy.ctsmpcore.CTSMPCore;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.UUID;

public class Friend implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            CTSMPCore core = CTSMPCore.getPlugin(CTSMPCore.class);
            FileConfiguration config = core.getConfig();
            List<String> friends = config.getStringList(player.getUniqueId().toString());
            String path = player.getUniqueId().toString();
            String targUUID = "";
            switch(args[0]) {
                case "add":
                    targUUID = Bukkit.getOfflinePlayer(args[1]).getUniqueId().toString();
                    if (targUUID.equals(player.getUniqueId().toString())) {
                        player.sendMessage(ChatColor.RED + "No friends? ;(");
                        return true;
                    }
                    if (friends.contains(targUUID)) {
                        player.sendMessage("User already friended!");
                        return true;
                    }
                    else {
                        if (config.getStringList(targUUID).contains(path)) {
                            // remove the friend from the pending list
                            player.sendMessage(ChatColor.GREEN + "Friend request from " + ChatColor.LIGHT_PURPLE + args[1] + ChatColor.GREEN + " accepted!");
                            List<String> pending = config.getStringList(path + ".pending");
                            pending.remove(targUUID);
                            config.set(path + ".pending", pending);
                        } else {
                            // adds player's UUID to the other user's pending list
                            player.sendMessage(ChatColor.GREEN + "Sent friend request to" + ChatColor.LIGHT_PURPLE + args[1]);
                            String bufferPath = targUUID + ".pending";
                            List<String> buffer = config.getStringList(bufferPath);
                            buffer.add(path);
                            config.createSection(bufferPath);
                            config.set(bufferPath, buffer);
                        }
                        if (Bukkit.getOfflinePlayer(UUID.fromString(targUUID)).isOnline()) {
                            Bukkit.getPlayer(UUID.fromString(targUUID)).sendMessage(ChatColor.LIGHT_PURPLE + player.getName() + ChatColor.GREEN + " just sent you a friend request, accept it with /friend add <username>");
                        }
                        friends.add(targUUID);
                    }
                    // Update's the user's friend values
                    config.createSection(path);
                    config.set(path, friends);
                    core.saveConfig();
                break;
                case "remove":
                    targUUID = Bukkit.getOfflinePlayer(args[1]).getUniqueId().toString();
                    if (targUUID.equals(player.getUniqueId().toString())) {
                        player.sendMessage(ChatColor.RED + "Hate yourself? cry about it emo ;(");
                        player.playEffect(player.getLocation(), Effect.GHAST_SHRIEK, 1);
                        return true;
                    }
                    if (friends.contains(targUUID)) {
                        friends.remove(targUUID);
                        player.sendMessage(ChatColor.LIGHT_PURPLE + Bukkit.getOfflinePlayer(args[1]).getName() + ChatColor.GREEN + " has been unfriended");
                    } else {
                        player.sendMessage(ChatColor.RED + "You are not friends with this user");
                    }
                    List<String> quirkyPending = config.getStringList(targUUID + ".pending");
                    if (quirkyPending.contains(player.getUniqueId().toString())) {
                        quirkyPending.remove(player.getUniqueId().toString());
                        config.set(targUUID + ".pending", quirkyPending);
                    }

                    config.createSection(path);
                    config.set(path, friends);
                    core.saveConfig();
                break;
                case "list":
                    player.sendMessage(ChatColor.UNDERLINE + "friends:");
                    for (String str : friends) {
                        OfflinePlayer temp = Bukkit.getOfflinePlayer(UUID.fromString(str));
                        List<String> tempf = config.getStringList(temp.getUniqueId().toString());
                        System.out.println(tempf);
                        if (tempf.contains(player.getUniqueId().toString())) {
                            player.sendMessage(temp.getName());
                        }
                    }
                break;
                case "pending":
                    List<String> pending = config.getStringList(path + ".pending");
                    player.sendMessage(ChatColor.UNDERLINE + "pending:");
                    for (String str : pending) {
                        player.sendMessage(str);
                    }
                break;
            }
        }
        return true;
    }
}
