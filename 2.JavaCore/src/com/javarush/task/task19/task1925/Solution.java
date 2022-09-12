package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(args[1]));
        String temp;
        String stroka = "";
        while ((temp=fileReader.readLine())!= null) {
            String[] str = temp.split(" ");
            for (int i = 0; i < str.length; i++) {
                if (str[i].length() > 6) {
                    stroka += str[i] + ",";
                }
            }
        }
        fileReader.close();
        if (stroka.length() > 1) {
            stroka = stroka.substring(0, stroka.length() - 1);
            fileWriter.write(stroka);
        }
        fileWriter.close();
    }
}
