package ru.nkotkin;

import org.junit.Test;

import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.junit.Assert.assertThat;

/**
 * Tests for ArrayDuplicates.java.
 */
public class ArrayDuplicatesTest {

    /**
     * whenArrayHasDuplicatesThenDeleteIt.
     * @throws Exception all.
     */
    @Test
    public final void whenArrayHasDuplicatesThenDeleteIt() throws Exception {
        ArrayDuplicates duplicates = new ArrayDuplicates();
        String[] input = {"Lisa", "Olga", "Lisa", "Sveta", "Valeria"};
        String[] except = {"Lisa", "Olga", "Sveta", "Valeria"};
        String[] result = duplicates.removeDuplicates(input);
        assertThat(result, arrayContainingInAnyOrder(except));
    }

    /**
     * whenArrayHasAllDuplicatesThenDeleteIt.
     * @throws Exception all.
     */
    @Test
    public final void whenArrayHasAllDuplicatesThenDeleteIt() throws Exception {
        ArrayDuplicates duplicates = new ArrayDuplicates();
        String[] input = {"1", "1", "1", "1", "1"};
        String[] except = {"1"};
        String[] result = duplicates.removeDuplicates(input);
        assertThat(result, arrayContainingInAnyOrder(except));
    }

//    /**
//     * whenAddArrayThenDeleteDuplicatesFromArray.
//     * @throws Exception - any
//     */
//    @Test
//    public final void whenAddArrayThenDeleteDuplicatesFromArray() throws Exception {
//
//        ArrayDuplicates dblRemove = new ArrayDuplicates();
//
//        String[] values = {"one", "one", "one", "two"};
//        String[] result = {"one", "two", null, null};
//
//        dblRemove.doRemove(values);
//        assertThat(result, is(values));
//    }

}
