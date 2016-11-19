package ru.nkotkin;

/**
 * Дано. три точки. Нужно составить
 * программу которая будет вычислять
 * площадь треугольника образованного
 * этими точками. Программа должна
 * учитывать условия невозможности построить
 * треугольник через эти точки.
 * @author nkotkin
 * @since 21.10.2016
 */
public class Triangle {

    /**
     * Points.
     */
    private final Point a, b, c;
    /**
     * Sides.
     */
    private final double lineA, lineB, lineC;

    /**
     * Constructor.
     * @param aArg - point a
     * @param bArg - point b
     * @param cArg - point c
     */
    public Triangle(final Point aArg, final Point bArg, final Point cArg) {
        // Координаты точек
        this.a = aArg;
        this.b = bArg;
        this.c = cArg;

        // Длинны сторон
        this.lineA = a.distanceTo(b);
        this.lineB = b.distanceTo(c);
        this.lineC = a.distanceTo(c);
    }

    /**
     * getter.
     * @return side A
     */
    public final double getLineA() {
        return this.lineA;
    }

    /**
     * getter.
     * @return side B
     */
    public final double getLineB() {
        return this.lineB;
    }

    /**
     * getter.
     * @return side C
     */
    public final double getLineC() {
        return this.lineC;
    }

    /**
     * Calculate area.
     * @return area of triangle
     */
    public final double area() {
        if (!this.checkExist()) {
            throw new ArithmeticException("Sides isn't correct!");
        }

        double p = (this.lineA + this.lineB + this.lineC) / 2;
        return Math.sqrt(p * (p - this.lineA) * (p - this.lineB) * (p - this.lineC));
    }

    /**
     * Check exist of triangle.
     * @return true if triangle can be created
     */
    private boolean checkExist() {
        boolean result = false;

        if (this.lineA < this.lineB + this.lineC
            && this.lineB < this.lineA + this.lineC
            && this.lineC < this.lineA + this.lineB) {
            result = true;
        }
        return result;
    }

}
