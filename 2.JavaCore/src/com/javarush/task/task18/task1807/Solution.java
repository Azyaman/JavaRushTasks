package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException{
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();
        FileInputStream inputStream = new FileInputStream(filename);
        int count = 0;
        while (inputStream.available() > 0) {
            int data = inputStream.read();
            if(data == 44) {
                count = count + 1;
            }
        }
        System.out.print(count);
        inputStream.close();

    }
}
