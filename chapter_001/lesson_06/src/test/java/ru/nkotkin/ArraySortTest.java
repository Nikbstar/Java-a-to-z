package ru.nkotkin;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Tests for ArraySort.java.
 */
public class ArraySortTest {

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
     * whenAddTwoArraysThenGetOneSortArray.
     * @throws Exception - any
     */
    @Test
    public final void whenAddTwoArraysThenGetOneSortArray() throws Exception {
        int[] arr1 = {NUM_ONE, NUM_THREE};
        int[] arr2 = {NUM_TWO, NUM_FOUR};
        int[] arr = {NUM_ONE, NUM_TWO, NUM_THREE, NUM_FOUR};
        ArraySort arrSort = new ArraySort();
        int[] result = arrSort.merge(arr1, arr2);
        assertThat(result, is(arr));
    }

}
