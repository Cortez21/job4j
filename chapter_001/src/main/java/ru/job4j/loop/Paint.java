package ru.job4j.loop;

/**
 * @author Maksim Yunusov (mailto:cortezzz1987@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Paint {

    /**
     * Создает псевдографичесую пирамиду на основе заданной высоты и возвращает результат в виде строки.
     * @param height - заданная высота.
     * @return - результат в виде строки.
     */
    public String piramid(int height) {
        StringBuilder result = new StringBuilder();
        // На основе заданной высоты вычисляем ширину пирамиды.
        int weight = height * 2 - 1;
        // С помощью внешнего и вложенного циклов пробегаем по всем ячейкам конструкции.
        for (int rows = 0; rows < height; rows++) {
            for (int cols = 0; cols < weight; cols++) {
                // Условный оператор определят где заполнять ячейку, а где оставлять пустое место.
                if (cols > height - 2 - rows && cols < height + rows) {
                    result.append("^");
                } else {
                    result.append(" ");
                }
            }
            result.append(System.lineSeparator());
        }
        return result.toString();
    }
}
