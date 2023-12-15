package com.autosaveworld;

import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;

public class AutoSave implements CommandExecutor {
    World world;
    SaveFolder createFolder;
    String fileServer;
    
    public AutoSave(String fileServer) {
        this.fileServer = fileServer;
        this.createFolder = new SaveFolder(fileServer);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("save") && sender instanceof ConsoleCommandSender) {
            
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
            for (World world : Bukkit.getWorlds()) {
                world.save();
            }
            Bukkit.broadcastMessage(ChatColor.GREEN + "World saved successfully");
    }
}
