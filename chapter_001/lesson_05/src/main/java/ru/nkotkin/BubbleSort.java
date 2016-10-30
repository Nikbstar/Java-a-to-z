package ru.nkotkin;

/**
 * Дано. Массив int values[]. Нужно написать метод который
 * будет сортировать данный массив использую алгоритм пузырька.
 */
public class BubbleSort {

	public static void doSort(int[] values) {
		int tmp;
		
		for(int outsideIterator = values.length; outsideIterator != 0; outsideIterator--) {
			for(int insideIterator = 0; insideIterator < outsideIterator - 1; insideIterator++) {
				if(values[insideIterator] > values[insideIterator + 1]) {
					tmp = values[insideIterator];
					values[insideIterator] = values[insideIterator + 1];
					values[insideIterator + 1] = tmp;
				}
			}
		}
	}

}