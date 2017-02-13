package ru.nkotkin.start;

/**
 * Created by nkotkin on 2/12/17.
 */
public class ValidateInput extends ConsoleInput {

    /**
     * Exception empty field.
     *
     * @param question - question.
     * @return true string.
     */
    @Override
    public final String ask(String question) {
        String result = "";
        boolean invalid = true;
        do {
            try {
                result = super.ask(question);
                invalid = false;
            } catch (EmptyFieldException efe) {
                System.out.println("Field is empty. Please enter validate data.");
            }
        } while (invalid);
        return result;
    }

    /**
     * interface ask.
     * Wrong number exceptions.
     *
     * @param question question.
     * @param range    range.
     * @return answer if data is validate.
     */
    @Override
    public final int ask(String question, int[] range) {
        int result = -1;
        boolean invalid = true;
        do {
            try {
                result = super.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                //moe.printStackTrace();
                System.out.println("Please select key from menu.");
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate data again.");
            }
        } while (invalid);
        return result;
    }

}
