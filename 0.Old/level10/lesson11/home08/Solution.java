package com.javarush.test.level10.lesson11.home08;

import java.util.ArrayList;

/* Массив списков строк
Создать массив, элементами которого будут списки строк. Заполнить массив любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<String>[] arrayOfStringList =  createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList()
    {
        //напишите тут ваш код
        ArrayList<String>[] arrayOfStringList = new ArrayList[3];
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("fdg1kljfdklj");
        list1.add("sdfdklj2hdfk dfgdf");
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("djlksdfvsjkhv3gdfvjkh");
        list2.add("sdfjkldhdjkhdjhvf4dv");
        ArrayList<String> list3 = new ArrayList<>();
        list3.add("ddkjhsfkjfhdkjhg5jdkhvdjklfhv");
        list3.add("dsjklfhfdlkgjfd6jklhfvkjldhv");
        arrayOfStringList[0] = list1;
        arrayOfStringList[1] = list2;
        arrayOfStringList[2] = list3;


        return arrayOfStringList;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList)
    {
        for (ArrayList<String> list: arrayOfStringList)
        {
            for (String s : list)
            {
                System.out.println(s);
            }
        }
    }
}