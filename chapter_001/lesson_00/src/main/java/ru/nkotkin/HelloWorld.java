package ru.nkotkin;

/**
 * Написать вывод Hello World на консоль.
 */
final class HelloWorld {

    /**
    * Default constructor.
    */
    private HelloWorld() {
    }

    /**
    * Print "Hello, World!".
    * @param args - comand line arguments
    */
    public static void main(final String[] args) {
        HelloWorld helloWorld = new HelloWorld();
        System.out.print("Hello, World!");
    }

}
