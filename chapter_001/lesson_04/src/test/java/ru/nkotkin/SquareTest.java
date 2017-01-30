package ru.nkotkin;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Tests for Square.java.
 */
public class SquareTest {

    /**
     * inicialize.
     */
    private Square square;
    /**
     * inicialize.
     */
    private static final float TEST_RESULT = 3f;

    /**
     * inicialize.
     */
    @Before
    public final void inicialize() {
        square = new Square(1f, 1f, 1f);
    }

    /**
     * whenAddXIntoCalculateThenReturnY.
     * @throws Exception - any exception
     */
    @Test
    public final void whenAddXIntoCalculateThenReturnY() throws Exception {
        assertThat(square.calculate(1), is(TEST_RESULT));
    }

    /**
     * whenIntoShowAddRangeOfValuesThenPrintAllY.
     * @throws Exception - any exception
     */
    @Test
    public final void whenIntoShowAddValuesThenPrintAllY() throws Exception {
        final String ln = System.getProperty("line.separator");
        final String testString = String.format("x = 0: y = 1.0%sx = 1: y = 3.0%s", ln, ln);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        square.show(0, 1, 1);
        assertThat(out.toString(), is(testString));
    }

    /**
     * whenIntoShowStepIsZeroThenExpection.
     * @throws Exception - any exception
     */
    @Test(expected = ArithmeticException.class)
    public final void whenIntoShowStepIsZeroThenExpection() throws Exception {
        square.show(1, 1, 0);
    }

    /**
     * whenIntoShowFinishLessStartThenExpection.
     * @throws Exception - any exception
     */
    @Test(expected = ArithmeticException.class)
    public final void whenIntoShowFinishLessStartThenExpect() throws Exception {
        square.show(1, 0, 1);
    }

}
