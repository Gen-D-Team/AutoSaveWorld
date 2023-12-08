package com.autosaveworld;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

/*
 * demo java plugin
 */
public class Plugin extends JavaPlugin
{
  
  public static Logger LOGGER=Logger.getLogger("demo");

  BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
  private int timeToSave = 20 * 10;
  AutoSave autoSave = new AutoSave();

  @Override
  public void onEnable()
  {
    LOGGER.info("demo enabled"); 
    scheduler.runTaskTimerAsynchronously(this, () -> {
      autoSave.run();
      // getServer().dispatchCommand(getServer().getConsoleSender(), null);
      getLogger().info("World saved automatically.");
    }, 0, timeToSave);
      autoSave.run();
  }

  public void onDisable()
  {
    LOGGER.info("demo disabled");
  }
}