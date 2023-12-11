package com.autosaveworld;

import java.io.File;
import java.io.FileNotFoundException;
// import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.zip.*;

public class Test {
    public void test() throws IOException {
        // Path src = Paths.get("E:/Java/Test/world");

        LocalDateTime localTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String date = formatter.format(localTime);

        createZip(date);
    }

    public static void createZip(String date) throws FileNotFoundException
    {
        File file = new File("E:/Java/AutoSaveWorld/src/main/dataWorld/" + date + ".zip");
        if (file.exists()) {
            System.out.println("File already exists");
        } else
        {
            ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(file));
        }
    }

    public void copyFile()
    {
        
    }
}
