package ru.nkotkin;
/**
 * 2. Создать класс с методом max - определяющий максимальную длинну 
 * стороны треугольника построенного из задание 1.
 * переделать на varargs - ты можешь сразу туда передавать длину стороны.
 * @author nkotkin
 * @since 23.10.2016
 */
public class MaxSide {
	final private double[] sides;

	public MaxSide(double... lines) {
		this.sides = new double[lines.length];
		System.arraycopy(lines, 0, this.sides, 0, lines.length);
	}

	public double max() {
		double result = this.sides[0];
		for(int iterator = 0; iterator != this.sides.length; iterator++) {
			if(result < this.sides[iterator]) result = this.sides[iterator];
		}
		return result;
	}
}