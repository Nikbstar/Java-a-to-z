package ru.nkotkin;

/**
 * Создать класс Square в нем один методы float calculate(int x)
 * и void show(start, finish, step). Метод должен вычислять значение
 * функции y = a*x2 + b * x + c; параметры a b c задаются через конструктор.
 * void show(start, finish, step) - вывести на экран значение функции в
 * диапазоне от x1 до x2 c шагом step.
 *
 * 2. Обязательно нужно добавить тесты проверяющие методы.
 *
 * 1. System.out.println("x = " + iterator + ": y = " + this.calculate(iterator)
 *    + ""); - использовать String.format
 *
 * 2. между методами обязательно ставлять пустую строку.
 */
public class Square {

    /**
     * constants.
     */
    private float a, b, c;

    /**
     * Constructor.
     * @param aArg - a const
     * @param bArg - b const
     * @param cArg - c const
     */
    public Square(final float aArg, final float bArg, final float cArg) {
        this.a = aArg;
        this.b = bArg;
        this.c = cArg;
    }

    /**
     * Calculating.
     * @param x - var x
     * @return result
     */
    public final float calculate(final int x) {
        return this.a * x * x + this.b * x + this.c;
    }

    /**
     * Func result in diaposone start - finish with step ster.
     * @param start - first x value
     * @param finish - last x value
     * @param step - step calculating
     */
    public final void show(final int start, final int finish, final int step) {
        if (step <= 0) {
            throw new ArithmeticException("Step must be greater then 0");
        }
        if (finish < start) {
            throw new ArithmeticException("Incorrect range. Start value must be"
                                          + " greater then last");
        }

        String result;
        for (int iterator = start; iterator <= finish; iterator += step) {
            result = String.format("x = %d: y = %.1f", iterator,
                                   this.calculate(iterator));
            System.out.println(result);
        }
    }

}
