package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException{
        BufferedReader filereader = new BufferedReader(new FileReader(args[0]));
        String name="";
        Date date;
        while (filereader.ready()) {
            String[] str = filereader.readLine().split(" ");
            for (int i = 0; i < str.length - 3; i++) {
                if (i == str.length - 4) { name += str[i]; }
                else { name += str[i] + " "; }
            }
            int day = Integer.parseInt(str[str.length-3]);
            int month = Integer.parseInt(str[str.length-2]);
            int year = Integer.parseInt(str[str.length-1]);
            date = new GregorianCalendar(year, month-1, day).getTime();
            PEOPLE.add(new Person(name, date));
            name = "";
        }
        filereader.close();
    }
}
