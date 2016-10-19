package ru.nkotkin;

public class Calculator {
	
	private double result;
	
	// Слодение
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
}