package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException{
        FileInputStream inputStream = new FileInputStream(args[0]);
        TreeMap <Integer, Integer> map = new TreeMap<>();
        while (inputStream.available() > 0) {
            int data = inputStream.read();
            if (map.containsKey(data)) {map.put(data, map.get(data) + 1);}
            else {map.put(data, 1);}
        }
        inputStream.close();
        for (Map.Entry<Integer, Integer> mp : map.entrySet()) {
            int i = mp.getKey();
            String aChar = new Character((char)i).toString();
            System.out.println(aChar + " " + mp.getValue());
        }
    }
}
