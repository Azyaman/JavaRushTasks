package com.javarush.task.task08.task0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Cамая длинная последовательность
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        List<Integer> list = new ArrayList<>();
        List<Integer> ind = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        int dlina = 1;
        int num = list.get(0);
        for (int i = 1; i < list.size(); i++ ) {
            if (num == list.get(i)) {
                dlina++;
                num = list.get(i);
            }
            else {
                ind.add(dlina);
                dlina = 1;
                num = list.get(i);
            }
        }
        ind.add(dlina);
        int max = Collections.max(ind);
        System.out.println(max);

    }
}
