package ru.nkotkin;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class FactorialTest {
	@Test
	public void whenAddArgThenReturnFactorialResul() {
		Factorial factorial = new Factorial(3);
		int result = factorial.getResult();
		assertThat(result, is(6));
	}

	@Test
	public void whenAddArgZeroInSetterThenReturnOne() {
		Factorial factorial = new Factorial();
		factorial.setArg(0);
		int result = factorial.getResult();
		assertThat(result, is(1));
	}

	@Test(expected = ArithmeticException.class)
	public void whenAddLessZeroNumThenReturnExpension() {
		Factorial factorial = new Factorial();
		factorial.setArg(-1);
		int result = factorial.getResult();
	}
}