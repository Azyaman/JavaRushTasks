package com.javarush.test.level09.lesson11.home08;

import java.util.ArrayList;

/* Список из массивов чисел
Создать список, элементами которого будут массивы чисел. Добавить в список пять объектов–массивов длиной 5, 2, 4, 7, 0 соответственно. Заполнить массивы любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList()
    {
        //напишите тут ваш код
        int[] one = new int[5];
        for (int i = 0; i < 5; i++)
        {
            one[i] = 10 + i;
        }
        int[] two = new int[2];
        for (int i = 0; i < 2; i++)
        {
            two[i] = 20 + i;
        }
        int[] three = new int[4];
        for (int i = 0; i < 4; i++)
        {
            three[i] = 30 + i;
        }
        int[] four = new int[7];
        for (int i = 0; i < 7; i++)
        {
            four[i] = 40 + i;
        }
        int[] five = new int[0];
        ArrayList<int[]> list = new ArrayList<>();
        list.add(one); list.add(two); list.add(three); list.add(four); list.add(five);
        return list;
    }

    public static void printList(ArrayList<int[]> list)
    {
        for (int[] array: list )
        {
            for (int x: array)
            {
                System.out.println(x);
            }
        }
    }
}
