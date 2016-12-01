package ru.nkotkin.start;

import ru.nkotkin.models.Item;
import ru.nkotkin.models.Task;
import ru.nkotkin.models.Bug;

import java.util.Random;

/**
 * Created by Nikolay Kotkin on 21.11.2016.
 */
final class Tracker {
    /**
     * Items limit.
     */
    private static final int ITEMS_LIMIT = 10;
    /**
     * Random num for item id.
     */
    private static final Random RN = new Random();

    /**
     * Items list.
     */
    private Item[] items = new Item[ITEMS_LIMIT];

    /**
     * position in items array.
     */
    private int position = 0;

    /**
     * Default constructor.
     */
    protected Tracker() {
    }

    /**
     * Add item in tracker.
     * @param itemArg - new item
     * @return item
     */
    public Item add(final Item itemArg) {
        itemArg.setId(this.generateId());
        this.items[this.position++] = itemArg;
        return itemArg;
    }

    /**
     * Edit item.
     * @param itemArg item
     * @return item
     */
    public Item edit(final Item itemArg) {
        for (int iterator = 0; iterator != this.position; iterator++) {
            if (this.items[iterator] != null && this.items[iterator].getId().equals(itemArg.getId())) {
                this.items[iterator] = itemArg;
                break;
            }
        }
        return itemArg;
    }

    /**
     * Delete item.
     * @param itemArg - item for deleting
     */
    public void delete(final Item itemArg) {
        for (int iterator = 0; iterator != this.position; iterator++) {
            if (this.items[iterator] != null && this.items[iterator].getId().equals(itemArg.getId())) {
                for (int index = iterator; index != this.position - 1; index++) {
                    this.items[index] = this.items[index + 1];
                }
                this.items[this.position - 1] = null;
                this.position--;
                break;
            }
        }
    }

    /**
     * Get all items.
     * @return Array with all created item's.
     */
    public Item[] getItems() {
        Item[] result = new Item[this.position];
        for (int iterator = 0; iterator != this.position; iterator++) {
            result[iterator] = this.items[iterator];
        }
        return result;
    }

    /**
     * Get filter items.
     * @param nameFilter - Filter by name
     * @return array of items
     */
    public Item[] getFilterItems(final String nameFilter) {
        int resultIterator = 0;
        Item[] result = new Item[this.position];

        for (int iterator = 0; iterator != this.position; iterator++) {
            if (this.contains(this.items[iterator].getName(), nameFilter)) {
                result[resultIterator++] = this.items[iterator];
            }
        }
        return result;
    }

    /**
     * Find item by id.
     * @param id - item id
     * @return found item
     */
    private Item findById(final String id) {
        Item result = null;
        for (Item item : this.items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     * Generate item id.
     * @return item id
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    /**
     * check contains.
     * @param origin - Original string
     * @param sub - sub string
     * @return boolean true if sub string is sub for original
     */
    private boolean contains(final String origin, final String sub) {
        /**
         * result.
         */
        boolean result = false;
        /**
         * array for origin string.
         */
        char[] originArr = new char[origin.length()];
        /**
         * array for sub string.
         */
        char[] subArr = new char[sub.length()];
        /**
         * iterator for origin array.
         */
        int originIterator;
        /**
         * iterator for sub array.
         */
        int subIterator;

        originArr = strToCharArray(origin);
        subArr = strToCharArray(sub);
        for (originIterator = 0; originIterator != originArr.length - subArr.length + 1; originIterator++) {
            if (result) {
                break;
            }
            for (subIterator = 0;
                 subIterator != subArr.length && originIterator + subIterator != originArr.length;
                 subIterator++) {
                if (originArr[originIterator + subIterator] == subArr[subIterator]) {
                    result = true;
                } else {
                    result = false;
                    break;
                }

            }
        }
        return result;
    }

    /**
     * string to char array.
     * @param str - string
     * @return array of chars
     */
    private char[] strToCharArray(final String str) {

        /**
         * array of chars.
         */
        char[] resultArr = new char[str.length()];

        for (int iterator = 0; iterator != resultArr.length; iterator++) {
            resultArr[iterator] = str.charAt(iterator);
        }

        return resultArr;
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
