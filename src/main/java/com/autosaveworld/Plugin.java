package com.autosaveworld;

import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

/*
 * demo java plugin
 */
public class Plugin extends JavaPlugin
{
  
  public static Logger LOGGER=Logger.getLogger("autosaveworld");
  private AutoSave autoSave;

  @Override
  public void onEnable()
  {
    autoSave = new AutoSave();

    LOGGER.info("AutoSaveWorld enabled");
    getCommand("save").setExecutor(autoSave);
  }

  public void onDisable()
  {
    LOGGER.info("AutoSaveWorld disabled");
  }
}