package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        Map<String, Double> map = new HashMap<>();
        ArrayList<Double> val = new ArrayList<>();
        ArrayList<String> nam = new ArrayList<>();

        while (reader.ready()) {
            String str = reader.readLine();
            String[] list = str.split(" ");
            if (map.containsKey(list[0])) {
                map.put(list[0], map.get(list[0]) + Double.parseDouble(list[1]));
            } else {
                map.put(list[0], Double.parseDouble(list[1]));
            }
        }
        reader.close();

        for (Map.Entry<String, Double> pair : map.entrySet()) {
            val.add(pair.getValue());
            nam.add(pair.getKey());

        }

        Double max = val.get(0);
        for (int i = 1; i < val.size(); i++) {
            if (val.get(i) > max) { max = val.get(i);}
        }

        for (int i = 0; i < val.size(); i++) {
            if (val.get(i).equals(max)) {
                System.out.println(nam.get(i));
            }
        }
    }
}
