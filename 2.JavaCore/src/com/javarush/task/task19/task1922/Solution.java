package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String name = bufferedReader.readLine();
        bufferedReader.close();
        BufferedReader fileReader = new BufferedReader(new FileReader(name));
        int count = 0;
        while (fileReader.ready()) {
            String str = fileReader.readLine();
            for (int i = 0; i < words.size(); i++) {
                if (str.contains(words.get(i))) {
                    count++;
                }
            }
            if (count == 2) {
                System.out.println(str);
            }
            count = 0;
        }
        fileReader.close();

    }
}
