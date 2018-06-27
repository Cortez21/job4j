package ru.job4j.array;
/**
 * @author Maksim Yunusov (mailto:cortezzz1987@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class MatrixCheck {
    /**
     * Провряет входящий массив на равность его ячеек по диагонали.
     * @param data проверяемый массив.
     * @return - если условие истинно - возвращает true.
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        for (int i = 0; i < data.length - 1; i++) {
            for (int a = 0; a < data.length - 1; a++) {
                if (data[i][a] != data[i + 1][a + 1]) {
                    result = false;
                }
            }
        }

        return result;
    }
}
