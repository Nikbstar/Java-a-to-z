package ru.nkotkin;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.number.IsCloseTo.closeTo;

/**
 * Tests for Triangle.java.
 */
public class TriangleTest {
    /**
     * Delta for CloseTo.
     */
    public static final double DELTA = 0.0001;
    /**
     * Just a number.
     */
    public static final double THREE_DOUBLE = 3;
    /**
     * Just a number.
     */
    public static final double ONE_POINT_FIVE_DOUBLE = 1.5;
    /**
     * whenAddPointsThenReturnArea.
     * @throws Exception - any
     */
    @Test
    public final void whenAddPointsThenReturnArea() throws Exception {
        // Assign
        Point a = new Point(0d, 0d);
        Point b = new Point(1d, 1d);
        Point c = new Point(THREE_DOUBLE, 0d);
        Triangle triangle = new Triangle(a, b, c);
        double checked = ONE_POINT_FIVE_DOUBLE;
        // Act
        double result = triangle.area();
        // Assert
        assertThat(result, is(closeTo(checked, DELTA)));
    }

    /**
     * whenWrongLinesThenReturnException.
     * @throws Exception - any
     */
    @Test(expected = ArithmeticException.class)
    public final void whenWrongLinesThenReturnException() throws Exception {
        Point a = new Point(0d, 0d);
        Point b = new Point(0d, 0d);
        Point c = new Point(0d, 0d);
        Triangle triangle = new Triangle(a, b, c);
        triangle.area();
    }

}
