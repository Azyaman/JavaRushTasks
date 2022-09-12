package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

/*
Требования:
1. Программа должна считывать имена файлов с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое первого файла (используй BufferedReader c конструктором FileReader).
4. Поток чтения из файла (BufferedReader) должен быть закрыт.
5. Программа должна записывать во второй файл содержимое первого файла, где заменены все точки "." на знак "!" (Для записи в файл используй BufferedWriter с конструктором FileWriter).
6. Поток записи в файл (BufferedWriter) должен быть закрыт.
 */

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = bufferedReader.readLine();
        String filename2 = bufferedReader.readLine();
        bufferedReader.close();
        BufferedReader in = new BufferedReader(new FileReader(filename1));
        String data = "";
        while (in.ready()) {
            data += in.readLine();
        }
        in.close();
        data = data.replaceAll("[.]", "!");
        BufferedWriter out = new BufferedWriter(new FileWriter(filename2));
        out.write(data);
        out.close();

    }
}
