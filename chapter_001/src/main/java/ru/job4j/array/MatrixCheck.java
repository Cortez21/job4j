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
        if (data[0][0] != data[0][data.length - 1]) {
            result = false;
        }
        for (int i = 0; i < data.length - 1; i++) {
            if (data[i][i] != data[i + 1][i + 1]) {
                result = false;
            }
            if (data[i][data.length - 1 - i] != data[i + 1][data.length - 2 - i]) {
                result = false;
            }

        }
        return result;
    }
}
