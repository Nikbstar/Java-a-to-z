package ru.nkotkin.start;

import ru.nkotkin.models.Item;
import ru.nkotkin.models.Task;
import ru.nkotkin.models.Bug;

/**
 * Created by Nikolay Kotkin on 21.11.2016.
 */
final class Tracker {
    /**
     * Items list.
     */
    private Item[] items = new Item[10];
    /**
     * position in items array.
     */
    private int position = 0;

    /**
     * Default constructor.
     */
    private Tracker() {
    }

    /**
     * Add item in tracker.
     * @param itemArg - new item
     * @return item
     */
    public Item add(final Item itemArg) {
        this.items[position++] = itemArg;
        return itemArg;
    }

    /**
     * Find item by id.
     * @param id - item id
     * @return found item
     */
    private Item findById(final String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     * Get all items.
     * @return Array with all created item's.
     */
    public Item[] getItems() {
        Item[] result = new Item[position];
        for (int iterator = 0; iterator != position; iterator++) {
            result[iterator] = this.items[iterator];
        }
        return result;
    }

    /**
     * Starter.
     * @param args - command line args
     */
    public static void main(final String[] args) {
        Tracker tracker = new Tracker();
        tracker.add(new Task("First task", "Task for testing", 1L));
        tracker.add(new Task("Second task", "Task for testing", 1L));
        tracker.add(new Bug("First bug", "Bug for testing", 1L));
        for (Item item : tracker.getItems()) {
            System.out.printf("%s - %s\n", item.getId(), item.getName());
        }
    }
}
