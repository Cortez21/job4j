package ru.job4j.coffeemachine;

import java.util.ArrayList;

/**
 * @author Maksim Yunusov (mailto:cortezzz1987@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class StartUI {
    ArrayList<Product> products = new ArrayList<>();


    public StartUI() {
        this.products.add(new Product("Espresso", 8));
        this.products.add(new Product("Americana", 11));
        this.products.add(new Product("Cappuccino", 14));
        this.products.add(new Product("Hot Chocolate", 17));
    }

    /**
     * Main method where UI communicate with a user
     */
    public void start(Input input, CashBack cashback) {

        System.out.println(new StringBuilder()
                .append("WELCOME TO THE COFFEE MACHINE")
                .append(System.lineSeparator())
                .append("Please read list of our products:")
                .toString()
        );
        boolean exit = false;
        while (!exit) {
            for (int i = 0; i < products.size(); i++) {
                System.out.println(
                        new StringBuilder()
                        .append(i)
                        .append(".")
                        .append(products.get(i).getName())
                        .append(" - ")
                        .append(products.get(i).getPrice())
                        .append(" dollars")
                );
            }

            Product choice = products.get(input.protectedRangeAsk("What do you prefer? Please enter number of product: ", products.size()));
            int money = input.protectedMoneyAsk("Please, insert money: ", choice.getPrice());

            ArrayList<Integer> result = cashback.action(money, choice);

            StringBuilder sb = new StringBuilder().append("Please, take your cash back: ");
            for (int value : result) {
                if (value != 0) {
                    sb.append(value).append(",");
                }
            }

            System.out.println(sb);

            if (input.ask("Do you want to exit? [1]= 'yes'") == 1) {
                exit = true;
            }

        }
    }

    public static void main(String[] args) {
        new StartUI().start(new Input(), new CashBack());
    }
}
