package com.javarush.task.task30.task3012;

/* 
Получи заданное число
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(74);
    }

    public void createExpression(int number) {
        //напишите тут ваш код
        StringBuilder str= new StringBuilder();
        str.append(number).append(" =");
        int i = 0;
        int ost = 0;
        do {
            ost = number % 3;
            number = number / 3;
            if (ost == 1) {
                str.append(" + ").append((int)(Math.pow(3, i)));
            }
            if (ost == 2) {
                str.append(" - ").append((int)(Math.pow(3, i)));
                number++;
            }
            i++;

        } while (number > 0);




        System.out.println(str);
    }
}