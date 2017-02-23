package ru.nkotkin.start;

/**
 * Created by nkotkin on 2/23/17.
 */
public abstract class BaseAction implements UserAction {

    /**
     * name of action.
     */
    private String name;

    /**
     * Constructor.
     * @param nameArg name of action.
     */
    public BaseAction(String nameArg) {
        this.name = nameArg;
    }

    /**
     * info about action.
     * @return info string.
     */
    public String info() {
        return String.format("%s. %s", this.key(), name);
    }

}
