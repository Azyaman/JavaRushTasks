package com.javarush.test.level06.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 5 чисел и выводит их в возрастающем порядке.
Пример ввода:
3
2
15
6
17
Пример вывода:
2
3
6
15
17
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));

        //напишите тут ваш код
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; i++)
        {
            int num = Integer.parseInt(reader.readLine());
            list.add(num);
        }

        for (int i = 0; i < 5; i++)
        {
            int min = list.get(0);
            for (int j = 1; j < list.size(); j++)
            {
                int b = list.get(j);
                if (b < min) min = b;
            }
            int index = list.indexOf(min);
            list.remove(index);
            System.out.println(min);
        }
    }
}
