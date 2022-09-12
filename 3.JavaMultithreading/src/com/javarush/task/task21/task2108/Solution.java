package com.javarush.task.task21.task2108;

/* 
Клонирование растений
*/
public class Solution {
    public static void main(String[] args) {
        Tree tree = new Tree("willow", new String[]{"s1", "s2", "s3", "s4"});
        Tree clone = null;
        try {
            clone = tree.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(tree);
        System.out.println(clone);

        System.out.println(tree.branches);
        System.out.println(clone.branches);
    }

    public static class Plant {
        private String name;

        public Plant(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static class Tree extends Plant implements Cloneable {
        private String[] branches;

        public Tree(String name, String[] branches) {
            super(name);
            this.branches = branches;
        }

        public String[] getBranches() {
            return branches;
        }

        protected Tree clone() throws CloneNotSupportedException {
            Tree clone = new Tree(this.getName(), this.branches.clone() );
            return clone;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Tree)) return false;
            Tree tree = (Tree) obj;
            if (getName() != tree.getName()) return false;
            return branches != null ? branches.equals(tree.getBranches()) : tree.getBranches() == null;
        }

        @Override
        public int hashCode() {
            int result = getName().hashCode();
            result = 31 * result + (branches != null ? branches.hashCode() : 0);
            return result;
        }
    }
}
