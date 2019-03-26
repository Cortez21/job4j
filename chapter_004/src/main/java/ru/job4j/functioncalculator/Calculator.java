package ru.job4j.functioncalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Calculator {
    public List<Double> calculate(int start, int finish, Function<Integer, Double> function) {
        List<Double> values = new ArrayList<>();
        for (int index = start; index < finish; index++) {
            values.add(Double.valueOf(function.apply(index)));
        }
        return values;
    }
}
