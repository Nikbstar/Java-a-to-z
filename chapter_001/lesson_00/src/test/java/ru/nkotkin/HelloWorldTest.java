package ru.nkotkin;
import java.io.ByteArrayOutputStream;
import org.junit.Test;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class HelloWorldTest {
	@Test
	public void whenRunHWThenPrintToOut() {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		HelloWorld.main(null);
		assertThat(out.toString(), is("Hello, World!"));
	}
}