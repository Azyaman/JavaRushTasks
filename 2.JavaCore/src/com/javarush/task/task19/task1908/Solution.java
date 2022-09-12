package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

/* Требования:
        1. Программа должна считывать имена файлов с консоли (используй BufferedReader).
        2. BufferedReader для считывания данных с консоли должен быть закрыт.
        3. Программа должна считывать содержимое первого файла (используй BufferedReader c конструктором FileReader).
        4. Поток чтения из файла (BufferedReader) должен быть закрыт.
        5. Программа должна записывать во второй файл все числа, через пробел, из первого файла (используй BufferedWriter с конструктором FileWriter).
        6. Поток записи в файл (BufferedWriter) должен быть закрыт.
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = br.readLine();
        String filename2 = br.readLine();
        br.close();
        BufferedReader reader = new BufferedReader(new FileReader(filename1));
        String data = "";
        while (reader.ready()) {
            data += reader.readLine();

        }
        reader.close();
        String[] words= data.split("[ ]|\\s");
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename2));
        Matcher matcher;
        Pattern pattern = Pattern.compile("\\d+");
        boolean first = true;
        for (int i = 0; i < words.length; i++) {
            matcher = pattern.matcher(words[i]);
            if (matcher.matches()) {
                if (first == true) { writer.write(words[i]); first = false;}
                else { writer.write(" " + words[i]);}
            }
        }
        writer.close();
    }
}
