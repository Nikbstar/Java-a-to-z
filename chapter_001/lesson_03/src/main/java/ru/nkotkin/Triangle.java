package ru.nkotkin;

/**
 * Дано. три точки. Нужно составить программу которая будет вычислять 
 * площадь треугольника образованного этими точками. Программа должна 
 * учитывать условия невозможности построить треугольник через эти точки.
 * @author nkotkin
 * @since 21.10.2016
 */
public class Triangle {
	private Point a, b, c;
	public double lineA, lineB, lineC;

	public Triangle(Point a, Point b, Point c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public double area() {
		//calculate the triangle area
		if(!checkExist()) throw new ArithmeticException("Can't be build triangle");
			
		double p = (this.lineA + this.lineB + this.lineC) / 2;
		return Math.sqrt(p * (p - this.lineA) * (p - this.lineB) * (p - this.lineC));
	}

	private boolean checkExist() {
		boolean result = false;
		this.lineA = a.distanceTo(b);
		this.lineB = b.distanceTo(c);
		this.lineC = a.distanceTo(c);

		if(this.lineA < this.lineB + this.lineC &&
			this.lineB < this.lineA + this.lineC &&
			this.lineC < this.lineA + this.lineB) result = true;
		return result;
		
	}
}