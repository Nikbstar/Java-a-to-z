package ru.nkotkin;

import org.junit.Test;
import org.junit.Before;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class SquareTest {
	private Square square;
	
	@Before
	public void initialize() {
		square = new Square(1f, 1f, 1f);
	}

	@Test
	public void whenAddXIntoCalculateThenReturnY() throws Exception {
		assertThat(square.calculate(1), is(3f));
	}

	@Test
	public void whenIntoShowAddRangeOfValuesAndStepThenPrintAllYWithStep() throws Exception {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		square.show(0, 1, 1);
		assertThat(out.toString(), is("x = 0: y = 1,0\r\nx = 1: y = 3,0\r\n"));
	}

	@Test(expected = ArithmeticException.class)
	public void whenIntoShowStepIsZeroThenExpection() {
		square.show(1, 1, 0);
	}

	@Test(expected = ArithmeticException.class)
	public void whenIntoShowFinishLessStartThenExpection() {
		square.show(1, 0, 1);
	}
}