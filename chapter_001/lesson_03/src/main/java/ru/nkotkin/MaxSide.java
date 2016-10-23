package ru.nkotkin;
/**
 * 2. Создать класс с методом max - определяющий максимальную длинну 
 * стороны треугольника построенного из задание 1.
 * переделать на varargs - ты можешь сразу туда передавать длину стороны.
 * @author nkotkin
 * @since 23.10.2016
 */
public class MaxSide {
	private double[] lines;
	public MaxSide(double... lines) {
		
	}
	public double max() {
		double result = 0d;
//		for (int iterator = 0; iterator < lines.length; iterator++) {
//			result = (lines[iterator] > lines[iterator + 1]) ? lines[iterator] : lines[iterator + 1];
//		}
		return result;
	}
}