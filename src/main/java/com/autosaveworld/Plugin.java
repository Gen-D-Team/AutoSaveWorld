package com.autosaveworld;

import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

/*
 * demo java plugin
 */
public class Plugin extends JavaPlugin
{
  
  public static Logger LOGGER=Logger.getLogger("autosaveworld");
  CreateFolder createFolder = new CreateFolder();
  

  @Override
  public void onEnable()
  {
    
    createFolder.createFolder();
    LOGGER.info("AutoSaveWorld enabled");
  }

  public void onDisable()
  {
    LOGGER.info("AutoSaveWorld disabled");
  }
}