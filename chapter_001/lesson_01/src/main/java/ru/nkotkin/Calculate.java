package ru.nkotkin;

public class Calculate {
	public static void main(String[] args) {
		Calculate calc = new Calculate();
		System.out.println(calc.echo("ahh"));
		System.out.println("Calculate...");
		final int first = Integer.valueOf(args[0]);
		final int second = Integer.valueOf(args[1]);
		final int summ = first + second;
		System.out.println("Sum " + summ);
	}

	public String echo(String value) {
		return String.format("%s %s %s", value, value, value);
	}
}