package com.javarush.test.level05.lesson12.home05;

/* Вводить с клавиатуры числа и считать их сумму
Вводить с клавиатуры числа и считать их сумму, пока пользователь не введёт слово «сумма». Вывести на экран полученную сумму.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        String ch = "";
        int sum = 0;
        BufferedReader BF = new BufferedReader(new InputStreamReader(System.in));
        while (!(ch.equals("сумма")))
        {
            ch = BF.readLine();
            if (ch.matches("[-]?\\d+"))
            {
                sum = sum + Integer.parseInt(ch);
            }
        }
        System.out.println(sum);
    }
}
