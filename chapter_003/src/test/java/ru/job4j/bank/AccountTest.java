package ru.job4j.bank;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AccountTest {
    @Test
    public void whenEnoughMoney() {
        Account account = new Account("09890");
        account.putMoney(500);
        assertThat(account.getMoney(500), is(true));
    }

    @Test
    public void whenNotEnoughMoney() {
        Account account = new Account("09890");
        account.putMoney(250);
        assertThat(account.getMoney(500), is(false));
    }
}
