package com.javarush.task.task31.task3101;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/* 
Проход по дереву файлов
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        File path = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);
        File allFilesContent = new File(resultFileAbsolutePath.getParentFile() + "/allFilesContent.txt");
        if (FileUtils.isExist(allFilesContent)) {
            FileUtils.deleteFile(allFilesContent);
        }
        FileUtils.renameFile(resultFileAbsolutePath, allFilesContent);
        FileOutputStream bos = new FileOutputStream(allFilesContent);
        bos.close();
        List<File> list = new ArrayList<>();

        try (FileOutputStream fos = new FileOutputStream (allFilesContent) ) {
             Files.walkFileTree(path.toPath(), new SimpleFileVisitor<Path>() {

                @Override
                public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
                    File file = path.toFile();
                    if (file.isFile()) {
                        if (file.length() <=50) {
                            list.add(file);
                        }
                    }
                    return super.visitFile(path, attrs);
                }

            });
            for (File paths : list) {
                fos.write(Files.readAllBytes(paths.toPath()));
                fos.write("\n".getBytes());
            }
        }
    }
}
