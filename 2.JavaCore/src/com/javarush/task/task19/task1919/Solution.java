package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        String str = "";
        Map<String, Double> map = new TreeMap<>();
        while (reader.ready()) {
            str = reader.readLine();
            String[] list = str.split(" ");
            if (map.containsKey(list[0])) {
                map.put(list[0], map.get(list[0]) + Double.parseDouble(list[1]));
            } else {
                map.put(list[0], Double.parseDouble(list[1]));
            }
        }
        reader.close();
        for (Map.Entry<String, Double> pair : map.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }


    }
}
