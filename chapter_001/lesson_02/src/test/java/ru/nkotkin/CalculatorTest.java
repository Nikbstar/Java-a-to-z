package ru.nkotkin;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

    /**
     * Tests for Calculator.java.
     */
    public class CalculatorTest {

    /**
     * create calculator.
     */
    private Calculator calculator;

    /**
     * inicialize method.
     */
    @Before
    public final void initialize() {
        calculator = new Calculator();
    }

    /**
     * add testing.
     * @throws Exception - any
     */
    @Test
    public final void whenAddSixAndTwoThenReturnEight() throws Exception {
        calculator.add(1d, 1d);
        assertThat(calculator.getResult(), is(2d));
    }

    /**
     * substruct testing.
     * @throws Exception - any
     */
    @Test
    public final void whenSubstructSixAndTwoThenReturnFour() throws Exception {
        calculator.substruct(2d, 1d);
        assertThat(calculator.getResult(), is(1d));
    }

    /**
     * div testing.
     * @throws Exception - any
     */
    @Test
    public final void whenDivSixAndTwoThenReturnThree() throws Exception {
        calculator.div(1d, 1d);
        assertThat(calculator.getResult(), is(1d));
    }

    /**
     * div by zero testing.
     * @throws Exception - any
     */
    @Test(expected = ArithmeticException.class)
    public final void whenDivByZeroThenReturnError() throws Exception {
        calculator.div(1d, 0d);
    }

    /**
     * multiple testing.
     * @throws Exception - any
     */
    @Test
    public final void whenMultipleSixAndTwoThenReturnTwelve() throws Exception {
        calculator.multiple(1.0, 1.0);
        assertThat(calculator.getResult(), is(1d));
    }

}
