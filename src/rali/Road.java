package rali;
public class Road {
	public static void main(String[] args) {
		Car car = new Car();
		car.fill(100);
		car.showGas();
		car.drive(10);
		car.showGas();
		Road.gasStation(car);
		car.showGas();
		}
	public static void gasStation(Car car) {
		car.fill(100);
	}
}

���������� ������ ��� � �������� �� �������.
[code=java]
public class RefTask {
public static void main(String[] args) {
Integer value = 1;
RefTask.change(value);
System.out.println(value);
}

public static void change(Integer that) {
that++;
}
}

[/code]

��� ����� �������� �� ������� � ������?
��� ������ � ��������� �� ����. ��������� ������ � ���. � ������ ����� ��������� ���������� ��������� �������.