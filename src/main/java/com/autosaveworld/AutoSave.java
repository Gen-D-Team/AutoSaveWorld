package com.autosaveworld;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.scheduler.BukkitRunnable;

public class AutoSave extends BukkitRunnable{

    public void run()
    {
       Bukkit.getScheduler().runTask(Bukkit.getPluginManager().getPlugin("demo"), () ->
        {
            for (World world : Bukkit.getWorlds())
            {
                world.save();
            }
        });
    }
}

