package ru.nkotkin;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Test for HelloWorld.java.
 */
public class HelloWorldTest {

    /**
     * whenRunHWThenPrintToOut.
     * @throws Exception - any
     */
    @Test
    public final void whenRunHWThenPrintToOut() throws Exception {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        HelloWorld.main(null);
        assertThat(out.toString(), is("Hello, World!"));
    }

}
