package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int indexMax = 0;
        int indexMin = 0;
        int max = 0;
        int min = 0;
        for (int i = 0; i < 10; i++) {
            list.add(br.readLine());
            if (list.get(i).length() > max) {max = list.get(i).length(); indexMax = i;}
            else if (list.get(i).length() < min ) {min = list.get(i).length(); indexMin = i;}

            if (i == 0) { min = list.get(i).length(); indexMin = i;}
        }

        if (indexMax < indexMin) {System.out.println(list.get(indexMax));}
        else {System.out.println(list.get(indexMin));}
    }
}
