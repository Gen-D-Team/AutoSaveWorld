package com.autosaveworld;


import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

/*
 * demo java plugin
 */
public class Plugin extends JavaPlugin
{ 
  public static Logger LOGGER=Logger.getLogger("autosaveworld");
  String fileServer = getDataFolder().getAbsolutePath().substring(0, this.getDataFolder().getAbsolutePath().indexOf("plugins"));
  AutoSave save = new AutoSave(fileServer);  

  public void onEnable()
  {
    LOGGER.info("AutoSaveWorld enabled");
    getCommand("save").setExecutor(save);
  }

  public void onDisable()
  {
    LOGGER.info("AutoSaveWorld disabled");
  }
}