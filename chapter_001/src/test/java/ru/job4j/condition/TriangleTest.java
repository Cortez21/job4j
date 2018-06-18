package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

/**
 * @author Maksim Yunusov (mailto:cortezzz1987@gmail.com).
 * @version $Id$.
 * @since 0.1
 */
public class TriangleTest {
    @Test
    public void whenAreaSetThreePointsThenTriangleArea() {

        // Создаем три три точки с координатами.
        Point a = new Point(8, 9);
        Point b = new Point(3, 2);
        Point c = new Point(3, 9);

        // Создаем объект треугольник и передаем в него объекты точек.
        Triangle triangle = new Triangle(a, b, c);

        // Вычисляем площадь.
        double result = triangle.area();

        // Задаем ожидаемый результат.
        double expected = 17.5D;

        //Проверяем результат и ожидаемое значение.
        assertThat(result, closeTo(expected, 0.1));
    }
}
