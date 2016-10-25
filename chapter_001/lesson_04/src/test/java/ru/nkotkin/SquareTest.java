package ru.nkotkin;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class SquareTest {
	@Test
	public void whenAddXIntoCalculateThenReturnY() throws Exception {
		Square square = new Square(1f, 1f, 1f);
		float result = square.calculate(1);
		assertThat(result, is(3f));
		
	}
}