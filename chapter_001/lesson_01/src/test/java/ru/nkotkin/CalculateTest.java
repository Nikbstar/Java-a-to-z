package ru.nkotkin;

import org.junit.Test;
import org.junit.Before;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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

    /**
     * whenSetNullInEchoThenReturnThreeNulls.
     * @throws Exception any.
     */
    @Test
    public final void whenThen() throws Exception {
        final String[] args = {"1", "1"};
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Calculate.main(args);
        assertThat(out.toString(), is("ahh ahh ahh\r\nCalculate...\r\nSum 2\r\n"));
    }
}
