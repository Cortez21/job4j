package ru.job4j.calculator;

/**
 * Класс для основных подсчетов программы.
 * @autor Maksim Yunusov (mailto:cortezzz1987@gmail.com).
 * @since 0.1.
 */
public class Calculator {
    private double result = 0.0;

    /**
     * Метод для просчета сложения двух чисел.
     * @param first - первый агрумент в сложении.
     * @param second - второй агрумент в сложении.
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * Медот для вычитания.
     * @param first - первый агрумент в вычитании.
     * @param second - второй аргумент в вычитании.
     */
    public void substract(double first, double second) {
        this.result = first - second;
    }

    /**
     * Метод для вычисления умножения.
     * @param first - первый аргумент в умножении.
     * @param second - второй аргумент в умножении.
     */
    public void div(double first, double second) {
        this.result = first * second;
    }

    /**
     * Метод для вычисления операции деления двух чисел.
     * @param first - первое число в делении.
     * @param second - второе число в делении.
     */
    public void multiple(double first, double second) {
        this.result = first / second;
    }

    /**
     * Метод - геттер для возврата результатов операций над двумя числами.
     * @return - результат возвращаемый методом
     */
    public double getResult() {
        return this.result;
    }
}
