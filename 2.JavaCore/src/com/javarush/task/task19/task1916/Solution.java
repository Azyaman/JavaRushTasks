package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException{
        ArrayList<String> line1 = new ArrayList<>();
        ArrayList<String> line2 = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file1 = br.readLine();
        String file2 = br.readLine();
        br.close();
        BufferedReader filereader1 = new BufferedReader(new FileReader(file1));
        BufferedReader filereader2 = new BufferedReader(new FileReader(file2));



//        BufferedReader filereader1 = new BufferedReader(new FileReader("C:\\Users\\LohovRV\\Desktop\\data.txt"));
//        BufferedReader filereader2 = new BufferedReader(new FileReader("C:\\Users\\LohovRV\\Desktop\\result.txt"));
        while (filereader1.ready()) {
            line1.add(filereader1.readLine());
        }
        while (filereader2.ready()) {
            line2.add(filereader2.readLine());
        }
        filereader1.close();
        filereader2.close();

        for (int i = 0; i < line1.size(); i++) {

            if ( (line2.size() != 0) && (line1.get(i).equals(line2.get(0))) ) {
                lines.add(new LineItem(Type.SAME, line1.get(i)));
                line2.remove(0);
            }
            else {
                if ( (line2.size() > 1) &&  (line1.get(i).equals(line2.get(1))) ) {
                    lines.add(new LineItem(Type.ADDED, line2.get(0)));
                    line2.remove(0);
                    i--;
                }
                else {
                    lines.add(new LineItem(Type.REMOVED, line1.get(i)));
                }
            }
        }
        if (line2.size() != 0)
        {
            for (int i = 0; i < line2.size(); i++) {
                lines.add(new LineItem(Type.ADDED, line2.get(i)));
            }
        }



        for (LineItem l : lines)
        {
            System.out.println(l.type + " " + l.line);
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
