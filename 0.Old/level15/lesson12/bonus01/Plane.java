package com.javarush.test.level15.lesson12.bonus01;


public class Plane implements Flyable
{
    public void fly() {}
    int capacity;

    public Plane(int capacity)
    {
        this.capacity = capacity;
    }

}
