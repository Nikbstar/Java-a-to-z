package ru.nkotkin;
/**
 * 2. Создать класс с методом max - определяющий максимальную длинну 
 * стороны треугольника построенного из задание 1.
 * @author nkotkin
 * @since 22.10.2016
 */
public class TriangleMax {

	public Triangle triangle;

	public TriangleMax (Triangle triangle) {
		this.triangle = triangle;
	}

	public double Max() {
		double result;
		double lineA = triangle.a.distanceTo(triangle.b);
		double lineB = triangle.b.distanceTo(triangle.c);
		double lineC = triangle.a.distanceTo(triangle.c);

		if(lineA > lineB) {
			result = (lineA > lineC) ? lineA : lineC;
		} else {
			result = (lineB > lineC) ? lineB : lineC;
		}
		return result;
	}
}