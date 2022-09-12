package com.javarush.task.task25.task2512;

import java.util.LinkedList;
import java.util.List;

/* 
Живем своим умом
*/

public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        recurs(e);
    }

    public void recurs (Throwable e) {
        if (e.getCause() != null) {
            recurs(e.getCause());
        }
        System.out.println(e);
    }

    public static void main(String[] args) {
        Thread t = new Thread(new Runnable()
        {
            public void run(){
                System.out.println("Thread ...  стартовал");
                throw new RuntimeException("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")));

            }

        });

        t.setUncaughtExceptionHandler(new Solution());
        t.start();
    }
}
