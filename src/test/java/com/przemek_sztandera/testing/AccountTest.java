package com.przemek_sztandera.testing;


import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumingThat;


class AccountTest {


    @Test
     void newlyCreatedAccountShouldNotBeActive() {
        // given
        // when
        Account newAccount = new Account();
        // then
        assertFalse(newAccount.isActive(), "Check if new account is not active");
        assertThat(newAccount.isActive(), equalTo(false));
        assertThat(newAccount.isActive(), is(false));
    }

    @Test
    void accountShouldBeActiveAfterActivation() {
        // given
        Account newAccount = new Account();

        // when
        newAccount.activate();

        // then
        assertTrue(newAccount.isActive());
        assertThat(newAccount.isActive(), is(true));
    }

    @Test
    void newlyCreatedAccountShouldNotHaveDefaultDeliveryAddressSet(){
        // given
        Account account = new Account();

        // when
        Address address = account.getDefaultDeliveryAddress();

        // then
        assertNull(address);
        assertThat(address, nullValue());
    }

    @Test
    void defaultDeliveryAddressShouldNotBeNullAfterBeingSet(){
        // given
        Address address = new Address("Wilcza", "6");
        Account account = new Account();
        account.setDefaultDeliveryAddress(address);
        // when
        Address address1 = account.getDefaultDeliveryAddress();

        // then
        assertNotNull(address1);
        assertThat(address1, is(notNullValue()));

    }

    @RepeatedTest(5)
    void newAccountWithNotNullAddressShouldBeActive() {
        // given
        Address address = new Address("Street", "66");

        // when
        Account account = new Account(address);

        // then
        assumingThat(address != null, () -> {
            assertTrue(account.isActive());
        });

    }
}
