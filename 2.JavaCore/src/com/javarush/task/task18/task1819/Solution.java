package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        String name2 = reader.readLine();
        FileInputStream inputStream1 = new FileInputStream(name1);
        byte[] buffer1 = new byte[inputStream1.available()];
        inputStream1.read(buffer1);
        inputStream1.close();
        FileInputStream inputStream2 = new FileInputStream(name2);
        FileOutputStream outputStream = new FileOutputStream(name1);
        byte[] buffer2 = new byte[inputStream2.available()];
        inputStream2.read(buffer2);
        inputStream2.close();
        outputStream.write(buffer2);
        outputStream.write(buffer1);
        outputStream.close();
    }
}
