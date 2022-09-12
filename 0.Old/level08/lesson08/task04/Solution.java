package com.javarush.test.level08.lesson08.task04;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{

    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));

        //напишите тут ваш код
        map.put("Schwarzenegger", new Date("JULY 30 1947"));
        map.put("Statham", new Date("JULY 26 1967"));
        map.put("Van Damme", new Date("OCTOBER 18 1960"));
        map.put("Norris", new Date("MARCH 10 1940"));
        map.put("Willis", new Date("MARCH 19 1955"));
        map.put("Connery", new Date("AUGUST 25 1930"));
        map.put("Seagal", new Date("APRIL 10 1952"));
        map.put("Chan", new Date("APRIL 7 1954"));
        map.put("Ford", new Date("JULY 13 1942"));
        return map;

    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        //напишите тут ваш код
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();
        while (iterator.hasNext())
        {
            Map.Entry<String, Date> pair = iterator.next();
            Date value = pair.getValue();
            if (value.getMonth() > 4 & value.getMonth() < 8) iterator.remove();
        }

    }
}
