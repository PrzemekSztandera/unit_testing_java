package com.przemek_sztandera.testing.account;

class Account {

    private boolean active;
    private Address defaultDeliveryAddress;
    private String email;
    private final String REGEX =
            "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";


    Account() {
        this.active = false;
    }

    public Account(Address defaultDeliveryAddress) {
        this.defaultDeliveryAddress = defaultDeliveryAddress;
        if(defaultDeliveryAddress != null) {
            activate();
        } else {
            this.active = false;
        }
    }

    void activate() {
        this.active = true;
    }

    boolean isActive() {
        return active;
    }

    public Address getDefaultDeliveryAddress() {
        return defaultDeliveryAddress;
    }

    public void setDefaultDeliveryAddress(Address defaultDeliveryAddress) {
        this.defaultDeliveryAddress = defaultDeliveryAddress;
    }

    public void setEmail(String email) {

        if(email.matches(REGEX)) {
            this.email = email;
        } else {
            throw new IllegalArgumentException();
        }

    }

    public String getEmail() {
        return email;
    }
}
