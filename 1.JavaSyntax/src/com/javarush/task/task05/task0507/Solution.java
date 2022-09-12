package com.javarush.task.task05.task0507;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Среднее арифметическое
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        int i = 0;
        while (true) {
            int number = Integer.parseInt(br.readLine());
            if (number == -1) break;
            sum = sum + number;
            i++;
        }
        System.out.println(sum/(i*1.0));
    }
}

