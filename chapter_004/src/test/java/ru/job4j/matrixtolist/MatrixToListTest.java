package ru.job4j.matrixtolist;

import com.sun.tools.javac.util.List;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MatrixToListTest {
    @Test
    public void whenMatrixConvertToList() {
        MatrixToList matrixToList = new MatrixToList();
        assertThat(matrixToList.convert(new int[][] {{1, 2}, {3, 4}, {5, 6}}), is(List.of(1, 2, 3, 4, 5, 6)));
    }
}
