package ru.nkotkin;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Tests fo ArrayMatrix.java.
 */
public class ArrayMatrixTest {
    /**
     * 0.
     */
    private static final int NUM_ZERO = 0;
    /**
     * 1.
     */
    private static final int NUM_ONE = 1;
    /**
     * 2.
     */
    private static final int NUM_TWO = 2;
    /**
     * 3.
     */
    private static final int NUM_THREE = 3;
    /**
     * 4.
     */
    private static final int NUM_FOUR = 4;
    /**
     * 5.
     */
    private static final int NUM_FIVE = 5;
    /**
     * 6.
     */
    private static final int NUM_SIX = 6;
    /**
     * 7.
     */
    private static final int NUM_SEVEN = 7;
    /**
     * 8.
     */
    private static final int NUM_EIGHT = 8;
    /**
     * 9.
     */
    private static final int NUM_NINE = 9;

    /**
     * inicialize.
     */
    private ArrayMatrix rotate;

    /**
     * inicialize.
     */
    @Before
    public final void inicialize() {
        rotate = new ArrayMatrix();
    }

    /**
     * whenAdd2DArrayThenGetRotateArrayOnRight.
     */
    @Test
    public final void whenAdd2DArrayThenGetRotateArrayOnRight() {
        int[][] values = {{NUM_ZERO, NUM_ONE}, {NUM_TWO, NUM_THREE}};
        int[][] result = {{NUM_TWO, NUM_ZERO}, {NUM_THREE, NUM_ONE}};

        rotate.doRotate(values);
        assertThat(result, is(values));
    }

    /**
     * whenAdd3DArrayWithLeftRotateThenGetRotateArrayOnLeft.
     */
    @Test
    public final void whenAdd3DArrayWithLeftRotateThenGetRotateArrayOnLeft() {
        int[][] values = {{NUM_ONE, NUM_TWO, NUM_THREE},
                          {NUM_FOUR, NUM_FIVE, NUM_SIX},
                          {NUM_SEVEN, NUM_EIGHT, NUM_NINE}};

        int[][] result = {{NUM_THREE, NUM_SIX, NUM_NINE},
                          {NUM_TWO, NUM_FIVE, NUM_EIGHT},
                          {NUM_ONE, NUM_FOUR, NUM_SEVEN}};

        rotate.doRotate(values, true);
        assertThat(result, is(values));
    }

}
