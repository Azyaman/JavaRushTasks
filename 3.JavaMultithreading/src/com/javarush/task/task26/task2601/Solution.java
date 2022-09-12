package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Comparator;

/* 
Почитать в инете про медиану выборки
*/

public class Solution {

    public static void main(String[] args) {
/*        Integer[] array = new Integer[] {13, 8, 15, 5, 18};
        Integer[] sortArray = sort(array);
        for (int i : sortArray) {
            System.out.println(i);
        } */
    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        int mediana;
        Arrays.sort(array);
        if (array.length %2 != 0) {
            mediana = array[(array.length -1) /2];
        } else {
            mediana = ( array[array.length/2] + array[(array.length/2) - 1] ) / 2;
        }

        Arrays.sort(array, Comparator.comparingInt(o -> Math.abs(mediana - o)));

        return array;
    }
}
