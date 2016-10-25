package ru.nkotkin;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class SquareTest {
	@Test
	public void whenAddXIntoCalculateThenReturnY() throws Exception {
		Square square = new Square(1f, 1f, 1f);
		float result = square.calculate(1);
		assertThat(result, is(3f));
	}
	@Test
	public void whenIntoShowAddRangeOfValuesAndStepThenPrintAllYWithStep() throws Exception {
		Square square = new Square(1f, 1f, 1f);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		square.show(0, 1, 1);
		assertThat(out.toString(), is("x = 0: y = 1.0\r\nx = 1: y = 3.0\r\n"));
	}
	@Test(expected = ArithmeticException.class)
	public void whenIntoShowStepIsZeroThenExpection() {
		Square square = new Square(1f, 1f, 1f);
		square.show(1, 1, 0);
	}
	@Test(expected = ArithmeticException.class)
	public void whenIntoShowFinishLessStartThenExpection() {
		Square square = new Square(1f, 1f, 1f);
		square.show(1, 0, 1);
	}
}