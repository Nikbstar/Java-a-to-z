package ru.nkotkin;

/**
 * Нужно сделать файл Calculator.java и создать в нем класс Calculator.
 * в классе должно быть внутреннее поле double result.
 * и четыре метода add(double first, double second) по аналогии
 *      substruct div multiple.
 * Методы должны быть void.
 * Каждый метод вычисляет арифметическую операцию и записывает ее
 *      в поле result.
 * Добавить тест CalculatorTest.
 */
public class Calculator {

    /**
     * Calculate result.
     */
    private double result;

    /**
     * add method.
     * @param first - first num
     * @param second - second num
     */
    public final void add(final double first, final double second) {
        this.result = first + second;
    }

    /**
     * substruct method.
     * @param first - first num
     * @param second - second num
     */
    public final void substruct(final double first, final double second) {
        this.result = first - second;
    }

    /**
     * div method.
     * @param first - first num
     * @param second - second num
     */
    public final void div(final double first, final double second) {
        if (second != 0d) {
            this.result = first / second;
        } else {
            throw new ArithmeticException("Cound not div by 0");
        }
    }

    /**
     * multiple method.
     * @param first - first num
     * @param second - second num
     */
    public final void multiple(final double first, final double second) {
        this.result = first * second;
    }

    /**
     * getter method.
     * @return result
     */
    public final double getResult() {
        return this.result;
    }

}
