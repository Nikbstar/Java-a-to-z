package ru.nkotkin;

import java.util.Arrays;

/**
 * Дано. Массив строк. String[] - нужно убрать дубликаты.
 *
 * 1. if(values[insideIterator] == values[outsideIterator]) {
 *    - нельзя так строки сравнивать.
 * 2. String[] values = {"one", "two", "one", "three"};
 *    String[] result = {"one", "two", null, "three"};
 *      нули надо перемешать в конец массива или удалять из него.
 */
public class ArrayDuplicates {

    /**
     * Removing duplicates.
     * @author P. Arseniev.
     * @param array array of strings.
     * @return array without duplicates.
     */
    public final String[] removeDuplicates(String[] array) {
        int limit = array.length;
        for (int out = 0; out != limit; out++) {
            for (int in = out + 1; in != limit; in++) {
                if (array[out].equals(array[in])) {
                    array[out] = array[limit - 1];
                    limit--;
                    in--;
                }
            }
        }
        return Arrays.copyOf(array, limit);
    }
//    /**
//     * ReRemove duplicates.
//     * @author N. Kotkin.
//     * @param values - Array of strings
//     */
//    public final void doRemove(final String[] values) {
//        for (int outsideIterator = 0;
//             outsideIterator != values.length;
//             outsideIterator++) {
//            if (values[outsideIterator] == null) {
//                continue;
//            }
//            for (int insideIterator = values.length - 1;
//                 insideIterator != outsideIterator;
//                 insideIterator--) {
//                if (this.equals(values[insideIterator], values[outsideIterator])) {
//                    this.moveNull(values, insideIterator);
//                }
//            }
//        }
//    }
//
//    /**
//     * find equals.
//     * @param str1 - string
//     * @param str2 - string
//     * @return true if strings is equils
//     */
//    private boolean equals(final String str1, final String str2) {
//        /**
//         * result
//         */
//        boolean result;
//
//        if (str1 == null) {
//            result = str2 == null;
//        } else {
//            result = str1.equals(str2);
//        }
//        return result;
//    }
//
//    /**
//     * move nulls back.
//     * @param values - array of strings
//     * @param iterator - position of null
//     */
//    private void moveNull(final String[] values, final int iterator) {
//        for (int i = iterator; i != values.length - 1; i++) {
//            values[iterator] = values[iterator + 1];
//        }
//        values[values.length - 1] = null;
//    }

}
