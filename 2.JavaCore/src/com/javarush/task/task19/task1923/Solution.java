package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(args[1]));
        Pattern p = Pattern.compile("\\d");
        while (fileReader.ready()) {
            String[] str = fileReader.readLine().split(" ");
            for (int i = 0; i < str.length; i++) {
                Matcher m = p.matcher(str[i]);
                if (m.find()) {
                    fileWriter.write(str[i]+ " ");
                }
            }
        }
        fileReader.close();
        fileWriter.close();
    }
}
