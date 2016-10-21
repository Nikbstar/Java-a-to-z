package ru.nkotkin;

/**
 * Дано. три точки. Нужно составить программу которая будет вычислять 
 * площадь треугольника образованного этими точками. Программа должна 
 * учитывать условия невозможности построить треугольник через эти точки.
 * @author nkotkin
 * @since 21.10.2016
 */
public class Triangle {
	public Point a;
	public Point b;
	public Point c;

	public Triangle(Point a, Point b, Point c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public double area() {
		//calculate the triangle area
		double lineA = a.distanceTo(b);
		double lineB = b.distanceTo(c);
		double lineC = a.distanceTo(c);
		double result;
		if( lineA < lineB + lineC && lineB < lineA + lineC && lineC < lineA + lineB) {
			double p = (lineA + lineB + lineC) / 2;
			result = Math.sqrt(p * (p - lineA) * (p - lineB) * (p - lineC));
		} else {
			throw new ArithmeticException("Can't be build triangle");
		}
		return result;
	}
}