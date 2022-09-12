package com.javarush.task.task30.task3008;

import java.io.*;
import java.net.SocketAddress;

public class ConsoleHelper {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() {
        String text = null;
        while (text == null) {
            try {
                text = bufferedReader.readLine();
            } catch (IOException e) {
                System.out.println("Произошла ошибка при попытке ввода текста.\nПопробуйте еще раз.");
            }
        }
        return text;
    }

    public static int readInt() {
        String text = null;
        int number = 0;
        while (text == null) {
            try {
                text = readString();
                number = Integer.parseInt(text);
            } catch (NumberFormatException e) {
                System.out.println("Произошла ошибка при попытке ввода числа.\nПопробуйте еще раз.");
                text = null;
            }
        }
        return number;
    }

}
