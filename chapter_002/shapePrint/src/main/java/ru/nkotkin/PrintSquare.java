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
     * @return string
     */
    @Override
    public final String pic() {
        return "XXXX\nXXXX\nXXXX\nXXXX\n";
    }

}
