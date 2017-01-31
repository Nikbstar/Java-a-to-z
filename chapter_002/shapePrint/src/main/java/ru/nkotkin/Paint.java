package ru.nkotkin;

/**
 * Created by nkotkin on 1/31/17.
 *
 * Используя шаблон проектирования стратегия
 * https://www.tutorialspoint.com/design_pattern/strategy_pattern.htm
 * 1. Реализовать класс Paint.draw(Shape);
 * 2. Shape.pic() : String - метод возвращает строку псевдографици.
 * 3. реализовать Квадрат. Треугольник.
 * 4. Метод draw - должен печатать псевдокартинку на консоль.
 *
 * Не забывайте писать тесты.
 */
public class Paint {

    /**
     * Printing the shape.
     * @param shape shape
     */
    public final void draw(Shape shape) {
        System.out.print(shape.pic());
    }

}
