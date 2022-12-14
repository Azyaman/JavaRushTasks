package com.javarush.test.level09.lesson11.home09;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* Десять котов
Создать класс кот – Cat, с полем «имя» (String).
Создать словарь Map(<String, Cat>) и добавить туда 10 котов в виде «Имя»-«Кот».
Получить из Map множество(Set) всех имен и вывести его на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap()
    {
        //напишите тут ваш код
        HashMap<String, Cat> map = new HashMap<>();
        map.put("Vaska", new Cat("Vaska"));
        map.put("Musya", new Cat("Musya"));
        map.put("Boris", new Cat("Boris"));
        map.put("Murzik", new Cat("Murzik"));
        map.put("Murka", new Cat("Murka"));
        map.put("Lilu", new Cat("Lilu"));
        map.put("Vitya", new Cat("Vitya"));
        map.put("Mitya", new Cat("Mitya"));
        map.put("Olya", new Cat("Olya"));
        map.put("Tuzik", new Cat("Tuzik"));
        return map;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map)
    {
        //напишите тут ваш код
        HashSet<Cat> set = new HashSet<>();
        for (Map.Entry<String, Cat> pair : map.entrySet()) set.add(pair.getValue());
        return set;
    }

    public static void printCatSet(Set<Cat> set)
    {
        for (Cat cat:set)
        {
            System.out.println(cat);
        }
    }

    public static class Cat
    {
        private String name;

        public Cat(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return "Cat "+this.name;
        }
    }


}
