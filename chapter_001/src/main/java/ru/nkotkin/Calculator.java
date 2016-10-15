package ru.nkotkin;

public class Calculator {
	private double result;
	// ��������
	public void add(double ... params) {
		for(Double param : params) {
			this.result += param;
		}
	}
	// ���������
	public void substract(double first, double second) {
		this.result = first - second;
	}
	// ���������
	public void multiple(double first, double second) {
		this.result = first * second;
	}
	// �������
	public void div(double first, double second) {
		if(second != 0d) {
			this.result = first / second;
		} else {
			throw new ArithmeticException("Cound not div by 0");
		}
	}
	// ���������� � �������
	public void expand(double first, int second) {
		double res = 1;
		for(int index = 0; index < second; index++) {
			res *= first;
		}
		this.result = res;
	}
	// ��������� �������������� �������� �� ��������� ������� ��������
	public void calc(String operation, double first, double second) {
		if("+".equals(operation)) {
			this.add(first, second);
		} else if("-".equals(operation)) {
			this.substract(first, second);
		} else if("*".equals(operation)) {
			this.multiple(first, second);
		} else if("/".equals(operation)) {
			this.div(first, second);
		} else if("e".equals(operation)) {
			this.expand(first, (int) second);
		} else {
			throw new UnsupportedOperationException();
		}
	}
	public double getResult() {
		return result;
	}
	public void clearResult() {
		this.result = 0;
	}
}