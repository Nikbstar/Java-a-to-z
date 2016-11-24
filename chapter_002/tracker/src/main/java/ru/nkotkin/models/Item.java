package ru.nkotkin.models;

/**
 * Created by Nikolay Kotkin on 21.11.2016.
 */
public class Item {
    /**
     * Item name.
     */
    private String name;
    /**
     * Item description.
     */
    private String description;
    /**
     * Create date.
     */
    private long create;

    /**
     * Default constructor.
     */
    public Item() {
    }

    /**
     * Constructor.
     * @param nameArg        - set name
     * @param descriptionArg - set description
     * @param createArg      - set create time
     */
    public Item(final String nameArg, final String descriptionArg, final long createArg) {
        this.name = nameArg;
        this.description = descriptionArg;
        this.create = createArg;
    }

    /**
     * getter for name.
     * @return string name
     */
    public final String getName() {
        return this.name;
    }

    /**
     * getter for description.
     * @return string description
     */
    public final String getDescription() {
        return this.description;
    }

    /**
     * getter for create.
     * @return long date
     */
    public final long getCreate() {
        return this.create;
    }

}
