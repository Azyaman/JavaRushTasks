package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        FileInputStream inputStream = new FileInputStream(fileName);
        list.add(inputStream.read());
        while (inputStream.available() > 0) {
            boolean check = false;
            int data = inputStream.read();
            for (int i = 0; i < list.size(); i++) {
                if (data == list.get(i)) {
                    check = true;
                    break;
                }
            }
            if (!check) { list.add(data); }
        }
        inputStream.close();

        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
