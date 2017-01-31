package ru.nkotkin;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by nkotkin on 1/31/17.
 */
public class PaintTest {

    /**
     * whenAddTriangleShapeThenPrintingTriangle.
     * @throws Exception all.
     */
    @Test
    public final void whenAddTriangleShapeThenPrintingTriangle() throws Exception {
        Paint paint = new Paint();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        paint.draw(new PrintTriangle());
        assertThat(out.toString(), is("  X\n XXX\nXXXXX\n"));
    }

    /**
     * whenAddSquareShapeThenPrintingSquare.
     * @throws Exception all.
     */
    @Test
    public final void whenAddSquareShapeThenPrintingSquare() throws Exception {
        Paint paint = new Paint();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        paint.draw(new PrintSquare());
        assertThat(out.toString(), is("XXXX\nXXXX\nXXXX\nXXXX\n"));
    }

}
