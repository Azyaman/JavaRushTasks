package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = reader.readLine();
        String filename2 = reader.readLine();
        reader.close();


        FileInputStream inputStream = new FileInputStream(filename1);
        byte[] buffer = new byte[inputStream.available()];
        byte[] buffer2 = new byte[inputStream.available()];

        FileOutputStream outputStream = new FileOutputStream(filename2);
        int count = inputStream.read(buffer2);
        for (int i = 0; i < buffer.length; i++) {
            buffer[buffer.length - 1 - i] = buffer2[i];
        }
        outputStream.write(buffer, 0, count);

        inputStream.close();
        outputStream.close();

    }
}
