package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException{

        String k = "Java";
        byte[] key = k.getBytes();

        if (args[0].equals("-e")) {
            FileInputStream inputStream = new FileInputStream(args[1]);
            FileOutputStream outputStream = new FileOutputStream(args[2]);
            int i = 0;
            while (inputStream.available() > 0) {
                int data = inputStream.read();
                int res = (byte) (data ^ key[i % key.length]);
                outputStream.write(res);
            }
            inputStream.close();
            outputStream.close();
        }

        if (args[0].equals("-d")) {
            FileInputStream inputStream = new FileInputStream(args[1]);
            FileOutputStream outputStream = new FileOutputStream(args[2]);
            int i = 0;
            while (inputStream.available() > 0) {
                int data = inputStream.read();
                int res = (byte) (data ^ key[i % key.length]);
                outputStream.write(res);
            }
            inputStream.close();
            outputStream.close();
        }


    }

}
