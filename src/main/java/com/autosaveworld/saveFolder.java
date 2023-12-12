package com.autosaveworld;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class SaveFolder {
    public void createZip() throws IOException {
        LocalDateTime dateNow = LocalDateTime.now();
        DateTimeFormatter date = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter time = DateTimeFormatter.ofPattern("HH-mm-ss");

        String zipName = date.format(dateNow);
        String baseFile = time.format(dateNow);

        File folderToZip = new File("E:\\server");
        File zip = new File("E:\\Java\\AutoSaveWorld\\src\\main\\dataWorld\\" + zipName + ".zip");
        try {
            FileOutputStream fos = new FileOutputStream(zip);
            ZipOutputStream zos = new ZipOutputStream(fos);

            ZipEntry ze = new ZipEntry(baseFile + "/");
            zos.putNextEntry(ze);

            zos.closeEntry();

            for (File folder : folderToZip.listFiles()) {
                if (folder.getName().equals("world") ||
                        folder.getName().equals("world_nether") ||
                        folder.getName().equals("world_the_end")) {
                    zipDir(folder, baseFile + "/" + folder.getName(), zos);
                }
            }

            zos.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void zipDir(File folder, String fileName, ZipOutputStream zos) {
        try {
            ZipEntry ze = new ZipEntry(fileName + "/");
            zos.putNextEntry(ze);

            for (File file : folder.listFiles()) {
                if (file.isDirectory()) {
                    zipDir(file, fileName + "/" + file.getName(), zos);
                } else {
                    // chỉ lấy từ folder bắt đầu bên trong file world và lấy thêm time ở đầu file zip
                    String getDest = fileName.split("/")[0] + "\\" + file.getAbsolutePath().substring(file.getAbsolutePath().indexOf("world"));
                    
                    addFile(file, getDest, zos);
                }
            }

            zos.closeEntry();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addFile(File file, String parentFolder, ZipOutputStream zos) {
        try {
            if (file.getName().equalsIgnoreCase("session.lock")) {
                return;
            }

            FileInputStream fis = new FileInputStream(file);

            ZipEntry ze = new ZipEntry(parentFolder);
            zos.putNextEntry(ze);

            byte[] buffer = new byte[1024];
            int length;

            while ((length = fis.read(buffer)) > 0) {
                zos.write(buffer, 0, length);
            }

            fis.close();
            zos.closeEntry();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}