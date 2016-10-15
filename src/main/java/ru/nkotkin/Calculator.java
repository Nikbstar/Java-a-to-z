package ru.nkotkin;

public class Calculator {
	private int result;
	public void add(int ... params) {
		for(Integer param : params) {
			this.result += param;
		}
	}
	public int getResult() {
		return result;
	}
	public void clearResult() {
		this.result = 0;
	}
}