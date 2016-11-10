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
        int[][] values = {{0, 1}, {2, 3}};
        int[][] result = {{2, 0}, {3, 1}};

        rotate.doRotate(values);
        assertThat(result, is(values));
    }

    /**
     * whenAdd3DArrayWithLeftRotateThenGetRotateArrayOnLeft.
     */
    @Test
    public final void whenAdd3DArrayWithLeftRotateThenGetRotateArrayOnLeft() {
        int[][] values = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] result = {{3, 6, 9}, {2, 5, 8}, {1, 4, 7}};

        rotate.doRotate(values, true);
        assertThat(result, is(values));
    }

}
