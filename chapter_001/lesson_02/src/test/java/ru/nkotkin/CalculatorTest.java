package ru.nkotkin;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class CalculatorTest {

	private Calculator calculator;

	@Before
	public void inicialize() {
		calculator = new Calculator();
	}

	// Сложение
	@Test
	public void whenAddSixAndTwoThenReturnEight() throws Exception {
		calculator.add(1d, 1d);
		assertThat(calculator.getResult(), is(2d));
	}

	// Вычитание
	@Test
	public void whenSubstructSixAndTwoThenReturnFour() throws Exception {
		calculator.substruct(2d, 1d);
		assertThat(calculator.getResult(), is(1d));
	}

	// Деление
	@Test
	public void whenDivSixAndTwoThenReturnThree() throws Exception {
		calculator.div(1d, 1d);
		assertThat(calculator.getResult(), is(1d));
	}

	// Деление на 0
	@Test(expected = ArithmeticException.class)
	public void whenDivByZeroThenReturnError() throws Exception {
		calculator.div(1d, 0d);
	}

	// Умножение
	@Test
	public void whenMultipleSixAndTwoThenReturnTwelve() throws Exception {
		calculator.multiple(1.0, 1.0);
		assertThat(calculator.getResult(), is(1d));
	}

}