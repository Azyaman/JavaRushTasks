package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        if (args[0].equals("-c"))
        {
            if (args[2].equals("м"))
            {
                allPeople.add(Person.createMale(args[1], format.parse(args[3])));
                System.out.println((allPeople.size()-1));
            }
            if (args[2].equals("ж"))
            {
                allPeople.add(Person.createFemale(args[1], format.parse(args[3])));
                System.out.println((allPeople.size()-1));
            }
        }

        if (args[0].equals("-u"))
        {

                Integer id = Integer.parseInt(args[1]);
                String name = args[2];
                allPeople.get(id).setName(name);
                Date date = null;
                date = format.parse(args[4]);
                allPeople.get(id).setBirthDay(date);
                if (args[3].toLowerCase().equals("м"))
                {
                    allPeople.get(id).setSex(Sex.MALE);
                }
                if (args[3].toLowerCase().equals("ж"))
                {
                    allPeople.get(id).setSex(Sex.FEMALE);
                }

        }

        if (args[0].equals("-d"))
        {
            Integer id = Integer.parseInt(args[1]);
            allPeople.get(id).setName(null);
            allPeople.get(id).setBirthDay(null);
            allPeople.get(id).setSex(null);
        }

        format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        if (args[0].equals("-i"))
        {
            Integer id = Integer.parseInt(args[1]);
            String sexy = null;
            if (allPeople.get(id).getSex() == Sex.MALE) {sexy = "м";}
            if (allPeople.get(id).getSex() == Sex.FEMALE) {sexy = "ж";}
            System.out.println(allPeople.get(id).getName() + " " + sexy + " " + format.format(allPeople.get(id).getBirthDay()));
        }
    }
}



