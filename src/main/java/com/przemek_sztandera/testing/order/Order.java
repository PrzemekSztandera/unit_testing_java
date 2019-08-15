package com.przemek_sztandera.testing.order;

import com.przemek_sztandera.testing.Meal;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<Meal> meals = new ArrayList<>();

    public List<Meal> getMeals() {
        return meals;
    }

    public void addMealToOrder(Meal meal) {
        this.meals.add(meal);
    }

    void removeMealFromOrder(Meal meal) {
        this.meals.remove(meal);
    }

    void cancel() {
        this.meals.clear();
    }

    int totalPrice() {
       return this.meals.stream().mapToInt(meal -> meal.getPrice()).sum();
    }

    @Override
    public String toString() {
        return "Order{" +
                "meals=" + meals +
                '}';
    }
}
