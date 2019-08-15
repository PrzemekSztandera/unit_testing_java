package com.przemek_sztandera.testing.order;

import com.przemek_sztandera.testing.Meal;
import org.junit.jupiter.api.*;

import java.io.FileNotFoundException;
import java.io.IOException;


class OrderBackupTest {

    private static OrderBackup orderBackup;

    @BeforeAll
    static void setUp() throws FileNotFoundException {
        orderBackup = new OrderBackup();
        orderBackup.createFile();
    }

    @AfterAll
    static void tearDown() throws IOException {
        orderBackup.closeFile();
    }

    @BeforeEach
    void appendTheStartOfTheLine() throws IOException {
        orderBackup.getWriter().append("New order: ");
    }

    @AfterEach
    void appendTheEndOfTheLine() throws IOException {
        orderBackup.getWriter().append(" backed up.");
    }


    @Tag("Fries")
    @Test
    void backUpOrderWithOneMeal () throws IOException {
        // given
        Meal meal = new Meal(10, "Fries");
        com.przemek_sztandera.testing.order.Order order = new com.przemek_sztandera.testing.order.Order();
        order.addMealToOrder(meal);

        // when
        orderBackup.backupOrder(order);

        // then
        System.out.println("Order: " + order.toString() + " backed up.");

    }
}