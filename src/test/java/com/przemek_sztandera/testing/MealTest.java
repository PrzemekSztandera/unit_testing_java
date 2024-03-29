package com.przemek_sztandera.testing;

import com.przemek_sztandera.testing.extension.IAExceptionIgnoreExtension;
import com.przemek_sztandera.testing.order.Order;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;


class MealTest {

    @Test
    void shouldReturnDiscountedPrice() {
        // given
        Meal meal = new Meal(35);

        // when
        int discountedPrice = meal.getDiscountedPrice(7);

        // then
        assertEquals(28, discountedPrice);
        assertThat(discountedPrice, is(equalTo(28)));
    }

    @Test
    void referencesToTheSameObjectShouldBeEqual() {
        // given
        Meal meal1 = new Meal(35);
        Meal meal2 = meal1;

        // then
        assertSame(meal1, meal2);
        assertThat(meal1, is(sameInstance(meal2)));
    }

    @Test
    void referencesToDifferentObjectShouldNotBeEqual() {
        // given
        Meal meal1 = new Meal(35);
        Meal meal2 = new Meal(35);

        // then
        assertNotSame(meal1, meal2);
        assertThat(meal1, is(not(sameInstance(meal2))));
    }

    @Test
    void twoMealsShouldBeEqualWhenPriceAndNameAreTheSame() {
        // given
        Meal meal1 = new Meal(15, "pizza");
        Meal meal2 = new Meal(15, "pizza");

        // then
        assertEquals(meal1, meal2);
    }

    @Test
    void exceptionShouldBeThrownIfDiscountIsHigherThanThePrice() {
        // given
        Meal meal = new Meal(20);

        // when
        // then
        assertThrows(IllegalArgumentException.class, () -> meal.getDiscountedPrice(30));
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 10, 15, 18})
    void mealPricesShouldBeLowerThan20(int price) {
        assertThat(price, lessThan(20));
    }

    @ParameterizedTest
    @MethodSource("createMealsWithNameAndPrice")
    void burgersShouldHaveCorrectNameAndPrice(String name, int price) {
        assertThat(name, containsString("burger"));
        assertThat(price, greaterThanOrEqualTo(10));
    }

    private static Stream<Arguments> createMealsWithNameAndPrice() {
        return Stream.of(
                Arguments.of("Hamburger", 10),
                Arguments.of("Cheeseburger", 12)
        );
    }

    @ParameterizedTest
    @MethodSource("createCakeNames")
    void cakeNamesShouldEndWithCake(String name) {
        assertThat(name, notNullValue());
        assertThat(name, endsWith("cake"));
    }

    private static Stream<String> createCakeNames() {
        List<String> cakeNames = Arrays.asList("cheesecake", "fruitcake", "cupcake");
        return cakeNames.stream();
    }

    @ExtendWith(IAExceptionIgnoreExtension.class)
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 8})
    void mealPricesShouldBeLowerThan10(int price) {
        if(price > 5) {
            throw new IllegalArgumentException();
        }
        assertThat(price, lessThan(20));
    }

    @Tag("Fries")
    @TestFactory
    Collection<DynamicTest> calculateMealPrices() {
        Order order = new Order();
        order.addMealToOrder(new Meal(10, 2, "Hamburger"));
        order.addMealToOrder(new Meal(7, 4, "Fries"));
        order.addMealToOrder(new Meal(22, 3, "Pizza"));

        Collection<DynamicTest> dynamicTests = new ArrayList<>();

        for(int i = 0; i < order.getMeals().size(); i++) {
            int price = order.getMeals().get(i).getPrice();
            int quantity = order.getMeals().get(i).getQuantity();

            Executable executable = () -> {
                assertThat(calculatePrice(price, quantity), lessThan(67));
            };

            String name = "Test name: " + i;
            DynamicTest dynamicTest = DynamicTest.dynamicTest(name, executable);
            dynamicTests.add(dynamicTest);
        }

        return dynamicTests;
    }

    @Disabled
    @Test
    void testMealSumPrice() {
        // given
        Meal meal = mock(Meal.class);

        given(meal.getPrice()).willReturn(15);
        given(meal.getQuantity()).willReturn(3);
        given(meal.sumPrice()).willCallRealMethod();

        // when
        int result = meal.sumPrice();

        // then
        assertThat(result, is(equalTo(45)));

    }

    private int calculatePrice(int price, int quantity) {
        return price * quantity;
    }
}