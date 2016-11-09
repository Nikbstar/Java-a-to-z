package ru.nkotkin;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Tests for Factorial.java.
 */
public class FactorialTest {

    /**
     * initialize.
     */
    private Factorial factorial;
    /**
     * tested num.
     */
    private static final int TEST_FACTORIAL = 3;
    /**
     * result num.
     */
    private static final int RESULT_FACTORIAL = 6;

    /**
     * initialize.
     */
     @Before
    public final void initialize() {
        factorial = new Factorial();
    }

    /**
     * whenAddNumThenReturnFactorialResul.
     * @throws Exception - any exception
     */
    @Test
    public final void whenAddNumThenReturnFactorialResul() throws Exception {
        assertThat(factorial.calc(TEST_FACTORIAL), is(RESULT_FACTORIAL));
    }

    /**
     * whenAddZeroThenReturnOne.
     * @throws Exception - any exception
     */
    @Test
    public final void whenAddZeroThenReturnOne() throws Exception {
        assertThat(factorial.calc(0), is(1));
    }

    /**
     * whenAddLessZeroNumThenReturnExpension.
     * @throws Exception - any exception
     */
    @Test(expected = ArithmeticException.class)
    public final void whenAddLessZeroNumThenReturnExpension() throws Exception {
        factorial.calc(-1);
    }

}
