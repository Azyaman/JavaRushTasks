package com.javarush.task.task22.task2207;



import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String FileName = br.readLine();
        br.close();
        BufferedReader fileReader = new BufferedReader(new FileReader(FileName));
        StringBuilder sb = new StringBuilder();
        while (fileReader.ready()) {
            sb.append(fileReader.readLine() + " ");
        }
        fileReader.close();
        String[] str = sb.toString().trim().split(" ");

        ArrayList<String> words = new ArrayList<>();
        words.addAll(Arrays.asList(str));
        for (int i = 0; i < words.size() - 1 ; i++) {
            for (int j = i + 1; j < words.size(); j++) {
                if (words.get(i).equals(new StringBuilder(words.get(j)).reverse().toString())) {
                    Pair pair = new Pair(words.get(i), words.get(j));
                    result.add(pair);
                    words.remove(j);
                    words.remove(i);
                    i--;
                    break;
                }
            }
        }

            for (int j = 0; j < result.size();j++) {
                System.out.println(result.get(j));
            }


    }

    public static class Pair {
        String first;
        String second;
        public Pair() {}

        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                        first == null ? second :
                            second == null ? first :
                                first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
