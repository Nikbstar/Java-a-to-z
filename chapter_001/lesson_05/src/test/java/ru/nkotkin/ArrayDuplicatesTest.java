package ru.nkotkin;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class ArrayDuplicatesTest {

	@Test
	public void whenAddArrayThenDeleteDuplicatesFromArray() {
		
		ArrayDuplicates dblRemove = new ArrayDuplicates();
		
		String[] values = {"one", "two", "one", "three"};
		String[] result = {"one", "two", null, "three"};

		dblRemove.doRemove(values);
		assertThat(result, is(values));
	}

}