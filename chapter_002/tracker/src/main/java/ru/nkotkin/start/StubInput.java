package ru.nkotkin.start;

/**
 * Created by nkotkin on 1/15/17.
 */
public class StubInput implements Input {
    /**
     * array of answers.
     */
    private String[] answers;
    /**
     * position.
     */
    private int position = 0;

    /**
     * Instantiates a new Stub input.
     *
     * @param argAnswers the arg answers
     */
    public StubInput(String[] argAnswers) {
        this.answers = argAnswers;

    }
    /**
     * interface ask.
     *
     * @param question - question.
     * @return - answer.
     */
    @Override
    public final String ask(String question) {
        return answers[position++];
    }

    /**
     * interface ask to int.
     *
     * @param question question.
     * @param range    range.
     * @return answer.
     */
    @Override
    public final int ask(String question, int[] range) {
        //throw new UnsupportedOperationException("Unsupported operation");
        return Integer.valueOf(answers[position++]);
    }
}
