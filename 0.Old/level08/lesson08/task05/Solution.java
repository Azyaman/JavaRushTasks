package com.javarush.test.level08.lesson08.task05;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
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

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        //напишите тут ваш код

        HashMap<String, String> copy = new HashMap<>(map);
        HashMap<String, String> copy2 = new HashMap<>(map);
        Iterator<Map.Entry<String, String>> iterator = copy.entrySet().iterator();
        while (iterator.hasNext())
        {
            int i = 0;
            Map.Entry<String, String> pair = iterator.next();
            Iterator<Map.Entry<String, String>> iterator2 = copy2.entrySet().iterator();
            while (iterator2.hasNext())
            {
                Map.Entry<String, String> pair2 = iterator2.next();
                if (pair2.getValue().equals(pair.getValue()))
                {
                    if (i != 0)
                    {
                        System.out.println(pair2.getValue());
                        removeItemFromMapByValue(map, pair2.getValue());
                    }
                    else
                    {
                        i++;
                    }
                }
            }
        }

    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
}
