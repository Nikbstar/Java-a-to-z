package ru.nkotkin.models;

/**
 * Created by Nikolay Kotkin on 21.11.2016.
 */
public class Bug extends Item {

    /**
     * Constructor.
     * @param nameArg - name
     * @param descriptionArg - description
     * @param createArg - create date
     */
    public Bug(String nameArg, String descriptionArg, long createArg) {
        super(nameArg, descriptionArg, createArg);
    }

}
