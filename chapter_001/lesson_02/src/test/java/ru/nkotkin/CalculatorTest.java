package ru.nkotkin;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

	private final double DELTA = 1e-15;

	// Сложение
	@Test
	public void whenAddSixAndTwoThenReturnEight() {
		Calculator calculator = new Calculator();
		calculator.add(6.0, 2.0);
		assertEquals(8.0, calculator.getResult(), DELTA);
	}

	// Вычитание
	@Test
	public void whenSubstructSixAndTwoThenReturnFour() {
		Calculator calculator = new Calculator();
		calculator.substruct(6.0, 2.0);
		assertEquals(4.0, calculator.getResult(), DELTA);
	}

	// Деление
	@Test
	public void whenDivSixAndTwoThenReturnThree() {
		Calculator calculator = new Calculator();
		calculator.div(6.0, 2.0);
		assertEquals(3.0, calculator.getResult(), DELTA);
	}
	// Деление на 0
	@Test(expected = ArithmeticException.class)
	public void whenDivByZeroThenReturnError() {
		Calculator calculator = new Calculator();
		calculator.div(6.0, 0.0);
	}

	// Умножение
	@Test
	public void whenMultipleSixAndTwoThenReturnTwelve() {
		Calculator calculator = new Calculator();
		calculator.multiple(6.0, 2.0);
		assertEquals(12.0, calculator.getResult(), DELTA);
	}
}