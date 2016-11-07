package ru.nkotkin;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class ArrayDuplicatesTest {

	@Test
	public void whenAddArrayThenDeleteDuplicatesFromArray() {
		
		ArrayDuplicates dblRemove = new ArrayDuplicates();
		
		String[] values = {"one", "one", "one", "two"};
		String[] result = {"one", "two", null, null};

		dblRemove.doRemove(values);
		assertThat(result, is(values));
	}

}