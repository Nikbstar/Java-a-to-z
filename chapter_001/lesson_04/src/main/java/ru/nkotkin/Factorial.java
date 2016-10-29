package ru.nkotkin;

/**
 * Написать программу для вычисления факториала. Использовать циклы.
 */
public class Factorial {
	private int result;

	public Factorial() {
	}

	public Factorial(int arg) {
		this.setArg(arg);
	}

	public void setArg(int arg) {
		this.result = arg;
	}

	public int getResult() {
		calcFactorial();
		return result;
	}

	private void calcFactorial() {
		if(this.result < 0 ) throw new ArithmeticException("The number must be greater than zero!");
		if(this.result == 0) {
			result = 1;
		} else {
			for(int iterator = result - 1; iterator != 0; iterator--) {
				result *= iterator;
			}
		}
	}
}