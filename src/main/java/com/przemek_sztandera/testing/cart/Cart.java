package com.przemek_sztandera.testing.cart;

import com.przemek_sztandera.testing.Meal;
import com.przemek_sztandera.testing.order.Order;

import java.util.ArrayList;
import java.util.List;

class Cart {

    private List<Order> orders = new ArrayList<>();

    public List<Order> getOrders() {
        return orders;
    }

    void addOrderToCart(Order order) {
        this.orders.add(order);
    }

    void clearCart() {
        this.orders.clear();
    }

    void simulateLargeOrder() {
        for(int i= 0; i < 1_000; i++) {
            Meal meal = new Meal(10, "hamburger");
            Order order = new Order();
            order.addMealToOrder(meal);
            addOrderToCart(order);
        }
        System.out.println("Cart size: " + orders.size());
        clearCart();

    }
}
