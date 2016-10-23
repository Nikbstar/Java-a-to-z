package ru.nkotkin;

import org.junit.Test;
import org.junit.Ignore;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.*;
//@Ignore
public class TriangleTest {
	@Test
	public void whenAddPointsThenReturnArea() throws Exception {
		// Assign
		Point a = new Point(0d, 0d);
		Point b = new Point(1d, 1d);
		Point c = new Point(3d, 0d);
		Triangle triangle = new Triangle(a, b, c);
		double checked = 1.5d;
		// Act
		double result = triangle.area();
		// Assert
		assertThat(result, is(closeTo(checked, 0.0001)));
	}
	@Test(expected = ArithmeticException.class)
	public void whenWrongLinesThenReturnException() throws Exception {
		Point a = new Point(0d, 0d);
		Point b = new Point(0d, 0d);
		Point c = new Point(0d, 0d);
		Triangle triangle = new Triangle(a, b, c);
		triangle.area();
	}
}