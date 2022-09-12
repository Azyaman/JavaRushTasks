package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();
        if (args.length > 0) {

            if (args[0].equals("-c")) {

                String productName = args[1];
                String price = args[2];
                String quantity = args[3];

                if (args[1].length() > 30) {
                    productName = args[1].substring(0, 30);
                } else {
                    for (int i = productName.length(); i < 30; i++) {
                        productName = productName + " ";
                    }
                }

                if (args[2].length() > 8) {
                    price = args[2].substring(0, 8);
                } else {
                    for (int i = price.length(); i < 8; i++) {
                        price = price + " ";
                    }
                }

                if (args[3].length() > 4) {
                    quantity = args[3].substring(0, 4);
                } else {
                    for (int i = quantity.length(); i < 4; i++) {
                        quantity = quantity + " ";
                    }
                }

                BufferedReader br = new BufferedReader(new FileReader(filename));
                String s;
                String d = null;
                ArrayList<Integer> IDs = new ArrayList<>();
                ArrayList<String> list = new ArrayList<>();
                int temp = 0;
                while ((s = br.readLine()) != null) {
                    if (s != null) {
                        list.add(s);
                        d = s.substring(0, 8);
                        d = d.replaceAll(" ", "");
                        temp = Integer.parseInt(d);
                        IDs.add(temp);
                    }
                }
                br.close();

                int max = 0;
                if (d == null) {
                    max = 1;
                }
                else {
                    max = IDs.get(0);
                    for (int i = 1; i < IDs.size(); i++) {
                        if (IDs.get(i) > max) {max = IDs.get(i);}
                    }
                }
                String id = String.valueOf(max + 1);
                if (id.length() < 8) {
                    for (int i = id.length(); i < 8; i++) {
                        id = id + " ";
                    }
                }
                String item = id + productName + price + quantity;
                list.add(item);

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
