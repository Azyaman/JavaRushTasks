package com.javarush.task.task22.task2212;

import java.util.Arrays;

/*
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber (String telNumber) {
        if ( (telNumber == null) || (telNumber.isEmpty()) ) { return false;}
        int dlina = telNumber.replaceAll("\\D", "").length();
        return telNumber.matches("^\\+?\\d+(\\(\\d{3}\\))?\\d+-?\\d+-?\\d+$") && (dlina == 12 || dlina == 10);
    }

    public static void main(String[] args) {
        System.out.println("+380501234567 - true -> " + checkTelNumber("+380501234567"));
        System.out.println("+38(050)1234567 - true -> " + checkTelNumber("+38(050)1234567"));
        System.out.println("+38050123-45-67 - true -> " + checkTelNumber("+38050123-45-67"));
        System.out.println("050123-4567 - true -> " + checkTelNumber("050123-4567"));
        System.out.println("+38)050(1234567 - false -> " + checkTelNumber("+38)050(1234567"));
        System.out.println("+38(050)1-23-45-6-7 - false -> " + checkTelNumber("+38(050)1-23-45-6-7"));
        System.out.println("050ххх4567 - false -> " + checkTelNumber("050ххх4567"));
        System.out.println("050123456 - false -> " + checkTelNumber("050123456"));
        System.out.println("(0)501234567 - false -> " + checkTelNumber("(0)501234567"));

    }
}
