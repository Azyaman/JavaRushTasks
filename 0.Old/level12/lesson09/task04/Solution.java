package com.javarush.test.level12.lesson09.task04;

/* Fly, Run, Swim для классов Human, Duck, Penguin, Airplane
Есть public интерфейсы Fly(летать), Run(бежать/ездить), Swim(плавать).
Добавь эти интерфейсы классам Human(человек), Duck(утка), Penguin(пингвин), Airplane(самолет).
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public interface Fly
    {
        public void fly();
    }

    public interface Run
    {
        public void run();
    }

    public interface Swim
    {
        public void swim();
    }


    public class Human implements Run, Swim
    {
        public void run()
        {
            System.out.println("run");
        }

        public void swim()
        {
            System.out.println("swim");
        }
    }

    public class Duck implements Fly, Run, Swim
    {
        public void fly()
        {
            System.out.println("fly");
        }

        public void run()
        {
            System.out.println("run");
        }

        public void swim()
        {
            System.out.println("swim");
        }
    }

    public class Penguin implements Run, Swim
    {
        public void run()
        {
            System.out.println("run");
        }

        public void swim()
        {
            System.out.println("swim");
        }
    }

    public class Airplane implements Run, Fly
    {
        public void run()
        {
            System.out.println("run");
        }

        public void fly()
        {
            System.out.println("fly");
        }

    }
}
