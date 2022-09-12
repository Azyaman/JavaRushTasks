package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList <Integer> istart = new ArrayList<>();
        ArrayList <Integer> iend = new ArrayList<>();


        String tag = args[0];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(br.readLine()));
        String str = "";
        while (fileReader.ready())
        {
            str += (char) fileReader.read();

        }
        br.close();
        fileReader.close();

        char[] name = str.replaceAll("\r\n", "").toCharArray();

        int count = 0;
        String word = "";






        for (int i = tag.length(); i < name.length - 2; i++) {
            for (int j = i - tag.length(); j <= i; j++) {
                word = word + name[j];
            }

            if ( ("<" + tag).equalsIgnoreCase(word) ) {
                count++;
                istart.add(i - tag.length());
            }


            if (count > 0 && ( ("</" + tag + ">" ).equalsIgnoreCase(word + name[i+1] + name[i+2]) ) ) {
                count--;
                iend.add(i+2);

                if (count==0) {
                    for (int k = 0; k < istart.size(); k++) {
                        for (int j = istart.get(k); j <= iend.get(istart.size()-1-k); j++) {
                            System.out.print(name[j]);
                        }
                        System.out.println();
                    }
                    istart.clear();
                    iend.clear();
                }
            }
            word = "";

        }

    }
}
