package ru.nkotkin;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CalculatorTest {
	// Сложение
	@Test
	public void whenAddSixAndTwoThenReturnEight() throws Exception {
		Calculator calculator = new Calculator();
		calculator.add(1d, 1d);
		assertThat(calculator.getResult(), is(2d));
	}

	// Вычитание
	@Test
	public void whenSubstructSixAndTwoThenReturnFour() throws Exception {
		Calculator calculator = new Calculator();
		calculator.substruct(2d, 1d);
		assertThat(calculator.getResult(), is(1d));
	}

	// Деление
	@Test
	public void whenDivSixAndTwoThenReturnThree() throws Exception {
		Calculator calculator = new Calculator();
		calculator.div(1d, 1d);
		assertThat(calculator.getResult(), is(1d));
	}
	// Деление на 0
	@Test(expected = ArithmeticException.class)
	public void whenDivByZeroThenReturnError() throws Exception {
		Calculator calculator = new Calculator();
		calculator.div(1d, 0d);
	}

	// Умножение
	@Test
	public void whenMultipleSixAndTwoThenReturnTwelve() throws Exception {
		Calculator calculator = new Calculator();
		calculator.multiple(1.0, 1.0);
		assertThat(calculator.getResult(), is(1d));
	}
}