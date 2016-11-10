package ru.nkotkin;

/**
 * Дано. Массив int values[]. Нужно написать метод который
 * будет сортировать данный массив использую алгоритм пузырька.
 */
public class BubbleSort {

    /**
     * Bubble sort.
     * @param values - Array of integers
     */
    public final void doSort(final int[] values) {
        /**
         * temp variable.
         */
        int tmp;

        for (int outsideIterator = values.length; outsideIterator != 0; outsideIterator--) {
            for (int insideIterator = 0; insideIterator < outsideIterator - 1; insideIterator++) {
                if (values[insideIterator] > values[insideIterator + 1]) {
                    tmp = values[insideIterator];
                    values[insideIterator] = values[insideIterator + 1];
                    values[insideIterator + 1] = tmp;
                }
            }
        }
    }

}
