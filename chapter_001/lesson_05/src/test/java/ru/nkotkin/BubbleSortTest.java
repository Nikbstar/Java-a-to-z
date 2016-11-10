package ru.nkotkin;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Tests for BubbleSort.java.
 */
public class BubbleSortTest {

    /**
     * whenAddArrayThenGetSortArray.
     */
    @Test
    public final void whenAddArrayThenGetSortArray() {
        int[] values = {2, 1, 0};
        int[] result = {0, 1, 2};
        BubbleSort bSort = new BubbleSort();

        bSort.doSort(values);
        assertThat(result, is(values));
    }

}
