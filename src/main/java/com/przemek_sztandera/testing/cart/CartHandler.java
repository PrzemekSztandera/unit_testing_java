package com.przemek_sztandera.testing.cart;

public interface CartHandler {
    boolean canHandleCart(Cart cart);
    void sendToPrepare(Cart cart);
    default boolean isDeliveryFree(Cart cart) {
        return cart.getOrders().size() > 2;
    }
}
