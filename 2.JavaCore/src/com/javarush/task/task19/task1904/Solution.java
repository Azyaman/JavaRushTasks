package com.javarush.task.task19.task1904;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        String file = "C://Users//LohovRV//Desktop//data.txt";
        Scanner in = new Scanner(new File(file));
        PersonScannerAdapter psd = new PersonScannerAdapter(in);
        System.out.println(psd.read());
        psd.close();

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private final Scanner fileScanner;
        PersonScannerAdapter (Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        public Person read() throws IOException {
            if (fileScanner.hasNext()) {
                String str = fileScanner.nextLine();
                String[] arr = str.split(" ");
                String dat = arr[3] + " " + arr[4] + " " + arr[5];
                SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");
                Date date = null;
                try { date = sdf.parse(dat); }
                catch (ParseException e) {System.out.println(e.getMessage());}
                Person person = new Person(arr[1], arr[2], arr[0], date);
                return person;
            }
            return null;
        }

        public void close() throws IOException {
            this.fileScanner.close();
        }
    }
}
