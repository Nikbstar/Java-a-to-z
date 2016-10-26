package ru.nkotkin;

/**
 * Дано. три точки. Нужно составить программу которая будет вычислять 
 * площадь треугольника образованного этими точками. Программа должна 
 * учитывать условия невозможности построить треугольник через эти точки.
 * @author nkotkin
 * @since 21.10.2016
 */
public class Triangle {
	final private Point a, b, c;
	final private double lineA, lineB, lineC;

	public Triangle(Point a, Point b, Point c) {
		// Координаты точек
		this.a = a;
		this.b = b;
		this.c = c;
		// Длинны сторон
		this.lineA = a.distanceTo(b);
		this.lineB = b.distanceTo(c);
		this.lineC = a.distanceTo(c);
	}

	public double getLineA() {
		return this.lineA;
	}

	public double getLineB() {
		return this.lineB;
	}

	public double getLineC() {
		return this.lineC;
	}

	public double area() {
		//calculate the triangle area
		if(!this.checkExist()) throw new ArithmeticException("Can't be build triangle because sides isn't correct!");

		double p = (this.lineA + this.lineB + this.lineC) / 2;
		return Math.sqrt(p * (p - this.lineA) * (p - this.lineB) * (p - this.lineC));
	}

	private boolean checkExist() {
		boolean result = false;

		if(this.lineA < this.lineB + this.lineC &&
			this.lineB < this.lineA + this.lineC &&
			this.lineC < this.lineA + this.lineB) result = true;
		return result;
	}
}