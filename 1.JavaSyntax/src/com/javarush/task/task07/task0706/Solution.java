package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        int[] arr = new int[15];
        int Chet = 0;
        int NeChet = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (i%2 == 0) { Chet += arr[i]; }
            else { NeChet += arr[i];}
        }
        br.close();
        if (NeChet > Chet) {System.out.println("В домах с нечетными номерами проживает больше жителей.");}
        else {System.out.println("В домах с четными номерами проживает больше жителей.");}




    }
}
