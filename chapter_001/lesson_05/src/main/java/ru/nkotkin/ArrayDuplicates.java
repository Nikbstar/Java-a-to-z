package ru.nkotkin;

/**
 * Дано. Массив строк. String[] - нужно убрать дубликаты.
 *
 * 1. if(values[insideIterator] == values[outsideIterator]) { - нельзя так строки сравнивать.
 * 2. String[] values = {"one", "two", "one", "three"};
 *    String[] result = {"one", "two", null, "three"};
 *		нули надо перемешать в конец массива или удалять из него.
 */
public class ArrayDuplicates {

	public void doRemove(String[] values) {
		for(int outsideIterator = 0; outsideIterator != values.length; outsideIterator++) {
			if(values[outsideIterator] == null) {
				continue;
			}
			for(int insideIterator = values.length - 1; insideIterator != outsideIterator; insideIterator--) {
				if(this.equals(values[insideIterator], values[outsideIterator])) {
					this.moveNull(values, insideIterator);
				}
			}
		}
	}

	private boolean equals(String str1, String str2) {
		return str1 == null ? str2 == null : str1.equals(str2);
	}

	private void moveNull(String[] values, int iterator) {
		while(iterator != values.length - 1) {
			values[iterator] = values[iterator + 1];
			iterator++;
		}
		values[values.length - 1] = null;
	}

}