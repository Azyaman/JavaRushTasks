package com.javarush.test.level12.lesson12.home07;

/* Fly, Run, Swim для классов Duck, Penguin, Toad
Есть интерфейсы Fly(летать), Swim(плавать), Run(бегать).
Добавь эти интерфейсы классам Duck(утка), Penguin(пингвин), Toad(жаба)
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

    public class Duck implements Fly, Run, Swim
    {
        public void fly() {int a;}
        public void run() {int a;}
        public void swim() {int a;}
    }

    public class Penguin implements Run, Swim
    {
        public void run() {int a;}
        public void swim() {int a;}
    }

    public class Toad implements Swim
    {
        public void swim() {int a;}
    }
}
