package com.javarush.task.task09.task0906;

/* 
Логирование стек-трейса
*/

public class Solution {
    public static void main(String[] args) {
        log("In main method");
    }

    public static void log(String text) {
        //напишите тут ваш код
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        int x = 0;
        for (StackTraceElement element : stackTraceElements) {
            x++;
            if (element.getMethodName().equals("log")) { break;}


        }
        System.out.println(stackTraceElements[x].getClassName() + ": " + stackTraceElements[x].getMethodName() + ": " + text);

    }
}
