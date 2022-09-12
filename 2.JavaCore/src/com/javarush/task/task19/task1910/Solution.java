package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
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
        data = data.replaceAll("\\p{Punct}", "");
        BufferedWriter out = new BufferedWriter(new FileWriter(filename2));
        out.write(data);
        out.close();
    }
}
