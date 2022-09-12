package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        String name2 = reader.readLine();
        String name3 = reader.readLine();
        FileOutputStream outputStream = new FileOutputStream(name1);
        FileInputStream inputStream2 = new FileInputStream(name2);
        FileInputStream inputStream3 = new FileInputStream(name3);
        byte[] buffer = new byte[inputStream2.available()];
        while (inputStream2.available() > 0) {
            inputStream2.read(buffer);
            outputStream.write(buffer);
        }
        inputStream2.close();
        buffer = new byte[inputStream3.available()];
        while (inputStream3.available() > 0) {
            inputStream3.read(buffer);
            outputStream.write(buffer);
        }
        inputStream3.close();
        outputStream.close();
    }
}
