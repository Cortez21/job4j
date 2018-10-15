package ru.job4j.tracker;

import java.util.Scanner;

public class ConsoleInput {
    private Scanner scan = new Scanner(System.in);
    public String ask(String question) {
        System.out.print(question);
        return scan.nextLine();
    }
}
