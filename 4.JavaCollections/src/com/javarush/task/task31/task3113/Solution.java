package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* 
Что внутри папки?
*/

public class Solution {

    public static void main(String[] args) throws IOException {

        System.out.println("Введите адрес папки");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Path path = Paths.get(str);
        path.toFile();
        if (!Files.isDirectory(path)) {
            System.out.println(str + " - не папка");
            br.close();
        } else {
            AtomicInteger dirCount = new AtomicInteger(0);
            AtomicInteger filesCount = new AtomicInteger(0);
            AtomicLong allFilesSize = new AtomicLong(0);

            br.close();

            Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    if(!dir.equals(path)) dirCount.incrementAndGet();
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    filesCount.incrementAndGet();
                    allFilesSize.addAndGet(attrs.size());
                    return FileVisitResult.CONTINUE;
                }

            });

            System.out.println("Всего папок - " + dirCount.get());
            System.out.println("Всего файлов - " + filesCount.get());
            System.out.println("Общий размер - " + allFilesSize.get());
        }
    }
}
