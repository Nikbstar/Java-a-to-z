package ru.nkotkin.models;

/**
 * Created by Nikolay Kotkin on 21.11.2016.
 */
public class Task extends Item {

    /**
     * Constructor.
     * @param nameArg - name
     * @param descriptionArg - desc
     * @param createArg - create date
     */
    public Task(final String nameArg, final String descriptionArg, final long createArg) {
        super(nameArg, descriptionArg, createArg);
    }

}
