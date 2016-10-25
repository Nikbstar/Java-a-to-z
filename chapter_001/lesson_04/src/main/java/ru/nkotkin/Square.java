package ru.nkotkin;

/**
 * Создать класс Square в нем один методы float calculate(int x)
 * и void show(start, finish, step). Метод должен вычислять значение
 * функции y = a*x2 + b * x + c; параметры a b c задаются через конструктор.
 * void show(start, finish, step) - вывести на экран значение функции в
 * диапазоне от x1 до x2 c шагом step. 
 *
 * 2. Обязательно нужно добавить тесты проверяющие методы.
 */
public class Square {
	private float a, b, c;
	
	public Square(float a, float b, float c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	public float calculate (int x) {
		return this.a * (x * x) + this.b * x + this.c;
	}
	public void show(float start, float finish, float step) {
		
	}
}