package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Проверка на упорядоченность
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int dlina = 0;
        for (int i = 0; i < 10; i++) {
            list.add(br.readLine());
        }

        for (int i = 0; i < 10; i++) {
            if (list.get(i).length() < dlina) {
                System.out.println(i);
                break;
            }
            else {dlina = list.get(i).length();}
        }
    }
}

