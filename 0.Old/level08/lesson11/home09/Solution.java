package com.javarush.test.level08.lesson11.home09;

import java.util.Date;


/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Не забудьте учесть первый день года.
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution
{
    public static void main(String[] args)
    {
        System.out.println(isDateOdd("JANUARY 2 2020"));

    }

    public static boolean isDateOdd(String date)
    {
        Date a = new Date(date);
        Date b = new Date(date);
        b.setSeconds(0);
        b.setMinutes(0);
        b.setHours(0);
        b.setDate(1);
        b.setMonth(0);
        long ms = a.getTime() - b.getTime();
        long day = 24*60*60*1000;
        return ((ms/day)%2==0);

    }
}
