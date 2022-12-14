package com.javarush.task.task22.task2211;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(args[0]);
        FileOutputStream outputStream = new FileOutputStream(args[1]);
        Charset win = Charset.forName("Windows-1251");
        Charset utf = Charset.forName("UTF-8");
        while (inputStream.available() > 0) {
            byte[] buffer = new byte[1000];
            inputStream.read(buffer);
            String s = new String(buffer, win);
            buffer = s.getBytes(utf);
            outputStream.write(buffer);
        }
        inputStream.close();
        outputStream.close();

    }
}
