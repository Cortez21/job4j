package ru.job4j.condition;

/**
 * @author Maksim Yunusov (mailto:cortezzz1987@gmail.com).
 * @version $Id$.
 * @since 0.1
 */
public class Triangle {

    private Point a;
    private Point b;
    private Point c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Метод, который вычисляет значение полупериметра по формуле Герона.
     * @param ab - Длинна первой стороны.
     * @param ac - длинна второй.
     * @param bc - длинна третьей стороны.
     * @return - возвращает значение полупериметра.
     */
    public double period(double ab, double ac, double bc) {
        return (ab + ac + bc) / 2;
    }

    /**
     * Метод, который вычисляет площадь треугольника по теореме Герона. Принимает значение полупериметра
     * от метода period.
     * @return - площадь треугольника.
     */
    public double area() {
        double result = -1;
        double ab = this.a.distanceTo(this.b);
        double ac = this.a.distanceTo(this.c);
        double bc = this.b.distanceTo(this.c);
        double p = period(ab, ac, bc);
        if (this.exist(ab, ac, bc)) {
            result = Math.sqrt(
                    p * (p - ab) * (p - ac) * (p - bc)
            );
        }
        return result;
    }

    /**
     * Вычисляет возможность существования треугольника по данным всех сторон.
     * @param ab - первая сторона.
     * @param ac - вторая сторона.
     * @param bc - третья сторона.
     * @return - существует ли треугольник (логическое true или false).
     */
    private boolean exist(double ab, double ac, double bc) {
        if (ab > ac && ab > bc) {
            return ab < (ac + bc);
        } else if (ab > ac && ab < bc) {
            return bc < (ac + ab);
        } else if (ab < ac && ac > bc) {
            return ac < (ab + bc);
        } else if (ab < ac && ac < bc) {
            return bc < (bc + ac);
        } else {
            return false;
        }

    }
}
