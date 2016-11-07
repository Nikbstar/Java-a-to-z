package ru.nkotkin;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Test for Calculate.java.
 */
public class CalculateTest {

    /**
     * create calc.
     */
    private Calculate calc;

    /**
     * inicialize method.
     */
    @Before
    public final void inicialize() {
        calc = new Calculate();
    }

    /**
     * whenSetStopInEchoThenReturnThreeStops.
     * @throws Exception any.
     */
    @Test
    public final void whenSetStopInEchoThenReturnThreeStops() throws Exception {
        assertThat(calc.echo("stop"), is("stop stop stop"));
    }

    /**
     * whenSetNullInEchoThenReturnThreeNulls.
     * @throws Exception any.
     */
    @Test
    public final void whenSetNullInEchoThenReturnThreeNulls() throws Exception {
        assertThat(calc.echo(null), is("null null null"));
    }

}
