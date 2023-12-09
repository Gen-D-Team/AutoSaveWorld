package com.autosaveworld;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.File;


public class CreateFolder {
    LocalDateTime time = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd_MM_yyyy HH-mm-ss");
    File folder;

    public void createFolder() {
        folder = new File("E:\\Java\\AutoSaveWorld\\src\\main\\dataWorld" + formatter.format(time));
        if (!folder.exists()) {
            folder.mkdirs();
            
            System.out.println("Created folder");
        } else
        {
            System.out.println("Folder already exists");
        }
    }
}
