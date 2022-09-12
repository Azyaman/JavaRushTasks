package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static Map<String, Integer> createMap() {
        //напишите тут ваш код
        Map<String, Integer> map = new HashMap<>();
        map.put("White", 100);
        map.put("Blue", 200);
        map.put("Green", 300);
        map.put("Yellow", 400);
        map.put("Red", 500);
        map.put("Kong", 600);
        map.put("King", 700);
        map.put("Black", 800);
        map.put("Morph", 900);
        map.put("Neo", 1000);
        return map;
    }

    public static void removeItemFromMap(Map<String, Integer> map) {
        //напишите тут ваш код
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> pair = iterator.next();
            if (pair.getValue() < 500) {iterator.remove(); map.remove(pair.getKey()); }
        }
    }

    public static void main(String[] args) {



    }
}