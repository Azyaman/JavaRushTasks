package com.javarush.test.level07.lesson12.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 20 чисел и выводит их в убывающем порядке.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        for (int i = 0; i < 20; i++)
        {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        for (int x : array)
        {
            System.out.println(x);
        }
    }

    public static void sort(int[] array)
    {
        //напишите тут ваш код
        ArrayList<Integer> list = new ArrayList<>();
        list.add(array[0]);
        for (int i = 1; i < 20; i++)
        {
            for (int j = 0; j<list.size();j++)
            {
                if (array[i]>=list.get(j))
                {
                    list.add(j, array[i]);
                    break;
                }
                if (j == list.size()-1){ list.add(j+1, array[i]); break;}
            }
        }
        for (int i = 0; i < 20; i++) array[i] = list.get(i);
    }
}
