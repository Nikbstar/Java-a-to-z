package ru.nkotkin;
import java.util.Scanner;

public class InteractRunner {
/*	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		try {
			Calculator calc = new Calculator();
			String exit = "n";
			while (!exit.equals("y")) {
				System.out.println("Enter first arg: ");
				String first = reader.next();
				System.out.println("Enter second arg: ");
				String second = reader.next();
				calc.add(Integer.valueOf(first) + Integer.valueOf(second));
				System.out.println("Result: " + calc.getResult() + "");
				calc.clearResult();
				System.out.println("Exit? (y/n) ");
				exit = reader.next();
			}
		} finally {
			reader.close();
		}
	}*/
	private final Calculator calculator;
	private final IO io;
	
	public InteractRunner(final Calculator calculator, final IO io) {
		this.calculator = calculator;
		this.io = io;
	}
	
	public void start() {
		boolean reuse = false;
		try (final Validator validator = new Validator(io)) {
			do {
				final double first;
				if (reuse) {
					first = calculator.getResult();
				} else {
					first = validator.getDouble("Enter first arg: ");
				}
				String operation = validator.getString("Enter operation: ");
				double second = validator.getDouble("Enter second arg: ");
				calculator.calc(operation, first, second);
				io.println(String.format("%s %s %s = %s", first, operation, second, calculator.getResult()));
				reuse = validator.compare("Do you want to reuse result? (y)", "y");
			} while (validator.compare("Do you want to continue? (y)", "y"));
		}
	}
	public static void main(String[] args) {
		new InteractRunner(new Calculator(), new ConsoleIO(new Scanner(System.in), System.out)).start();
	}
}