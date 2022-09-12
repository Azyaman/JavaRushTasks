package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream console = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        String result = outputStream.toString();
        System.setOut(console);
        String[] res = result.split(" ");
        int itog = 0;
        if (res[1].equals("+")) {
            itog = Integer.parseInt(res[0]) + Integer.parseInt(res[2]);
            result = res[0] + " + " + res[2] + " = " + itog;
        }
        else if (res[1].equals("-")) {
            itog = Integer.parseInt(res[0]) - Integer.parseInt(res[2]);
            result = res[0] + " - " + res[2] + " = " + itog;
        }
        else if (res[1].equals("*")) {
            itog = Integer.parseInt(res[0]) * Integer.parseInt(res[2]);
            result = res[0] + " * " + res[2] + " = " + itog;
        }
        System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

