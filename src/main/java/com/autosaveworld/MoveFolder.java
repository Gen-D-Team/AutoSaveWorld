package com.autosaveworld;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MoveFolder {

    // Function để gọi copyDir
    public void copyFolder(File src, File dest) throws IOException 
    {
        //Nếu src không phải là 1 folder
        if (src.isDirectory()) {
            //Nếu dest chưa tồn tại
            if (!dest.exists()) {
                dest.mkdir();
            }
            //Thực hiện việc sao chép
            String files[] = src.list();

            for (String file : files)
            {
                /*
                * Lấy file gắn vào src và dest
                */
                File srcFile = new File(src, file);
                File destFile = new File(dest, file);

                copyFolder(srcFile, destFile);
            }
        } else
        {
            //Nếu src là 1 file
            //Chỉ cần copy các file còn lại
            //Không cần phải vô từng folder nữa
            copyFile(src, dest);
        }
    }

    public static void copyFile(File src, File dest) throws IOException {
        OutputStream out = new FileOutputStream(dest);
        InputStream in = new FileInputStream(src);
        byte[] buffer = new byte[1024];
        int len;

        // khi trong folder dest có file
        while ((len = in.read(buffer)) > 0) {
            // ghi vào out
            out.write(buffer, 0, len);
        }

        in.close();
        out.close();
    }
}