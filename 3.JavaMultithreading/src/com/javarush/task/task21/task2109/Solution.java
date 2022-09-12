package com.javarush.task.task21.task2109;

import java.util.Objects;

/*
Запретить клонирование
*/
public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        protected A clone() throws CloneNotSupportedException{
            int i = this.i;
            int j = this.j;
            A a = new A (i ,j);
            return a;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof A)) return false;
            A a = (A) obj;
            return getI() == a.getI() && getJ() == a.getJ();
        }

        @Override
        public int hashCode() {
            int result = getI();
            result = 31 * result + getJ();
            return result;
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }
        public String getName() {
            return name;
        }

        protected B clone() throws CloneNotSupportedException{
            throw new CloneNotSupportedException();
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof B)) return false;
            B b = (B) obj;
            if (getName() != b.getName()) return false;
            return getI() == b.getI() && getJ() == b.getJ();
        }

        @Override
        public int hashCode() {
            int result = getI();
            result = 31 * result + getJ() + (name != null ? name.hashCode() : 0);
            return result;
        }

    }

    public static class C extends B {
        public C(int i, int j, String name) {
            super(i, j, name);
        }

        protected C clone() throws CloneNotSupportedException {
            C clone = new C (this.getI(), this.getJ(), this.getName());
            return clone;
        }

    }

    public static void main(String[] args) {

    }
}
