package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        ArrayList<Human> list = new ArrayList<>();
        Human son1 = new Human("Vasya", true, 7, new ArrayList<Human>());
        Human son2 = new Human("Dima", true, 10, new ArrayList<Human>());
        Human dot = new Human("Dasha", false, 13, new ArrayList<Human>());
        list.add(son1);
        list.add(son2);
        list.add(dot);
        Human fath = new Human("Roma", true, 40, list);
        Human moth = new Human("Tanya", false, 40, list);
        ArrayList<Human> list2 = new ArrayList<>();
        list2.add(fath);
        Human grf1 = new Human("Vadim", true, 67, list2);
        Human grm1 = new Human("Galya", false, 66, list2);
        ArrayList<Human> list3 = new ArrayList<>();
        list3.add(moth);
        Human grf2 = new Human("Tolya", true, 69, list3);
        Human grm2 = new Human("Zina", false, 68, list3);
        System.out.println(grf2);
        System.out.println(grm2);
        System.out.println(grf1);
        System.out.println(grm1);
        System.out.println(fath);
        System.out.println(moth);
        System.out.println(dot);
        System.out.println(son2);
        System.out.println(son1);
    }

    public static class Human
    {
        //напишите тут ваш код
        String name;
        Boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<>();

        public Human (String name, boolean sex, int age, ArrayList<Human> children)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }



        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
