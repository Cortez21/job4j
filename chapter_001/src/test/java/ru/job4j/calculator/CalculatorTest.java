package ru.job4j.calculator;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * Тест класса Calculator.
 * @author Maksim Yunusov (mailto:cortezzz1987@gmail.com).
 * @since 0.1.
 */
public class CalculatorTest {

    /**
     * Проверка метода сложения add.
     */
    @Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.add(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }

    /**
     * Тест метода вычитания substract.
     */
    @Test
    public void whenSubOneMinusOneThenZero() {
        Calculator calc = new Calculator();
        calc.substract(1D, 1D);
        double result = calc.getResult();
        double expected = 0D;
        assertThat(result, is(expected));
    }

    /**
     * Тест метода умножения div.
     */
    @Test
    public void whenDivTwoOnTwoThenFour() {
        Calculator calc = new Calculator();
        calc.div(2D, 2D);
        double result = calc.getResult();
        double expected = 4D;
        assertThat(result, is(expected));
    }

    /**
     * Тест метода деления multiple
     */
    @Test
    public void whenMultSixOnTwoThenThree() {
        Calculator calc = new Calculator();
        calc.multiple(6D, 2D);
        double result = calc.getResult();
        double expected = 3D;
        assertThat(result, is(expected));

    }
}
