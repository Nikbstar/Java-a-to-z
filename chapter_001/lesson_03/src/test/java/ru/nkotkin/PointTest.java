package ru.nkotkin;

import org.junit.Test;
import org.junit.Ignore;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@Ignore
public class PointTest {

	@Test
	public void whenAddCoordinatesThenReturnDistance() throws Exception {
		// Assign
		Point point1 = new Point(0d, 0d);
		Point point2 = new Point(0d, 1d);
		double checked = 1d;
		// Act
		double result = point1.distanceTo(point2);
		// Assert
		assertThat(result, is(checked));
	}
}