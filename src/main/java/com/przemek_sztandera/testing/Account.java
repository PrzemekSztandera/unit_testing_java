package com.przemek_sztandera.testing;

class Account {

    private boolean active;

    Account() {
        this.active = false;
    }

    void activate() {
        this.active = true;
    }

    boolean isActive() {
        return active;
    }
}
