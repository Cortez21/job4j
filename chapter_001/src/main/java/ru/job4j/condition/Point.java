package ru.job4j.condition;

/**
 * Класс Point инициализирует точку в системе координат и выполняет расчет до другой точки.
 * @author Maksim Yunusov (mailto:cortezzz1987@gmail.com).
 * @version $Id$.
 * @since 0.1
 */
public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Высчитывает расстояние между двумя точками в системе координат. Текущей (this.x, this.y)
     * и входящей (that.x, that.y) класса Point.
     * @param that - входящие данные типа Point.
     * @return - растояние между двумя точками.
     */
    public double distanceTo(Point that) {
        return Math.sqrt(
                Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2)
        );
    }
}
