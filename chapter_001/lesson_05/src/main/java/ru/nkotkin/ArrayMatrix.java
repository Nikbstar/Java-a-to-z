package ru.nkotkin;

/**
 * Дано. Двухмерный квадратный массив int values[][] - нужно написать метод, 
 * который будет поворачивать данный массив на 90 градусов.
 *
 * убрать статик методы.
 */
public class ArrayMatrix {

	public void doRotate(int[][] values, boolean leftRotate) {
		int tmp;
		int rowIterator = 0;
		int columnIterator = 0;

		for(rowIterator = 0; rowIterator != values.length / 2; rowIterator++) {
			for(columnIterator = rowIterator; columnIterator != values.length - 1 - rowIterator; columnIterator++) {
				tmp = values[rowIterator][columnIterator];
				if(leftRotate) {
					values[rowIterator][columnIterator] = values[columnIterator][values.length - 1 - rowIterator];
					values[columnIterator][values.length - 1 - rowIterator] = values[values.length - 1 - rowIterator][values.length - 1 - columnIterator];
					values[values.length - 1 - rowIterator][values.length - 1 - columnIterator] = values[values.length - 1 - columnIterator][rowIterator];
					values[values.length - 1 - columnIterator][rowIterator] = tmp;
				} else {
					values[rowIterator][columnIterator] = values[values.length - 1 - columnIterator][rowIterator];
					values[values.length - 1 - columnIterator][rowIterator] = values[values.length - 1 - rowIterator][values.length - 1 - columnIterator];
					values[values.length - 1 - rowIterator][values.length - 1 - columnIterator] = values[columnIterator][values.length - 1 - rowIterator];
					values[columnIterator][values.length - 1 - rowIterator] = tmp;
				}
			}
		}
	}

	public void doRotate(int[][] values) {
		doRotate(values, false);
	}

}