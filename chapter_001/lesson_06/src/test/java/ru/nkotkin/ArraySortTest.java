package ru.nkotkin;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Tests for ArraySort.java.
 */
public class ArraySortTest {

    /**
     * whenThen.
     * @throws Exception - any
     */
    @Test
    public final void whenThen() throws Exception {
        int[] arr1 = {1, 3};
        int[] arr2 = {2, 4};
        int[] arr = {1, 2, 3, 4};
        ArraySort arrSort = new ArraySort();
        int[] result = arrSort.merge(arr1, arr2);
        assertThat(result, is(arr));
    }

}
