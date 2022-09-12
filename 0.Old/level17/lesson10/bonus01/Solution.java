package com.javarush.test.level17.lesson10.bonus01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        SimpleDateFormat format = new SimpleDateFormat("DD/MM/YYYY", Locale.ENGLISH);

        if (args[0].equals("-c"))
        {
            if (args.length == 4)
            {
                String name = args[1];
                Date date = null;

                try
                {
                    date = format.parse(args[3]);
                }
                catch (ParseException e) {}

                if (args[2].toLowerCase().equals("м"))
                {
                    allPeople.add(Person.createMale(name, date));
                    System.out.print(allPeople.get(allPeople.size()-1));
                }
                if (args[2].toLowerCase().equals("ж"))
                {
                    allPeople.add(Person.createFemale(name, date));
                    System.out.print(allPeople.get(allPeople.size()-1));
                }
            }

            if (args.length == 5)
            {
                String name = args[1] + args[2];
                Sex sex;
                Date date = null;

                try
                {
                    date = format.parse(args[4]);
                }
                catch (ParseException e) {}

                if (args[3].toLowerCase().equals("м"))
                {
                    allPeople.add(Person.createMale(name, date));
                    System.out.print(allPeople.get(allPeople.size()-1));
                }
                if (args[3].toLowerCase().equals("ж"))
                {
                    allPeople.add(Person.createFemale(name, date));
                    System.out.print(allPeople.get(allPeople.size()-1));
                }
            }

        }

        if (args[0].equals("-u"))
        {
            if (args.length == 5)
            {
                Integer id = Integer.parseInt(args[1]);

                String name = args[2];
                allPeople.get(id).setName(name);

                Date date = null;

                try
                {
                    date = format.parse(args[4]);
                    allPeople.get(id).setBirthDay(date);
                }
                catch (ParseException e) {}

                if (args[3].toLowerCase().equals("м"))
                {
                    allPeople.get(id).setSex(Sex.MALE);
                }

                if (args[3].toLowerCase().equals("ж"))
                {
                    allPeople.get(id).setSex(Sex.FEMALE);
                }
            }

            if (args.length == 6)
            {
                Integer id = Integer.parseInt(args[1]);

                String name = args[2] + args[3];
                allPeople.get(id).setName(name);

                Date date = null;

                try
                {
                    date = format.parse(args[5]);
                    allPeople.get(id).setBirthDay(date);
                }
                catch (ParseException e) {}

                if (args[4].toLowerCase().equals("м"))
                {
                    allPeople.get(id).setSex(Sex.MALE);
                }

                if (args[4].toLowerCase().equals("ж"))
                {
                    allPeople.get(id).setSex(Sex.FEMALE);
                }
            }
        }

        format = new SimpleDateFormat("DD-MMM-YYYY", Locale.ENGLISH);

        if (args[0].equals("-d"))
        {
            Integer id = Integer.parseInt(args[1]);
            allPeople.get(id).setName(null);
            allPeople.get(id).setBirthDay(null);
            allPeople.get(id).setSex(null);
        }

        if (args[0].equals("-i"))
        {
            Integer id = Integer.parseInt(args[1]);
            String sex = null;
            if (allPeople.get(id).getSex() == Sex.MALE) {sex = "м";}
            if (allPeople.get(id).getSex() == Sex.FEMALE) {sex = "ж";}
            System.out.println(allPeople.get(id).getName() + " " + sex + " " + format.format(allPeople.get(id).getBirthDay()));
        }


    }
}
