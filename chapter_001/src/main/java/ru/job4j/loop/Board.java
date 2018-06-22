package ru.job4j.loop;

/**
 * @author Maksim Yunusov (mailto:cortezzz1987@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Board {

    /**
     * Принимает значения высоты и ширины и на основе
     * этих аргументов строит шахматную доску соответствующих размеров.
     * @param width - параметр ширины.
     * @param height - параметр высоты.
     * @return - возвращает строки с псевдографической шахматной доской.
     */
    public String paint(int width, int height) {
        StringBuilder result = new StringBuilder("");
        for (int i = 0; i < height; i++) {
            for (int a = 0; a < width; a++) {
                if ((i + a) % 2 == 0) {
                    result.append("X");
                } else {
                    result.append(" ");
                }
            }
            result.append(System.getProperty("line.separator"));
        }
        return result.toString();
    }
}
