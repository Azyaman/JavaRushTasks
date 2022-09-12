package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //...
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        br.close();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        StringBuilder sb = new StringBuilder();
        while (fileReader.ready()) {
            sb.append(fileReader.readLine());
        }
        fileReader.close();
        StringBuilder result = getLine(sb.toString());
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder result = new StringBuilder();
        if (words.length < 1) {return result;}
        StringBuilder temp = new StringBuilder();
        for (int k = 0; k < words.length; k++) {
            temp.append(words[k])
                    .append(" ");
        }
        String[] str = temp.toString().trim().split(" ");
        ArrayList <String> list = new ArrayList<>(Arrays.asList(str));
        TreeMap <Integer, LinkedList > chains = new TreeMap<>();
        for (int q = 0; q < list.size(); q++) {
            LinkedList<String> testChain = new LinkedList<>();
            ArrayList <String> clone = new ArrayList<>(list);
            clone.add(0, clone.get(q));
            clone.remove(q + 1);
            testChain.add(clone.get(0));
            for (int i = 0 ; i < clone.size(); i++ ) {
                boolean cont = false;
                char[] word1 = clone.get(i).toLowerCase().toCharArray();
                char a = word1[word1.length - 1];
                for (int j = i + 1; j < clone.size(); j++) {
                    char[] word2 = clone.get(j).toLowerCase().toCharArray();
                    char b = word2[0];
                    if (a == b) {
                        testChain.add(clone.get(j));
                        clone.remove(i);
                        clone.add(0, clone.get(j - 1));
                        clone.remove(j);
                        i--;
                        cont = true;
                        break;
                    }
                }
                if (!cont) break;
            }
            chains.put(testChain.size(), testChain);
        }
        Map.Entry <Integer, LinkedList> lastChain = chains.lastEntry();
        LinkedList biggestChain = lastChain.getValue();

        biggestChain.forEach( s -> result.append(s).append(" "));
        result.deleteCharAt(result.length() - 1);
        return result;
    }
}
