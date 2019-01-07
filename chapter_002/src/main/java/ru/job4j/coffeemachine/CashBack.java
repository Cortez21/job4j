package ru.job4j.coffeemachine;

import java.util.ArrayList;

/**
 * @author Maksim Yunusov (mailto:cortezzz1987@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class CashBack {

    /**
     * The array with all banknotes which we have for cash back
     */
    private final int[] banknotes = new int[] {200, 100, 50, 20, 10, 5, 2, 1};


    /**
     * Calculating how much money and what banknotes we will return
     * @param sum - What banknote we take from user
     * @param product - product which user orders
     * @return array of banknotes for cash back
     */
    public ArrayList<Integer> action(int sum, Product product) {
        ArrayList<Integer> cashback = new ArrayList<>();
        sum -= product.getPrice();
        int value;
        for (int banknote : banknotes) {
            value = sum / banknote;
            for (int i = 0; i < value; i++) {
                cashback.add(banknote);
            }
            sum %= banknote;
        }
        return cashback;
    }
}
