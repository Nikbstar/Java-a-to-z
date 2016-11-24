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
    private Item[] items = new Item[100];

    /**
     * Default constructor.
     */
    private Tracker() {
    }

    /**
     * Starter.
     * @param args - command line args
     */
    public static void main(final String[] args) {
        Tracker tracker = new Tracker();

        tracker.items[0] = new Item("itemName", "itemDescription", 0L);
        tracker.items[1] = new Task("taskName", "taskDescription", 0L);
        tracker.items[2] = new Bug();

        for (Item item : tracker.items) {
            if (item instanceof Task) {
                System.out.printf("%s ", ((Task) item).caclulatePrice());
            }
            System.out.printf("%s %s\n", item.getName(), item.getDescription());
        }
    }
}
