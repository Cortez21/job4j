package ru.job4j.coffeemachine;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CashBackTest {
    @Test
    public void whenTakeCappuccinoAndInsert100Dollars() {
        CashBack cashBack = new CashBack();
        Product cappuccino = new Product("Cappuccino", 14);
        ArrayList<Integer> expectBanknotes = new ArrayList<>();
        expectBanknotes.add(50);
        expectBanknotes.add(20);
        expectBanknotes.add(10);
        expectBanknotes.add(5);
        expectBanknotes.add(1);
        ArrayList<Integer> result = cashBack.action(100, cappuccino);
        assertThat(result, is(expectBanknotes));
    }


}
