package ru.nkotkin;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class MaxSideTest {

	@Test
	public void whenAddTriangleSidesThenReturnMaxLine() throws Exception {
		Point a = new Point(0d, 0d);
		Point b = new Point(1d, 1d);
		Point c = new Point(2d, 0d);
		Triangle triangle = new Triangle(a, b, c);
		
		MaxSide triangleMaxSide = new MaxSide(triangle.getLineA(), triangle.getLineB(), triangle.getLineC());

		assertThat(triangleMaxSide.max(), is(2d));
	}

}