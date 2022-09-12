package com.javarush.task.task19.task1906;

/* 
Четные байты
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String in = reader.readLine();
        String out = reader.readLine();
        reader.close();
        FileReader fileReader = new FileReader(in);
        FileWriter fileWriter = new FileWriter(out);
        int count = 0;
        while (fileReader.ready()) {
            int data = fileReader.read();
            count++;
            if (count % 2 == 0) fileWriter.write(data);
        }
        fileReader.close();
        fileWriter.close();
    }
}
