package com.javarush.task.task31.task3112;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/* 
Загрузчик файлов
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("D:/MyDownloads"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        String fileName = urlString.split("/")[urlString.split("/").length - 1];
        Path downloadPath = downloadDirectory.resolve(fileName);
        if (Files.notExists(downloadDirectory)) {
            Files.createDirectories(downloadDirectory);
        }
        Files.deleteIfExists(downloadPath);
        InputStream inputStream = new URL(urlString).openStream();
        Path tempFile = Files.createTempFile("temp-",".tmp");
        Files.copy(inputStream, tempFile, StandardCopyOption.REPLACE_EXISTING);
        Files.move(tempFile, downloadPath);
        inputStream.close();
        return downloadPath;
        // implement this method
    }
}
