package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(args[0]);
        int count1 = 0;
        int count2 = 0;
        while (inputStream.available() > 0) {
            if (inputStream.read() == 32) { count2++;}
            count1++;
        }
        inputStream.close();
        double d = (double) count2 / (double) count1 * 100;
        String pattern = "##0.00";
        DecimalFormat DF = new DecimalFormat(pattern);
        String format = DF.format(d);
        System.out.println(format);
    }
}
