package com.przemek_sztandera.testing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test cases for Cart")
class CartTest {

//    @Disabled
    @DisplayName("Cart is able to process 1000 orders in 100ms.")
    @Test
    void simulateLargeOrder() {
        // given
        Cart cart = new Cart();

        // when
        // then
        assertTimeout(Duration.ofMillis(100), cart::simulateLargeOrder);
    }

    @Test
    void cartShouldNotBeEmptyAfterAddingOrder() {
        // given
        Meal meal = new Meal(5);
        Order order = new Order();
//        order.addMealToOrder(meal);
        Cart cart = new Cart();

        // when
        cart.addOrderToCart(order);

        // then
        assertThat(cart.getOrders(), anyOf(
                notNullValue(),
                hasSize(1),
                is(not(empty())),
                is(not(emptyCollectionOf(Order.class)))
        ));

        assertThat(cart.getOrders(), allOf(
                notNullValue(),
                hasSize(1),
                is(not(empty())),
                is(not(emptyCollectionOf(Order.class)))
        ));

        assertAll("This is a group of assertions for cart.",
                () -> assertThat(cart.getOrders(), notNullValue()),
                () -> assertThat(cart.getOrders(), hasSize(1)),
                () -> assertThat(cart.getOrders(), is(not(emptyCollectionOf(Order.class)))),
                () -> assertThat(cart.getOrders().get(0).getMeals(), empty()),
                () -> {
                    List<Meal> mealList = cart.getOrders().get(0).getMeals();
                    assertThat(mealList, empty());
                }
        );
    }
}