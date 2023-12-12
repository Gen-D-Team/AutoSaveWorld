package com.autosaveworld;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class AutoSave extends BukkitRunnable implements CommandExecutor {
    Player player;
    World world;
    SaveFolder createFolder;

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        
        if (cmd.getName().equalsIgnoreCase("save") && sender instanceof ConsoleCommandSender) {
            createFolder = new SaveFolder();
            run();

            try {
                createFolder.createZip();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }

    // run to save world
    public void run() {
        Server server = Bukkit.getServer();
        Bukkit.getScheduler().runTask(Bukkit.getPluginManager().getPlugin("autosaveworld"), () -> {
            for (World world : Bukkit.getWorlds()) {
                world.save();
            }

            if (server.getOnlinePlayers().size() > 0) {
                Bukkit.broadcastMessage(ChatColor.GREEN + "World saved successfully");
                }
             else
            {
                System.out.println("No player");
            }
        });
    }
}
