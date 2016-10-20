package ru.nkotkin;

/**
 * 1. Создать класс Point c двумя полями x, y. Этот класс будет описывать точку в системе координат.
 * Дано. три точки. Нужно составить программу которая будет вычислять площадь треугольника образованного этими точками.
 * Программа должна учитывать условия невозможности построить треугольник через эти точки.
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
		return -1d;
	}
}