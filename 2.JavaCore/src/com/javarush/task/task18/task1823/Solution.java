package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String name = reader.readLine();
            if (name.equals("exit")) {break;}
            else {new ReadThread(name).start();}
        }
        reader.close();
    }

    public static class ReadThread extends Thread {
        String fileName;
        public ReadThread(String fileName) {
            this.fileName = fileName;
            //implement constructor body
        }
        public void run() {
            try {
                FileInputStream inputStream = new FileInputStream(fileName);
                byte[] buffer = new byte[inputStream.available()];
                Map <Byte, Integer> map = new HashMap<>();
                inputStream.read(buffer);
                inputStream.close();
                for (int i = 0; i < buffer.length; i++) {
                    if (map.containsKey(buffer[i])) {map.put(buffer[i], map.get(buffer[i]) + 1);}
                    else {map.put(buffer[i], 1);}
                }
                int max = 0;
                for (Map.Entry <Byte, Integer> pair : map.entrySet()) {
                    if (pair.getValue() > max) {max = pair.getValue();}
                }
                for (Map.Entry <Byte, Integer> pair : map.entrySet()) {
                    if (pair.getValue() == max) {resultMap.put(fileName, (int)pair.getKey());}
                }


            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
        // implement file reading here - реализуйте чтение из файла тут
    }
}
