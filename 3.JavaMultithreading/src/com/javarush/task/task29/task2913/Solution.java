package com.javarush.task.task29.task2913;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* 
Замена рекурсии
*/

public class Solution {
    private static int numberA;
    private static int numberB;

    public static String getAllNumbersBetween(int a, int b) {
        StringBuilder str = new StringBuilder();
        if (a < b) {
            for (int i = a; i <= b; i++) {
                str.append(i);
                if (i != b) {
                    str.append(" ");
                }
            }
        } else {
            if (a == b) {
                return String.valueOf(a);
            }
            for (int i = a; i >= b; i--) {
                str.append(i);
                if (i != b) {
                    str.append(" ");
                }
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        Random random = new Random();
        numberA = random.nextInt(1000);
        numberB = random.nextInt(1000);
        System.out.println(getAllNumbersBetween(numberA, numberB));
        System.out.println(getAllNumbersBetween(numberB, numberA));
    }
}