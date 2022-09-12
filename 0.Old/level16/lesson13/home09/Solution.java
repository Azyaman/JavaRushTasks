package com.javarush.test.level16.lesson13.home09;

import java.io.*;
/* Только по-очереди!
1. В классе Solution создать нить public static Read3Strings унаследовавшись от Thread.
2. В методе run реализовать чтение с консоли трех строк.
3. Три подряд введенных строки должны считываться в одной нити и объединяться в одну строку через пробел.
4. В методе main вывести результат для каждой нити.
5. Используйте join

Пример:
Входные данные
a
b
c
d
e
f
Выходные данные:
a b c
d e f
*/

public class Solution
{
    public static volatile BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws InterruptedException
    {
        Read3Strings t1 = new Read3Strings();
        Read3Strings t2 = new Read3Strings();
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        System.out.println(t1.getResult());
        System.out.println(t2.getResult());
    }

    public static class Read3Strings extends Thread
    {
        String result = "";
        public void run ()
        {
            String text1 = "";
            String text2 = "";
            String text3 = "";
            try
            {
                text1 = reader.readLine();
                text2 = reader.readLine();
                text3 = reader.readLine();
            }
            catch (IOException e) {}

            result = text1 + " " + text2 + " " + text3;

        }

        public String getResult()
        {
            return result;
        }

    }
}
