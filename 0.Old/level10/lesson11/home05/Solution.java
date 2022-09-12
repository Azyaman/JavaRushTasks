package com.javarush.test.level10.lesson11.home05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Количество букв
Ввести с клавиатуры 10 строчек и подсчитать в них количество различных букв (для 33 букв алфавита).  Вывести результат на экран.
Пример вывода:
а 5
б 8
в 3
г 7
д 0
…
я 9
*/

public class Solution
{
    public static void main(String[] args)  throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //алфавит
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] abcArray = abc.toCharArray();

        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (int i = 0; i < abcArray.length; i++)
        {
            alphabet.add(abcArray[i]);
        }

        //ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++)
        {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }


        //напишите тут ваш код
        Integer[] value = new Integer[alphabet.size()];
        for (int i = 0; i < alphabet.size(); i++) value[i] = 0;

            for (int i = 0; i < 10; i++)
        {
            char[] temp = list.get(i).toCharArray();
            for (int j = 0; j < temp.length; j++)
            {
                for (int k = 0; k < alphabet.size(); k++)
                {
                    if (temp[j] == alphabet.get(k))
                    {
                        value[k] = value[k] + 1;
                    }
                }
            }
        }
        for (int i = 0; i < alphabet.size(); i++)
        {
            System.out.println(alphabet.get(i) + " " + value[i]);
        }
    }

}
