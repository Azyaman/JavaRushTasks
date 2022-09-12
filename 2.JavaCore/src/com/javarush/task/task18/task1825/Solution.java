package com.javarush.task.task18.task1825;

/* 
Собираем файл
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        Map<Integer, String> map = new TreeMap<>();

        while (true) {
            String file = reader.readLine();
            if (file.equals("end")) {break;}
            list.add(file);
        }
        reader.close();

        String fileName = list.get(0).substring(0, list.get(0).lastIndexOf("."));

        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i).substring(list.get(i).lastIndexOf("part") + 4, list.get(i).length());
            int value = Integer.parseInt(s);
            map.put(value, list.get(i));
        }

        FileOutputStream outputStream = new FileOutputStream(fileName);

        for (Map.Entry<Integer, String> pair : map.entrySet()) {
            FileInputStream inputStream = new FileInputStream(pair.getValue());
            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            outputStream.write(buffer);
            inputStream.close();
        }
        outputStream.close();

    }
}
