package ru.nkotkin;

/**
 * Created by nkotkin on 1/30/17.
 */
public class PrintSquare implements Shape {

    /**
     * Printing character.
     */
    private static final char CHARACTER = 'X';

    /**
     * print the shape.
     *
     * @param side side length.
     * @return string
     */
    @Override
    public String pic(int side) {
        final char[] chars = new char[(side + 1) * side];
        for (int iterator = 0; iterator != chars.length; iterator++) {
            if (iterator % side == 0 && iterator != 0) {
                chars[iterator] = '\n';
            } else {
                chars[iterator] = CHARACTER;
            }
        }
        return new String(chars);
    }
}
