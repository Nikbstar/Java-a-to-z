package ru.nkotkin;

/**
 * 1. Создать класс Point c двумя полями x, y. Этот класс
 * будет описывать точку в системе координат.
 * @author nkotkin
 * @since 20.10.2016
 */
public class Point {
	public double x;
	public double y;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double distanceTo(Point point) {
		//calculate distance between two points
		return Math.sqrt(Math.pow((point.x - this.x), 2) + Math.pow((point.y - this.y), 2));
	}
}