package ru.nkotkin;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class HelloWorldTest {

	@Test
	public void whenRunHWThenPrintToOut() {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		HelloWorld.main(null);
		assertThat(out.toString(), is("Hello, World!"));
	}

}