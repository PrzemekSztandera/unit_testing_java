package com.przemek_sztandera.testing;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void testAssertArrayEquals() {
        // given
        int[] ints1 = {1, 2, 3};
        int[] ints2 = {1, 2, 3};

        // then
        assertArrayEquals(ints1, ints2);
    }

    @Test
    void mealListShouldBeEmptyAfterCreationOfOrder() {
        // given
        Order order = new Order();
        List<Meal> list = order.getMeals();

        // then
        assertThat(list, is(empty()));
        assertThat(list.size(), equalTo(0));
        assertThat(list, hasSize(0));
        assertThat(list, emptyCollectionOf(Meal.class));
    }

    @Test
    void addingMealToOrderShouldIncreaseOrderSize() {
        // given
        Order order = new Order();
        Meal meal = new Meal(10, "pizza");

        // when
        order.addMealToOrder(meal);

        // then
        assertThat(order.getMeals(), hasSize(1));
        assertThat(order.getMeals(), contains(meal));
        assertThat(order.getMeals(), hasItem(meal));
        assertThat(order.getMeals().get(0).getPrice(), equalTo(10));
    }

    @Test
    void removingMealFromOrderShouldDecreaseOrderSize(){
        // given
        Order order = new Order();
        Meal meal = new Meal(10, "pizza");

        // when
        order.addMealToOrder(meal);
        order.removeMealFromOrder(meal);

        // then
        assertThat(order.getMeals(), hasSize(0));
        assertThat(order.getMeals(), not(contains(meal)));
    }

    @Test
    void mealsShouldBeInCorrectOrderAfterAddingThemToOrder() {
        // given
        Order order = new Order();
        Meal meal1 = new Meal(10, "pizza");
        Meal meal2 = new Meal(5, "burger");

        // when
        order.addMealToOrder(meal1);
        order.addMealToOrder(meal2);

        // then
        assertThat(order.getMeals(), contains(meal1, meal2));
    }

    @Test
    void testIfTwoMealListAreTheSame() {
        // given
        Meal meal1 = new Meal(10, "pizza");
        Meal meal2 = new Meal(5, "burger");
        Meal meal3 = new Meal(8, "kebab");

        List<Meal> list1 = Arrays.asList(meal1, meal2);
        List<Meal> list2 = Arrays.asList(meal1, meal2);

        // then
        assertThat(list1, is(list2));
    }
}