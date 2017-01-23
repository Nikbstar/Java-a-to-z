package ru.nkotkin.models;

import java.text.SimpleDateFormat;

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
    public Task(String nameArg, String descriptionArg, long createArg) {
        super(nameArg, descriptionArg, createArg);
    }

    /**
     * Bug to string.
     * @return bug string.
     */
    @Override
    public final String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

        return String.format("Task %s\n\tDecsription: %s\n\tCreated: %s\n",
                this.getName(), this.getDescription(), dateFormat.format(this.getCreate()));
    }
}
