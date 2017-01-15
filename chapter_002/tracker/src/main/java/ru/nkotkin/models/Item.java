package ru.nkotkin.models;

/**
 * Created by Nikolay Kotkin on 21.11.2016.
 */
public class Item {
    /**
     * item id.
     */
    private int id;

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
     * Constructor.
     * @param nameArg        - set name
     * @param descriptionArg - set description
     * @param createArg      - set create time
     */
    public Item(String nameArg, String descriptionArg, long createArg) {
        this.name = nameArg;
        this.description = descriptionArg;
        this.create = createArg;
    }

    /**
     * Getter fot item id.
     * @return item id
     */
    public final int getId() {
        return this.id;
    }

    /**
     * Setter for item id.
     * @param idArg item id
     */
    public final void setId(int idArg) {
        this.id = idArg;
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
