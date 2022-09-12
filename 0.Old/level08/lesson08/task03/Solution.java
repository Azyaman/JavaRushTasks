package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;


/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<>();
        map.put("Иванов", "Иван");
        map.put("Петров", "Петр");
        map.put("Сидоров", "Федов");
        map.put("Федоров", "Илья");
        map.put("Алексеев", "Алексей");
        map.put("Корнев", "Роман");
        map.put("Хомяков", "Иван");
        map.put("Пупкин", "Сергей");
        map.put("Денисов", "Игорь");
        map.put("Петухов", "Артем");
        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        //напишите тут ваш код
        int count = 0;
        for (String item : map.values())
        {
            if (name.equals(item)) count++;
        }
        return count;


    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName)
    {
        //напишите тут ваш код
        return map.containsKey(lastName) ? 1 : 0;

    }
}
