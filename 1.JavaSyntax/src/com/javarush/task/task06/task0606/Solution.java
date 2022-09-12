package com.javarush.task.task06.task0606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        br.close();
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            int number = Integer.parseInt(String.valueOf(arr[i]));
            if (number%2 == 0) { even++; }
            else { odd++; }
        }
        System.out.println("Even: " + even + " Odd: " + odd);
    }
}
