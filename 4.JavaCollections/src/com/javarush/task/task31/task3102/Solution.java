package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/* 
Находим все файлы
*/

public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        File rootDir = new File(root);
        Queue<File> queue = new LinkedList<>();
        Collections.addAll(queue, Objects.requireNonNull(rootDir.listFiles()));
        List<String> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            File temp = queue.poll();
            if (temp.isDirectory()) {
                Collections.addAll(queue, Objects.requireNonNull(temp.listFiles()));
            } else {
                result.add(temp.getAbsolutePath());
            }
        }

        return result;

    }

    public static void main(String[] args) {

    }
}
