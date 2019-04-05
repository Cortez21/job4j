package ru.job4j.matrixtolist;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MatrixToList {
    public List<Integer> convert(int[][] matrix) {

        return Arrays.stream(matrix)
                .flatMap(e -> Arrays.stream(e).boxed())
                .collect(Collectors.toList());
    }
}
