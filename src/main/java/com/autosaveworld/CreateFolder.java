package com.autosaveworld;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.EnumSet;

public class CreateFolder {

    // Function để gọi copyDir
    public void copyFolder(Path src, Path dest) throws IOException {
        // Nếu src không phải là 1 folder
        try {
            Files.walkFileTree(src, EnumSet.of(FileVisitOption.FOLLOW_LINKS), Integer.MAX_VALUE,
                    new SimpleFileVisitor<Path>() {

                        @Override
                        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
                                throws IOException {
                            Path targetDest = dest.resolve(src.relativize(dir));

                            try {
                                Files.copy(dir, targetDest);
                            } catch (FileAlreadyExistsException e) {
                                if (!Files.isDirectory(targetDest)) {
                                    throw e;
                                }
                            }

                            return FileVisitResult.CONTINUE;
                        }

                        @Override
                        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
                                throws IOException {
                            Files.copy(file, dest.resolve(src.relativize(file)));
                            return FileVisitResult.CONTINUE;
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Path getDestFolder(String srcName) {
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH-mm-ss");
        Path folder = Paths.get("E:\\Java\\AutoSaveWorld\\src\\main\\dataWorld\\" + formatter.format(time) + "\\" + srcName);

        try {
            Files.createDirectories(folder);
        } catch (IOException e) {
            e.printStackTrace();
        }     
        return folder;
    }

    public Path getSourceFolder(String srcName)
    {
        Path folder = Paths.get("E:\\Java\\Test\\" + srcName);
        return folder;
    }
}