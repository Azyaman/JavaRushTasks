package com.javarush.task.task30.task3010;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.regex.Pattern;

/* 
Минимальное допустимое основание системы счисления
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код


        try {
            String income = args[0];
            Pattern pattern = Pattern.compile("[0-9A-Za-z]");
            if (income.length() > 256) {
                System.out.println("incorrect");

            } else {
                char[] chars = income.toCharArray();
                for (int j = 0; j < chars.length; j++ ) {
                    if (!pattern.matcher(Character.toString(chars[j])).find()) {
                        System.out.println("incorrect");
                        break;
                    }
                }
                for (int i = 2; i < 37; i++) {
                    try {
                        new BigDecimal(new BigInteger(income, i));
                        System.out.println(i);
                        break;
                    } catch (Exception ex) {}
                }
            }
//            System.out.println("incorrect");
        } catch (Exception e) {}
    }
}