package com.przemek_sztandera.testing.order;

import com.przemek_sztandera.testing.Meal;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private OrderStatus orderStatus;
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

    public void changeOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
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
