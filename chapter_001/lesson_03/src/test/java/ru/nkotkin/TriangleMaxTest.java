package ru.nkotkin;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TriangleMaxTest {
	@Test
	public void whenAddTriangleThenReturnMaxLine() throws Exception {
		Point a = new Point(0d, 0d);
		Point b = new Point(1d, 1d);
		Point c = new Point(2d, 0d);
		Triangle triangle = new Triangle(a, b, c);
		
		TriangleMax tMax = new TriangleMax(triangle);

		assertThat(tMax.Max(), is(2d));
	}
}