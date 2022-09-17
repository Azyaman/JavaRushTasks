package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

public class Order {
    private final Tablet tablet;

    protected List<Dish> dishes;

    public Order (Tablet tablet) throws IOException {
        this.tablet = tablet;
        this.dishes = ConsoleHelper.getAllDishesForOrder();
    }

    public int getTotalCookingTime() {
        int totalCookingTime = 0;
        for (Dish orderDish : dishes) {
            totalCookingTime  += orderDish.getDuration();
        }
        return totalCookingTime;
    }

    public boolean isEmpty() {
        return !(dishes.size() > 0);
    }

    @Override
    public String toString() {
        if (dishes.isEmpty()) {
            return "";
        } else {
            return "Your order: " + dishes + " of " + tablet.toString() + ", cooking time "
                    + getTotalCookingTime() + "min";
        }
    }

}


