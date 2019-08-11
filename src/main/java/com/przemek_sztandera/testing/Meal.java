package com.przemek_sztandera.testing;

public class Meal {

    private int price;
    private int quantity;
    private String name;

    public Meal(int price, int quantity, String name) {
        this.price = price;
        this.quantity = quantity;
        this.name = name;
    }

    Meal(int price, String name) {
        this.price = price;
        this.name = name;
    }

    Meal(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    int getPrice() {
        return price;
    }

    int getDiscountedPrice(int discount) {
        if(discount > price) {
            throw new IllegalArgumentException("Discount can not be higher than the price!");
        }
        return price - discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Meal meal = (Meal) o;

        if (price != meal.price) return false;
        return name != null ? name.equals(meal.name) : meal.name == null;
    }

    @Override
    public int hashCode() {
        int result = price;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}
