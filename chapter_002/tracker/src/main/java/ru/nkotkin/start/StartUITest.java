package ru.nkotkin.start;

/**
 * Created by nkotkin on 1/15/17.
 */
public class StartUITest {

    /**
     * constructor.
     */
    private StartUITest() {
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Input input = new StubInput("Create first task");
        new StartUI(input).mineMenu();
    }
}
