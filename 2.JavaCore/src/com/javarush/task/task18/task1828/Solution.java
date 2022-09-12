package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();

        if (args.length > 0) {

            if (args[0].equals("-u")) {

                String id = args[1];
                String productName = args[2];
                String price = args[3];
                String quantity = args[4];



                if (args[1].length() > 8) {
                    id = args[1].substring(0, 8);
                } else {
                    for (int i = id.length(); i < 8; i++) {
                        id = id + " ";
                    }
                }

                if (args[2].length() > 30) {
                    productName = args[2].substring(0, 30);
                } else {
                    for (int i = productName.length(); i < 30; i++) {
                        productName = productName + " ";
                    }
                }

                if (args[3].length() > 8) {
                    price = args[3].substring(0, 8);
                } else {
                    for (int i = price.length(); i < 8; i++) {
                        price = price + " ";
                    }
                }

                if (args[4].length() > 4) {
                    quantity = args[4].substring(0, 4);
                } else {
                    for (int i = quantity.length(); i < 4; i++) {
                        quantity = quantity + " ";
                    }
                }

                BufferedReader br = new BufferedReader(new FileReader(filename));
                String s;
                String d = null;
                ArrayList<String> list = new ArrayList<>();
                while ((s = br.readLine()) != null) {
                    if (s != null) {
                        d = s.substring(0, 8);
                        if (id.equals(d)) {
                            String item = id + productName + price + quantity;
                            list.add(item);
                        }
                        else {
                            list.add(s);
                        }
                    }
                }
                br.close();

                BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
                for (int i = 0; i < list.size(); i++) {
                    writer.write(list.get(i));
                    writer.newLine();
                }
                writer.close();
            }

            if (args[0].equals("-d")) {

                String id = args[1];

                if (args[1].length() > 8) {
                    id = args[1].substring(0, 8);
                } else {
                    for (int i = id.length(); i < 8; i++) {
                        id = id + " ";
                    }
                }

                BufferedReader br = new BufferedReader(new FileReader(filename));
                String s;
                String d = null;
                ArrayList<String> list = new ArrayList<>();
                while ((s = br.readLine()) != null) {
                    if (s != null) {
                        d = s.substring(0, 8);
                        if (id.equals(d)) {
                            continue;
                        }
                        else {
                            list.add(s);
                        }
                    }
                }
                br.close();

                BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
                for (int i = 0; i < list.size(); i++) {
                    writer.write(list.get(i));
                    writer.newLine();
                }
                writer.close();

            }
        }
    }
}
