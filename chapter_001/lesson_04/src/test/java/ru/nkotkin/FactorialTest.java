package ru.nkotkin;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class FactorialTest {
	private Factorial factorial;

	@Before
	public void initialize() {
		factorial = new Factorial();
	}

	@Test
	public void whenAddNumThenReturnFactorialResul() {
		assertThat(factorial.calc(3), is(6));
	}

	@Test
	public void whenAddZeroThenReturnOne() {
		assertThat(factorial.calc(0), is(1));
	}

	@Test(expected = ArithmeticException.class)
	public void whenAddLessZeroNumThenReturnExpension() {
		factorial.calc(-1);
	}
}