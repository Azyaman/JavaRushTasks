package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(args[0]);
        int english = 0;
        Pattern p = Pattern.compile("[a-zA-Z]");
        while (inputStream.available() > 0) {
            int data =  inputStream.read();
            Character c = (char)data;
            String s = c.toString();
            Matcher m = p.matcher(s);
            if (m.find()) {english++;}
        }
        System.out.println(english);
        inputStream.close();
    }
}
