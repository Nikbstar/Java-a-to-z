package ru.nkotkin.models;

import java.text.SimpleDateFormat;

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

    /**
     * Bug to string.
     * @return bug string.
     */
    @Override
    public final String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

        return String.format("%s) Bug %s\n\tDecsription: %s\n\tCreated: %s\n",
                this.getId(), this.getName(), this.getDescription(), dateFormat.format(this.getCreate()));
    }
}
