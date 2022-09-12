package com.javarush.test.level04.lesson16.home02;

import java.io.*;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        //напишите тут ваш код
        BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(BR.readLine());
        int n = Integer.parseInt(BR.readLine());
        int l = Integer.parseInt(BR.readLine());

        if (m >= n)
        {
            if (m <= l)
            {
                System.out.println(m);
            }
            else
            {
                if (l >= n )
                {
                    System.out.println(l);
                }
                else
                {
                    System.out.println(n);
                }
            }

        }
        else
        {
            if (l >= n )
            {
                System.out.println(n);
            }
            else
            {
                System.out.println(l);
            }
        }
    }
}
