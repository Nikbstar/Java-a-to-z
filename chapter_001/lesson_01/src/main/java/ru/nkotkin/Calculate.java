package ru.nkotkin;

/**
 * 0. Создать пакет с фамилией и именем. Например parsentev.
 * 1. Создать текстовый файл Calculate.java
 * 2. Добавить в него метод main и сделать вывод
 *      на консоль суммы двух аргументов, переданных программе.
 * 3. Скомпилировать файл и запусить.
 * 4. Все операции компиляции и запуска выполнять в консоли.
 *      Редактирование файла делать в блокноте.
 * 5. Добавить в проект maven. и сделать его модульным.
 *      https://yadi.sk/i/sOizWYsmt2SAa
 */
public class Calculate {

    /**
     * Running Calculate.
     * @param args - comand line arguments
     */
    public static void main(final String[] args) {
        Calculate calc = new Calculate();

        System.out.println(calc.echo("ahh"));
        System.out.println("Calculate...");

        final int first = Integer.valueOf(args[0]);
        final int second = Integer.valueOf(args[1]);
        final int summ = first + second;

        System.out.println("Sum " + summ);
    }

    /**
     * Write value three times.
     * @param value - any String
     * @return triple value
     */
    public final String echo(final String value) {
        return String.format("%s %s %s", value, value, value);
    }

}
