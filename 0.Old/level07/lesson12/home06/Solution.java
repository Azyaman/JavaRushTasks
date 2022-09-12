package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        Human Grandf1 = new Human("Bob", true, 85, null, null);
        Human Grandf2 = new Human("Dave", true, 89, null, null);
        Human Grandm1 = new Human("Mary", false, 81, null, null);
        Human Grandm2 = new Human("Nikky", false, 83, null, null);
        Human Father = new Human("Rick", true, 45, Grandf1, Grandm1);
        Human Mother = new Human("Roxette", false, 42, Grandf2, Grandm2);
        Human Child1 = new Human("Maggy", false, 21, Father, Mother);
        Human Child2 = new Human("Rob", true, 23, Father, Mother);
        Human Child3 = new Human("Amy", false, 18, Father, Mother);
        System.out.println(Grandf1);
        System.out.println(Grandf2);
        System.out.println(Grandm1);
        System.out.println(Grandm2);
        System.out.println(Father);
        System.out.println(Mother);
        System.out.println(Child1);
        System.out.println(Child2);
        System.out.println(Child3);


    }

    public static class Human
    {
        //напишите тут ваш код
        private String name;
        private Boolean sex;
        private int age;
        private Human father;
        private Human mother;

        public Human (String name, boolean sex, int age, Human father, Human mother)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }


        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
