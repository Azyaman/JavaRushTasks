package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой стороки.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        FileWriter writer = new FileWriter(name, false);

        String stroka = reader.readLine();
        while (!(stroka.equalsIgnoreCase("exit")))
        {
            writer.write(stroka + "\r\n");
            writer.flush();
            stroka = reader.readLine();
        }
        writer.write(stroka);
        reader.close();
        writer.close();
    }
}
