package ru.nkotkin.start;

/**
 * Created by nkotkin on 1/15/17.
 */
public interface Input {

    /**
     * interface ask to string.
     * @param question - question.
     * @return - answer.
     */
    String ask(String question);

    /**
     * interface ask to int.
     * @param question question.
     * @param range range.
     * @return answer.
     */
    int ask(String question, int[] range);
}
