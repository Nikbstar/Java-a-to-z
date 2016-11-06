package ru.nkotkin;

/**
 * Дано. Массив строк. String[] - нужно убрать дубликаты.
 */
public class ArrayDuplicates {

	public void doRemove(String[] values) {
		for(int outsideIterator = 0; outsideIterator != values.length; outsideIterator++) {
			if(values[outsideIterator] == null) {
				continue;
			}
			for(int insideIterator = values.length - 1; insideIterator != outsideIterator; insideIterator--) {
				if(values[insideIterator] == values[outsideIterator]) {
					values[insideIterator] = null;
				}
			}
		}
	}

}