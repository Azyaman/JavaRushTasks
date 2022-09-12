package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = reader.readLine();
        String filename2 = reader.readLine();
        String filename3 = reader.readLine();
        reader.close();

        FileInputStream inputStream = new FileInputStream(filename1);
        int size = 0;
        if (inputStream.available() % 2 != 0) {size = (inputStream.available() / 2) + 1;}
        else {size = inputStream.available() / 2;}

        FileOutputStream outputStream = new FileOutputStream(filename2);
        byte[] buffer = new byte[size];
        int count = inputStream.read(buffer);
        outputStream.write(buffer, 0, count);
        outputStream.close();

        outputStream = new FileOutputStream(filename3);
        buffer = new byte[inputStream.available()];
        count = inputStream.read(buffer);
        outputStream.write(buffer, 0, count);

        inputStream.close();
        outputStream.close();
    }
}
