package com.javarush.task.task18.task1813;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream  extends FileOutputStream {
    private FileOutputStream original;
    public AmigoOutputStream (FileOutputStream fileOutputStream) throws FileNotFoundException {
        super(fileName);
        this.original = fileOutputStream;
    }
    public static String fileName = "C:/Users/LohovRV/Desktop/result.txt";

    @Override
    public void write(int b) throws IOException {original.write(b);}

    @Override
    public void write(byte[] b) throws IOException {original.write(b);}

    @Override
    public void write(byte[] b, int off, int len) throws IOException {original.write(b, off, len);}

    @Override
    public void flush() throws IOException {original.flush();}

    @Override
    public void close() throws IOException {
        String text = "JavaRush © All rights reserved.";
        original.flush();
        original.write(text.getBytes());
        original.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

}
