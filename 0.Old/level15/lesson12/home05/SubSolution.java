package com.javarush.test.level15.lesson12.home05;


public class SubSolution extends Solution
{

    public SubSolution(double a) {super(a);}
    public SubSolution(String a) {super(a);}
    public SubSolution(int a) {super(a);}

    protected SubSolution(Byte a) {super(a);}
    protected SubSolution(Boolean a) {super(a);}
    protected SubSolution(Integer a) {super(a);}

    private SubSolution(Short a) {super(a);}
    private SubSolution(Double a) {super(a);}
    private SubSolution(Character a) {super(a);}

    SubSolution(double a, int b) {super(a, b);}
    SubSolution(String a, int b) {super(a, b);}
    SubSolution(int a, int b) {super(a, b);}


}
