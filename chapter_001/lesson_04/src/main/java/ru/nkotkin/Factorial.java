package ru.nkotkin;

/**
 * Написать программу для вычисления факториала. Использовать циклы.
 */
public class Factorial {

    /**
     * Factorial calculate.
     * @param arg - non-negative integer
     * @return - result
     */
    public final int calc(final int arg) {
        /**
         * result.
         */
        int result = arg;

        if (result < 0) {
            throw new ArithmeticException("The number must be greater than 0!");
        }

        if (result == 0) {
            result = 1;
        } else {
            for (int iterator = result - 1; iterator != 0; iterator--) {
                result *= iterator;
            }
        }
        return result;
    }

}
