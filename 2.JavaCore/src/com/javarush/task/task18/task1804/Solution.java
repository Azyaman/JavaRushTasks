package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Map<Integer, Integer> map = new HashMap<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        FileInputStream inputStream = new FileInputStream(fileName);
        int maxValue = 0;
        while (inputStream.available() > 0) {
            int data = inputStream.read();
            if (map.containsKey(data)) {
                map.put(data, map.get(data) + 1);
            } else {
                map.put(data, 1);
            }
            if (map.get(data) > maxValue) {
                maxValue = map.get(data);
            }
        }
        inputStream.close();
        int minValue = maxValue;
        for (Map.Entry<Integer, Integer> pair : map.entrySet())
        {
            if (pair.getValue() < minValue) { minValue = pair.getValue(); }
        }
        for (Map.Entry<Integer, Integer> pair : map.entrySet())
        {
            if (pair.getValue() == minValue) { System.out.print(pair.getKey() + " "); }
        }
    }
}