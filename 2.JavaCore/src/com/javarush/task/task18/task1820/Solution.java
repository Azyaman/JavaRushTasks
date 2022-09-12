package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        String name2 = reader.readLine();
        reader.close();
        BufferedReader br = new BufferedReader(new FileReader(name1));
        FileWriter writer = new FileWriter(name2, false);
        String s = br.readLine();
        String[] ss = s.split(" ");
        for (int i = 0; i < ss.length; i++) {
            Double idata = Double.parseDouble(ss[i]);
            String result = String.valueOf((int)Math.round(idata));
            if (i != (ss.length - 1)) {
                writer.write(result + " ");
            }
            else { writer.write(result);}
        }
        br.close();
        writer.close();
    }
}
