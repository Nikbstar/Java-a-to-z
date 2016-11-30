package ru.nkotkin.models;

import java.util.Random;

/**
 * Created by Nikolay Kotkin on 21.11.2016.
 */
public class Item {
    /**
     * item id.
     */
    private String id;
    /**
     * Random num for item id.
     */
    private static final Random RN = new Random();

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
/*    public Item() {
    }*/

    /**
     * Constructor.
     * @param nameArg        - set name
     * @param descriptionArg - set description
     * @param createArg      - set create time
     */
    public Item(final String nameArg, final String descriptionArg, final long createArg) {
        this.id = this.generateId();
        this.name = nameArg;
        this.description = descriptionArg;
        this.create = createArg;
    }

    /**
     * Getter fot item id.
     * @return item id
     */
    public final String getId() {
        return this.id;
    }

    /**
     * Generate item id.
     * @return item id
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
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
