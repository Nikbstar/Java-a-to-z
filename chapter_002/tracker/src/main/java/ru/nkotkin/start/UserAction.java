package ru.nkotkin.start;

/**
 * Created by nkotkin on 2/5/17.
 */
public interface UserAction {

    /**
     * Key of menu action.
     * @return int key.
     */
    int key();

    /**
     * Perfomens basic action.
     * @param inputArg input type.
     * @param trackerArg tracker
     */
    void execute(Input inputArg, Tracker trackerArg);

    /**
     * info about action.
     * @return info string.
     */
    String info();

}
