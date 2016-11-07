package ru.nkotkin;

/**
 * 1. Создать класс Point c двумя полями x, y. Этот класс
 * будет описывать точку в системе координат.
 * @author nkotkin
 * @since 20.10.2016
 */
public class Point {

    /**
     * x coordinate.
     */
    private final double x;
    /**
     * y coordinate.
     */
    private final double y;

    /**
     * Constructor.
     * @param xArg - x coordinate
     * @param yArg - y coordinate
     */
    public Point(final double xArg, final double yArg) {
        this.x = xArg;
        this.y = yArg;
    }

    /**
     * Calculate distance between two points.
     * @param point - point
     * @return distance between two points
     */
    public final double distanceTo(final Point point) {
        return Math.sqrt(Math.pow((point.x - this.x), 2)
               + Math.pow((point.y - this.y), 2));
    }

}
