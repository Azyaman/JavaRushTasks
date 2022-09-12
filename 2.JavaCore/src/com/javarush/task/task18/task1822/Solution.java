package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        HashMap <Integer, String> map = new HashMap<>();
        String name = bufferedReader.readLine();
        bufferedReader.close();
        BufferedReader fileReader = new BufferedReader(new FileReader(name));
        while (true) {
            String s = fileReader.readLine();
            if (s == null) break;
            String[] str = s.split(" ", 2);
            map.put(Integer.parseInt(str[0]), str[1]);
        }
        fileReader.close();
        Integer id = Integer.parseInt(args[0]);
        if (map.containsKey(id)) {System.out.println(id + " " + map.get(id));}

    }
}
