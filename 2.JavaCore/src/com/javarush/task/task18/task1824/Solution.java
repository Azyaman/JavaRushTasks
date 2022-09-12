package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String file = reader.readLine();
            FileInputStream inputStream = null;
            try {
                inputStream = new FileInputStream(file);
            }
            catch (FileNotFoundException e) {
                System.out.println(file);
                break;
            }
            inputStream.close();
        }

    }
}
