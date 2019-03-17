package ru.job4j.bank;

/**
 * @author Maksim Yunusov (mailto:cortezzz1987@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Account {
    private int balance = 0;
    private final String requisites;

    public Account(String requisites) {
        this.requisites = requisites;
    }

    public int getBalance() {
        return balance;
    }

    public String getRequisites() {
        return requisites;
    }

    /**
     * Decreasing money on entered sum
     * @param value
     * @return answer about successful of this operation
     */
    public boolean getMoney(double value) {
        boolean result = false;
        if (value <= balance) {
            balance -= value;
            result = true;
        }
        return result;
    }

    public void putMoney(double value) {
        balance += value;
    }
}
