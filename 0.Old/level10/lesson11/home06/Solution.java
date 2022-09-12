package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        //напишите тут ваши переменные и конструкторы
        String name;
        boolean sex;
        int age;
        int weight;
        int height;
        String address;

        public Human (String name, boolean sex, int age, int weight, int height, String address)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.weight = weight;
            this.height = height;
            this.address = address;
        }

        public Human (String name, boolean sex, int weight, int height, String address)
        {
            this.name = name;
            this.sex = sex;
            this.weight = weight;
            this.height = height;
            this.address = address;
        }

        public Human (String name, boolean sex, int age, int weight, int height)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.weight = weight;
            this.height = height;
        }

        public Human (String name, boolean sex, int weight, int height)
        {
            this.name = name;
            this.sex = sex;
            this.weight = weight;
            this.height = height;
        }

        public Human (String name, boolean sex, int age, String address)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.address = address;
        }

        public Human (String name, boolean sex, int age)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human (boolean sex, int age, int height)
        {
            this.sex = sex;
            this.age = age;
            this.height = height;
        }

        public Human (boolean sex, int age, String address)
        {
            this.sex = sex;
            this.age = age;
            this.address = address;
        }
        public Human (String name, boolean sex, String address)
        {
            this.name = name;
            this.sex = sex;
            this.address = address;
        }


        public Human (String name, boolean sex)
        {
            this.name = name;
            this.sex = sex;
        }


    }
}
