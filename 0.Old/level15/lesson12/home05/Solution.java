package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution
{
    public Solution(double a) {}
    public Solution(String a) {}
    public Solution(int a) {}

    protected Solution(Byte a) {}
    protected Solution(Boolean a) {}
    protected Solution(Integer a) {}

    private Solution(Short a) {}
    private Solution(Double a) {}
    private Solution(Character a) {}

    Solution(double a, int b) {}
    Solution(String a, int b) {}
    Solution(int a, int b) {}


}

