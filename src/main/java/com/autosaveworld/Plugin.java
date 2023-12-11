package com.autosaveworld;

import java.io.File;
import java.io.IOException;
// import java.nio.file.*;
import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

/*
 * demo java plugin
 */
public class Plugin extends JavaPlugin
{ 
  public static Logger LOGGER=Logger.getLogger("autosaveworld");
  File src = new File("E:\\server");

  public void onEnable()
  {
    // Path src = Paths.get("E:\\server\\world");
    // Path dest = Paths.get("E:\\Java\\AutoSaveWorld\\src\\main\\dataWorld");

    CreateFolder moveFolder = new CreateFolder();
    LOGGER.info("AutoSaveWorld enabled");

    try {
      for (String file : src.list())
      {
        if (file.equals("world") || file.equals("world_nether") || file.equals("world_the_end"))
        {
          moveFolder.copyFolder(moveFolder.getSourceFolder(file), moveFolder.getDestFolder(file));   
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void onDisable()
  {
    LOGGER.info("AutoSaveWorld disabled");
  }
}