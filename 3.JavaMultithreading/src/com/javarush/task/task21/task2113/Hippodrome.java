package com.javarush.task.task21.task2113;


import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses = new ArrayList<>();
    public List getHorses() {
        return horses;
    }

    public Hippodrome(List<Horse> list) {
        this.horses = list;
    }

    public static Hippodrome game;

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            this.move();
            this.print();
            Thread.sleep(100);
        }
    }

    public void move() {
        for (int i = 0; i < horses.size(); i++) {
            horses.get(i).move();
        }
    }

    public void print() {
        for (int i = 0; i < horses.size(); i++) {
            horses.get(i).print();
        }
        for (int i = 0; i < 10; i++) {
           System.out.println();
        }
   }

    public Horse getWinner() {
        double maxDistance = 0.0;
        Horse winner = null;
        for (int i = 0; i < horses.size(); i++) {
             if (horses.get(i).getDistance() > maxDistance) {
                 maxDistance = horses.get(i).getDistance();
                 winner = horses.get(i);
             }
        }
        return winner;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }


    public static void main(String[] args) throws InterruptedException {

        game = new Hippodrome(new ArrayList<Horse>());
        Horse horse1 = new Horse("One", 3, 0);
        Horse horse2 = new Horse("Two", 3, 0);
        Horse horse3 = new Horse("Three",  3, 0);
        game.getHorses().add(horse1);
        game.getHorses().add(horse2);
        game.getHorses().add(horse3);
        game.run();
        game.printWinner();
    }
}
