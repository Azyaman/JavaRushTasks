package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        reader.close();

        FileReader fr = new FileReader(name);
        BufferedReader freader = new BufferedReader(fr);
        ArrayList<Integer> list = new ArrayList<>();

        String line = freader.readLine();
        while (line != null)
        {
            if(Integer.parseInt(line) % 2 == 0) list.add(Integer.parseInt(line));
            line = freader.readLine();
        }
        fr.close();
        freader.close();

        Integer[] array = list.toArray(new Integer[list.size()]);
        for (int i = 0; i < array.length; i++)
        {
            for (int j = i + 1; j < array.length; j++)
            {
                if (array[j] < array[i])
                {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

        for (int i = 0; i < array.length; i++) System.out.println(array[i]);


    }
}
