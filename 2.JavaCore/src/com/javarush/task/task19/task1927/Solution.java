package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        String ad = "JavaRush - курсы Java онлайн";
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream newStream = new PrintStream(outputStream);
        System.setOut(newStream);
        testString.printSomething();
        String[] result = outputStream.toString().split("\n");
        int adClock = 0;
        String str = "";
        for (int i = 0; i < result.length; i++) {
            str += result[i] + System.lineSeparator();
            adClock++;
            if (adClock == 2) {
                str += ad + System.lineSeparator();
                adClock = 0;
            }
        }
        System.setOut(consoleStream);
        System.out.println(str);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
