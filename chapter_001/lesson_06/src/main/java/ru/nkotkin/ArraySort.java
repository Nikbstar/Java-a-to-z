package ru.nkotkin;

/**
 * Дано два массива int. Оба отсортированы по возрастанию.
 * Нужно объединить эти массивы в один отсортированный массив.
 */
public class ArraySort {

    /**
     * Merge two sort int arrays in one sort.
     * @param firstArray - first array
     * @param secondArray - secons array
     * @return marge array
     */
    public final int[] merge(final int[] firstArray, final int[] secondArray) {
        /**
         * result array.
         */
        int[] result = new int[firstArray.length + secondArray.length];
        /**
         * first array iterator.
         */
        int firstIterator = 0;
        /**
         * second array iterator.
         */
        int secondIterator = 0;
        /**
         * result array iterator.
         */
        int resultIterator = 0;

        while (firstIterator < firstArray.length && secondIterator < secondArray.length) {
            if (firstArray[firstIterator] < secondArray[secondIterator]) {
                result[resultIterator] = firstArray[firstIterator];
                firstIterator++;
            } else {
                result[resultIterator] = secondArray[secondIterator];
                secondIterator++;
            }
            resultIterator++;
        }
        while (firstIterator < firstArray.length) {
            result[resultIterator] = firstArray[firstIterator];
            resultIterator++;
            firstIterator++;
        }
        while (secondIterator < secondArray.length) {
            result[resultIterator] = secondArray[secondIterator];
            resultIterator++;
            secondIterator++;
        }

        return result;
    }

}
