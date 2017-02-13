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
        String scan = scanner.nextLine().trim();
        if (!scan.equals("")) {
            return scan;
        } else {
            throw new EmptyFieldException("String is empty.");
        }
    }

    /**
     * interface ask to int.
     *
     * @param question question.
     * @param range    range.
     * @return answer.
     */
    @Override
    public int ask(String question, int[] range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else {
            throw new MenuOutException("Out of menu range.");
        }
    }

}
