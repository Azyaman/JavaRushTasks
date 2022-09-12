package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file = br.readLine();
        br.close();
        FileReader fileReader = new FileReader(file);
        String s = "";
        while (fileReader.ready()) {
            s += (char) fileReader.read();
        }
        fileReader.close();
        String[] words= s.split("\\p{Punct}|[ ]|\\s");
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equalsIgnoreCase("world")) {count++;}
        }
        System.out.println(count);
    }
}
