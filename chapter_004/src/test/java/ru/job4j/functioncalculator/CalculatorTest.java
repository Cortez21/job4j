package ru.job4j.functioncalculator;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.lang.Math.*;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class CalculatorTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        Calculator calculator = new Calculator();
        List<Double> result = calculator.calculate(5, 8, x -> Double.valueOf(2 * x + 1));
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        Calculator calculator = new Calculator();
        List<Double> result = calculator.calculate(5, 8, x -> pow(2 * x, 2) + (2 * 3) + 4);
        List<Double> expected = Arrays.asList(110D, 154D, 206D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLogarithmicFunctionThenLogarithmicResults() {
        Calculator calculator = new Calculator();
        List<Double> result = calculator.calculate(5, 8, x -> Double.valueOf(round(log(3D) * x)));
        List<Double> expected = Arrays.asList(5D, 7D, 8D);
        assertThat(result, is(expected));
    }

}
