package com.javarush.test.level12.lesson12.home06;

/* Fly, Run, Climb для классов Cat, Dog, Tiger, Duck
1. Внутри класса Solution создай интерфейс public interface Fly(летать) с методом void fly().
2. Внутри класса Solution создай интерфейс public interface Climb(лазить по деревьям) с методом void climb().
3. Внутри класса Solution создай интерфейс public interface Run(бегать) с методом void run().
4. Подумай логически, какие именно интерфейсы нужно добавить для каждого класса.
5. Добавь интерфейсы классам Cat(кот), Dog(собака), Tiger(тигр), Duck(Утка).
*/

public class Solution
{
    public interface Fly
    {
        public void fly();
    }

    public interface Climb
    {
        public void climb();
    }

    public interface Run
    {
        public void run();
    }


    public class Cat implements Climb, Run
    {
        public void climb()
        {
            int a;
        }

        public void run()
        {
            int a;
        }

    }

    public class Dog implements Run
    {
        public void run()
        {
            int a;
        }

    }

    public class Tiger extends Cat implements Climb, Run
    {
        public void climb()
        {
            int a;
        }

        public void run()
        {
            int a;
        }
    }

    public class Duck implements Fly, Run
    {
        public void fly()
        {
            int a;
        }

        public void run()
        {
            int a;
        }

    }
}
