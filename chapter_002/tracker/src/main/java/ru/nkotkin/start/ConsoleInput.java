package ru.nkotkin.start;

import java.util.Scanner;

/**
 * Created by nkotkin on 1/15/17.
 */
public class ConsoleInput implements Input {
    /**
     * Read input from console.
     */
    private Scanner scanner = new Scanner(System.in);
    /**
     * interface ask.
     *
     * @param question - question.
     * @return - answer.
     */
    @Override
    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }
}
