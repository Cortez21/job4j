package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

public class PointTest {
    @Test
    public void whenAX6AY2AndBX3BY8Then() {
        Point a = new Point(6, 2);
        Point b = new Point(3, 8);

        double distance = a.distanceTo(b);
        assertThat(distance, closeTo(6.7, 0.1));
    }
}
