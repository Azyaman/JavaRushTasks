package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        try {
            if (string == null || string.isEmpty() || !string.contains(" ")) throw new RuntimeException();
            int start = string.indexOf(" ");
            int j = 1;
            int ind = start;
            int count;
            while ((count = string.indexOf(" ", ind + 1)) != -1) {
                j++;
                ind = count;
                if (j == 5) return string.substring(start + 1, count);
            }
            if (j < 4) throw new RuntimeException();
            else {
            return string.substring(start + 1); }
        }
        catch (RuntimeException e) {throw new TooShortStringException();}
    }


    public static class TooShortStringException extends RuntimeException{
    }
}
