package com.przemek_sztandera.testing;

import java.util.ArrayList;
import java.util.List;

class Order {

    private List<Meal> meals = new ArrayList<>();

    List<Meal> getMeals() {
        return meals;
    }

    void addMealToOrder(Meal meal) {
        this.meals.add(meal);
    }

    void removeMealFromOrder(Meal meal) {
        this.meals.remove(meal);
    }

    void cancel() {
        this.meals.clear();
    }

    @Override
    public String toString() {
        return "Order{" +
                "meals=" + meals +
                '}';
    }
}
