package ru.nkotkin;

/**
 * Дано. Двухмерный квадратный массив int values[][] - нужно написать метод,
 * который будет поворачивать данный массив на 90 градусов.
 *
 * убрать статик методы.
 */
public class ArrayMatrix {

    /**
     * Rotate array.
     * @param values - array of ints
     * @param leftRotate - direction of rotation
     */
    public final void doRotate(final int[][] values, final boolean leftRotate) {
        /**
         * temp variable.
         */
        int tmp;
        /**
         * row iterator.
         */
        int rowIterator = 0;
        /**
         * column iterator.
         */
        int columnIterator = 0;

        for (rowIterator = 0; rowIterator != values.length / 2; rowIterator++) {
            for (columnIterator = rowIterator; columnIterator != values.length - 1 - rowIterator; columnIterator++) {
                tmp = values[rowIterator][columnIterator];
                if (leftRotate) {
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
