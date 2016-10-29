package ru.nkotkin;

import org.junit.Test;
import org.junit.Before;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CalculateTest {
	private Calculate calc;
	
	@Before
	public void inicialize() {
		calc = new Calculate();
	}

	@Test
	public void whenSetStopInEchoThenReturnThreeStops() throws Exception {
		assertThat(calc.echo("stop"), is("stop stop stop"));
	}

	@Test
	public void whenSetNullInEchoThenReturnThreeNulls() throws Exception {
		assertThat(calc.echo(null), is("null null null"));
	}
}