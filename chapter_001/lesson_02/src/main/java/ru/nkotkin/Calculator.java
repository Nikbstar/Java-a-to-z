package ru.nkotkin;

/**
 * Нужно сделать файл Calculator.java и создать в нем класс Calculator.
 * в классе должно быть внутреннее поле double result.
 * и четыре метода add(double first, double second) по аналогии substruct div multiple.
 * Методы должны быть void.
 * Каждый метод вычисляет арифметическую операцию и записывает ее в поле result.
 * Добавить тест CalculatorTest.
 */
public class Calculator {

	private double result;

	// Сложение
	public void add(double first, double second) {
		this.result = first + second;
	}

	// Вычитание
	public void substruct(double first, double second) {
		this.result = first - second;
	}

	// Деление
	public void div(double first, double second) {
		if(second != 0d) {
			this.result = first / second;
		} else {
			throw new ArithmeticException("Cound not div by 0");
		}
	}

	// Умножение
	public void multiple(double first, double second) {
		this.result = first * second;
	}

	// Получить результат
	public double getResult() {
		return this.result;
	}

}